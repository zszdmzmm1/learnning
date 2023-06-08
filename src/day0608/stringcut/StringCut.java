package day0608.stringcut;

public class StringCut {
    public static void stringCut(char apart, String ... a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if(i == a.length - 1){
                return ;
            }
            System.out.print(apart);
        }
        if(a.length == 0){
            System.out.println("");
        }
    }

}
