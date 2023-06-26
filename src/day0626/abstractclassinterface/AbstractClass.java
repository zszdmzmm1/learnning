package day0626.abstractclassinterface;

public abstract class AbstractClass implements Iexample{
    private int num;
    private String string;

    public abstract void test0();
    public abstract void test1();
    public void test(){
        System.out.println("抽象类。");
    }

}
