package team.domain;

import team.service.Status;

public class Programmer extends Employee{
    private int teamId = -1; // TID - 开发团队中的ID
    private Status status = Status.FREE;
    private IEquipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, IEquipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public IEquipment getEquipment() {
        return equipment;
    }

    public void setEquipment(IEquipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
    }

    public String getTeamDetails() {
        return teamId + "/" + super.toString() + "\t程序员";
    }
}
