package Problems;

import java.util.Arrays;

/******
 * Here we will try to find the target with the sum of three elements inside the array
 * We will be using 3 pointers and the algorithm applies once it gets sorted out first
 */
public class Three_Sum
{
    /******
     * We will be needing three pointers for this algorithm
     *
     * @param array
     */
    public void three_Sum(int[] array, int target)
    {
        Arrays.sort(array); //will sort this array first
        for(int i = 0; i < array.length; i++)
        {
            int j = i + 1;
            int k = array.length - 1;

            while(j < k)
            {
                int sum = array[i] + array[j] + array[k];

                if(sum == target)
                {
                    System.out.println(array[i] + "," + array[j] + "," + array[k]);
                    j++;
                    k++;
                }
                else if(sum > target) k--;

                else{
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Three_Sum obj = new Three_Sum();
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

        obj.three_Sum(array, 20);
    }
}
