import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The driver of our program. Does all of the printing to the console.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public class Database {

    private static final int FAILURE = 1;
    private static final int SUCCESS = 0;

    public static void main(String[] args) {


        System.out.println("Auto-populating database...");
        File facultyData = null;
        File adminData = null;
        Table<Employee> faculty = new Table<>("Faculty");
        Table<Employee> admin = new Table<>("Admin");

        try {
            facultyData = new File("./faculty.txt");
            adminData = new File("./admin.txt");
        } catch (NullPointerException npe) {
            System.out.println("Unable to populate database. Exiting...");
            System.exit(FAILURE);
        }

        try {
            Scanner input = new Scanner(facultyData);

            while(input.hasNextLine()) {
                String[] lineArray = input.nextLine().split("\\s+");
                String lastName = lineArray[0];
                String firstName = lineArray[1];
                String status = lineArray[2];
                String id  = lineArray[3];
                String phone = lineArray[4];
                String division = lineArray[5];
                String years = lineArray[6];
                faculty.insert(new Employee(lastName, firstName, status, id, phone, division, years));
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Unable to read faculty data into database. Exiting...");
            System.exit(FAILURE);
        }

        boolean incorrectChoice = true;
        // ============= TESTING IF LINKED LIST WORKS ==================

/*

        Table<Employee> faculty = new Table<>("Faculty");
        faculty.insert(new Employee("100", "John", "Doe", "MARRIED", "828-227-9999", "faculty", "12", "Comp Sci"));
        faculty.insert(new Employee("200", "Jane", "Doe", "MARRIED", "828-227-9922", "faculty", "12", "Comp Sci"));
        faculty.insert(new Employee("300", "Jimmy", "Buffet", "DIVORCED", "828-888-9292", "faculty", "12", "Comp Sci"));
        faculty.insert(new Employee("400", "Fred", "Flintstone", "SINGLE", "828-456-4567", "faculty", "12", "Comp Sci"));

        System.out.println(faculty.toString());

*/

        // ============= TESTING IF LINKED LIST WORKS ==================


        System.out.println(faculty.toString());
/*
        while(incorrectChoice) {
            System.out.println("Please make a selection:");
            System.out.println("\t0) Quit");
            System.out.println("\t1) Intersect");
            System.out.println("\t2) Difference");
            System.out.println("\t3) Union");
            System.out.println("\t4) Select");
            System.out.println("\t5) Remove");
            System.out.println("\t6) Print both tables");
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            int userSelection = input.nextInt();

        // Main menu
            switch (userSelection) {
                case 0:
                    // Exit the program
                    System.out.println("Quitting...");
                    System.exit(0);
                case 1:
                    System.out.println("Performing intersect...");
                    break;
                case 2:
                    // Do Difference
                    System.out.println("Performing difference...");
                    break;
                case 3:
                    // Do Union
                    System.out.println("Performing union...");
                    break;
                case 4:
                    // Do Select
                    System.out.println("Performing select...");
                    break;
                case 5:
                    // Do Remove
                    System.out.println("Performing remove...");
                    break;
                case 6:
                    // Print both tables
                    System.out.println("Printing both tables.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    incorrectChoice = true;
                    break;
            } // end switch statement
        }
*/
        System.exit(SUCCESS);
    } // end main method;

} // end Database class
