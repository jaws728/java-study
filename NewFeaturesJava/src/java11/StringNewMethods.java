package java11;

public class StringNewMethods {
    public static void main(String[] args) {
        System.out.println(" \t \n   ".isBlank()); //true
        System.out.println(" asd==  \n \t".strip()); //asd==
        System.out.println(" asd  ".stripTrailing()); // asd
        System.out.println(" asd  ".stripLeading()); //asd
        System.out.println("Java ".repeat(3)); //Java Java Java
        System.out.println("a\nb\nc\n".lines().count()); //3
    }
}
