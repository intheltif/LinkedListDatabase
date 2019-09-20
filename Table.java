/**
 * An object that represents a table in our database. The type of this table
 * must implement the <em>AttributeInterface</em> interface.
 *
 * @author Evert Ball
 * @version 09/18/2019
 *
 */
public class Table<T extends AttributeInterface> {

    /** First record in the table */
    private Node head;

    /** Last record in the table */
    private Node tail;

    /** The current record we are on in the table */
    private Node currentNode;

    /** Label for the table */
    private String title;

    /**
     * Constructor that creates a table with only the title.
     *
     * @param title The name of the table.
     */
    public Table(String title) {

        this.head  = null;
        this.tail  = null;
        this.title = title;
        this.currentNode = null;

    } // end Table constructor

    // Getters and Setters
    
    /**
     * Set the head of the Linked List.
     *
     * @param head The head node of the linked list.
     */
    public void setHead(Node head) {
        this.head = head;
    } // end setHead method

    /**
     * Set the tail node of the linked list.
     *
     * @param tail The tail node of the linked list.
     */
    public void setTail(Node tail) {
        this.tail = tail;
    } // end setTail method
    
    /**
     * Set the current node of the linked list.
     *
     * @param current The current node of the linked list.
     */
    public void setCurrent(Node current) {
        this.currentNode = current;
    } // end setCurrent method

    /**
     * Set the name of the table.
     *
     * @param title The name of the table.
     */
    public void setTitle(String title) {
        this.tail = tail;
    } // end setTail method

    /**
     * Get the head of the Linked List.
     *
     * @return The first record in the table.
     */
    public Node getHead() {
        return this.head;
    } // end getHead method

    /**
     * Get the tail node of the linked list.
     *
     * @return The last record in the table.
     */
    public Node getTail() {
        return this.tail;
    } // end getTail method

    /**
     * Set the current node of the linked list.
     *
     * @return The current record in our table.
     */
    public Node getCurrent() {
        return this.currentNode;
    } // end getCurrent method

    /**
     * Get the name of the table.
     *
     * @return The name of the table.
     */
    public String getTitle() {
        return this.title;
    } // end getTail method

    /**
     * Adds a new record to the end of table. If the table is empty, sets the
     * head and the tail references to the new node. Otherwise it changes the
     * current tail to point to the newly created Node and moves the tail to
     * the new Node. If the record already exists in our table, we do not add
     * it again.
     *
     * @param data The data for the new row in the table.
     */
    public void insert(T data) {

        Node newNode = new Node(data);

        // If head is null then the list is empty.
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else if(!this.contains(data)) { // otherwise, just add to the list.
            this.tail.next = newNode;
            this.tail = newNode;
        } // end if statement
    } // end insert method

    /**
     * Removes the node matching id. Does a lot of checks to see which node
     * we are currently on. Keeps track of nodes ahead and behind of the
     * current so that we can remove it's reference, essentially deleting
     * the node.
     *
     * @param id The ID of the node to remove.
     */
    public void remove(String id) {
        // Store head node
        Node current = head;
        Node prev = null;

        // If the id is the first node
        if (current != null && current.data.check("id", id)) {
            head = current.next; // Changed head
            return;
        }

        // Search for the id to be removed, keep track of where we are in list
        while (current != null && !(current.data.check("id", id))) {
            prev = current;
            current = current.next;
        }

        // If id was not found
        if (current == null) {
            return;
        }

        // Unlink the node from linked list thus removing it.
        prev.next = current.next;
    } // end remove method

    /**
     * Creates a new table comprised of nodes having a value for a specific
     * attribute, created from two tables.
     *
     * @param attribute The attribute that we are checking the specific value of.
     * @param value The value of the attribute we are checking.
     * @param table The other table to perform the intersect operation on.
     * @return The newly created table containing the intersection of this
     * table and the other.
     */
    public Table<T> intersect(String attribute, String value, Table<T> table) {

        // Create new table whose title is a comma separated combination of the
        // two tables we are intersecting.
        Table<T> newTable = new Table<>(this.getTitle() + ", "
                + table.getTitle());

        // First check this table.
        Node temp = head;
        while(temp != null) {
            if(temp.data.check(attribute, value)) {
                newTable.insert(temp.data);
            }
            temp = temp.next;
        }

        // Then check the other table.
        temp = table.getHead();
        while(temp != null) {
            if(temp.data.check(attribute, value)) {
                if(!newTable.contains(temp.data)) {
                    newTable.insert(temp.data);
                }
            }
            temp = temp.next;
        }

        return newTable;
    } // end intersect method.

