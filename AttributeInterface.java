/**
 * An interface that provides methods the records in the database
 * must implement.
 *
 * @author Evert Ball
 * @version 09/18/2019
 */
public interface AttributeInterface {

    /**
     * Check to see if a record has an attribute containing a specific value.
     */
    public boolean check(String attribute, String value);

    /**
     * Change the value of a specific attribute.
     */
    public boolean change(String attribute, String value);

    /**
     * Make a deep copy.
     */
    public AttributeInterface makeCopy();
} //end AttributeInterface interface
