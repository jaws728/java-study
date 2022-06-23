package lesson1;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @description: 反射操作泛型
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/19 19:11
 */
public class GenericTypes {
    public void test1 (Map<String, UserClass> map, List<String> list) {
        System.out.println("TEST1");
    }

    public Map<String, UserClass> test2() {
        System.out.println("Test2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test1 = GenericTypes.class.getMethod("test1", Map.class, List.class);
        for (Type genericParameterType : test1.getGenericParameterTypes()) {
            System.out.println("GENERIC PARAMETER TYPE: " + genericParameterType); //整个泛型
            if (genericParameterType instanceof ParameterizedType){
                for (Type actualTypeArgument : ((ParameterizedType) genericParameterType).getActualTypeArguments()) {
                    System.out.println("ACTUAL TYPE ARGUMENT: " + actualTypeArgument); //泛型内的属性<>
                }
            }
        }

        Method test2 = GenericTypes.class.getMethod("test2", null);
        Type genericReturnType = test2.getGenericReturnType();
        System.out.println("GENERIC RETURN TYPE: " + genericReturnType);
        if (genericReturnType instanceof ParameterizedType){
            for (Type actualTypeArgument : ((ParameterizedType) genericReturnType).getActualTypeArguments()) {
                System.out.println("ACTUAL TYPE ARGUMENT: " + actualTypeArgument);
            }
        }
    }
}
