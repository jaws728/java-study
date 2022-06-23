package java8.stream;

import java8.methodReference.Employee;
import java8.methodReference.EmployeeData;

import java.util.List;
import java.util.stream.Stream;

/**
 * @description: 通过集合创建Stream
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/21 14:00
 */
public class CreateStreamCollection {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        Stream<Employee> employeeStream = employees.parallelStream();
        System.out.println(stream);
        System.out.println(employeeStream);
    }
}