    /**
     * Creates a new table comprised of nodes in <em>this</em> table, but not
     * in <em>table</em>.
     *
     * @param table The other table to perform the difference operation on.
     * @return The newly created table containing the difference of this
     * table and the other.
     */
    public Table<T> difference(Table<T> table) {

        // Create new table whose title is a comma separated combination of the
        // two tables we are performing the difference operation on.
        Table<T> newTable = new Table<>(this.getTitle() + ", "
                + table.getTitle());

        Node temp = head;
        Node other = table.getHead();

        // For each record in this table, check if the other table's record
        // is the same. If not, add it to the new table.
        while(temp != null) {
            // If the data is not equal, add it to the new list.
            if(!(temp.data.equals(other.data))) {
                newTable.insert(temp.data);
            }
            // Move to the next record
            temp = temp.next;
            other = other.next;
        }

        return newTable;
    } // end difference method.

    /**
     * Creates a new table comprised of nodes that occur in both tables.
     * Checks for duplicates and does not add them to the new table.
     *
     * @param table The other table to perform the union operation on.
     * @return The newly created table containing the union of this table and
     * the other.
     */
    public Table<T> union(Table<T> table) {

        // Create new table whose title is a comma separated combination of the
        // two tables we are performing the difference operation on.
        Table<T> newTable = new Table<>(this.getTitle() + ", "
                + table.getTitle());


        // Add everything from this list
        Node temp = head;
        while(temp != null) {
            newTable.insert(temp.data);
            temp = temp.next;
        }


        // Insert everything from the other list, except duplicates.
        temp = table.getHead();
        while(temp != null) {
            if(table.contains(temp.data)) {
                newTable.insert(temp.data);
            }
            temp = temp.next;
        }

        return newTable;
    } // end union method.

    /**
     * Creates a new table comprised of nodes having a value for a specific
     * attribute.
     *
     * @param attribute The attribute that we are checking the specific value of.
     * @param value The value of the attribute we are checking.
     * @return The newly created table containing the selection of this table
     * and the other.
     */
    public Table<T> selection(String attribute, String value) {

        //Create a new table so that we do not mess up our original table.
        Table<T> newTable = new Table<>(this.title);
        Node temp = head;

        // For every record in the table, check if it contains the specified
        // attribute and add it to the new list if it does.
        while(temp != null) {
            if(temp.data.check(attribute, value)) {
                newTable.insert(temp.data);
            }
            // move to the next record
            temp = temp.next;
        }

        return newTable;
    } // end selection method.

    /**
     * Determines whether the table contains a certain record based on that
     * record's ID.
     *
     * @return True if the table contains the data we're searching for.
     */
    private boolean contains(T data) {
        boolean doesContain = false;
        Node temp = head;
        Employee dataEmp = (Employee)data;
        while(temp != null) {
            if(temp.data.check("id", dataEmp.getId())) {
                doesContain = true;
            }
            temp = temp.next;
        }

        return doesContain;
    }

    /**
     * Returns this table as a nicely formatted String to be displayed.
     *
     * @return A String containing all nodes in this list, formatted nicely.
     */
    public String toString() {
        Node current = head;
        StringBuilder returnString = new StringBuilder();
        while(current != null) {
            returnString.append("\n").append(current.data.toString());
            current = current.next;
        }
        return returnString.toString();
    }

    // The Node class.
    /**
     * The nodes that make up our linked list.
     *
     * @author Evert Ball
     * @version 09/18/2019
     */
    private class Node {

        /** Reference to the data */
        private T data;

        /** Reference to the next node in the list */
        private Node next;
        
        /**
         * Sets the data for this node.
         * @param data data to be carried by this node.
         */
        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Sets the data for the node and assigns the next node in the list.
         * @param data data to be carred by this node.
         * @param nextNode next node in the list.
         */
        private Node(T data, Node nextNode) {
            this.data = data;
            this.next = nextNode;
        }
        
        /**
         * Display the state of just the data portion of this node.
         */
        public String toString() {
            return this.data.toString();
        }

    } // end Node class

} // end Table class
