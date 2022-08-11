package review;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Arrays.stream(Thread.State.values()).forEach(System.out::println);
    }
}
