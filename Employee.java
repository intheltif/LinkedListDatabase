public class Employee implements AttributeInterface {

    /** Identification number */
    private String id;

    /** Phone number */
    private String phone;

    /** Division within the institution */
    private String division;

    /** Number of years employed */
    private String years;

    /** Personal Information */
    private Person person;

    /** Current department or classification */
    private String department;

    /**
     * The constructor for a person object.
     */
    public Employee(
            String id,
            String phone,
            String division,
            String years,
            Person person,
            String department) {

        this.id = id;
        this.phone = phone;
        this.division = division;
        this.years = years;
        this.person = person;
        this.department = department;

    } // end constructor

    /**
     * Check to see if a record has an attribute containing a specific value.
     *
     * @param attribute The attribute to check
     * @param value The specific value to check for.
     * @return true if the value exists, false otherwise.
     */
    public boolean check(String attribute, String value) {
        // TODO finish check method.
    } // end check method.

    /**
     * Change the value of a specific attribute.
     *
     * @param attribute The attribute to change.
     * @param value The value we are changing the attribute to.
     * @return True if the value was changed, false otherwise.
     */
    public boolean change(String attribute, String value) {
        // TODO finish change method.
    } // end change method

    /**
     * Create a deep copy. NOTE: Do not use clone() or copy constructors.
     *
     * @return A deep copy.
     */
    public AttributeInterface makeCopy() {
        // TODO finish makeCopy method that makes a deep copy.
    }

} // end Employee class
