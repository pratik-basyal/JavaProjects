import java.util.Arrays;

/**********
 * Merge Sort Algorithm is the algorithm to sort the array
 * In this method we will Divide and Conquer the array
 * We will keep breaking down the array until there is no room to break it
 * That means we will break it until there is only one of em
 *
 * After that we will conquer, which means we will start merging the array
 * We will keep merging which was broken one by one and finally we will obtain the sorted array
 */
public class Merge_Sort_Algorithm
{
    /*********
     * This method takes all three of these
     * @param original
     * @param temp
     * @param low
     * @param high
     * we will store the original to temp first and try to sort it out
     * once we sort it out we will again store it to the original one and boom
     *
     * So we will be taking low and high integers
     * We will find the mid and divide the array to the left and right part
     *
     * We will be using the formula for mid as :
     * Mid = low + (high - low) / 2;
     * This is because type int has its limit
     * And when high and low value reaches to the almost maximum values
     * And we use the formula as : mid = (high + low) / 2
     * (High + low) will produce garbage value and the result will be garbage
     */
    public void merge_sort(int[] original, int[] temp, int low, int high)
    {
        if(low < high) // this will be our base case for the recursion
        {
            int mid = low + (high - low) / 2; // this formula is explained above

            merge_sort(original, temp, low, mid); // this will work for the left part

            merge_sort(original, temp, mid + 1, high);

            conquer(original, temp, low, high, mid);
        }
    }

    /*********
     * This Conquer method will help in sort after the arrays get divided
     * @param original
     * @param temp
     * @param low
     * @param high
     * @param mid
     *
     * In other word this will help in merging the arrays
     */
    public void conquer(int[] original, int[] temp, int low, int high, int mid)
    {
        for(int i = low; i <= high; i++)
        {
            temp[i] = original[i];
        }

        int i = low; // left sorted array
        int k = low; // will merge both arrays into original array
        int j = mid + 1; // right sorted araray

        while(i <= mid && j <= high)
        {
            if(temp[i] <= temp[j])
            {
                original[k] = temp[i];
                i++;
            }

            else{
                original[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i <= mid)
        {
            original[k] = temp[i];
            i++;
            k++;
        }

        // we don't need this part, cause we will have already stored values in a proper order in original array
        // since we would already be sorting out the arrays
        while(j <= high)
        {
            original[k] = temp[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Merge_Sort_Algorithm obj = new Merge_Sort_Algorithm();
        int[] array = {2,4,6,1,3,5};
        int[] temp = new int[array.length];

        obj.merge_sort(array, temp, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}
