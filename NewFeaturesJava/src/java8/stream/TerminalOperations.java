package java8.stream;

import java8.methodReference.Employee;
import java8.methodReference.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 终止操作
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/22 09:56
 */
public class TerminalOperations {
    public static void findAndMatch(){
        System.out.println("--- FIND AND MATCH: ---");
        List<Employee> list = EmployeeData.getEmployees();

        boolean allMatch = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        System.out.println("--------");
        boolean anyMatch = list.stream().anyMatch(e -> e.getSalary() < 1000);
        System.out.println(anyMatch);

        System.out.println("--------");
        boolean noneMatch = list.stream().noneMatch(e -> e.getId() == 1000);
        System.out.println(noneMatch);

        System.out.println("--------");
        System.out.println(list.stream().findFirst());

        System.out.println("--------");
        System.out.println(list.stream().findAny());

        System.out.println("--------");
        System.out.println(list.stream().count());

        System.out.println("--------");
        System.out.println(list.stream().max((e1, e2) -> e1.getAge() - e2.getAge()));

        System.out.println("--------");
        System.out.println(list.stream().min((e1,e2) -> (int) (e1.getSalary() - e2.getSalary())));
    }

    public static void reduces(){
        System.out.println("--- REDUCES: ---");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().reduce(0, Integer::sum));

        System.out.println("--------");
        List<Employee> list1 = EmployeeData.getEmployees();
        System.out.println(list1.stream().map(Employee::getSalary).reduce((d1,d2) -> d1 + d2));
    }

    public static void collects(){
        System.out.println("--- COLLECTS: ---");
        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> collect = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("--------");
        list.stream().filter(a -> a.getAge() < 30).collect(Collectors.toSet()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        findAndMatch();
        reduces();
        collects();
    }
}
