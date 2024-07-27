package Collections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String args[]) {
        Employee[] arrayOfEmps = {
                new Employee("Alice", 23, "Computer Science", 50000),
                new Employee("Bob", 21, "Mechanical Engineering", 60000),
                new Employee("Charlie", 43, "Mechanical Engineering", 45000),
                new Employee("Jack", 44, "Computer Science", 75000)
        };

        List<Employee> empList = Stream.of(arrayOfEmps).collect((Collectors.toList()));
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 1, 3);
        List<String> names = Arrays.asList("Cat", "Cow", "Snake", "BuilderDP");
        IntStream intstrm = IntStream.range(10, 20);  //which creates IntStream of numbers 10 to 19.


        //create stream
        Stream<Integer> employees = Stream.of(1,2,3,4);
        Stream<String> streamEmpty = Stream.empty(); //empty stream
        System.out.println(streamEmpty.collect(Collectors.toList()) +" - "+ employees.collect(Collectors.toList()));

        //findFirst method
        int num = numbers.stream().distinct().findFirst().get();
        System.out.println(num);

        // map method
        //map() returns a Stream<Integer>, mapToInt() returns an IntStream.
        List<Integer> square = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(square);
        List<Integer> lengths = names.stream()
                .map(String::length)    //s -> s.length()
                .collect(Collectors.toList());
        System.out.println(lengths);

        //flatMap method
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8));
        System.out.println("List<Lists> :"+listOfLists);
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(Collection::stream)    //list -> list.stream()
                .collect(Collectors.toList());
        System.out.println("flatMapped: " + flattenedList);

        // filter method
        List<String> result = names.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(result);

        //size and limit
        List<Integer> collect = numbers.stream()
                .skip(3)  //skips first 3 elements
                .limit(5)  //it limits the output
                .collect(Collectors.toList());
        System.out.println("size and limit: "+collect);

        // sorted method
        List<String> show = names.stream().sorted().collect(Collectors.toList());
        System.out.println("sort: "+show);
        List<Employee> emp = empList.stream()
                .sorted(Comparator.comparing(Employee::getName)) //(e1, e2) -> e1.getName().compareTo(e2.getName())
                .collect(Collectors.toList());
        System.out.println(emp);

        //distinct method
        List<String> nums = names.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct: "+nums);

        // collect method returns a set
        Set<Integer> squareSet = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toSet());
        System.out.println(squareSet);
        String empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "))  //Collectors.joining() will insert the delimiter between the two String elements of the stream
                .toString();
        System.out.println(empNames);

        // forEach method
        numbers.stream().map(x -> x + x).forEach(System.out::println);  //y -> System.out.println(y)

        // reduce method
        int even = numbers.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum); //we start with the initial value of 0 and repeated apply addition on i,j
        System.out.println("EvenReduce : " + even);
        int mul = numbers.stream()
                .reduce(1, (i, j) -> i*j); //Identity should be given as 1. As we are doing multiplication
        System.out.println("MulReduce : " + mul);

        //Max & min methods
        int max = numbers.stream().max(Integer::compareTo).get();  //stream() expects predicate for min and max
        int min = numbers.stream().min((x,y) -> x.compareTo(y)).get();
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

        //allMatch, anyMatch, and noneMatch
        boolean allEven = numbers.stream().allMatch(i -> i % 2 == 0);  //checks if the predicate is true for all the elements in the stream
        boolean oneEven = numbers.stream().anyMatch(i -> i % 2 == 0);  // checks if the predicate is true for any one element
        boolean noneMultipleOfThree = numbers.stream().noneMatch(i -> i % 3 == 0);  //checks if there are no elements matching the predicate.
        System.out.println("allEven: "+allEven+" oneEven: "+oneEven+" noneMulOfThree: "+noneMultipleOfThree);

        //parallelStream
        List<Integer> sumOfSquaresParallel = numbers.stream()
                .parallel() // Convert the stream to a parallel stream
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println("Sum of squares (parallel): " + sumOfSquaresParallel);
    }
}
