package java9;

import java.util.*;

/**
 * @description: 快速创建只读集合
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/23 07:16
 */
public class CollectionNew {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Joe");
        list.add("Bob");
        list.add("Bill");

        //JDK8
        list = Collections.unmodifiableList(list);
        // cannot add: throws exception
        // list.add("Tom");
        System.out.println(list);

        //JDK9
        List<Integer> integers = List.of(1, 2, 4, 543, 1, 123);
        //integers.add(123); //error
        System.out.println(integers);

        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 12, 23);
        System.out.println(set);

        Map<Integer, String> kvMap = Map.ofEntries(Map.entry(1, "Tom"));
    }
}
