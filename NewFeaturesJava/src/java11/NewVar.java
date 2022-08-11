package java11;

import java.lang.constant.Constable;
import java.util.function.Consumer;

public class NewVar {
    public static void main(String[] args) {
        Consumer<String> con = (@Deprecated var t) -> System.out.println(t.toUpperCase());
        con.accept("hello from other sky");
    }
}
