package java9;

import java.util.Comparator;

public class GenericNews {
    public static void main(String[] args) {
        // JDK7: <>类型推断
        // JDK9: <>与匿名类一起操作
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }
}
