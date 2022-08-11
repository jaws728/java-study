package java9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalNew {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Tom", "Jerry", "Tim", "Bob");
        Optional<List<String>> optional = Optional.ofNullable(list);
        // 输出为：[Tom, Jerry, Tim, Bob]
        optional.stream().forEach(System.out::println);
        // 由于Optional中存储的是List，而list中存储的是String，因此若要一个个输出，则需输出转流
        // Optional是容器：嵌套再嵌套 --> 拆解再拆解
        optional.stream().flatMap(x -> x.stream()).forEach(System.out::println);
    }
}
