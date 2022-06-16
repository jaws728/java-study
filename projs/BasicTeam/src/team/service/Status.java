package team.service;

/**
 * @Description 表示员工状态
 * @author pck
 * @version
 * @date 2022/04/27
 *
 */

public class Status {
    private final String name;

    private Status(String name){
        this.name = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VACATION = new Status("VACATION");

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
