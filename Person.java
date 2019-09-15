/*
 * Represents a person in our Database.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public class Person {

    /** An enumeration of marital statuses a person can have */
    private enum Status {

        S("Single"),
        M("Married"),
        D("Divorced"),
        W("Widowed");

        private final String status;

        private Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return this.status;
        }
    }

    /** First Name */
    private String first;

    /** Last name */
    private String last;

    /** Marital Status */
    private Status status;

    /**
     * Creates a person object.
     *
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param status The marital status of the person.
     */
    public Person(String firstName, String lastName, String status) {

        this.first  = firstName;
        this.last   = lastName;
        this.status = Status.valueOf(status.toUpperCase());

    } // end Person constructor

    /**
     * Change the first name of this person. Used in the case that a person
     * has a legal name change.
     *
     * @param firstName This person's new first name.
     */
    public void setFirst(String firstName) {
        this.first = firstName;
    } // end setFirst method

    /**
     * Change the last name of this person.
     *
     * @param lastName The person's new last name.
     */
    public void setLast(String lastName) {
        this.last = lastName;
    } // end setLast method

    /**
     * Change this person's marital status.
     *
     * @param status The new marital status.
     */
    public void setStatus(String status) {
        this.status = Status.valueOf(status.toUpperCase());
    } //end setStatus method

    /**
     * Return this person's first name.
     *
     * @return The first name of this person.
     */
    public String getFirst() {
        return this.first;
    } // end getFirst method

    /**
     * Return this person's last name.
     *
     * @return The last name of this person.
     */
    public String getLast() {
        return this.last;
    } // end getLast method

    /**
     * Return the marital status of this Person.
     *
     * @return The marital status of this person.
     */
    public String getStatus() {
        return this.status.getStatus();
    } // end getStatus method

    /**
     * Converts our person object to a string. The format of the string
     * is "Last Name, First Name, Marital Status".
     *
     * @return This object as a String in the format specified above.
     */
    public String toString() {
        StringBuilder personString = new StringBuilder("");

        personString.append(this.last + ", ");
        personString.append(this.first + ", ");
        personString.append(this.status);

        return personString.toString();
    }
} // end Person class
