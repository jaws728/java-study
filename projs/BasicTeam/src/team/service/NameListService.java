package team.service;

import team.domain.*;

import static team.service.Data.*;
/**
 * @Description: 负责将Data中的数据分装至Employee[]数组中，同时提供相关操作
 */

public class NameListService {
    private Employee[] employees;

    public NameListService() {
        // 给employees及数组进行初始化
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            IEquipment equipment = null;

            if (type != EMPLOYEE){
                int equipType = Integer.parseInt(EQUIPMENTS[i][0]);
                switch (equipType) {
                    case PC -> equipment = new PC(EQUIPMENTS[i][1], EQUIPMENTS[i][2]);
                    case NOTEBOOK -> equipment = new NoteBook(EQUIPMENTS[i][1], Double.parseDouble(EQUIPMENTS[i][2]));
                    case PRINTER -> equipment = new Printer(EQUIPMENTS[i][1], EQUIPMENTS[i][2]);
                }
            }

            switch (type) {
                case EMPLOYEE -> employees[i] = new Employee(id, name, age, salary);
                case PROGRAMMER -> employees[i] = new Programmer(id, name, age, salary, equipment);
                case DESIGNER -> employees[i] = new Designer(id, name, age, salary, equipment, Double.parseDouble(EMPLOYEES[i][5]));
                case ARCHITECT -> employees[i] = new Architect(id, name, age, salary, equipment, Double.parseDouble(EMPLOYEES[i][5]), Integer.parseInt(EMPLOYEES[i][6]));
            }
        }
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("不存在该员工！");
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
