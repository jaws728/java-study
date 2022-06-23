package java8.stream;

import java.util.stream.Stream;

/**
 * @description:
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/22 09:09
 */
public class CreateStreamOf {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }
}
