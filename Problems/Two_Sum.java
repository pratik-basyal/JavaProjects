package Problems;

import java.util.*;
/******
 * Here we will be given an array, where we need to find the target
 * Target need to be found by the sum of two numbers in array
 * We need to return array with the resultant indexes
 */
public class Two_Sum
{
    /****
     * Here we will use HashMap technique
     * We will put numbers in hashmap, num as key, and index as value
     * Then we will check with each iteration if it contains key or not
     * Time Complexity : 0(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] result(int[] nums, int target)
    {
        HashMap<Integer, Integer> my_map = new HashMap<>();
        int[] result = new int[2]; // stores the result and return the same result

        for(int i = 0; i < nums.length; i++)
        {
            if(my_map.containsKey(target - nums[i]))
            {
                result[0] = my_map.get(target - nums[i]);;
                result[1] = i;
                return result;
            }
            my_map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Two numbers not found in array");
    }

    public static void main(String[] args) {
        Two_Sum obj = new Two_Sum();
        int[] nums = {1,2,5,7,11,9};

        System.out.println(Arrays.toString(obj.result(nums, 21)));
    }
}
