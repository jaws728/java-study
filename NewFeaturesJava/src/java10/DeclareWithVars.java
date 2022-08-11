package java10;

import java.util.ArrayList;

public class DeclareWithVars {
    public static void main(String[] args) {
        var x = 10;
        var list = new ArrayList<Integer>();
        list.add(1);
        var num = new int[]{1,2,3,4};
        System.out.println(x);
        System.out.println(list);
        for (var n: num) {
            System.out.println(n);
        }

        // Cannot use conditions:
        // var x;
        // var x = null;
        // var sup = () -> Math.random();
        // var con = System.out::println;
        // var arr = {1,2,3,4};
        // try {}
        // catch (var e) {}
    }
}

class Test {
    // Cannot use:
    // var x = 10;
    // public Test(var x) {}
    // public var testing(){ return 0; }
    // public void testing(var s){}
}
