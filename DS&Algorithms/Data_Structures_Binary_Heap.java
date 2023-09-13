/*********
 * Binary Heap helps us in implementation of the priority queue operations efficiently
 * Binary Heap Tree is a COMPLETE BINARY TREE, in which
 * Parent node is (>=) or (<=) than values of its children
 * For Min Heap tree parent node will be smaller than its children node
 * For Max Heap Tree parent node will be larger than its children node
 *
 *
 * And FOR THE COMPLETE BINARY TREE PART :
 * Complete Binary Tree is a tree which left side are never empty
 * Such that, if we traverse from left to right, (horizontally look at the tree) its never empty
 * Even though the tree is incomplete, if all left sides are filled, then it is considered as a Complete Binary Tree
 *
 *
 * We Represent/Implement a binary heap tree in the form of an array
 * First index of a binary heap tree (as an array) is usually empty
 * We store the node in the array by traversing the tree level from left to right
 *
 */

/*************
 * Lets assume a Binary Max Heap tree such that :
 *          9
 *        /   \
 *      3      6
 *    /   \   / \
 *   2     1 5   4
 *
 *   we store this tree as ann array - {[], 9, 3, 6, 2, 1, 5, 4} // first one is empty
 *   So we can do the Parent - Child Calculations on this tree
 *   Children of 1st index = 2, 3 (Index 1 = 2 * 1, 2 * 1 + 1)
 *   Children of 2nd index = 4, 5 (Index 2 = 2 * 2, 2 * 2 + 1)
 *   Children of 3rd index = 6, 7 (Index 3 = 2 * 3, 2 * 3 + 1)
 *   ........
 *   Children of kth index = 2 * K, 2 * K + 1 {FORMULA TO CALCULATE CHILDREN OF PARENT NODE}
 *
 *   Parent of 7th index = 7/2 = 3
 *   Parent of 6th index = 6/2 = 3
 *   .......
 *   Parent of Kth index = k/2(th index)
 */
public class Data_Structures_Binary_Heap
{
    int[] max_heap; // this is the integer array to represent heap
    int n; // to keep track the capacity of the heap

    /*****
     * Constructor for the heap
     * @param capacity
     */
    public Data_Structures_Binary_Heap(int capacity)
    {
        this.max_heap = new int[capacity + 1]; //since the first index will be empty so we need an extra one
        n = 0; // this is the default value
    }


    /******
     * This checks whether the binary heap tree is empty or not
     * @return
     */
    public boolean is_empty()
    {
        return n == 0;
    }

    public static void main(String[] args) {
        Data_Structures_Binary_Heap max_heap = new Data_Structures_Binary_Heap(7);
    }
}
