import java.util.List;
import java.util.NoSuchElementException;

/*******
 * #IMPORTANT POINTS
 * Since we couldn't traverse back in the singly linked list,
 * We didn't declared private node tail that points to last node,
 * But in doubly_linked_list we can traverse through the node in reverse,
 * We declare #Tail Node to use it as a preference to travel reversely
 */
public class Data_Structures_Doubly_Linked_list
{
    private ListNode head; // first node
    private ListNode tail; // last node
    private int length; // length of the whole list
    public static class ListNode
    {
        private int data; // can be any type

        public ListNode next; // pointer to the next obj
        public ListNode previous; // pointer to the previous obj

        public ListNode(int data) //constructor
        {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    public Data_Structures_Doubly_Linked_list() //constructor for the whole class
    {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    /*****
     * checks if list is empty
     * returns true if it does and false otherwise
     * @return
     */
    public boolean is_Empty()
    {
        return length == 0; // in other words it also works as if head == null
    }

    public int length()
    {
        return length;
    }

    /******
     * This method just keeps adding in the doubly linked list
     */
    public void insert_at_last(int value)
    {
        ListNode newNode = new ListNode(value);

        if(is_Empty()) head = newNode;

        else
        {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    /********
     * This method will help to put node at beginning
     */
    public void insert_at_first(int value)
    {
        ListNode newNode = new ListNode(value);

        if(is_Empty()) tail = newNode;

        else
        {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    /******
     * Insert the node at certain position
     * For eg: 1--->2---->3---->4 if we were to insert the node 5 at pos : 3
     * Then it would be after 2 so for that to happen :
     * We follow this algorithm
     */

    public void insert_at_certain_position(int value, int position) //assume position is 3 for now
    {
        ListNode current = head;
        ListNode my_node = new ListNode(value);
        int count = 1;

        while(count < position - 1)
        {
            current = current.next;
            count++;
        }

        ListNode temp = null;
        if(current != tail)
        {
            temp = current.next;
            current.next = my_node;
            my_node.previous = current;
            my_node.next  = temp;
            temp.previous = current;
        }
        else{
//            current.next = my_node;
//            my_node.previous = current;
            insert_at_last(value);
        }
    }

    /*********
     * This method deletes the first node in the doubly linked list
     */
    public void delete_first_node()
    {
        ListNode temp = head;
        if(is_Empty()) throw new NoSuchElementException();

        else if (head == tail) {
            tail = null;
        }

        else
        {
            head.next.previous = null;
            head = head.next;
            temp.next = null;
            temp.previous = null;
        }
        length--;
    }

    /******
     * To delete the last node in the list
     * We don't need pointer to the previous node like the singly linked list
     * We can easily delete the node without previous node pointer by traversing backward
     */
    public ListNode delete_last_node()
    {
        ListNode temp = tail;
        if(is_Empty()) throw new NoSuchElementException();

        else if(head == tail) head = null;

        else{
            temp.previous.next = null;
            tail = tail.previous;
            temp.previous = null;
        }
        length--;
        return temp;
    }

    /*********
     * Delete the node of any position we want
     * Again just a hint : we don't need current and previous pointer like singly linked list
     * For eg: 1--->2---->3---->4 if we were to delete at position 3
     * 7---->5---->4---->2---->8---->99---->null
     */
    public void delete_at_certain_position(int position)
    {
        ListNode current = head;
        int count = 1;

        while(count < position - 1)
        {
            if(current == tail) return;
            current = current.next;
            count++;
        }
        ListNode temp = current.next;
        if(temp == null) return;

        if(current == head && position == 1) delete_first_node();

        else if(temp == tail) delete_last_node();

        else {
            current.next = current.next.next;
            current.next.previous = current;
            temp.previous = null;
            temp.next = null;
        }
    }

    /********
     * This method will print the data from the Doubly Linked List.
     */
    public void print_forward()
    {
        ListNode temp = head;

        while(temp != null)
        {
            System.out.print(temp.data + "---->");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    /******
     * To print the data reversely in the Doubly_linked_List
     */
    public void print_backward()
    {
        ListNode temp = tail;

        while(temp != null)
        {
            System.out.print(temp.data + "---->");
            temp = temp.previous;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        Data_Structures_Doubly_Linked_list dll = new Data_Structures_Doubly_Linked_list();

        //this is one way of adding the nodes in our list
//        dll.head = new ListNode(7);
//        ListNode second = new ListNode(8);
//        ListNode third = new ListNode(9);
//        ListNode fourth = new ListNode(11);
//        ListNode fifth = new ListNode(15);

        dll.insert_at_first(2);
        dll.insert_at_first(4);
        dll.insert_at_first(5);
        dll.insert_at_first(7);


        dll.print_forward();
        System.out.println("Lets insert 6 in the beginning");
        dll.insert_at_first(6);
        dll.print_forward();
        System.out.println("Lets insert 29 at the end");
        dll.insert_at_last(29);
        dll.print_forward();
//        dll.print_backward();

        System.out.println("Deleting the first node :");
        dll.delete_first_node();

        dll.print_forward();
        System.out.println(dll.delete_last_node().data);
        dll.print_forward();
        dll.insert_at_certain_position(8,5);
        dll.insert_at_certain_position(99,6);
        dll.print_forward();
        dll.delete_at_certain_position(7);
        dll.print_forward();
    }

}
