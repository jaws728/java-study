package team.service;

import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Programmer;

public class TeamService {
    private static int counterId = 1; // 用于给memberId赋值 - 自增1的方式
    private final int MAX_MEMBER = 5; // 限制开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER]; //保存开发团队成员
    private int total = 0; // 开发团队中实际人数

    public TeamService() {
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        System.arraycopy(this.team, 0, team, 0, team.length);
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        // 成员已满，无法添加
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        // 该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        // 该员工已在本开发团队中
        if (((Programmer) e).getTeamId() != -1){
            throw new TeamException("该员工已在本开发团队中");
        }
        // 该员工已是某团成员
        // 该员工正在休假，无法添加
        Status status = ((Programmer) e).getStatus();
        if ("BUSY".equals(status.getName())){
            throw new TeamException("该员工已是某团成员");
        } else if ("VACATION".equals(status.getName())){
            throw new TeamException("该员工正在休假，无法添加");
        }
        // 团队中最多只能有：架构师1名、设计师2名、程序员3名
        int numArch = 0, numDes = 0, numPro = 0;
        for (int i = 0; i < total; i++){
            if (team[i] instanceof Architect) {
                numArch++;
            } else if (team[i] instanceof Designer) {
                numDes++;
            } else {
                numPro++;
            }
        }
        if (e instanceof Architect) {
            if (numArch > 0) {
                throw new TeamException("团队中最多只能有一名架构师");
            }
        } else if (e instanceof Designer) {
            if (numDes > 1){
                throw new TeamException("团队中最多只能有两名设计师");
            }
        } else {
            if (numPro > 2) {
                throw new TeamException("团队中最多只能有三名程序员");
            }
        }

        // 添加e至team中并更改对应的属性
        ((Programmer) e).setStatus(Status.BUSY);
        ((Programmer) e).setTeamId(counterId++);
        team[total++] = (Programmer) e;
    }

    public void removeMember(int teamId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getTeamId() == teamId){
                team[i].setTeamId(-1);
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        // 若找不到指定员工
        if (i == total) {
            throw new TeamException("找不到指定员工，删除失败");
        }

        // 后一个元素覆盖前一个元素
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;
    }
}
