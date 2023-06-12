package day0612;

import com.google.gson.Gson;

public class StringMethod {
    public static void main(String[] args) {
        StringBuffer sMessage = new StringBuffer("jka");
        StringBuffer sFinalMessage =  sMessage.append("_").append("yeah");
        String sFinal = sFinalMessage.toString();
        System.out.println("sResult = " + sFinal);

        String s = new String();
        System.out.println("s = " + s);



    }

}
