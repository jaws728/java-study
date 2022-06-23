package lesson1;

/**
 * @description: 获取不同的类加载器
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/19 17:31
 */
public class TypesOfClassLoaders {
    public static void main(String[] args) throws ClassNotFoundException {
        // 系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 扩展类加载器：系统类加载器的父类加载器
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println(extensionClassLoader);

        // 根类加载器：扩展类加载器的父类加载器
        ClassLoader rootClassLoader = extensionClassLoader.getParent();
        System.out.println(rootClassLoader); // 无法获取：null

        // 测试类使用的类加载器
        ClassLoader classLoader = Class.forName("lesson1.TypesOfClassLoaders").getClassLoader();
        System.out.println(classLoader);

        // 测试JDK内置类的使用类加载器
        ClassLoader loader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(loader); // 无法获取：null

        // 获取系统类加载器可使用路径
        String properties = System.getProperty("java.class.path");
        System.out.println(properties);
    }
}
