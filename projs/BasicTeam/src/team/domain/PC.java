package team.domain;

public class PC implements IEquipment{
    private String model; // 机器型号
    private String display; // 显示器型号

    public PC() {
        super();
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
