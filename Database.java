import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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

    private static final String EQUALS = repeatChar('=', 40);

    private Table<Employee> faculty = new Table<>("Faculty");
    private Table<Employee> admin = new Table<>("Admin");
    private Scanner input;

    public static void main(String[] args) {

        Database db = new Database();
        db.go();

        System.exit(SUCCESS);
    } // end main method;

    private void go() {
        File facultyData = null;
        File adminData = null;

        try {
            facultyData = new File("./faculty.txt");
            adminData = new File("./admin.txt");
        } catch (NullPointerException npe) {
            System.out.println("Unable to find files to populate database. " +
                    "Exiting...");
            System.exit(FAILURE);
        }

        System.out.println("Auto-populating database...");

        populateDB(facultyData, this.faculty);
        populateDB(adminData, this.admin);

        int userSelection = -1;
        boolean incorrectChoice = true;
        this.input = new Scanner(System.in);

        while(incorrectChoice) {

            printMainMenu();

            try {
                userSelection = input.nextInt();
            } catch (InputMismatchException ime) {
                incorrectChoice = true;
                continue;
            }

            incorrectChoice = performSelection(userSelection);
        } // end while loop
        input.close();
    } // end go method

    /**
     * Prints the main menu for the database to stdout.
     */
    private void printMainMenu() {
        System.out.println("Please make a selection:");
        System.out.println("\t0) Quit");
        System.out.println("\t1) Intersect");
        System.out.println("\t2) Difference");
        System.out.println("\t3) Union");
        System.out.println("\t4) Select");
        System.out.println("\t5) Remove");
        System.out.println("\t6) Print both tables");
        System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    } // end printMainMenu method

    /**
     * Performs the main menu item selected by the user.
     *
     * @param selection The main menu number input by the user.
     * @return True if the selection is valid, allowing another choice from
     *         the main menu.
     */
    private boolean performSelection(int selection) {
        boolean isValidChoice = true;
        switch (selection) {
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
                this.input = new Scanner(System.in);
                String chosenTable;
                String idToRemove;
                try {
                    System.out.print("Enter Table (F/A) >> ");
                    chosenTable = input.next();
                    System.out.print("Enter Value >> ");
                    idToRemove = Integer.toString(input.nextInt());
                } catch (InputMismatchException ime) {
                    System.out.println("Incorrect format. Exiting to menu...");
                    break;
                }
                if(chosenTable.toLowerCase() == "f") {
                    this.faculty.remove(idToRemove);
                } else if(chosenTable.toLowerCase() == "a") {
                    this.admin.remove(idToRemove);
                } else {
                    System.out.println("Please choose an existing table. " +
                            "(F)aculty or (A)dmin...");
                }
                input.close();
                break;
            case 6:
                printTable(this.faculty);
                printTable(this.admin);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        } // end switch statement
        return isValidChoice;
    } // end performSelection method.

    /**
     * Populates a single table in our database with records from a file.
     *
     * @param file The file to populate the records from.
     * @param table The table to insert the records into.
     */
    private void populateDB(File file, Table<Employee> table) {

        try {
            this.input = new Scanner(file);

            while(input.hasNext()) {
                //TODO Remove println's here
                String lastName = input.next();
                String firstName = input.next();
                String status = input.next();
                String id = Integer.toString(input.nextInt());
                String phone = Long.toString(input.nextLong());
                String division = Integer.toString(input.nextInt());
                String years = Integer.toString(input.nextInt());

                table.insert(new Employee(lastName, firstName, status,
                        id, phone, division, years, table.getTitle()));

            } // end while
            input.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Unable to read faculty data into database. " +
                    "Exiting...");
            System.exit(FAILURE);
        } catch (InputMismatchException ime) {
            System.out.println("Phone, ID, Division, and Years must be an " +
                    "integer. Unable to populate database. Exiting...");
            System.exit(FAILURE);
        } catch (NoSuchElementException nsee) {
            System.out.println("Incorrect file format. Unable to populate " +
                    "database. Exiting...");
            System.exit(FAILURE);
        } // end try-catch
    } // end populateDB method.

    /**
     * Prints out the specified table in a nicely formatted manner.
     *
     * @param table The table to print.
     */
    private void printTable(Table<Employee> table) {

        // Print the table with correct formatting
        System.out.printf("%s%s%s" , EQUALS, table.getTitle(), EQUALS);
        System.out.println(this.faculty.toString());
        System.out.printf("%s%s%s\n\n", EQUALS, table.getTitle(), EQUALS);
    }


    /**
     * Creates a string of size <em>length</em> of the same character. Used for
     * printing multiple of the same character to separate pieces of data.
     *
     * @param character The character to print.
     * @param length The amount of times that character should appear in the final
     *               string.
     * @return A String containing <em>length</em> number of characters.
     */
    private static final String repeatChar(char character, int length) {
        char[] data = new char[length];
        Arrays.fill(data, character);
        return new String(data);
    } // end repeatChar method.

} // end Database class
