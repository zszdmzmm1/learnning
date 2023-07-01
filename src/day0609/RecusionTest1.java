package day0609;

public class RecusionTest1 {
    public static void main(String[] args) {
        Method m = new Method();
        System.out.println(m.Example(10));
    }


}

class Method {

    public int Example(int num){
        if(num == 0){
            return 1;
        }else if(num == 1){
            return 4;
        }else{
            return Example(num - 2) + 2 * Example(num - 1);
        }
    }
}


