package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @description: java内置4大核心函数式接口
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/20 20:03
 */
public class FunctionalCoreFunctions {
    public static void consumerTest() {
        Consumer<Double> con = price -> System.out.println("矿泉水的价格为：" + price);
        con.accept(23.0);
        //OR
        priceConsume(200.0, p -> System.out.println("鸡腿的价格是：" + p));
    }
    public static void priceConsume(Double price, Consumer<Double> con){
        con.accept(price);
    }
    public static void predicateTest() {
        List<String> list = Arrays.asList("China", "India", "North", "America", "UK");
        List<String> a = filterString(list, str -> str.contains("a"));
        System.out.println(a);
    }

    public static List<String> filterString(List<String> list, Predicate<String> pred) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s: list) {
            if (pred.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

    public static void main(String[] args) {
        consumerTest();
        predicateTest();
        // supplyTest();
        // functionTest();
    }
}
