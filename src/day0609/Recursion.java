package day0609;

import day0608.printstar.Method;

public class Recursion {
    public static void main(String[] args) {
        SumMethod method = new SumMethod();
        System.out.println(method.method(100));
    }
}

class SumMethod{
    public int method(int num){
        if(num == 1){
            return 1;
        }else {
            return method(num - 1) + num;
        }
    }
}
