package Problems;

/******
 * Here we will be given a string and substring
 * If substring can be formed after deleting certain characters in a sequence then its a valid substring
 * Or if its not in correct order then its an invalid substring
 */

import java.util.*;
public class Valid_Subsequence
{

    /******
     * This is what I did myself.
     * Time Complexity : 0(n)
     * @param str
     * @param sub_str
     * @return
     */
    public boolean is_Valid_Substring(String str, String sub_str)
    {
         Queue<Character> my_queue = new LinkedList<>();
         for(char c : str.toCharArray())
         {
             if(sub_str.contains(String.valueOf(c)))
             {
                 my_queue.offer(c);
             }
         }

        System.out.println(my_queue);

         if(!my_queue.isEmpty()) {
             for (int i = 0; i < sub_str.length(); i++) {
                 if (sub_str.charAt(i) != my_queue.poll() || my_queue.isEmpty()) {
                     return false;
                 }
             }
         }
         return true;
    }

    /********
     * This is the algorithm we are supposed to use
     * Time Complexity : 0(1)
     * @param str
     * @param substr
     * @return
     */
    public boolean isValidSubstring(String str, String substr)
{
    int i = 0, j = 0; //i will traverse for str and j will traverse for substr

    while(i < str.length() && j < substr.length())
    {
        if(str.charAt(i) == substr.charAt(j)) j++;

        i++;
    }

    return j == substr.length();
}

    public static void main(String[] args) {
        String str = "abcde";
        String sub_str = "ace";

        Valid_Subsequence obj = new Valid_Subsequence();
        System.out.println(obj.isValidSubstring(str, sub_str));
    }
}
