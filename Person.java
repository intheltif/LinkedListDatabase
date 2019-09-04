/**
 * Represents a person in our Database.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public class Person {

    /** First Name */
    private String first;
    /** Last name */
    private String last;
    /** Marital Status */
    private Status status;

    /**
     * Constructs a person object
     */
    public Person(String firstname, String lastname, Status status) {

        this.first  = firstname;
        this.last   = lastname;
        this.status = status;

    } // end Person constructor

} // end Person class
