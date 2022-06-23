package lesson1;

/**
 * @description: 静态代理类 - 在编译期，代理类和被代理类将被确定下来
 * @param  * @param null
 * @return {@link null}
 * @throws
 * @author pkcrazy
 * @date 2022/06/20 16:46
 */
public class StaticProxy {
    public static void main(String[] args) {
        // 创建被代理对象
        ClothFactory nikeClothFactory = new NikeClothFactory();
        // 创建代理类对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        // 调用方法
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备工作");
        factory.produceCloth();
        System.out.println("代理工厂结尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产过程");
    }
}
