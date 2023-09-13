import java.util.NoSuchElementException;
import java.util.*;

/*********
 * Stack is the linear data structure used for storing the data
 * Its an ordered list in which insertion and deletion are done at one end, called top.
 * Last element inserted is the first one to be deleted
 * Hence it is called as a LAST IN FIRST OUT (LIFO)
 */


public class Data_Structures_Stack {
    private ListNode top;

    private int length;

    public static class ListNode
    {
        public int data;
        public ListNode next; // pointer for the next node

        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }

    }

    public Data_Structures_Stack()
    {
        this.top = null;
        this.length = 0;
    }

    /*****
     * checks is the stack is empty or not
     * @return
     */
    public boolean is_Empty()
    {
        return length == 0;
    }

    /******
     * This method push the new node on top of the previous node
     * That is, this method stack the new node on top of the TOP node i.e. first node
     * @param data
     */
    public void push(int data)
    {
        ListNode new_node = new ListNode(data);

        new_node.next = top;
        top = new_node;
        length++;
    }


    /*****
     * This method basically removes the first element from the stack
     * @return
     */
    public ListNode pop()
    {
        if(is_Empty()) throw new NoSuchElementException();

        ListNode temp = top;
        top = top.next;
        temp.next = null;
        length--;
        return temp;
    }

    /*****
     * This method returns a top node or top data.
     * Also checks for the empty stack
     */
    public ListNode peek()
    {
        if(is_Empty()) throw new NoSuchElementException();

        return top;
    }

    public void print_stack()
    {
        if (is_Empty()) throw new NoSuchElementException();
        ListNode temp = top; //pointer to the top

        while(temp != null)
        {
            System.out.print(temp.data + "--->");
            temp = temp.next;
        }
        System.out.print("null\n");
    }


    /*******
     * All these stack structures aside, I will now add new Method
     * This Method will help me reverse the string using Stack class in java
     */
    public char[] reverse_the_String(String str)
    {
        Stack<Character> stack = new Stack<>(); //generic type
        char[] char_array = str.toCharArray();

        for(char c : char_array)
        {
            stack.push(c);
        }

        for(int j = 0; j < str.length(); j++) {
            char_array[j] = stack.pop();
        }
        return char_array;
    }


    public static void main(String[] args) {
        Data_Structures_Stack my_stack = new Data_Structures_Stack();

        my_stack.push(8);
        my_stack.push(5);
        my_stack.push(3);
        my_stack.push(7);

        System.out.println(my_stack.peek().data);
        System.out.println(my_stack.pop().data);
        System.out.println(my_stack.pop().data);

        my_stack.print_stack();

        System.out.println(my_stack.reverse_the_String("PRATIK"));
    }
}
