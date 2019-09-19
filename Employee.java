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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDepartment() {
        return department;
    }

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

    /**
     * Derterminese wheter an Employee is equal to another based on their ID.
     *
     * @return true if this is the same Employee, false if not.
     */
    public boolean equals(Object other) {
        Employee otherEmployee = (Employee)other;
        boolean isEqual = false;

        if(this.id == otherEmployee.id) {
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

        builtString.append("Employee(" + this.id + ") ");
        builtString.append(this.person.getLast() + ", ");
        builtString.append(this.person.getFirst() + ": ");
        builtString.append(this.person.getStatus() + "\n");
        builtString.append("\tRecord: " + this.years + " years in division ");
        builtString.append("[" +this.years + "] -- Dept: " + this.department);
        builtString.append("\n" + DASHES);

        return builtString.toString();
    }

} // end Employee class
