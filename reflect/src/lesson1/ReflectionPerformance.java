package lesson1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 分析动态获取/反射性能
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/19 18:31
 */
public class ReflectionPerformance {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException {
        normalCreation();
        reflectionCreation();
        reflection1Creation();
    }

    public static void normalCreation() {
        UserClass u = new UserClass();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            u.getName();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行多次：" + (endTime - startTime) + "ms");
    }

    public static void reflectionCreation() throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        UserClass u = new UserClass();
        Class c = u.getClass();

        Method getName = c.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            getName.invoke(u, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射方式执行多次：" + (endTime - startTime) + "ms");
    }

    public static void reflection1Creation() throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        UserClass u = new UserClass();
        Class c = u.getClass();

        Method getName = c.getDeclaredMethod("getName", null);
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            getName.invoke(u, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射关闭检测方式执行多次：" + (endTime - startTime) + "ms");
    }


}
