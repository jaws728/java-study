package java9;

public class InterfaceNews implements INew{
    @Override
    public void mAbs() {
        System.out.println("抽象方法实现");
    }

    @Override
    public void mDefault() {
        INew.super.mDefault();
    }

    public static void main(String[] args) {
        INew.mStatic(); //只可接口调用

        InterfaceNews i = new InterfaceNews();
        i.mAbs();
        i.mDefault();

        // 接口中的私有方法不可在外部调用
        //i.mPrivate();
    }
}

interface INew{
    // public:
    void mAbs();
    static void mStatic(){
        System.out.println("静态方法");
    }
    default void mDefault(){
        System.out.println("默认方法");
    }
    private void mPrivate(){
        System.out.println("私有方法");
    }
}
