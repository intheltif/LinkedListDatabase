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
     * Make a deep copy. Do NOT use clone() or copy constructor.
     */
    public void /*AttributeInterface*/ makeCopy();
} //end AttributeInterface interface
