/******
 * Here we will Learn lots of searching techniques within the array
 */
public class Data_Structures_Searching_Algorithms
{
    /*****
     * This method is nothing but just the direct searching technique using for loop
     * Time consuming for big chunk of an array
     * But prretty effective for small arrays
     * @param arr
     */
    public int Linear_Search(int[] arr, int key)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == key) return i;
        }
        return -1; // if we don't find it then this will return -1
    }

    /*******
     * This method is pretty useful but will work only for sorted arrays
     * We will divide the array into half everytime until we find the key
     * Also this method will returnthe index of the key
     * @param arr
     * @param key
     * @return
     */
    public int Binary_Search_Index(int[]arr, int key)
    {
        int high = arr.length - 1;
        int low = 0;

        while(low <= high) {
            int mid = (high + low) / 2;

            if (arr[mid] == key) return mid;

            if (arr[mid] < key) {
                low = mid + 1;
            }

            if (arr[mid] > key) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
