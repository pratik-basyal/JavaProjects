import java.util.Arrays;

/*********
 * In this problem we will be having dutch national flag problem
 * Which means we will have the array of only 0's, 1's, and 2's
 * We will need to solve this array with keeping 0's at front, 1's in middle and 2's at last
 */
public class Data_Structures_Dutch_National_Flag_Problem
{
    /********
     * This method is used to swap the element within our array
     * @param arr
     * @param index
     * @param index1
     */
    public void swap(int[] arr, int index, int index1)
    {
        int temp = arr[index];

        arr[index] = arr[index1];

        arr[index1] = temp;
    }

    public void modify_the_array(int[] array)
    {
        // we will have three pointers to traverse in array
        int i = 0; // this will traverse from left to right
        int j = 0; // this will traverse as 0's gets adding up to the front
        int k = array.length - 1; // As 2's gets adding up to the last this will traverse to left

        while(i <= k) // goes until i cross the k while traversing
        {
            if(array[i] == 0)
            {
                swap(array, i, j);
                i++;
                j++;
            }
            else if(array[i] == 1)
            {
                i++;
            }

            else{ // otherwise the value would be 2 and we will swap it with k
                swap(array, i, k);
                k--;
            }
        }
    }

    public static void main(String[] args) {
        Data_Structures_Dutch_National_Flag_Problem obj = new Data_Structures_Dutch_National_Flag_Problem();
        int[] array = {0,2,2,0,1,1};

        obj.modify_the_array(array);

        System.out.println(Arrays.toString(array));

    }
}
