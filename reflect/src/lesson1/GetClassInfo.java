package lesson1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description: 获取类的信息
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/19 17:41
 */
public class GetClassInfo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class clazz = Class.forName("lesson1.Person");

        // 获取名字
        System.out.println("GET NAME: " + clazz.getName()); // 包名 + 类名
        System.out.println("SIMPLE NAME" + clazz.getSimpleName()); // 类名

        // 获取属性
        for (Field field : clazz.getFields()) {
            // 纯public属性
            System.out.println("FIELD: " + field);
        }
        for (Field declaredField : clazz.getDeclaredFields()) {
            // 全部属性
            System.out.println("DECLARED FIELD: " + declaredField);
        }

        // 获取指定属性值
        Field name = clazz.getDeclaredField("name");
        System.out.println("NAME FIELD: " + name);

        // 获取类方法
        for (Method method : clazz.getMethods()) {
            System.out.println("PUBLIC METHOD: " + method);
        }
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println("DECLARED METHOD: " + declaredMethod);
        }

        // 获取指定方法
        Method toString = clazz.getMethod("toString", null);
        System.out.println("TO STRING METHOD: " + toString);

        // 获取构造器
        for (Constructor constructor : clazz.getConstructors()) {
            System.out.println("CONSTRUCTOR: " + constructor);
        }
        for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println("DECLARED CONSTRUCTOR: " + declaredConstructor);
        }

        // 获取指定构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(null);
        System.out.println("NULL PARAMETER CONSTRUCTOR: " + declaredConstructor);
    }
}
