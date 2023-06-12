package day0609.rockpaperscissors;

import java.util.Objects;

public class Player {
    static String pick;
    public static void show(String choice){
        System.out.print("User Input: ");
        System.out.println(choice);
        pick = choice;
    }

    public static void match(){
        if(Objects.equals(pick, ComputerChoice.pick)){
            System.out.println("draw");
        }else if((pick.equals("rock") && ComputerChoice.pick.equals("scissors"))
            || (pick.equals("scissors") && Objects.equals(ComputerChoice.pick, "paper"))
            || (pick.equals("paper") && Objects.equals(ComputerChoice.pick, "rock"))){
            System.out.println("win");
        }else{
            System.out.println("lose");
        }
    }
}
