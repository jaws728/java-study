package lesson1;

/**
 * @description: 什么叫反射
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/17 02:39
 */
public class FirstDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("lesson1.UserClass");
        System.out.println(c1);

        // 一个类在内存中只有一个Class，并加载后整个结构将被封装在Class类中
        Class c2 = Class.forName("lesson1.UserClass");
        Class c3 = Class.forName("lesson1.UserClass");
        System.out.println(c2.hashCode() == c3.hashCode());
    }
}

// 实体类：pojo，entity
class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }
    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
