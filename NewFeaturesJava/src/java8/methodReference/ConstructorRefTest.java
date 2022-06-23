package java8.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description: 构造器引用 + 数组引用
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/21 07:21
 */
public class ConstructorRefTest {
    public static void main(String[] args) {
        Supplier<Employee> sup = Employee::new;
        System.out.println(sup.get());

        Function<Integer,Employee> fun = Employee::new;
        Employee emp = fun.apply(1234);
        System.out.println(emp);

        Function<Integer,String[]> fun1 = String[]::new;
        String[] arr = fun1.apply(98);
        System.out.println(arr);
    }
}
