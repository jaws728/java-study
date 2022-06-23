package java8.stream;

import java8.methodReference.Employee;
import java8.methodReference.EmployeeData;

import java.util.*;
import java.util.stream.Stream;

/**
 * @description: 中间操作
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/22 09:28
 */
public class IntermediateOperations {
    public static void filters(){
        System.out.println("---- FILTERS: ----");
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        // filter
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println("-----------");
        // limit
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("-----------");
        // skip
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("-----------");
        // distinct
        employees.stream().distinct().forEach(System.out::println);
    }

    public static void maps(){
        System.out.println("---- MAPS: ----");
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        System.out.println("-----------");
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(n -> n.length() > 2).forEach(System.out::println);

        System.out.println("-----------");
        // flatMap: aa -> a,a
        list.stream().flatMap(s -> {
            ArrayList<Character> arr = new ArrayList<>();
            for (Character c: s.toCharArray()){
                arr.add(c);
            }
            return arr.stream();
        }).forEach(System.out::println);

    }

    public static void sorts(){
        System.out.println("---- SORTS: ----");
        List<Integer> list = Arrays.asList(234, 632, -234, 423, 145);
        list.stream().sorted().forEach(System.out::println);

        System.out.println("-----------");
        list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //desc
            }
        }).forEach(System.out::println);
    }

    public static void main(String[] args) {
        filters();
        maps();
        sorts();
    }
}
