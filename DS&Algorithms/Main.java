import java.util.*;

/******
 * Bubble Sort Algorithm is also called the Sinking Algorithm
 * This algorithm just checks if the array is in the correct order
 * Large number in the array will just sink in to the last position
 * And once it sinks we will ignore the last one and refuce the size of array one at a time
 * We start with first two numbers, and if they are in wrong order :
 * We swap them and move to next two
 * We will continue until every numbers are in correct order
 */
//public class Main {
//    public static int[] BubbleSort(int[] nums)
//    {
        // this boolean is to break the loop if array is already sorted
        // so that we don't need to loop through an entire array
//        boolean isSwapped;
//        int len = nums.length;
//
//        // we going to len - 1 end
//        for(int i = 0; i < len - 1; i++)
//        {
//            isSwapped = false; // keeps track of sorting
//
//
//            for(int j = 0; j < len - 1 - i; j++)
//            {
//                if(nums[j] > nums[j+1])
//                {
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                    isSwapped = true;
//                }
//            }
//            if(!isSwapped) break;
//        }
//        return nums;
//    }
//    public static void main(String[] args) {
//        int [] nums = {5,1,2,10,9};
//        System.out.println(Arrays.toString(BubbleSort(nums)));
//    }
//}


/******
 * Insertion Sort Algorithm
 * Here we divide the array in two parts : which are - Sorted and Unsorted parts
 * We pick the first element from the unsorted part
 * And we try to fix its position in the sorted parts
 *
 */

//public class Main
//{
//    public static int [] Insertion_sort(int[] nums)
//    {
//        int temp; // to store the data and swap if necessary
//
//        // here we just starts with i = 1 because
//        // we consider sorted array for i = 0;
//        // and we keep adding to that following the algorithm
//        for(int i = 1; i < nums.length; i++)
//        {
//            temp = nums[i];
//            if(temp < nums[i-1])
//            {
//                int j = i-1; // sorted part
//                while(j >= 0 && nums[j] > temp )
//                {
//                    // we will just use j so that we don't mess with i and change its value
//                    nums[j+1] = nums[j];
//                    j--;
//                }
//                nums[j+1] = temp;
//            }
//        }
//        return nums;
//    }
//
//    public static void main(String[] args) {
//        int [] nums = {5,1,9,2,10,11,4};
//        System.out.println(Arrays.toString(Insertion_sort(nums)));
//    }
//}

/*********
 * Selection Sort Algorithm
 * We try to sort the array with the minimum value
 */

//public class Main
//{
//    public static int[] Selection_sort(int[] nums)
//    {
//        for(int i = 0; i < nums.length-1; i++)
//        {
//            int count = i;
//            int min = nums[i];
//            int j;
//            for(j = i+1; j < nums.length; j++)
//            {
//                if(nums[j] < min)
//                {
//                    min = nums[j];
//                    count = j;
//                }
//            }
//            int temp = nums[i];
//            nums[i] = nums[count];
//            nums[count] = temp;
//        }
//        return nums;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {5,1,9};
//        System.out.println(Arrays.toString(Selection_sort(nums)));
//    }
//}

/*******
 * MERGE SORT
 * Dividing the content into half recursively
 * Finally, merge every single sorted ones and Sort it
 ********/

/***
 * 1. This is just the reference for the Merge Sort algorithm
 * First we do linear search which is quite fair and simple
 * we find index in array with just a loop
 *
 * 2. This is BINARY SEARCH now
 */

//public class Main
//{
//    /**
//     * basically we are executing the sorted array(nums)
//     * and finding the right index for the key we are given to find
//     */
//    public int Binary_index_Search(int[] nums, int key)
//    {
//        int low = 0; //index for the first element in array
//        int high = nums.length - 1; // index for the last element in array
//
//        while(low <= high)
//        {
//            int mid = (high + low) / 2;
//            if(nums[mid] == key)
//            {
//                return mid;
//            }
//
//            if(key < nums[mid])
//            {
//                high = mid - 1;
//            }
//
//            else
//            {
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        int nums[] = {24, 67, 89, 87, 45, 99};
//        int key = 99;
//
//        Main binary_search = new Main();
//        System.out.println(binary_search.Binary_index_Search(nums, key));
//    }
//}

/****
 * Given an array of integers, return a pair of numbers such that
 * they add up to a specific target
 */

//public class Main
//{
//    public int[] target_array(int nums[], int target)
//    {
//        int left = 0;
//        int right = nums.length - 1;
//        int[] result = new int[2];
//        Arrays.sort(nums); // sorted array in ascending order
//
//        while(left < right)
//        {
//            int sum = nums[left] + nums[right];
//
//            if(sum == target)
//            {
//                result[0] = nums[left];
//                result[1] = nums[right];
//                break;
//            }
//
//            else if(sum > target)
//            {
//                right --;
//            }
//
//            else {
//                left++;
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Main my_main = new Main();
//        int nums[] = {1,2,3,4,5};
//        int target = 8;
//        System.out.println(Arrays.toString(my_main.target_array(nums, target)));
//    }
//}

public class Main{
    int[] reverse_array(int[] nums){
        int start = 0
                ;
        int end = nums.length-1;

        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        Main mine = new Main();
        int nums[] = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(mine.reverse_array(nums)));
    }
}