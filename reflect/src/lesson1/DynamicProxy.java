package lesson1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 动态代理对象
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/20 17:57
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Human superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyHuman.getProxyInstance(superMan);
        String believe = proxyInstance.getBelieve();
        System.out.println(believe);
        proxyInstance.eat("麻辣烫");

        // 动态的特性：可更改对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyHuman.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
    }
}

/**
 * @description:
 *      实现动态代理的问题：
 *          1、如何根据加载到内存中的被代理类动态创建一个代理类及其对象
 *          2、当通过代理类对象调用方法时，如何动态的去调用被代理类中的同名同方法
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/20 18:01
 */
interface Human{
    String getBelieve();
    void eat(String food);
}

class SuperMan implements Human{

    @Override
    public String getBelieve() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃" + food);
    }
}

class ProxyHuman implements Human {

    /*
     * 调用此方法，返回代理类对象
     */
    public static Object getProxyInstance(Object obj){
        // obj为被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }

    @Override
    public String getBelieve() {
        return null;
    }

    @Override
    public void eat(String food) {

    }
}

class MyInvocationHandler implements InvocationHandler{

    //需要使用被代理类的对象进行赋值
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 当通过代理类调用方法时，将自动调用以下方法：invoke()
    // 将被代理类要执行的方法功能声明在此方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method：即为代理类对象调用的方法
        // 此方法也作为被代理类对象要调用的方法
        return method.invoke(obj, args);
    }
}
