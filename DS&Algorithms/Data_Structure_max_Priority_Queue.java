/**********
 * Priority Queue is a data structures that allows us to find the maximum/minimum elements
 * In a constant time
 * This supports the following operations :
 * Insert Key : Insert a key to the priority queue
 * deleteMax() / deleteMin() : Returns and removes the largest/smallest element in the queue
 * getMax() / getMin() : returns max/min keys
 *
 * Heap Method is used to implement the priority queue tho.
 * Max heap is a complete binary tree, where parent node is greater than children nodes
 */

public class Data_Structure_max_Priority_Queue
{
    private int max_heap[]; // integer array that represents the heap/priority_queue

    private int n; // size of the max heap

    // default constructor for the max_Priority Queue
    public Data_Structure_max_Priority_Queue(int capacity)
    {
        this.max_heap = new int[capacity + 1]; // index 0 must be empty
        this.n = 0;
    }

    /******
     * returns the empty size of an array
     * basically checks if the array is an empty or not
     * @return
     */
    public boolean is_Empty()
    {
        return n == 0;
    }

    /******
     * Just returns the size of an array
     * @return
     */
    public int size()
    {
        return n;
    }

    /******
     *So first of all, Binary Heap Tree is a complete Binary tree.
     *         9
     *       /   \
     *      3      6
     *    /   \   / \
     *   2     1 5   4
     *
     *  If we were to add 10 to this tree it would be on the 4th level, below 2.
     *  And it would mess up Binary Max Heap Tree.
     *  So for that we will be inserting the node as following the algorithm below :
     */

    public void insert(int num)
    {
        if(n == max_heap.length - 1) // when n reaches the last index and the array is full
        {
            resize(max_heap.length * 2);
        }
        n++;
        max_heap[n] = num;
        swim(n);
    }

    /********
     * This method is just to resize the array if it gets full and theres no more room to next data
     * @param capacity
     */
    public void resize(int capacity)
    {
        int[] new_heap = new int[capacity];

        for(int i = 0; i < max_heap.length; i++)
        {
            new_heap[i] = max_heap[i];
        }
        max_heap = new_heap;
    }

    /**********
     * This method will simply swap the value to its correct position
     * By checking the parent node and the children node in the array
     * We will use the formula we learned in Binary_Heap to calculate the parent and children child
     * @param index
     */
    private void swim(int index) //Bottom Up Re-heapify Technique
    {
        /******
         * In this loop index must be greater than 1 because, 1 is the root node itself
         * We will be comparing the children node to its parent node
         * And swap it if needed accordingly to the max_heap properties
         */
        while(index > 1 && max_heap[index] > max_heap[index/2]) // we compared the children node to its parent node
        {
            int temp = max_heap[index];
            max_heap[index] = max_heap[index/2];
            max_heap[index/2] = temp;

            index = index/2; //index will be moved on to the previous parent node
        }
    }

    public int delete_Max()
    {
        int temp = max_heap[1];

        swap(1, n);

        n--;

        sink(1); //apply re-heapify

        max_heap[n+1] = 0;

        return temp;
    }

    /********
     * So when we delete the data, the tree might fall apart
     * Max Heap Tree might not satisfy the property
     * So we follow the algorithm, to make it right
     * @param index
     */
    public void sink(int index) //Top down Re-heapify algorithm
    {
        //storing the formula for children node of tree i.e. 2*k and 2*k + 1
        int child_1;

        while(2 * index <= n)
        {
            child_1 = 2 * index;

            if(child_1 < n && max_heap[child_1] < max_heap[child_1 + 1])
            {
                child_1++;
            }

            if(max_heap[index] >= max_heap[child_1]) break; // comparing parent to child

            swap(index, child_1);

            index = child_1;
        }
    }

    /*******
     * Extra function to swap the numbers in tree and will be used in delete method
     * @param index
     * @param index1
     */
    public void swap(int index, int index1)
    {
        int temp = max_heap[index];

        max_heap[index] = max_heap[index1];

        max_heap[index1] = temp;

    }

    /**********
     * This method is to print the heap in proper order
     * @param heap
     */
    public void print_max_heap(int[] heap)
    {
        for(int i = 1; i < heap.length; i++)
        {
            if(heap[i] == 0) continue;

            System.out.print(heap[i] + " ");
        }
    }

    /********
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //PQ ---> Priority Queue
        Data_Structure_max_Priority_Queue my_PQ = new Data_Structure_max_Priority_Queue(5);

        my_PQ.insert(6);
        my_PQ.insert(2);
        my_PQ.insert(7);
        my_PQ.insert(8);
        my_PQ.insert(9);
        my_PQ.insert(5);
        my_PQ.insert(4);

        System.out.println(my_PQ.size());
        my_PQ.print_max_heap(my_PQ.max_heap);

        my_PQ.delete_Max();
        System.out.println();
        my_PQ.print_max_heap(my_PQ.max_heap);
    }
}
