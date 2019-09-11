/**
 * Represents an employee in our database.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public class Employee implements AttributeInterface  {

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

    /**
     * The constructor for a person object.
     */
    public Employee(
            String lastName,
            String firstName,
            String status,
            String id,
            String phone,
            String division,
            String years) {

        this.id = id;
        this.phone = phone;
        this.division = division;
        this.years = years;
        this.person = new Person(firstName, lastName, status);

    } // end constructor

    /**
     * Check to see if a record has an attribute containing a specific value.
     *
     * @param attribute The attribute to check
     * @param value The specific value to check for.
     * @return true if the value exists, false otherwise.
     */
    @Override
    public boolean check(String attribute, String value) {

        boolean hasAttribute = false;

        switch(attribute) {
            case "id":
                if(this.id.equals(value)) {
                    hasAttribute = true;
                }
                break;
            case "phone":
                if(this.phone.equals(value)) {
                    hasAttribute = true;
                }
                break;
            case "division":
                if(this.division.equals(value)) {
                    hasAttribute = true;
                }
                break;
            case "years":
                if(this.years.equals(value)) {
                    hasAttribute = true;
                }
                break;
            case "person":
                if(this.person.toString().equals(value)) {
                    hasAttribute = true;
                }
                break;
        } // end switch statement

        return hasAttribute;
    } // end check method.

    /**
     * Change the value of a specific attribute.
     *
     * @param attribute The attribute to change.
     * @param value The value we are changing the attribute to.
     * @return True if the value was changed, false otherwise.
     */
    @Override
    public boolean change(String attribute, String value) {
        // TODO finish change method.
        return false;
    } // end change method

    /**
     * Create a deep copy. NOTE: Do not use clone() or copy constructors.
     *
     * @return A deep copy.
     */
    @Override
    public void /*AttributeInterface*/ makeCopy() {
        // TODO finish makeCopy method that makes a deep copy.
    }

    @Override
    public String toString() {
        StringBuilder builtString = new StringBuilder();

        builtString.append(this.id + "\t");
        builtString.append(this.person.getFirst() + "\t");
        builtString.append(this.person.getLast() + "\t");
        builtString.append(this.phone + "\t");
        builtString.append(this.division + "\t");
        builtString.append(this.years + "\t");
        return builtString.toString();
    }

} // end Employee class
