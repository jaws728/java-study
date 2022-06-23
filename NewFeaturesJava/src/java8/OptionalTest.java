package java8;

import java.util.Optional;

/**
 * @description: Optional类
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/23 03:15
 */
public class OptionalTest {

    public static String getTeacherName(Person p){
        // 没有Optional类之前：优化过后的getName
        if (p != null){
            Teacher teacher = p.getTeacher();
            String name = teacher.getName();
            if (name != null){
                return name;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create Optional Class
        Teacher teacher = new Teacher();
        Optional<Teacher> optionalTeacher = Optional.of(teacher); //teacher必须为非空
        System.out.println(optionalTeacher);

        System.out.println("==================");
        Optional<Teacher> optionalTeacher1 = Optional.ofNullable(teacher); //teacher可为null
        System.out.println(optionalTeacher1);

        System.out.println("==================");
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        //查询
        System.out.println("==================");
        teacher = null;
        Teacher orElse = Optional.ofNullable(teacher).orElse(new Teacher("老师"));
        System.out.println(orElse);
    }
}
