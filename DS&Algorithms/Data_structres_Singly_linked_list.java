import java.util.*;


/*******
 * So Basically what Singly Linked is data structure used for storing collection of nodes
 * This is the list where we can only traverse forward
 * Node has data and the pointer to the next node
 * First node is head node and Last node has data and points to null
 * And this is how we implement singly-linked list in java
 */
public class Data_structres_Singly_linked_list {
    private ListNode head;

    private static class ListNode
    {
        private int data; //generic type
        private ListNode next; // pointer to the next node

        public ListNode(int data) // constructor
        {
            this.data = data;
            this.next = null; // whenever we create new node, its next point to null
        }
    }

    /*****
     * to insert the node at the very beginning
     * @param value
     */
    public void insert_node_at_begining(int value)
    {
        ListNode to_add = new ListNode(value);
        to_add.next = head;
        head = to_add;
    }



    /*****
     * to insert the node at last
     * @param value
     */
    public void insert_node_at_last(int value)
    {

        ListNode new_node = new ListNode(value);

        if(head == null)
        {
            head = new_node;
            return;
        }

        //pointer to point to the last node
        ListNode current = head;

        while(current.next != null)
        {
            current = current.next;
        }

        current.next = new_node;
    }

    /***
     * to insert the node at the certain position
     * @param value
     * @param position
     */
    public void insert_at_certain_position(int value, int position)
    {
        ListNode new_node = new ListNode(value);
        int count = 1;
        ListNode current = head;
        while(count < position - 1)
        {
            current = current.next;
            count++;
        }
        ListNode temp = current.next;
        new_node.next = temp;
        current.next = new_node;
    }

    /****
     * this is to delete at first
     * @return
     */
    public ListNode delete_at_first()
    {
        if(head == null)
        {
            return null;
        }

        ListNode temp = head;
        head = head.next;
        temp.next = null;

        return temp;
    }


