package lesson1;

import java.lang.annotation.*;

/**
 * @description: 反射操作注解
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/20 16:20
 */
public class GetAnnotationsReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("lesson1.Student1");
        for (Annotation annotation : c.getAnnotations()) {
            System.out.println("FOR-ANNOTATION: " + annotation);
        }

        Annotation annotation = c.getAnnotation(TablePk.class);
        System.out.println("GET ANNOTATION: " + annotation);
    }
}

@TablePk("db_student")
class Student1 {
    private int id;
    private int age;
    private String name;

    public Student1() {

    }

    public Student1(int id, int age, String name){
        this.id = id;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TablePk{
    String value();
}
