package Collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String args[]) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 1, 3);
        List<String> names = Arrays.asList("Cat", "Cow", "Snake", "Dog");

        //create empty stream
        Stream<String> streamEmpty = Stream.empty();
        System.out.println(streamEmpty);

        //findFirst method
        int num = numbers.stream().distinct().findFirst().get();
        System.out.println(num);

        // map method
        List<Integer> square = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(square);
        List<Integer> lengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengths);

        //flatMap method
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8));
        System.out.println("List<Lists> :"+listOfLists);
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println("flatMapped: " + flattenedList);

        // filter method
        List<String> result = names.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(result);

        // sorted method
        List<String> show = names.stream().sorted().toList();
        System.out.println(show);

        //distinct method
        List<String> nums = names.stream().distinct().toList();
        System.out.println(nums);

        // collect method returns a set
        Set<Integer> squareSet = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toSet());
        System.out.println(squareSet);

        // forEach method
        numbers.stream().map(x -> x + x).forEach(y -> System.out.println(y));

        // reduce method
        int even = numbers.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (ans, i) -> ans + i);
        System.out.println("Even : " + even);

        //Max & min methods
        int max = numbers.stream().max(Integer::compareTo).get();
        int min = numbers.stream().min((x,y) -> x.compareTo(y)).get();
        System.out.println(max + " "+ min);
    }
}
