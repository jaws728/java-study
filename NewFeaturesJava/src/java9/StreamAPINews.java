package java9;

import java.util.stream.Stream;

public class StreamAPINews {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(123, 324, 234, 456, 786, 789, 2345, 275);
        stream.takeWhile(x -> x < 500).forEach(System.out::println);
        System.out.println("---------");
        Stream<Integer> stream0 = Stream.of(123, 324, 234, 456, 786, 789, 2345, 275);
        stream0.dropWhile(x -> x < 500).forEach(System.out::println);

        // Error:
        //Stream<Object> stream1 = Stream.of(null);
        // Correct Format
        System.out.println("---------");
        Stream<Object> stream2 = Stream.ofNullable(null);
        stream2.forEach(System.out::println);
        // Is not error:
        System.out.println("----------");
        Stream<Object> stream3 = Stream.of(null, null);
        stream3.forEach(System.out::println);

        System.out.println("----------");
        Stream.iterate(1, x -> x < 20, x -> x + 2).forEach(System.out::println);
    }
}
