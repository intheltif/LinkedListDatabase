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
    public Person(String firstName, String lastName, Status status) {

        this.first  = firstName;
        this.last   = lastName;
        this.status = status;

    } // end Person constructor

    // Getters and setters below

    public void setFirst(String firstName) {
        this.first = firstName;
    }

    public void setLast(String lastName) {
        this.last = lastName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFirst() {
        return this.first;
    }
    public String getLast() {
        return this.last;
    }
    public String getStatus() {
        return this.status;
    }

} // end Person class
