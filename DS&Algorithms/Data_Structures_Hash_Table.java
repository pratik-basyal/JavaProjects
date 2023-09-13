/********
 * Hashing is a technique used for storing, retrieving, and removing information as quick as possible
 * It is a process of converting an arbitrary sized key into the fixed sized value
 * Conversion is done via special function also known as Hashing
 * Operations supported by hashing will have run time complexity of 0(1), which is the best
 */
public class Data_Structures_Hash_Table
{
    /******
     * First off we will learn about Modular Hash Function
     * This function takes key and size, returns remainder by dividing key by size
     * Remainder is used as an index to store the key in an array of provided size
     */

    /******
     * Now we have HASH TABLE
     * It is a generalized form of an array
     * It stores data in the form of key-value pair
     * It converts key to an index using hash function
     * Taking the index from it, we store the key-value
     * Primary operations supported by the hash table :
     * put(key, value), get(key), remove(key)
     * Average runtime is 0(1)
     *
     * We will be creating HashNode in case we encounter the collison.
     * While storing data, we will simply make the key, value pair, list node if we have get same index
     * HASH NODE :: ---------------------
     *             | Key | Value | Next | ---> next
     *             ----------------------
     * Index (remainder) will act as head and we will create this node starting that index
     * This technique is also called : Separate Chaining Collision Resolution Technique
     *
     */
    private HashNode[]  buckets; // 0, 1, 2, 3, 4, 5 .....
    private int num_of_buckets; // is the capacity of the array
    private int size; //number of key value pairs in hash-table

    Data_Structures_Hash_Table() //default constructor
    {
        this(10); // this will be the default capacity
    }

    Data_Structures_Hash_Table(int capacity)
    {
        this.num_of_buckets = capacity;
        buckets = new HashNode[capacity];
        this.size = 0;
    }

    private class HashNode
    {
        private Integer key;
        private String value;

        private HashNode next;

        public HashNode(int key, String value)
        {
            this.key = key; // can be generic type
            this.value = value; // can be generic type
            this.next = null;
        }
    }

    /*******
     * This will help us determine bucket index of key
     * @param key
     * @return
     */
    public int get_the_bucket_index(Integer key)
    {
        return key % num_of_buckets;
    }

    public int size()
    {
        return size;
    }
    public boolean is_Empty()
    {
        return size == 0;
    }

    public void put(Integer key, String value)
    {
        if(key == null || value == null)
        {
            throw new IllegalArgumentException("Either key or value is null");
        }
        int bucket_index = get_the_bucket_index(key);

        HashNode head = buckets[bucket_index];

        //checks if the key has the same value
        while(head != null)
        {
            if(head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

        //after checking head will point to the different node, so we need to reassign it
        head = buckets[bucket_index];

        //if theres no same key, we can confirm that new node need to be added so we increase size
        size++;
        HashNode node = new HashNode(key, value); // this will be the node we want to insert
        node.next = head; //since this will be the first node we add
        buckets[bucket_index] = node;
    }

    /**********
     * This function will return the value which is string
     * If we give a key then it will find the value for us in hash table
     * @param key
     * @return
     */
    public String get(Integer key)
    {
        if(key == null) throw new IllegalArgumentException("No key found!");

        int index = get_the_bucket_index(key);
        HashNode head = buckets[index];

        while(head != null)
        {
            if(key.equals(head.key))
            {
                return head.value;
            }
            head = head.next;
        }
        return "No value found";
    }

    /*********
     * This method will remove the key and its value
     * And returns the value in the process
     * @param key
     * @return
     */
    public String remove_key(Integer key)
    {
        if(key == null) throw new IllegalArgumentException("Invalid key");
        
        int index = get_the_bucket_index(key);
        HashNode head = buckets[index];
        HashNode previous = null;
        
        while(head != null)
        {
            if(head.key.equals(key)) {
                break;
            }

            previous = head;
            head = head.next;
        }

        if(head == null) return null;

        size --;
        if(previous != null) {
            previous.next = head.next;
        }
        else {
            buckets[index] = head.next;
        }
        return head.value;
    }
    public static void main(String[] args) {
        Data_Structures_Hash_Table table = new Data_Structures_Hash_Table(10);

        table.put(105, "Pratik");
        table.put(21, "Sneha");
        table.put(31, "Pasanna");

        System.out.println(table.size());
        System.out.println(table.buckets[1].key);
        System.out.println(table.get(21));
        System.out.println(table.get(43));
        System.out.println(table.remove_key(31));
        System.out.println(table.get(31));
        System.out.println(table.size());
    }
}
