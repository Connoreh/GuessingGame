import java.util.Scanner;

public class UserInput {

    public static int getInt(String prompt, Integer floor, Integer ceiling) {
        int val = 0;
        Scanner sc = new Scanner(System.in);
        boolean goodVal = false; // control loop
        do {
            try {
                System.out.print(prompt);
                val = Integer.parseInt(sc.nextLine());
                if (floor != null && val < floor) {
                    System.out.println("Your value of " + val + " is lower than " + floor);
                    goodVal = false;
                }
                else if (ceiling != null && val > ceiling) {
                    System.out.println("Your value of " + val + " is higher than " + ceiling);
                    goodVal = false;
                }
                else {
                    goodVal = true;
                }
            } catch (Exception e) {
                System.out.println("Illegal input: not an integer.");
                goodVal = false;
            }

        } while (goodVal == false);

        return val;
    }
}

