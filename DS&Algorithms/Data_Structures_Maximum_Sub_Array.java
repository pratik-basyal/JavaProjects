/********
 * Kadane's Algorithm
 * We will have current max and max_So_Far variables
 * Current_max will keep track of max sum of sub array
 * max_So_Far is the maximum value created by sub arrays so far
 */
public class Data_Structures_Maximum_Sub_Array
{

    public static int max_sum_from_sub_array(int[] array)
    {
        int current_max = array[0];;
        int max_so_far = array[0];

        for(int i = 1; i < array.length; i++)
        {
            current_max += array[i];

            if(current_max < array[i])
            {
                current_max = array[i];
            }

            if(max_so_far < current_max)
            {
                max_so_far = current_max;
            }
        }
        return max_so_far;
    }

    public static void main(String[] args)
    {
        int [] array = {4,3,-2,6,-12,7,-1,6};
        System.out.println(max_sum_from_sub_array(array));
    }
}
