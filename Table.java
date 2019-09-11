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
    
    // Actual methods that do something
    
    /**
     * Adds a new record to the end of table. If the table is empty, sets the head and the tail
     * references to the new node. Otherwise it changes the current tail to point to the newly
     * created Node and moves the tail to the new Node.
     * TODO: Maybe remove a bit of documentaion explaining how it works.
     *
     * @param data The data for the new row in the table.
     */
    public void insert(T data) {

        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
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

        if(this.head == null) {
            System.out.println("Unable to remove element from empty table");
        } else {
            Node previousNode = head;
            Node currentNode = head;
            Node nextNode = head.next;

            // Logic that removes references to the node that matches id.
            while(currentNode.next != null) { // while not on last node

                // If we find the id we are looking for
                if (currentNode.data.check("id", id)) {

                    // If it's the first node in the list
                    if(currentNode == head) {
                        // remove set head to the next node after this one and
                        // remove this node's ref to the next
                        head = nextNode;
                        currentNode.next = null;
                    // if it's not the first node
                    } else {
                        // move previous node's ref to the node after this one
                        // remove this node's ref to the next one
                        previousNode.next = nextNode;
                        currentNode.next = null;
                    } // end head check if statement
                // if on second node, don't move the previous node
                } else if(previousNode == head) {
                    currentNode = nextNode;
                    nextNode = currentNode.next;
                // otherwise move all node refs forward one and look again.
                } else {
                    previousNode = currentNode;
                    currentNode = nextNode;
                    nextNode = currentNode.next;
                } //end attribute check if statement
            } // end while loop
        } // end outter-most if else

    } // end remove method

    /**
     * Performs the intersection of of this table with another table.
     *
     * @param table The other table to perform the intersect operation on.
     * @return The newly created table containing the intersection of this table and the other.
     */
    public Table<T> intersect(Table<T> table) {
        Table<T> newTable = new Table<>("Intersection");

        // TODO perform intersection

        return newTable;
    } // end difference method.

    /**
     * Performs the difference of of this table with another table.
     *
     * @param table The other table to perform the difference operation on.
     * @return The newly created table containing the difference of this table and the other.
     */
    public Table<T> difference(Table<T> table) {
        Table<T> newTable = new Table<>("Difference");

        // TODO perform difference

        return newTable;
    } // end difference method.

    /**
     * Performs the union of of this table with another table.
     *
     * @param table The other table to perform the union operation on.
     * @return The newly created table containing the union of this table and the other.
     */
    public Table<T> union(Table<T> table) {
        Table<T> newTable = new Table<>("Union");

        // TODO perform union

        return newTable;
    } // end union method.

    /**
     * Performs the selection of of this table with another table.
     *
     * @param table The other table to perform the selection operation on.
     * @return The newly created table containing the selection of this table and the other.
     */
    public Table<T> selection(Table<T> table) {
        Table<T> newTable = new Table<>("Selection");

        // TODO perform selection

        return newTable;
    } // end selection method.

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
