/*  Guessing game by Connor Hellman
Choose to play hot or cold or high or low, and guess a number randomly generated, receive feedback on guess until correct.
*/

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    static Scanner sc = new Scanner(System.in);
    static int previousCategory;
    static int previousDifference;

    public static void main(String[] args){
        System.out.println("Welcome to the Guessing Game!");
        int gametype, rnum;
        String menu;
        menu = "Game type: 1=Hot/Cold, 2=High/Low, 0=Quit): ";
        gametype = UserInput.getInt(menu, 0,2);
        while (gametype != 0){
            Random rnd = new Random();
            rnum = rnd.nextInt(100) + 1;
            System.out.println("I am thinking of a number from 1 to 100.." + rnum);
            if (gametype == 1){
                playHotCold(rnum);

            } else if (gametype == 2){
                playHighLow(rnum);

            } else {
                System.out.println("I do not know " + gametype);

            }
            gametype = UserInput.getInt(menu, 0, 2);
        } // end while

        System.out.println("Thanks for playing!");

    }// end main
    private static void playHotCold(int rnum){
        int userGuess;
        int userGuessCount = 0; //how many times guessed
        boolean playing = true;
        previousCategory = 0;
        previousDifference = 0;
        String hotColdMenu = "Your Guess? (0=quit): ";
        do {
            userGuess = UserInput.getInt(hotColdMenu, 0, 100);
            userGuessCount++;
            if(userGuess == rnum){
                System.out.println("You guessed my number in " + userGuessCount + " tries!");
                playing = false;
            } else if (userGuess == 0) {
                playing = false;
                System.out.println("Sorry, you did not guess my number: " + rnum + " in " + --userGuessCount + " tries.");
            } else {
                showHotCold(userGuess, rnum);
            }



        } while (playing);



    }
    private static void showHotCold(int userGuess, int rnum){

        int diff = Math.abs(userGuess - rnum);
        String msg = "";
        int category = 0;
        if (diff > 60){
            msg = "cold";
            category = 1;
        } else if (diff >= 30){
            msg = "warm";
            category = 2;
        } else if (diff >= 16){
            msg = "very warm";
            category = 3;
        } else {
            msg = "Hot";
            category = 4;
        }
        if (previousCategory == category){
            if(diff == previousDifference){
                msg+= "(same degree)";
            }else if (diff > previousDifference){
                msg += "(getting colder)";
            } else {
                if(category == 4){
                    msg+= "(getting hotter)";
                }
                else {
                    msg += "(getting warmer)";
                }
            }
//            msg += "message";
        }
        System.out.println("Your guess was " + msg);
        previousCategory = category;
        previousDifference = diff;


    }
    private static void playHighLow(int rnum){
        int userGuess;
        int userGuessCount = 0; //how many times guessed
        boolean playing = true;
        String msg = "";
        String HighLowMenu = "Your Guess? (0=quit): ";
//        userGuess = UserInput.getInt(HighLowMenu, 0, 100);
        do {
            userGuess = UserInput.getInt(HighLowMenu, 0, 100);
            userGuessCount++;
            if (userGuess > rnum) {
                System.out.println("too high");
//                userGuess = UserInput.getInt(HighLowMenu, 0, 100);
            } else if (userGuess == 0){
                playing = false;
                System.out.println("Sorry, you did not guess my number: " + rnum + " in " + --userGuessCount + " tries.");

            } else if (userGuess < rnum) {
                System.out.println("too low");
//                userGuess = UserInput.getInt(HighLowMenu, 0, 100);
            } else {
                System.out.println("You guessed my number in " + userGuessCount + " tries!");
                playing = false;
            }
        } while (playing);

    }
}
