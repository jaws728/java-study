package lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 通过反射动态创建对象
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/19 18:00
 */
public class DynamicClassCreation {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获得Class对象
        Class clazz = Class.forName("lesson1.UserClass");
        // 构造一个对象
        UserClass user = (UserClass) clazz.newInstance(); //本质：调用无参构造器
        System.out.println(user);
        // 通过构造器创建对象
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        UserClass u = (UserClass) constructor.newInstance("pkcrazy", 16, 2);
        System.out.println(u);
        // 通过反射调用普通方法
        Method setName = clazz.getDeclaredMethod("setName", String.class);
        // 通过invoke激活
        setName.invoke(user, "破壳");
        System.out.println(user.getName());
        // 操作属性
        Field age = clazz.getDeclaredField("age");
        // 不可直接操作私有化属性：需要关闭程序安全检查 -> 通过setAccessible方法
        age.setAccessible(true);
        age.set(user, 12);
        System.out.println(user.getAge());

        System.out.println("-- PRINTING ALL: --");
        System.out.println(user);
        System.out.println(u);
    }
}

class UserClass {
    private String name;
    private int age;
    private int id;

    public UserClass() {
    }

    public UserClass(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
