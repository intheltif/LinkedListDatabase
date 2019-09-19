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
     * the new Node.
     *
     * TODO: Maybe remove a bit of documentaion explaining how it works.
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
        Node temp = head;
        Node prev = null;

        // If the id is the first node
        if (temp != null && temp.data.check("id", id)) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the id to be removed, keep track of where we are in list
        while (temp != null && !(temp.data.check("id", id))) {
            prev = temp;
            temp = temp.next;
        }

        // If id was not found
        if (temp == null) {
            return;
        }

        // Unlink the node from linked list thus removing it.
        prev.next = temp.next;
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
        Table<T> newTable = new Table<>(this.getTitle() + ", "
                + table.getTitle());
        Node temp = head;

        // First check this table.
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
        Table<T> newTable = new Table<>(this.getTitle() + ", "
                + table.getTitle());

        // TODO perform difference
        Node temp = head;
        Node other = table.getHead();

        // First check this table.
        while(temp != null) {
            if(!(temp.data.equals(other.data))) {
                newTable.insert(temp.data);
            }
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
        Table<T> newTable = new Table<>(this.getTitle() + ", "
                + table.getTitle());

        Node temp = head;

        // Add everything from this list
        while(temp != null) {
            newTable.insert(temp.data);
            temp = temp.next;
        }

        temp = table.getHead();

        // Insert everything from the other list, except duplicates.
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
        Table<T> newTable = new Table<>(this.title);
        Node temp = head;

        while(temp != null) {
            if(temp.data.check(attribute, value)) {
                newTable.insert(temp.data);
            }
            temp = temp.next;
        }

        return newTable;
    } // end selection method.

    /**
     * Determines whether a table contains a certain piece of data.
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
