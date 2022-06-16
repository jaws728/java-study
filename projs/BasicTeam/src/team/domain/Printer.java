package team.domain;

public class Printer implements IEquipment{
    private String name;
    private String type;

    public Printer(){
        super();
    }

    public Printer(String name, String type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
