package team.view;

import team.domain.Employee;
import team.domain.Programmer;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

import java.util.Scanner;

public class TeamView {
    private NameListService nls = new NameListService();
    private TeamService ts = new TeamService();

    public void enterMainMenu() {
        boolean loopFlag = true;
        char op = 0;
        while (loopFlag) {
            if (op != '1'){
                listAllEmployees();
            }

            System.out.print("1-团队列表\n2-添加团队成员\n3-删除团队成员\n4-退出\n请选择(1-4)：");

            op = TSUtility.readMenuSelection();
            switch (op) {
                case '1' -> getTeam();
                case '2' -> addMember();
                case '3' -> deleteMember();
                case '4' -> {
                    System.out.print("确定是否退出(Y/N):");
                    char exit = TSUtility.readConfirmSelection();
                    if (exit == 'Y'){
                        loopFlag = false;
                    }
                }
            }
        }
        System.out.println("已退出");
    }

    private void listAllEmployees(){
        System.out.println("----------------------------------------------开发团队调度软件----------------------------------------------\n");

        Employee[] employees = nls.getEmployees();
        if (employees == null || employees.length == 0){
            System.out.println("公司中没有任何员工信息！");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");

            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }

        System.out.println("---------------------------------------------------------------------------------------------------------\n");
    }

    private void getTeam(){
        System.out.println("--------------------团队成员列表--------------------");

        Programmer[] team = ts.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员！");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (Programmer p: team){
                System.out.println(p.getTeamDetails());
            }
        }

        System.out.println("--------------------------------------------------");
    }

    private void addMember(){
        System.out.println("--------------------添加成员--------------------");

        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee e = nls.getEmployee(id);
            ts.addMember(e);
            System.out.println("添加成功！");
        } catch (TeamException ex) {
            System.out.println("添加失败：" + ex.getMessage());
        }
        TSUtility.readReturn(); //按回车键继续...

        System.out.println("----------------------------------------------");
    }

    private void deleteMember(){
        System.out.println("--------------------删除成员--------------------");

        System.out.print("请输入要删除员工的TID：");
        int tid = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N): ");
        char op = TSUtility.readConfirmSelection();
        if (op == 'N'){
            return;
        }
        try {
            ts.removeMember(tid);
            System.out.println("删除成功！");
        } catch (TeamException ex) {
            System.out.println("删除失败：" + ex.getMessage());
        }
        TSUtility.readReturn(); //按回车键继续...

        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args){
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
