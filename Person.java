/*
 * Represents a person in our Database.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public class Person {

    private enum Status {
        SINGLE,
        MARRIED,
        DIVORCED,
        WIDOWED,
    };
    /** First Name */
    private String first;
    /** Last name */
    private String last;
    /** Marital Status */
    private Status status;

    /**
     * Constructs a person object
     */
    public Person(String firstName, String lastName, String status) {

        this.first  = firstName;
        this.last   = lastName;
        this.status = Status.valueOf(status.toUpperCase());

    } // end Person constructor

    public void setFirst(String firstName) {
        this.first = firstName;
    } // end setFirst method

    public void setLast(String lastName) {
        this.last = lastName;
    } // end setLast method

    public void setStatus(Status status) {
        this.status = status;
    } //end setStatus method

    public String getFirst() {
        return this.first;
    } // end getFirst method
    public String getLast() {
        return this.last;
    } // end getLast method

    public Status getStatus() {
        return this.status;
    } // end getStatus method
} // end Person class