    /*****
     * to delete at last node of the linked list
     * @return
     */
    public ListNode delete_at_last()
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while(current.next != null)
        {
            previous = current;
            current = current.next;
        }
        previous.next = null; // break the chain
        return current;
    }

    /***
     * delete the data for the certain position
     * @param pos
     * @return
     */
    public ListNode delete_at_certain_position(int pos)
    {
        if(pos == 1)
        {
            return delete_at_first();
        }
            int count = 1;
            ListNode current = head;
            ListNode previous = null;

            while (count < pos) {
                previous = current;
                current = current.next;
                count++;
            }
            previous.next = current.next;
            return current;
    }

    /**
     * To reverse the linked-list
     */
    public ListNode reverse_linked_list(ListNode head)
    {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    /***
     *  This method helps us to return the middle node of the linked list
     */

    public ListNode middle_node(ListNode head)
    {
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;

        while(fast_ptr != null && fast_ptr.next != null)
        {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr;
    }

    /***
     * method to return nth node from the end
     */

    public ListNode nth_node_from_end(ListNode head, int n)
    {
        ListNode ref_ptr = head; //ref_ptr
        ListNode main_ptr = head; //main_ptr
        int count = 0;

        while(count < n)
        {
            ref_ptr = ref_ptr.next;
            count++;
        }

        while(ref_ptr != null)
        {
            main_ptr = main_ptr.next;
            ref_ptr = ref_ptr.next;
        }
        return main_ptr;
    }

    /****
     * this method is used to delete the duplicates from the linked list
     * This will only work on the sorted list and won't work in UNSORTED LIST
     */

    public void remove_duplicates(ListNode head)
    {
        ListNode current = head;

        while(current != null && current.next != null)
        {
            if(current.data == current.next.data)
            {
                current.next = current.next.next;
            }

            else{
                current = current.next;
            }
        }
    }

    /****
     * This method will help us in inserting the new node in the linked list
     * The list has to be the sorted list
     * And this won't work on the unsorted list
     */

    public ListNode insert_new_node_in_sorted_list(int value)
    {
        ListNode newNode = new ListNode(value);
        ListNode current = head;
        ListNode prev = null;

        while(current != null && current.data < newNode.data)
        {
            prev = current;
            current = current.next;
        }

        newNode.next = current;
        prev.next = newNode;

        return head;
    }

    /*****
     * To remove the key from teh singly linked list
     */

    public void remove_key(int key)
    {
        ListNode current = head;
        ListNode previous = null;

        while(current != null && current.data != key)
        {
            previous = current;
            current = current.next;
        }
        if(current == null) return;
        previous.next = current.next;
    }

    /***
     * Detects the loop in teh linked list
     * Like there is no null value to the next of any node
     * It just connected to every other nodes
     */

    public boolean detects_loop_in_linked_list()
    {
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;

        while(fast_ptr != null && fast_ptr.next != null)
        {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;

            if(fast_ptr == slow_ptr) return true;
        }
        return false;
    }

    /*****
     * So these methods are really important one
     * We detected the loop earlier this time we are
     * Finding the starting of the loop
     * We can use this algorithm in other things too
     * This method is called Floyd's Cycle Detection algorithm
     */

    /****
     * so we will need two methods for this part
     * first one will be to get the start node
     * and with the help of same algorithm we will unlink the loop for this list
     * @return
     */

    public ListNode get_start_node(ListNode slow_ptr)
    {
        ListNode temp = head;

        /**
         * they will meet at some point if we start from the point where the
         * fastptr and slowptr point
         */

        while(head != slow_ptr)
        {
            temp = temp.next;
            slow_ptr = slow_ptr.next;
        }
        return temp;
    }


    /****
     * this method will basically unlink the node which was the
     * linkage for the starting of the loop
     * @param slow_ptr
     */
    public void remove_the_loop(ListNode slow_ptr)
    {
        ListNode temp = head;

        while(temp.next != slow_ptr.next)
        {
            temp = temp.next;
            slow_ptr = slow_ptr.next;
        }
        slow_ptr.next = null;

    }
    public ListNode Floyds_cycle_detection()
    {
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;

        while(fast_ptr != null && fast_ptr.next != null)
        {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;

            if(slow_ptr == fast_ptr)
            {
                //remove_the_loop(slow_ptr); if you don't want the loop in the list
                return get_start_node(slow_ptr);//if you want the starting node for loop
            }
        }
        return null;
    }

    /*****
     * Method to merge the motherfucking singly linked list
     * Aight
     * FYI this method only works for sorted linked list so yes
     */

    public ListNode merge_two_sorted_list(ListNode a, ListNode b)
    {
        // a = 1--->3--->5---->7---->null
        // b = 2--->4--->6---->8---->null
        //result = 1--->2--->3--->4--->5--->6--->7--->8--->null
        ListNode temporary = new ListNode(0);
        ListNode temp_tail = temporary;

        while(a != null && b != null)
        {
            if(a.data <= b.data)
            {
                temp_tail.next = a; // if we took temp listnode as null then this would create an null pointer exception
                a = a.next;
            }
            else{
                temp_tail.next = b;
                b = b.next;
            }
            temp_tail = temp_tail.next;
        }
        if(a == null)
        {
            temp_tail = b;
        }
        else{
            temp_tail = a;
        }
        temporary = temporary.next;
        return temporary;
    }

    /*******
     * Method to add two list and merge them
     * We cannot traverse the singly-linked list reveersely
     * So we need to reverse the list first then do the addition respectively
     * And this method is for the already reversed list
     * i.e a and b are already in reversed order and we are just adding
     * Finally we will need to reverse returned list to get an actual result
     */
    public ListNode add_two_reversed_list(ListNode a, ListNode b)
    {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while(a != null || b != null)
        {
            int x = (a != null) ? a.data : 0; //? and : is like a if-else statement
            int y = (b != null) ? b.data : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }

        if(carry > 0) temp.next = new ListNode(carry);
        return dummy.next;
    }

    /**
     * if we were to count the number of nodes in the Singly Linked List
     * we will have to create a count variable
     * and use it inside this while loop and then
     * good to go
     * Below while loop is just to print the data from every node of the linked lit
     */
    public void print_list(ListNode head)
    {

        ListNode current = head; // this is just a node

        while(current != null)
        {
            System.out.print(current.data + " -----> ");
            current = current.next;
        }
        System.out.print("null \n");
    }

    public static void main(String[] args) {
        Data_structres_Singly_linked_list my_list = new Data_structres_Singly_linked_list();

        my_list.head = new ListNode(10);
        ListNode second = new ListNode(8);
        ListNode third =  new ListNode(9);
        ListNode fourth = new ListNode(11);

        my_list.head.next = second; // 10 ----> 8
        second.next = third; // 8 -----> 9
        third.next = fourth; // 9 -----> 11


        /**
         * if we want to add the node at the very front
         * then we will need to follow this algorithm
         * 3 lines in the methods are important ones
         */
        my_list.insert_node_at_begining(23);
        my_list.insert_node_at_last(7);
        my_list.insert_at_certain_position(3,5);

//        System.out.println(my_list.delete_at_first().data);
//        System.out.println(my_list.delete_at_last().data);
//        my_list.print_list(my_list.head);
//        System.out.println("\n" + my_list.delete_at_certain_position(4).data);
//        my_list.print_list(my_list.head);
//        System.out.println("\n" + my_list.delete_at_certain_position(1).data);
//        my_list.print_list(my_list.head);
        my_list.print_list(my_list.head);

        System.out.println(my_list.nth_node_from_end(my_list.head, 4));

        System.out.println(my_list.middle_node(my_list.head).data);

        my_list.print_list(my_list.reverse_linked_list(my_list.head));

    }
}
