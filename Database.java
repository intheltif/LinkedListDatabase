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

    /** A constant to represent a failed exit. */
    private static final int FAILURE = 1;

    /** A constant to represent a successful exit. */
    private static final int SUCCESS = 0;

    /** A constant to represent a row of equals to separate data. */
    private static final String EQUALS = repeatChar('=', 33);

    /** Table holding information about faculty staff. */
    private Table<Employee> faculty = new Table<>("Faculty");

    /** Table holding information about administration staff. */
    private Table<Employee> admin = new Table<>("Admin");

    /** The scanner to read input into the database */
    private Scanner input;

    /**
     * The main entry point into the program. To avoid having to make all
     * methods static, this main method lets go() do all of the work of calling
     * non-static methods.
     *
     * @param args The command line arguments. Passed down to the go() method.
     */
    public static void main(String[] args) {

        Database db = new Database();
        db.go();

        System.exit(SUCCESS);
    } // end main method;

    /**
     * The method that essentially runs our database. It calls all of the
     * methods needed to populate and run the functionality of the database.
     */
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

        populateDB(adminData, this.admin);
        populateDB(facultyData, this.faculty);

        String userSelection = "";
        boolean incorrectChoice = true;
        this.input = new Scanner(System.in);
        do{
            printMainMenu();
            try{
                userSelection = input.next();
            } catch(InputMismatchException ime) {
                incorrectChoice = true;
            }

            performUserSelection(userSelection);

        } while(incorrectChoice);

        this.input.close();
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
        System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
    } // end printMainMenu method

    /**
     * Performs the main menu item selected by the user.
     *
     * @param selection The main menu number input by the user.
     * @return True if the selection is valid, allowing another choice from
     *         the main menu.
     */
    private void performUserSelection(String selection) {
        String chosenTable = null;
        switch (selection) {
            case "0":
                // Exit the program
                System.out.println("Quitting...");
                System.exit(0);
            case "1":
                System.out.println("Performing intersect...");
                performDatabaseIntersect();
                break;
            case "2":
                // Do Difference
                System.out.println("Performing difference...");
                // TODO Still need to finish method below
                performDatabaseDifference();
                break;
            case "3":
                // Do Union
                System.out.println("Performing union...");
                performDatabaseUnion();
                break;
            case "4":
                // Do Select
                System.out.println("Performing select...");
                performDatabaseSelect();
                break;
            case "5":
                // Do Remove
                System.out.println("Performing remove...");

                this.input = new Scanner(System.in);
                String idToRemove;
                try {
                    System.out.print("Enter Table (F/A) >> ");
                    chosenTable = input.next();
                } catch (InputMismatchException ime) {
                    System.out.println("Incorrect format. Exiting to menu...");
                    break;
                }
                if(!(chosenTable.toLowerCase().equals("f") ||
                        chosenTable.toLowerCase().equals("a"))) {
                    System.out.println("Please choose an existing table. " +
                            "(F)aculty or (A)dmin...");
                    break;
                }

                try {
                    System.out.print("Enter Value >> ");
                    idToRemove = Integer.toString(input.nextInt());
                } catch (InputMismatchException ime) {
                    System.out.println("Incorrect format. Exiting to menu...");
                    break;
                }
                if(chosenTable.toLowerCase().equals("f")) {
                    this.faculty.remove(idToRemove);
                } else if(chosenTable.toLowerCase().equals("a")) {
                    this.admin.remove(idToRemove);
                } else {
                    System.out.println("Please choose an existing table. " +
                            "(F)aculty or (A)dmin...");
                }

                break;
            case "6":
                printTable(this.faculty);
                printTable(this.admin);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        } // end switch statement
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
            this.input.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Unable to read data into database. " +
                    "Cannot find file. Exiting...");
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
        System.out.println(table.toString());
        System.out.printf("%s%s%s\n\n", EQUALS, table.getTitle(), EQUALS);
    }

    /**
     * Get the input needed for performing a union on two tables, perform the
     * union, then print the newly created table.
     */
    private void performDatabaseUnion() {

        printTable(this.faculty.union(this.admin));

    } // End performDatabaseUnion

    /**
     * Get the input needed for performing a intersect on two tables, perform
     * the intersect, then print the newly created table.
     */
    private void performDatabaseIntersect() {

        String attr = "";
        String value = "";

        try {
            System.out.print("Enter Attribute >> ");
            attr = input.next();
            System.out.print("Enter Value >> ");
            value = input.next();
        } catch (NoSuchElementException nsee) {
            System.out.println("Incorrect format. Exiting to menu...");
            return;
        } catch (IllegalStateException ise) {
            System.out.println("Scanner was closed prematurely. " +
                    "Exiting to menu...");
            return;
        }

        printTable(this.faculty.intersect(attr, value, this.admin));
    } // End performDatabaseIntersect method

    /**
     * Get the input needed for performing a intersect on two tables, perform
     * the intersect, then print the newly created table.
     */
    private void performDatabaseDifference() {

        String chosenTable = "";

        try {
            System.out.print("Enter Table (F/A) >> ");
            chosenTable = input.next();
        } catch (NoSuchElementException nsee) {
            System.out.println("Incorrect format. Exiting to menu...");
            return;
        } catch (IllegalStateException ise) {
            System.out.println("Scanner was closed prematurely. " +
                    "Exiting to menu...");
            return;
        }

        if(chosenTable.toLowerCase().equals("f")) {
            printTable(this.faculty.difference(this.admin));
        } else if(chosenTable.toLowerCase().equals("a")) {
            printTable(this.admin.difference(this.faculty));
        } else {
            System.out.println("Please choose an existing table. " +
                    "(F)aculty or (A)dmin...");
        }
    } // End performDatabaseDifference method

    /**
     * Get the input needed for performing a Select on a table, perform the
     * select, then print the newly created table.
     */
    private void performDatabaseSelect() {

        String attr = "";
        String value = "";
        String chosenTable = null;
        try {
            System.out.print("Enter Table (F/A) >> ");
            chosenTable = input.next();
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect format. Exiting to menu...");
            return;
        }
        if(!(chosenTable.toLowerCase().equals("f") ||
                chosenTable.toLowerCase().equals("a"))) {
            System.out.println("Please choose an existing table. " +
                    "(F)aculty or (A)dmin...");
            return;
        }
        try {
            System.out.print("Enter Attribute >> ");
            attr = input.next();
            System.out.print("Enter Value >> ");
            value = input.next();
        } catch (NoSuchElementException nsee) {
            System.out.println("Incorrect format. Exiting to menu...");
            return;
        } catch (IllegalStateException ise) {
            System.out.println("Scanner was closed prematurely. " +
                    "Exiting to menu...");
            return;
        }

        if(chosenTable.toLowerCase().equals("f")) {
            printTable(this.faculty.selection(attr.toLowerCase(),
                    value.toLowerCase()));
        } else if(chosenTable.toLowerCase().equals("a")) {
            printTable(this.admin.selection(attr.toLowerCase(),
                    value.toLowerCase()));
        } else {
            System.out.println("Please choose an existing table. " +
                    "(F)aculty or (A)dmin...");
        }

    } // End performDatabaseSelect method

    /**
     * Creates a string of size <em>length</em> of the same character. Used for
     * printing multiple of the same character to separate pieces of data.
     *
     * @param character The character to print.
     * @param length The amount of times that character should appear in the final
     *               string.
     *
     * @return A String containing <em>length</em> number of characters.
     */
    private static final String repeatChar(char character, int length) {
        char[] data = new char[length];
        Arrays.fill(data, character);
        return new String(data);
    } // end repeatChar method.

} // end Database class
