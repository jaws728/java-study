package lesson1;

/**
 * Class的创建方式
 */
public class GetClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p = new Student();
        System.out.println(p);

        //方式一：通过对象获取
        Class c1 = p.getClass();
        System.out.println(c1.hashCode());

        //方式二：forName
        Class c2 = Class.forName("lesson1.Student");
        System.out.println(c2.hashCode());

        //方式三：类名.class
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本包装类都有Type属性
        System.out.println(Integer.TYPE);

        //获得父类类
        System.out.println(c1.getSuperclass());
    }
}

class Person {
    public String name;

    public Person() {
        this.name = "Person";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public String name;

    public Student() {
        this.name = "Student";
    }
}

class Teacher extends Person {
    public String name;

    public Teacher() {
        this.name = "Teacher";
    }
}
