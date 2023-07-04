package day0609.rockpaperscissors;

public class ComputerChoice {
    static String pick;

    public static String getChoice(int order){
        if(order == 1){
            return "rock";
        }else if(order == 2){
            return "paper";
        }else{
            return "scissors";
        }
    }

    public static void show(String choice){
        System.out.print("Computer Choice: ");
        System.out.println(choice);
        pick = choice;
    }



}
