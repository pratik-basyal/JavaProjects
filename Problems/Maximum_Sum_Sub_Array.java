package Problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class Maximum_Sum_Sub_Array
{
    public int max_sum_of_sub_array(int[] nums, int key) //{1,5,1,2,9,9,9};
    {
        int len = nums.length;
        int[] result = new int[len - key + 1];
        int sum = 0;
        Deque<Integer> deque = new ArrayDeque<>(); // to store the indices
        int j = 0;

        for(int i = 0; i < len; i++)
        {
            deque.offer(i);
            sum += nums[i];

            if(i == key - 1)
            {
                result[j] = sum;
                j++;
            }

            else if(i >= key && !deque.isEmpty())
            {
                sum = sum - nums[deque.pollFirst()];
                result[j] = sum;
                j++;
            }
        }
        int res = 0;
        for(int value : result)
        {
            if(value > res)
            {
                res = value;
            }
        }
        return res;
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0; // left pointer of the sliding window
        int j = 0; // right pointer of the sliding window
        long sum = 0; // variable to store the current sum of the subarray
        long max = 0; // variable to store the maximum subarray sum of distinct elements
        boolean vals[] = new boolean[1000001]; // an array to track the occurrence of elements

        while (j < nums.length)
        {
            sum += nums[j]; // add the current element to the current sum

            if (!vals[nums[j]])
            {
                vals[nums[j]] = true; // mark the current element as present in the window
            }

            else
            {
                // If the current element is already in the window, remove elements until it becomes distinct
                while (nums[i] != nums[j] && i < j)
                {
                    sum -= nums[i]; // remove the leftmost element from the sum
                    vals[nums[i]] = false; // mark the removed element as not present
                    i++; // move the left pointer to the right
                }
                sum -= nums[i]; // remove the duplicate element at index i
                i++; // move the left pointer to the right
            }

            if (j - i + 1 == k)
            {
                max = Math.max(max, sum); // update the maximum subarray sum if the window size is k
                sum -= nums[i]; // remove the leftmost element from the sum
                vals[nums[i]] = false; // mark the removed element as not present
                i++; // move the left pointer to the right
            }

            j++; // move the right pointer to the right
        }

        return max; // return the maximum subarray sum of distinct elements
    }

    public static void main(String[] args)
    {
        Maximum_Sum_Sub_Array obj = new Maximum_Sum_Sub_Array();
        int[] array = {1,1,1,2,3};
        System.out.println(obj.maximumSubarraySum(array, 3));
    }
}
