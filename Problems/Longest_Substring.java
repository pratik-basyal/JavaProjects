package Problems;

import java.util.*;
/********
 * Longest substring without the repeating characters.
 */
public class Longest_Substring
{
    public int longest_no_repeating_substring(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest_substring = 0, start = 0;

        for(int end = 0; end < str.length(); end++)
        {
            char c = str.charAt(end);
            if(map.containsKey(c))
            {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            longest_substring = Math.max(longest_substring, end - start + 1 );
        }
        return longest_substring;
    }

    public static void main(String[] args)
    {
        Longest_Substring obj = new Longest_Substring();
        System.out.println(obj.longest_no_repeating_substring("dvdf"));
        System.out.println(obj.longest_no_repeating_substring("pwwkew"));
    }
}
