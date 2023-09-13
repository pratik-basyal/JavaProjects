import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**********
 * This is also a linear data structures used for storing the data
 * We insert the data to the last and we delete the data from the first in this list
 * Which is why its also called First-In-First_Out (FIFO) list
 */

public class Data_Structures_Queue
{
    private ListNode front;

    private ListNode end;

    private int  length; // count the size of the queue

    public static class ListNode
    {
        private int data; //integer type data
        public ListNode next; // pointer to the next

        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    /******
     * This is a constructor to the main class
     */
    public Data_Structures_Queue()
    {
        this.front = null;
        this.end = null;
    }

    public boolean is_empty()
    {
        return length == 0;
    }

    /*******
     * This is enqueuing part of the queue
     * We add the data/node to the end of the list
     * That is why this method is called queue
     * @param data
     */

    public void Enqueue(int data)
    {
        ListNode new_node = new ListNode(data);
        if(is_empty()) front = end = new_node;

        else{
            end.next = new_node;
        }
        end = new_node;
        length++;
    }

    /*******
     * This method is dequeing that is deleting from the first node
     * And keep going
     */

    public int Dequeue()
    {
        ListNode current = front;

        if(is_empty()) throw new NoSuchElementException("Queue is empty bitch!!");

        front = front.next;
        current.next = null;
        length--;

        return current.data;
    }

    public void print_queue()
    {
        ListNode current = front;

        while(current != null)
        {
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.print("null\n");
    }

    /********
     * This method generates the binary number in the string representation.
     * We will do this with the help of Queue method in java classses
     *
     * @param value
     * @return
     */

    public String[] generate_binary_numbers(int value)
    {
        String[] result = new String[value]; // to store the final result and return it
        Queue<String> binary_num = new LinkedList<>();

        binary_num.offer("1"); //1st num is always 1

        for(int i = 0; i < value; i++)
        {
            result[i] = binary_num.poll(); //returns and removes the element at the front

            String n1 = result[i] + "0";
            String n2 = result[i] + "1";

            binary_num.offer(n1);
            binary_num.offer(n2);
        }
        return result;
    }

    public static void main(String[] args) {
        Data_Structures_Queue queue = new Data_Structures_Queue();

        queue.Enqueue(5);
        queue.Enqueue(7);
        queue.Enqueue(8);
        queue.Enqueue(9);

        queue.print_queue();

        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());

        queue.print_queue();

        System.out.println(Arrays.toString(queue.generate_binary_numbers(9)));

    }
}
