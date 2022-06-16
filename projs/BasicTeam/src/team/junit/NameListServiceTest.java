package team.junit;

import org.junit.Test;
import team.domain.Employee;
import team.service.NameListService;
import team.service.TeamException;

public class NameListServiceTest {
    @Test
    public void testGetEmployees(){
        NameListService serv = new NameListService();
        Employee[] employees = serv.getEmployees();
        for(Employee employee: employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService serv = new NameListService();
        int id = 1;
        id = 101;
        try {
            System.out.println(serv.getEmployee(id));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
