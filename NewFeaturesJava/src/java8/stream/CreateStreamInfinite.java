package java8.stream;

import java.util.stream.Stream;

/**
 * @description: 创建无限流
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/22 09:14
 */
public class CreateStreamInfinite {
    public static void main(String[] args) {
        // 遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        // 生成10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
