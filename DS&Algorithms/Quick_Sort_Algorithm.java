import java.util.Arrays;

/************
 * Quick Sort Algorithm is also similar to the merge sort
 * We Divide and Conquer the arrays
 * This involves 3 steps :
 * Pivot element : We will pick the pivot element, it can be any element from the array
 * Partitioning : We will rearrange all the elements in array. All the elements smaller than pivot
 * will come to the left side of the pivot, and all th elements greater than the pivot element
 * will come to the right side of the pivot. In this way the pivot will come to the correct index
 * Recursion : We follow these steps recursively, until the array is sorted out
 */
public class Quick_Sort_Algorithm
{
    public void quick_sort(int[] array, int low, int high)
    {
         int pivot = array[high];

         if(low < high) // base case for the recursion
         {
             int p = partitioning(array, low, high, pivot);

             quick_sort(array, low, p-1); // one step lower to the pivot element (p-1)
             quick_sort(array, p+1, high); // one step higher to the pivot element(p+1)
         }
    }

    /*******
     * This method will return the index of the pivot element
     * here index i to j - 1 will be the partitioned lower and equal elements to pivot element
     * j to high will be the partitioned higher to the pivot element
     * @param array
     * @param low
     * @param high
     * @param pivot
     * @return
     */
    public int partitioning(int[] array, int low, int high, int pivot)
    {
        int i = low;
        int j = low; // this pointer will make sure to put all the lower elements at front

        while(i<= high)
        {
            if(array[i] <= pivot)
            {
                int temp = array[i];
                array[i] = array[j];
                array[j]= temp;
                j++;
            }
            i++;
        }
        return j -1; // this is the index of pivot element
    }

    public static void main(String[] args) {
        Quick_Sort_Algorithm obj = new Quick_Sort_Algorithm();
        int[] array = {9, 7, -3, 2, 4, 8, 6, 5};
        obj.quick_sort(array, 0, 7);

        System.out.println(Arrays.toString(array));
    }
}
