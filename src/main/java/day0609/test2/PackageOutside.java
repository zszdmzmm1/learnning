package day0609.test2;

import day0609.test1.Demo;

public class PackageOutside {
    public static void main(String[] args) {
        Demo demo = new Demo();


        demo.varPublic = 1;
        //demo.varDefault = 1;
        //demo.varPrivate = 1;
        demo.methodPublic();
        //demo.methodDefault();
        //demo.methodPrivate();
    }
}
