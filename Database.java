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

    private static final String EQUALS = repeatChar('=', 35);

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
            System.out.println("Please make a selection:");
            System.out.println("\t0) Quit");
            System.out.println("\t1) Intersect");
            System.out.println("\t2) Difference");
            System.out.println("\t3) Union");
            System.out.println("\t4) Select");
            System.out.println("\t5) Remove");
            System.out.println("\t6) Print both tables");
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            try {
                userSelection = input.nextInt();
            } catch (InputMismatchException ime) {
                incorrectChoice = true;
                continue;
            }

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
                    System.out.printf("%s %s %s" , EQUALS,
                            this.faculty.getTitle(), EQUALS);
                    System.out.println(this.faculty.toString());
                    System.out.printf("%s %s %s\n\n", EQUALS,
                            this.faculty.getTitle(), EQUALS);
                    System.out.printf("%s %s %s" , EQUALS,
                            this.admin.getTitle(), EQUALS);
                    System.out.println(this.admin.toString());
                    System.out.printf("%s %s %s\n\n", EQUALS,
                            this.admin.getTitle(), EQUALS);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    incorrectChoice = true;
                    break;
            } // end switch statement
        } // end while loop
    } // end go method

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
                //System.out.println(lastName);
                String firstName = input.next();
                //System.out.println(firstName);
                String status = input.next();
                //System.out.println(status);
                String id = Integer.toString(input.nextInt());
                //System.out.println(id);
                String phone = Long.toString(input.nextLong());
                //System.out.println(phone);
                String division = Integer.toString(input.nextInt());
                //System.out.println(division);
                String years = Integer.toString(input.nextInt());
                //System.out.println(years + "\n");

                table.insert(new Employee(lastName, firstName, status,
                        id, phone, division, years, table.getTitle()));

            } // end while

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
