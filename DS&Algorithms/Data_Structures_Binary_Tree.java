import java.util.List;
import java.util.*;
/**********
 * Binary tree is a non-linear data structures used for storing data
 * It is made up of nodes and edges without having any cycles
 * Each node in a tree can point to n number of nodes in a tree
 * It is a way of representing hierarchical structure with a parent node called as root
 * and many other additional nodes
 *
 * A tree is called a binary tree if each node has zero, one or two children
 */
public class Data_Structures_Binary_Tree
{
    private TreeNode root; // can be any generic type


    public static class TreeNode
    {
        private int data;

        private TreeNode left; // left TreeNode pointer

        private TreeNode right; // right TreeNode pointer

        public TreeNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*******
     * This method helps us to create a binary tree
     */
    public void create_Tree()
    {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(11);

        root = first;

        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.left = sixth;
        third.right = seventh;
    }

    /***********
     * This method does the pre_order_traversal
     * Which means : Visit the root node
     * Traverse the left subtree in pre-order fashion and
     * Traverse the right subtree in pre-order fashion too
     * @param root
     */
    public void pre_order_traversal(TreeNode root)
    {
        if(root == null) // base case
        {
            return;
        }

        System.out.print(root.data + " ");
        pre_order_traversal(root.left);
        pre_order_traversal(root.right);
    }

    /*********
     * This method is the iterative pre-order traversal
     * We will be using any method but recursion for this one
     * I am going to use the Stack method on this one
     */

    public void iterative_pre_order_traversal()
    {
        if(root == null) return;

        Stack <TreeNode> my_stack = new Stack<>();
        my_stack.push(root);

        while(!my_stack.isEmpty())
        {
            TreeNode temp = my_stack.pop(); // pointer to the top root of the stack
            System.out.print(temp.data + " ");

            //first we will store the right node of the tree
            //this is because Stack follows LIFO order
            // and we are printing left node first so right node must go first
            if(temp.right != null)
            {
                my_stack.push(temp.right);
            }

            //after that we will store the left node
            if(temp.left != null)
            {
                my_stack.push(temp.left);
            }
        }
    }

    /**********
     * This method is the post order traversal
     * First we go to left node
     * Once we are done with the left node we then get to the root node
     * then we traverse to the right and repeat the first two process
     * @param root
     */
    public void in_order_traversal(TreeNode root)
    {
        if(root == null) return; // base case

        in_order_traversal(root.left);
        System.out.print(root.data + " ");
        in_order_traversal(root.right);
    }


    /********
     * This method is used for in_order_traversal the same way as above
     * But not with the recursive method but the iterative method
     */
    public void iterative_in_order_traversal()
    {
        Stack <TreeNode> stack = new Stack<>();

        TreeNode temp = root; // pointer to the root node

        while(temp != null || !stack.isEmpty())
        {
            if(temp != null)
            {
                stack.push(temp);
                temp = temp.left;
            }

            else
            {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    /*******
     * So this method is for the post order traversal
     * Here we will again go left first all the way to the end
     * And then go to the right node as the same
     * And finally we will visit the actual node and print it
     * @param root
     */
    public void post_order_traversal(TreeNode root)
    {
        if(root == null) return; // base case

        post_order_traversal(root.left);
        post_order_traversal(root.right);

        System.out.print(root.data + " ");
    }


    /*********
     * This is the same post order traversal as above
     * But in a iterative way
     */
    public void iterative_post_order_traversal()
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty())
        {
            if(current != null)
            {
                stack.push(current);
                current = current.left;
            }

            else{
                TreeNode temp = stack.peek().right;

                if(temp == null)
                {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");

                    //this extra loop is to see if the temp is pointing to the right side of parent node or left
                    // and if its pointing to the right node then we can now point it to the parent node and print it
                    while(!stack.isEmpty() && temp == stack.peek().right)
                    {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }
                else{
                    current = temp;
                }
            }
        }
    }

    /***********
     * This method traverses according to the level
     * So first root node is the level 0
     * After that its the level 1 and so on
     * We always print left first and then go with the right one
     */
    public void level_order_traversal()
    {
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null)
            {
                queue.offer(temp.left);
            }

            if(temp.right != null)
            {
                queue.offer(temp.right);
            }
        }
    }

    /*******
     * THis method will return the maximum value in the tree
     * We can use any traversal to return it
     * Its just too easy
     * I'd like to go with queue and level order traversal
     * The most easiest one ofc
     * @param root
     * @return
     */
    int max_value_in_tree(TreeNode root)
    {
        if(root == null) return 0;

        Queue <TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        int max = 0; // to store the maximum value

        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();

            if(max < temp.data)
            {
                max = temp.data;
            }

            if(temp.left != null)
            {
                queue.offer(temp.left);
            }

            if(temp.right != null) queue.offer(temp.right);
        }

        return max;
    }

    /*******
     * We are finding the max value in tree using the recursive method
     * @param root
     * @return
     */
    public int find_max_using_recursive(TreeNode root)
    {
        if(root == null) return Integer.MIN_VALUE;

        int result = root.data; // store the root to compare with left and right

        int left = find_max_using_recursive(root.left); // go all the way to the left node
        int right = find_max_using_recursive(root.right); // go all the way to the right node

        if(result < left) result = left;

        if(result < right) result = right;

        return  result;
    }

    public static void main(String[] args) {
        Data_Structures_Binary_Tree my_Tree = new Data_Structures_Binary_Tree();

        my_Tree.create_Tree();
//        my_Tree.pre_order_traversal(my_Tree.root);
//        System.out.println();
//        my_Tree.iterative_pre_order_traversal();
//        System.out.println();
//        my_Tree.in_order_traversal(my_Tree.root);
//        System.out.println();
//        my_Tree.iterative_in_order_traversal();
//        System.out.println();
//        my_Tree.post_order_traversal(my_Tree.root);
//        System.out.println();
//        my_Tree.iterative_post_order_traversal();

        System.out.println(my_Tree.max_value_in_tree(my_Tree.root));
        System.out.println(my_Tree.find_max_using_recursive(my_Tree.root));
    }

}
