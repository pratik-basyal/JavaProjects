package Problems;

import java.util.ArrayList;
import java.util.*;

/***********
 * Here we will be given an integer array and a value, we will be asked to remove that value from array
 * And return the array
 */
public class Remove_Element
{
    /******
     * This what I came up with
     * @param array
     * @param val
     * @return
     */
    public int remove_val(int[] array, int val)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != val)
            {
                result.add(array[i]);
                count++;
            }
        }
        return count;
    }

    public int remove_element(int[] nums, int val)
    {
        int j = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val)
            {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args)
    {
        int[] array = {3,2,2,3};
        System.out.println();
    }
}
