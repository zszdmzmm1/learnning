package day0609;

public class Recursion {
    public static void main(String[] args) {
        SumMethod method = new SumMethod();
        System.out.println(method.method(100));
        System.out.println(method.method1(5));
        System.out.println(method.method2(5));

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

    public int method1(int num){
        if(num == 1){
            return 1;
        }else{
            return num*method1(num-1);
        }
    }

    public  int method2(int num){
        if(num == 1 || num == 2){
            return 1;
        }else{
            return method2(num - 1) + method2(num - 2);
        }
    }
}


