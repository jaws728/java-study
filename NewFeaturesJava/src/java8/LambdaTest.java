package java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @description: Lambda表达式的使用
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/20 18:59
 */
public class LambdaTest {
    public static void test1(){
        // 普通方式
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个普通Runnable接口测试");
            }
        };
        r1.run();

        // 使用Lambda表达式
        Runnable r2 = () -> System.out.println("Lambda方式使用Runnable接口测试");
        r2.run();

        // 更多应用
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com.compare(12, 32));
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(34, 54));
        Comparator<Integer> com2 = Integer :: compare;
        System.out.println(com2.compare(34, 54));
    }

    public static void test2(){
        Consumer<String> con = (String s) -> { System.out.println(s); };
        con.accept("Consumer in Lambda function.");
        Consumer<String> con1 = (s) -> { System.out.println(s); };
        con1.accept("Consumer1 in Lambda function.");
        Consumer<String> con2 = s -> { System.out.println(s); };
        con2.accept("Consumer2 in Lambda function.");
        Consumer<String> con3 = (s) -> System.out.println(s);
        con3.accept("Consumer3 in Lambda function.");
        Consumer<String> con4 = s -> System.out.println(s);
        con4.accept("Consumer4 in Lambda function.");
    }

    public static void test3(){
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println("对比：" + o1 + o2);
            return Integer.compare(o1, o2);
        };
        System.out.println(com.compare(12, 15));

        Comparator<Integer> com1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare(114, 123));
    }

    public static void main(String[] args) {
       test1();
       test2();
       test3();
    }
}
