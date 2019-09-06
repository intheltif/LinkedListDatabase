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
     * Constructor that creates a table with all relevant fields.
     *
     * @param head The head Node of the linked list.
     * @param tail The tail Node of the linked list.
     * @param title The name of the table.
     */
    public Table(Node head, Node tail, String title) {

        this.head  = head;
        this.tail  = tail;
        this.title = title;
        this.currentNode = head;

    } // end Table constructor

    /**
     * Constructor that creates a table with only head and title.
     *
     * @param head The head Node of the linked list.
     * @param title The name of the table.
     */
    public Table(Node head, String title) {

        this.head  = head;
        this.tail  = null;
        this.title = title;
        this.currentNode = head;

    } // end Table constructor
    
    /**
     * Constructor that creates a table with only the title.
     *
     * @param title The name of the table.
     */
    public Table(String title) {

        this.head  = null
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
     * @param head The head node of the linked list.
     */
    public Node getHead() {
        return this.head;
    } // end getHead method

    /**
     * Get the tail node of the linked list.
     *
     * @param tail The tail node of the linked list.
     */
    public Node getTail() {
        return this.tail;
    } // end getTail method

    /**
     * Set the current node of the linked list.
     *
     * @param current The current node of the linked list.
     */
    public Node setCurrent() {
        return this.currentNode;
    } // end getCurrent method

    /**
     * Get the name of the table.
     *
     * @param title The name of the table.
     */
    public String getTitle() {
        return this.title;
    } // end getTail method
    
    // Actual methods that do something
    
    /**
     * Adds a new record to the end of table.
     *
     * @param data The data for the new row in the table.
     */
    public void insert(T data) {
        Node newNode = new Node(data);
        this.tail = newNode;
    } // end insert method



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
