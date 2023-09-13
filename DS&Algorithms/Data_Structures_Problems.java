/*********
 * In this class we will discuss about the problem solving skills with the help of everything we have learned
 *
 */

import java.util.Arrays;
import java.util.*;

/******
 * 1st QN IS :
 * Given an array of integers, for each element in the array, find its next greater element in the array.
 */
public class Data_Structures_Problems {
    private int index_pointer; // this wil be the pointer to the index of an array

    /****
     * This is one way of doing this problem
     * @param args
     */

//    public int[] next_greater_element(int[] array)
//    {
//        index_pointer = 1;
//        for(int i = 0; i < array.length; i++)
//        {
//            while(index_pointer < array.length)
//            {
//                if(array[i] < array[index_pointer])
//                {
//                    array[i] = array[index_pointer];
//                    index_pointer = i + 1;
//                    break;
//                }
//
//                else if( i == array.length - 1 || index_pointer == array.length -1)
//                {
//                    array[i] = -1;
//                    break;
//                }
//                index_pointer++;
//            }
//        }
//        return array;
//    }
//
//    /*******
//     * This will be the other way of doing it with the help of Stack class
//     * We will create a different method as a reference to complete this task
//     * @param
//     */
//
//    public boolean is_empty(Stack<Integer> stack)
//    {
//        return stack.size() == 0;
//    }
//
//
//    /********
//     * I made an empty stack and the integer array
//     * @param array
//     * @return
//     */
//    public int[] next_greater_element(int[] array)
//    {
//        int[] result = new int[array.length]; // result with the same size as array
//        Stack <Integer> my_stack = new Stack<>(); // empty stack
//
//            for (int i = array.length - 1; i >= 0; i--)
//            {
//                if(!is_empty(my_stack))
//                {
//                    while (!is_empty(my_stack) && array[i] >= my_stack.peek())
//                    {
//                        my_stack.pop();
//                    }
//                }
//
//                if(is_empty(my_stack))
//                {
//                    result[i] = -1;
//                }
//
//                else
//                {
//                    result[i] = my_stack.peek();
//                }
//
//                my_stack.push(array[i]);
//            }
//            return result;
//    }

    /*******
     * QN 2.
     * This is also from the leetcode problem.
     * A string is valid if the paranthesis are valid.
     * Valid paranthesis means open brackets must be closed with the same closing bracket
     * We will do this shit using the stack class in java
     */
    public boolean is_valid_parenthesis(String str)
    {
        Stack<Character> brackets = new Stack<>();

        for(char c : str.toCharArray())
        {
            if (c == '{' || c == '(' || c == '[')
            {
                brackets.push(c);
            } else
            {
                if (brackets.isEmpty()) return false;
                else
                {
                    char character = brackets.peek();
                    if (character == '{' && c == '}' ||
                            (character == '[' && c == ']') ||
                            (character == '(' && c == ')'))
                    {
                        brackets.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return brackets.isEmpty();
    }

    /**************
     * In the given nxn matrix we need find if the number is present inside the table or not
     * if yes then we will print found if not the otherwise
     * This algorithm only applies for the sorted matrix
     */

    public void search(int[][] matrix, int size, int number)
    {
        int  i = 0;
        int j = size - 1;

        while(i < size && j >= 0)
        {
            if(matrix[i][j] == number)
            {
                System.out.println("Number found at index (" + i + "," + j + ")");
                return;
            }

            if(matrix[i][j] > number)
            {
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("Value not found!");
    }

    /*******
     * This method will print matrix in the spiral form
     * We will be using 4 for loops
     * 1st loop : Left to Right
     * 2nd loop : Top to bottom
     * 3rd loop : Right to Left
     * 4th loop : Bottom to Top
     * @param matrix
     */
    public void print_matrix_in_Spiral_Form(int[][] matrix, int row, int column)
    {
        // j helps in traversing rows, and k helps in traversing columns
        int i, j = 0 , k = 0;

        while(j < row && k < column)
        {
            // First : Left to Right Traverse
            for(i = k; i < column; i++)
            {
                System.out.print(matrix[j][i] + " ");
            }
            j++;

            // Second : Top to bottom
            for(i = j; i < row; i++)
            {
                System.out.print(matrix[i][column - 1] + " ");
            }
            column--;

            // Third : Right to left
            if(j < row)
            {
                for (i = column - 1; i >= k; i--) {
                    System.out.print(matrix[row - 1][i] + " ");
                }
                row--;
            }

            // Fourth : Bottom to top
            if(k < column) {
                for (i = row - 1; i >= j; i--) {
                    System.out.print(matrix[i][k] + " ");
                }
                k++;
            }
        }
    }

    /***************
     * So this is another problem
     * We will be given a sorted array in ascending order
     * We need to square every element in the array
     * And We will need to sort it out
     * We can do it in simple way but it will take n(log(n)) time complexity which is bad
     * We have to find a way to do it in O(n) complexity
     */
    public int[] sorted_squared_array(int[] array)
    {
        // since this is in ascending order we can follow this algorithm
        int i = 0;
        int j = array.length - 1;
        int[] result = new int[array.length];

        // we will traverse only once in the whole array
        for(int k = array.length - 1; k >= 0; k--)
        {
            if(Math.abs(array[i]) > Math.abs(array[j]))
            {
                result[k] = array[i] * array[i];
                i++;
            }
            else {
                result[k] = array[j] * array[j];
                j--;
            }
        }
        return result;
    }

    /**********
     * In the given sorted array Rearrange the array in sucha way that :
     * First will have the largest number, second will have the smallest number and so on
     * For eg : {1,2,3,4,5,6,7} ---> {7,1,6,2,5,3,4}
     */
    public int[] rearrange_the_array(int[] array)
    {
        int i = 0, j = array.length - 1;
        int[] result = new int[array.length];

        for(int k = 0; k < array.length; k++)
        {
            if(k % 2 == 0) {
                result[k] = array[j];
                j--;
            }

            else
            {
                result[k] = array[i];
                i++;
            }
        }
        return result;
    }
    /******
     * @param args
     */
    public static void main(String[] args)
    {
        Data_Structures_Problems obj = new Data_Structures_Problems();

        int[] arr = {-12, -11, 0, 3, 10}, array = {2,3,5,6,8,9};

//        System.out.println(Arrays.toString(obj.next_greater_element(arr)));

        int[][] matrix =
                {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
                };

        obj.print_matrix_in_Spiral_Form(matrix, 4,4);

        System.out.println(obj.is_valid_parenthesis("()[]{}"));

        System.out.println(Arrays.toString(obj.sorted_squared_array(arr)));

        System.out.println(Arrays.toString(obj.rearrange_the_array(array)));

    }
}
