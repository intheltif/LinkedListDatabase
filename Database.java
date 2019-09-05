import java.util.Scanner;

/**
 * The driver of our program. Does all of the printing to the console.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public class Database {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please make a selection:");
        System.out.println("\t0) Quit");
        System.out.println("\t1) Intersect");
        System.out.println("\t2) Difference");
        System.out.println("\t3) Union");
        System.out.println("\t4) Select");
        System.out.println("\t5) Remove");
        System.out.println("\t6) Print both tables");
        System.out.print(">>>>>>>>>>>>>>>>>>>> ");
        int userSelection = input.nextInt();

        // This will exit on any choice except 1 through 6.
        // TODO Change this to exit on 0, error on any number outside 1<=x<=6
        switch (userSelection) {
            case 1:
                // Do Intersect
            case 2:
                // Do Difference
            case 3:
                // Do Union
            case 4:
                // Do Select
            case 5:
                // Do Remove
            case 6:
                // Print both tables
            default:
                System.exit(0);    // Successful exit
        } // end switch statement

    } // end main method

} // end Database class
