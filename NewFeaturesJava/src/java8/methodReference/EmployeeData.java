package java8.methodReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 提供测试的数据
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/21 00:09
 */
public class EmployeeData {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "马化腾",34,6000.38));
        list.add(new Employee(1002, "马云",13,9876.23));
        list.add(new Employee(1003, "刘强东",53,3000.87));
        list.add(new Employee(1004, "雷军",45,7000.46));
        list.add(new Employee(1005, "李彦宏",63,8000.73));
        list.add(new Employee(1006, "比尔盖茨",23,6728.78));
        list.add(new Employee(1007, "任正非",34,3096.90));
        list.add(new Employee(1008, "扎克伯格",26,2856.48));

        return list;
    }
}
