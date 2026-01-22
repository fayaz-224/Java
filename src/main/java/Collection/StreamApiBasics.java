package Collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiBasics {
    public static void main(String args[]) {
        //Input
        Employee[] arrayOfEmps = {
                new Employee("Alice", 23, "Computer Science", 50000),
                new Employee("Bob", 21, "Mechanical Engineering", 60000),
                new Employee("Charlie", 43, "Mechanical Engineering", 45000),
                new Employee("Jack", 44, "Computer Science", 75000)
        };
        List<Employee> empList = Arrays.stream(arrayOfEmps).collect((Collectors.toList()));
        List<Integer> numList = Arrays.asList(2, 3, 4, 5, 1, 3);
        List<String> nameList = Arrays.asList("Cat", "Cow", "Snake", "BuilderDP");

        // create stream
        Stream<Integer> s1 = Stream.of(1,2,3,4);
        Stream<String> s2 = Arrays.stream(new String[] {"aa", "bb"});
        Stream<String> streamEmpty = Stream.empty(); //empty stream
        System.out.println(streamEmpty.collect(Collectors.toList()) +" - "+ s1.collect(Collectors.toList()));

        // findFirst - Returns the first element in encounter order. Order is always respected.
        // findAny - Returns any element. No order guarantee. In a sequential stream, it often looks like findFirst() — but don’t rely on it.
        Optional<Integer> num = numList.stream().findFirst();
        int num2 = numList.stream().findAny().get();
        System.out.println(num.get() +" "+ num2);

        // map - map() returns a Stream<Integer>, mapToInt() returns an IntStream.
        List<Integer> square = numList.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(square);
        List<Integer> lengths = nameList.stream()
                .map(String::length)    //s -> s.length()
                .collect(Collectors.toList());
        System.out.println(lengths);

        // flatMap
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3),
                                                        Arrays.asList(4, 5),
                                                        Arrays.asList(6, 7, 8));
        System.out.println("List<Lists> :"+listOfLists);
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(Collection::stream)    //list -> list.stream()
                .collect(Collectors.toList());
        System.out.println("flatMapped: " + flattenedList);

        // filter
        List<String> result = nameList.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(result);

        // distinct & skip & limit
        List<Integer> collect = numList.stream()
                .distinct()  //only unique
                .skip(3)  //skips first 3 elements
                .limit(5)  //limits the output to 5 elements
                .collect(Collectors.toList());
        System.out.println("size and limit: "+collect);

        // sorted
        List<String> show = nameList.stream().sorted().collect(Collectors.toList());
        System.out.println("sort: "+show);
        List<Employee> emp = empList.stream()
                .sorted(Comparator.comparing(Employee::getName)) //(e1, e2) -> e1.getName().compareTo(e2.getName())
                .collect(Collectors.toList());
        System.out.println(emp);

        // collect
        Set<Integer> squareSet = numList.stream()
                .map(x -> x * x)
                .collect(Collectors.toSet());
        System.out.println(squareSet);

        // forEach
        numList.stream().map(x -> x + x).
                forEach(System.out::println);  //y -> System.out.println(y)

        // reduce - Used to combine all elements into a single result
        // syntax: T result = stream.reduce(identity, (a, b) -> someOperation);
        // identity -> Initial/default value (e.g. 0 for sum, 1 for product, "" for strings)
        // (a, b) -> Two elements being combined — one from the stream and one accumulated
        int even = numList.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum); //we start with the initial value of 0 and repeated apply addition on i,j
        System.out.println("Even Reduce : " + even);
        int mul = numList.stream()
                .reduce(1, (i, j) -> i*j); //Identity = 1
        System.out.println("Mul Reduce : " + mul);
        int maxR = numList.stream()
                .reduce(Integer::max)
                .get();
        System.out.println("Max Reduce : " + maxR);
        //| Task         | Code Example                  |
        //| ------------ | ----------------------------- |
        //| Sum          | `reduce(0, Integer::sum)`     |
        //| Product      | `reduce(1, (a, b) -> a * b)`  |
        //| Max          | `reduce(Integer::max)`        |
        //| Min          | `reduce(Integer::min)`        |
        //| Join strings | `reduce("", (a, b) -> a + b)` |

        //Max & min methods
        int max = numList.stream().max(Integer::compareTo).get();  //stream() expects predicate for min and max
        int min = numList.stream().min((x,y) -> x.compareTo(y)).get();
        System.out.println(max + " "+ min);

        //IntStream, LongStream, and DoubleStream – which are primitive specializations for int, long and double respectively.
        //These specialized streams do not extend Stream but extend BaseStream on top of which Stream is also built.
        //For example, the standard min() and max() take a comparator, whereas the specialized streams do not.
        Integer latestEmpId = empList.stream()
                .mapToInt(Employee::getSalary) //we get an IntStream here
                .max()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(latestEmpId);
        //average
        Double avgSal = empList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(avgSal);

        //Boxed - boxed() converts a primitive stream into an object stream. It's required below becoz Collectors.toList() works on Stream<T>, not IntStream.
        List<Integer> intStream = IntStream.range(10, 15).boxed().collect(Collectors.toList());  //which creates IntStream of numbers 10 to 19.
        List<Integer> intStream2 = IntStream.rangeClosed(10, 15).boxed().collect(Collectors.toList()); // 10 to 20
        System.out.println(intStream +" : "+intStream2);

        //Collectors.joining() will insert the delimiter between the two String elements of the stream
        String empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(empNames);
        String empNames2 = empList.stream()
                .map(Employee::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("Reduced names: "+empNames2);

        //allMatch, anyMatch, and noneMatch
        boolean allEven = numList.stream().allMatch(i -> i % 2 == 0);  //checks if the predicate is true for all the elements in the stream
        boolean oneEven = numList.stream().anyMatch(i -> i % 2 == 0);  // checks if the predicate is true for any one element
        boolean noneMultipleOfThree = numList.stream().noneMatch(i -> i % 3 == 0);  //checks if there are no elements matching the predicate.
        System.out.println("allEven: "+allEven+" oneEven: "+oneEven+" noneMulOfThree: "+noneMultipleOfThree);

        //parallelStream
        List<Integer> sumOfSquaresParallel = numList.stream()
                .parallel() // Convert the stream to a parallel stream
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println("Sum of squares (parallel): " + sumOfSquaresParallel);
    }
}
