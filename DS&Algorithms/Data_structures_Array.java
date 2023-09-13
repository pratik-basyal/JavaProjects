public class Data_structures_Array {
    /***
     * We Will work through array firs and then do rest later.
     */
    int min_value(int[] nums)
    {
        int min = nums[0];
        for(int num : nums)
        {
            if(num < min)
            {
                min = num;
            }
        }
        return min;
    }

    int[] move_zeroes_to_an_end(int[]nums)
    {
        int i = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] != 0 && nums[i] == 0)
            {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            if(nums[i] != 0)
            {
                i++;
            }
        }
        return nums;
    }

    int find_missing_number(int[]nums){
        int n = nums.length +1;

        int sum = n * (n+1) / 2;

        for(int num : nums){
            sum = sum - num;
        }
        return sum;
    }

    boolean is_palindrome_word (String s)
    {
        int start = 0;
        int end = s.length() - 1;

        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Data_structures_Array data = new Data_structures_Array();
        int[] nums = {1,2,3,4,6};
//        System.out.println(data.min_value(nums));
//        System.out.println(Arrays.toString(data.move_zeroes_to_an_end(nums)));
        System.out.println(data.find_missing_number(nums));
        System.out.println(data.is_palindrome_word("deifie"));
    }
}
