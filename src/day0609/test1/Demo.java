package day0609.test1;

public class Demo {
    int varDefault;
    public int varPublic;
    private int varPrivate;

    void methodDefault(){}
    public void methodPublic(){}
    private void methodPrivate(){}

    public void classInside(){
        varDefault = 1;
        varPublic = 1;
        varPrivate = 1;

        methodDefault();
        methodPrivate();
        methodPublic();
    }


}
