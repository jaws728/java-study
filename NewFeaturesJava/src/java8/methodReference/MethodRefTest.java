package java8.methodReference;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description: 方法引用的使用
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/21 06:58
 */
public class MethodRefTest {

    public static void test1() {
        PrintStream out = System.out;
        Consumer<String> con = out::println;
        con.accept("print line");
    }

    public static void test2(){
        Employee employee = new Employee(2000,"Tom",13,2300);
        Supplier<String> sup = () -> employee.getName();
        Supplier<String> sup1 = employee::getName;
        System.out.println(sup.get());
        System.out.println(sup1.get());
    }

    public static void test3(){
        Comparator<Integer> com = (t1, t2) -> Integer.compare(t1,t2);
        System.out.println(com.compare(25, 35));
        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(43, 46));
    }

    public static void test4(){
        Function<Double,Long> fun = d -> Math.round(d);
        System.out.println(fun.apply(26.85));

        Function<Double,Long> fun1 = Math::round;
        System.out.println(fun1.apply(24.75));
    }

    public static void test5(){
        Comparator<String> com = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com.compare("dfs", "fwe"));
        Comparator<String> com1 = String::compareTo;
        System.out.println(com1.compare("fq", "fg"));
    }

    public static void test6(){
        BiPredicate<String,String> pred = String::equals;
        System.out.println(pred.test("fs", "lf"));
    }

    public static void test7(){
        Function<Employee,String> fun = Employee::getName;
        fun.apply(new Employee(32,"Louis",43,9000.56));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
