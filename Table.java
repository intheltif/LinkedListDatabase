public class Table<T extends AttributeInterface> {

    /** First record in the table */
    private Node head;

    /** Last record in the table */
    private Node tail;

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

    } // end Table constructor
    
    /**
     * Set the head of the Linked List.
     *
     * @param head The head node of the linked list.
     */
    public void setHead(Node head) {
        this.head = head;
    } // end setHead constructor

    /**
     * Set the tail node of the linked list.
     *
     * @param tail The tail node of the linked list.
     */
    public void setTail(Node tail) {
        this.tail = tail;
    } // end setTail method

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
    public void getHead(Node head) {
        this.head = head;
    } // end getHead constructor

    /**
     * Get the tail node of the linked list.
     *
     * @param tail The tail node of the linked list.
     */
    public void getTail(Node tail) {
        this.tail = tail;
    } // end getTail method

    /**
     * Get the name of the table.
     *
     * @param title The name of the table.
     */
    public void getTitle(String title) {
        this.tail = tail;
    } // end getTail method

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
