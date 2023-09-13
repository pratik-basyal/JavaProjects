/******************
 * Binary search tree is also a tree like a Binary Tree (Unorganized Tree)
 * But the difference is : This tree is an organized Tree in an ordered manner.
 * Since this is an organized one we can easily search and insert data faster.
 * This has the following properties :
 * Left subtree of the parent node only contains the value lesser than it's value
 * Right subtree of the node only contains the value higher than the node's value
 * Left and right subtree must also become a binary search tree
 */



import java.util.*;
public class Data_Structires_Binary_Search_Tree
{
    private TreeNode root;

    public static class TreeNode
    {
        private int data;
        private TreeNode left; // pointer to the left
        private TreeNode right; // pointer to the right

        private TreeNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /***********
     * This method is used to insert the node in the Binary Search Tree
     * @param root
     * @param value
     */
    public TreeNode insert_node(TreeNode root, int value)
    {
        if(root == null)
        {
            root = new TreeNode(value);
            return root;
        }

        if(value < root.data) root.left = insert_node(root.left, value);

        if(value > root.data) root.right = insert_node(root.right, value);

        return root;
    }

    /*******
     * Search method
     * This method helps in hiding the internal implementation of the search method
     * This means users need not to be worried about the root node or the recursive nature of the algorithm
     *
     */
    public TreeNode search_key(int key)
    {
        return search_key(root, key);
    }

    /*********
     * This method helps us to search the key in the tree
     * Key is actually a data that we want to search
     * @param root
     * @param key
     * @return
     */
    public TreeNode search_key(TreeNode root, int key)
    {
        if(root == null || root.data == key) return root;

        if(key < root.data) return search_key(root.left, key);

        else{
            return search_key(root.right, key);
        }
    }

    /*****
     * Just a user friendly method so that user won't have to worry about the details
     * Like root, and long value, etc, they can just call this method to check if tree is valid or not
     * @return
     */

    public void valid_Binary_Search_Tree()
    {
         if(valid_Binary_Search_Tree(root, Long.MIN_VALUE, Long.MAX_VALUE))
         {
             System.out.println("The tree is a Valid Binary Search Tree(BST).");
         }

         else{
             System.out.println("Tree is not a valid Binary Search Tree(BST).");
         }
    }

    /*********
     * This method checks whether the tree is valid BST or not?
     * That means, it will check the properties of the Binary Search Tree
     * @return
     */
    public boolean valid_Binary_Search_Tree(TreeNode root, long min, long max)
    {
        if(root == null) return true; //base case

        if(root.data >= max || root.data <= min) return false;

        boolean left = valid_Binary_Search_Tree(root.left, min, root.data);

        if(left)  // we will traverse right only if left is true
        {
            boolean right = valid_Binary_Search_Tree(root.right, root.data, max);
            return right;
        }
        return false; // if traversing one of em is false then we will just return false
    }

    public static void main(String[] args)
    {

    }
}
