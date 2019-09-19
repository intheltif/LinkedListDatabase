import java.util.Arrays;

/**
 * Represents an employee in our database.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public class Employee implements AttributeInterface  {

    /** Dashes to separate each employee in our toSting */
    private static final String DASHES = repeatChar('-', 70);

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

    /** Department belonged to */
    private String department;

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
            String years,
            String deparment) {

        this.id = id;
        this.phone = phone;
        this.division = division;
        this.years = years;
        this.person = new Person(firstName, lastName, status);
        this.department = deparment;

    } // end constructor

    /**
     * Gets the id of this person as a string.
     *
     * @return This person's ID as a string.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of this person.
     *
     * @param id The new id given to this person.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the phone number of this person as a string.
     *
     * @return This person's phone number as a string.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of this person.
     *
     * @param phone The new phone number given to this person.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the division of this person as a string.
     *
     * @return This person's division as a string.
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the division of this person.
     *
     * @param division The new division the person is a part of.
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * Gets the number of years this person has been working here.
     *
     * @return This number of years worked here as a String.
     */
    public String getYears() {
        return years;
    }

    /**
     * Sets the number of years this person has worked here.
     *
     * @param years The number of years worked here.
     */
    public void setYears(String years) {
        this.years = years;
    }

    /**
     * Gets the department name this employee belongs to.
     *
     * @return The name of this employee's department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of this employee
     *
     * @param department The new department of this employee.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

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
                if(Integer.parseInt(this.id) == Integer.parseInt(value)) {
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
            case "department":
                if(this.department.equals(value)) {
                    hasAttribute = true;
                }
                break;
        } // end switch statement

        return hasAttribute;
    } // end check method.

    /**
     * Change the value of a specific attribute. For changing the person
     * attribute, you must specify the part of the person (first, last, status)
     * that is being changed, and provide that value. This method will take
     * care of changing the person object.
     *
     * @param attribute The attribute to change.
     * @param value The value we are changing the attribute to.
     * @return True if the value was changed, false otherwise.
     */
    @Override
    public boolean change(String attribute, String value) {
        boolean wasChanged = false;

        switch(attribute) {
            case "id":
                this.setId(value);
                wasChanged = true;
                break;
            case "phone":
                this.setPhone(value);
                wasChanged = true;
                break;
            case "division":
                this.setDivision(value);
                break;
            case "years":
                this.setYears(value);
                wasChanged = true;
                break;
            case "first":
                this.person.setFirst(value);
                wasChanged = true;
                break;
            case "last":
                this.person.setLast(value);
                wasChanged = true;
                break;
            case "status":
                this.person.setStatus(value);
                wasChanged = true;
                break;
            case "department":
                this.setDepartment(value);
                wasChanged = true;
                break;
        } // end switch statement

        return wasChanged;
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

    /**
     * Determines whether an Employee is equal to another based on their ID.
     *
     * @return true if this is the same Employee, false if not.
     */
    public boolean equals(Object other) {
        Employee otherEmployee = (Employee)other;
        boolean isEqual = false;

        if(this.id.equals(otherEmployee.id)) {
            isEqual = true;
        }

        return isEqual;
    } // end equals method

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

    @Override
    public String toString() {
        StringBuilder builtString = new StringBuilder();

        builtString.append("Employee(").append(this.id).append(") ");
        builtString.append(this.person.getLast()).append(", ");
        builtString.append(this.person.getFirst()).append(": ");
        builtString.append(this.person.getStatus()).append("\n");
        builtString.append("\tRecord: ").append(this.years).append(" years in division ");
        builtString.append("[").append(this.division).append("] -- Dept: ").append(this.department);
        builtString.append("\n").append(DASHES);

        return builtString.toString();
    }

} // end Employee class
