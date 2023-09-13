package Problems;

import java.util.HashSet;

/*******
 * Given an integer array, return true if any value appears at least twice, or return false
 */
public class Contains_duplicate
{
    /***
     * This algorithm is the worst
     * Because it has time complexity of n^2
     * @param nums
     * @return
     */
    public boolean has_duplicates(int[] nums)
    {
        int left = 0;
        int right = nums.length;

        for(int i = 0; i < nums.length - 1; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] == nums[j])
                {
                    return true;
                }
            }
        }
        return false;
    }

    /*******
     * This takes the 0(n) time complexity
     * But it takes more space than above algorithm
     * @param nums
     * @return
     */
    public boolean has_duplicates_hashset(int[] nums)
    {
        HashSet<Integer> my_set = new HashSet<>();

        for(int num : nums)
        {
            if(my_set.contains(num))
            {
                return true;
            }
            my_set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_duplicate obj = new Contains_duplicate();
        int[] nums = {1,2,3,4,5};
        System.out.println(obj.has_duplicates_hashset(nums));
    }
}
