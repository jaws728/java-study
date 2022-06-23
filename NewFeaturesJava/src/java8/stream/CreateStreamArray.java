package java8.stream;

import java8.methodReference.Employee;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description: 通过数组创建Stream
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/21 14:05
 */
public class CreateStreamArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        IntStream in = Arrays.stream(arr);

        Employee tom = new Employee(2313, "Tom");
        Employee jerry = new Employee(4313, "Jerry");
        Employee[] emps = new Employee[]{tom, jerry};
        Stream<Employee> stream1 = Arrays.stream(emps);
    }
}
