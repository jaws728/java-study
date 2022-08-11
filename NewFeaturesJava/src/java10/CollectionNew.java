package java10;

import java.util.ArrayList;
import java.util.List;

public class CollectionNew {
    public static void main(String[] args) {
        List<String> list = List.of("Java", "C", "JS"); //只读集合
        List<String> copy = List.copyOf(list); //只读集合
        System.out.println(list == copy); //true

        ArrayList<String> list1 = new ArrayList<>(); //可改变集合
        list1.add("test");
        List<String> copy1 = List.copyOf(list1); //只读集合
        System.out.println(list1 == copy1); //false
    }
}
