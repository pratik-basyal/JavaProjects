package Problems;
import java.util.*;
/********
 * We will try to find the first non-repeating character in 0(1) time complexity
 * Lets see what we can do in here
 */
public class First_Non_Repeating_Character
{
    /********
     * This is the method that I came up with
     * Time complexity : 0(n^2)
     * Which is def not goood
     * @param str
     * @return
     */
    public int first_non_repeating(String str)
    {
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < str.length(); i++)
        {
            if(!queue.contains(str.charAt(i)))
            {
                queue.offer(str.charAt(i));
            }
            else{
                queue.remove();
            }
        }

        if(!queue.isEmpty()) return (int)queue.peek();

        return -1;
    }

    /***********
     * This is another approach for the same method
     * We will be using mapping technique on this one
     * Time Complexity : 0(n)
     * @param str
     * @return
     */
    public int firstNonRepeatingChar(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray())
        {
            //default value will be 0 and when it calls map.get for character again it will have value 1 already
            //that is how this works out
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if(map.get(c) == 1) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        First_Non_Repeating_Character obj = new First_Non_Repeating_Character();
        String str = "racecar";
//        System.out.println((char) obj.first_non_repeating("codeforcode"));
        System.out.println(str.charAt(obj.firstNonRepeatingChar(str)));
    }
}
