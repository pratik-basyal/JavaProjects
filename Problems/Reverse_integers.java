package Problems;

import java.util.Arrays;

public class Reverse_integers
{
    /********
     * This is the one approach I came up with.
     * Time Complexity : 0(n)
     * @param num
     * @return
     */
    public int reverse(int num)
    {
        String str = Integer.toString(num);
        char[] string = str.toCharArray();
        int i = 0; // traverse through left
        int j = str.length() - 1; // traverse through right

        while(i < j)
        {
            char temp = string[i];
            string[i] = string[j];
            string[j] = temp;
            i++;
            j--;
        }

        String result = new String(string);
        return Integer.parseInt(result);
    }

    /*******
     * This is the another approach for same problem
     * Time Complexity : 0(d). -> d is the number of digits in num
     * @param num
     * @return
     */

    public long reverse_num(long num)
    {
        boolean isNegative = num < 0;
        if(isNegative) num *= -1;
        long reverse = 0;
        while(num > 0)
        {
            long last_digit = num % 10;
            reverse = reverse * 10 + last_digit;
            num = num / 10;
        }

        return isNegative ? reverse * -1 : reverse; // if the number is negative then we need to return - reverse
    }

    public static void main(String[] args)
    {
        Reverse_integers obj = new Reverse_integers();
        long num = -752363886;
//        System.out.println(obj.reverse((int)num));

        System.out.println(obj.reverse_num(num));
    }
}
