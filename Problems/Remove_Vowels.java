package Problems;
import java.util.*;

public class Remove_Vowels
{
    public boolean isVowels(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        {
            return true;
        }
        return false;
    }

    /********
     * This is the approach I came up with.
     * Has Time Complexity of :: 0(n).
     * @param str
     * @return
     */
    public String removeVowel(String str)
    {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < str.length(); i++)
        {
            if(!isVowels(str.charAt(i)))
            {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    /******
     * This is yet another approach for the same problem
     * Time Complexity : 0(n). Same.
     * @param str
     * @return
     */
    public String after_vowel_removal(String str)
    {
        Set<Character> ch = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray())
        {
            if(!ch.contains(c))
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "what is your name?";

        Remove_Vowels obj = new Remove_Vowels();

        System.out.println(obj.removeVowel(str));
        System.out.println(obj.after_vowel_removal(str));
    }
}
