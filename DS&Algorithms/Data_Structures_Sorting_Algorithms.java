import java.util.Arrays;

/*******
 * Here we will learn about lots of sorting algorithms
 */
public class Data_Structures_Sorting_Algorithms
{
    /*******
     * This method follows bubble sort algorithm.
     * In bubble sort we keep swaping two datas at a time and push the maximum number to the last
     * Similarly we will just keep continue it until the array get sorted
     * @param arr
     */
    public static int[] Bubble_Sort(int[] arr)
    {
        int len = arr.length - 1;

        boolean isSwapped; // this will check if the swap happened or not

        for (int i = 0; i < len; i++)
        {
            isSwapped = false;
            for(int j = 0; j < len - i; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
        return arr;
    }

    /***********
     * Here we will first divide the array  in the two part
     * They are sorted and unsorted array
     * We will start the sorted array by picking the first element in the array
     * Then we will just add the element from the unsorted array
     * @param array
     * @return
     */
    public static int[] insertion_sort(int[] array)
    {
        int temp; // this is the sorted part

        for(int i = 1; i < array.length; i++)
        {
            temp = array[i];
            int j = i - 1;
            if(temp < array[j])
            {
                while(j >= 0 && temp < array[j])
                {
                    array[j] = array[j + 1];
                    j--;
                }
            }
            array[j + 1] = temp;
        }
        return array;
    }

    /*********
     * This method is called the selection sort.
     * Here we find the minimum, and then swap its places until it all got sorted out
     * Basically heres also , array's divided into two parts : sorted and unsorted part
     * First everything is in unsorted part
     * WE pick the first element in the array, and go thru all others to find the minimum
     * AFter that we will put swap it with the first element
     * Now the first element becomes the part of sorted array
     * @param array
     * @return
     */
    public static int[] selection_sort(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            int count = i; // to keep the track of which one is minimum's index

            int min = array[i];

            for(int j = i + 1; j < array.length; j++)
            {
                if(min > array[j])
                {
                    min = array[j];
                    count = j; // minimum's index
                }
            }

            if(count != i)
            {
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;
            }
        }
        return array;
    }

    /**********
     * This method will return a merged integer sorted array.
     * P
     * @param array1
     * @param array2
     * @return
     */
    public static int[] merge_two_sorted_arrays(int[] array1, int[] array2)
    {
        int[] new_array = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0; //pointer to the index of array1, array2, and new array respectively

        while(i < array1.length && j < array2.length)
        {
            if (array1[i] < array2[j])
            {
                new_array[k] = array1[i];
                i++;
                k++;
            }
            else
            {
                new_array[k] = array2[j];
                j++;
                k++;
            }
        }

        // if theres any left in array1 after array2 is done for
        while(i < array1.length)
        {
            new_array[k] = array1[i];
            i++;
            j++;
        }

        // if there is any left in array2 after array1 is done for
        while(j < array2.length)
        {
            new_array[k] = array2[j];
            j++;
            k++;
        }
        return new_array;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,4, 9, 7, 6};

        int[] arr1 = {2,3,5,10};
        int[] arr2 = {4,6,11,15};

        System.out.println(Arrays.toString(Bubble_Sort(arr)));
        System.out.println(Arrays.toString(insertion_sort(arr)));
        System.out.println(Arrays.toString(selection_sort(arr)));

        System.out.println(Arrays.toString(merge_two_sorted_arrays(arr1, arr2)));
    }
}
