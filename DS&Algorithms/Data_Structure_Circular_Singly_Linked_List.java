import java.util.NoSuchElementException;


/********
 * Circular Singly linked list is also used to store the data/nodes in the list
 * In this list we will be able to move forward only like a singly_linked_list
 * But only difference is that, first and last node are connected to each other
 * Its like a loop, a circular loop which doesn't end
 */
public class Data_Structure_Circular_Singly_Linked_List {
    private ListNode head;
    private ListNode tail;
    private int length;

    public static class ListNode{
        private int data; //data with integer type

        private ListNode next; // pointer to the next node

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    //constuctor for the main class
    Data_Structure_Circular_Singly_Linked_List()
    {
        this.head = null;
        this.tail = null;
        length = 0;
    }


    /*****
     * Checks whether the list is empty or not
     * @return
     */
    public boolean is_empty()
    {
        return length == 0;
    }

    /******
     * This method is to print the each node of the list
     */
    public void print_list()
    {
        if(is_empty()) return;

        ListNode current = head;
        head = tail.next;

        while(current != tail)
        {
            System.out.print(current.data + "---->");
            current = current.next;
        }
        System.out.print(current.data + "\n");
    }


    /*****
     * This method helps us to insert the node at first and also organize the list accordingly
     * @param value
     */
    public void insert_the_node_at_first(int value)
    {
        ListNode new_node = new ListNode(value);

        ListNode current = head;

        if(is_empty()) head = tail = new_node;

        else{
            new_node.next = current;
            head = new_node;
            tail.next = head;
        }
        length++;
    }

    /*******
     * This method helps us to insert at last without disrupting the data structure
     * @param value
     */
    public void insert_at_last(int value)
    {
        ListNode new_node = new ListNode(value);
        ListNode current = tail;

        if(is_empty()) head = tail = new_node;

        else{
            current.next = new_node;
            tail = new_node;
            tail.next = head;
        }
        length++;
    }

    /*******
     * This method will return the first node and it will be removed from the list
     * @return
     */
    public ListNode remove_first_node()
    {
        if(is_empty()) throw new NoSuchElementException();

        ListNode current = head;

        head = head.next;
        current.next = null;
        tail.next = head;
        length--;

        return current;
    }

    public static void main(String[] args) {
        Data_Structure_Circular_Singly_Linked_List my_list = new Data_Structure_Circular_Singly_Linked_List();

//        my_list.head = new ListNode(3);
//        ListNode second = new ListNode(8);
//        ListNode third = new ListNode(9);
//        ListNode fourth = new ListNode(11);
//
//        my_list.head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = my_list.head;
//
//        my_list.tail = fourth;
//        my_list.print_list();

        my_list.insert_the_node_at_first(2);
        my_list.insert_the_node_at_first(4);
        my_list.insert_the_node_at_first(5);
        my_list.insert_the_node_at_first(7);

        my_list.insert_at_last(12);
        my_list.insert_at_last(13);

        my_list.print_list();

        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);
//        System.out.println(my_list.remove_first_node().data);

        my_list.print_list();
    }
}
