package team.domain;

public class Designer extends Programmer{
    private double bonus; // 奖金

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, IEquipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
    }

    public String getTeamDetails() {
        return getTeamId() + "/" + getDetails() + "\t设计师\t" + bonus;
    }
}
