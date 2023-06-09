package day0609.rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rock, paper, scissors:");
        Player.show(sc.next());
        ComputerChoice.show(ComputerChoice.getChoice((int)(Math.random() * 3 + 1)));
        Player.match();



    }
}
