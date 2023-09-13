package Problems;

import java.util.*;
import java.util.Stack;

/******
 * We will be given an array and the window key
 * We will be able to only see the array with the length of window key first
 * And we will traveerse to find the max among those
 */
public class Sliding_window_Max
{
    /********
     * This algorithm works but time complexity of this algorithm is : 0(n * k)
     * @param array
     * @param key
     * @return
     */
    int[] result(int[] array, int key)
    {
        int[] result = new int[array.length - key + 1];

        for(int i = 0; i <= array.length - key; i++)
        {
            int j = i + 1, k = key + i - 1;
            int max = array[i];
            while(j <= k)
            {
                if(max < array[j])
                {
                    max = array[j];
                }
                j++;
            }
            result[i] = max;
        }
        return result;
    }

    /*********
     * This is the perfect algorithm with time complexity of 0(n).
     * @param array
     * @param key
     * @return
     */
    public int[] maxSlidingWindow(int[] array, int key) {

    int n = array.length;
    int[] result = new int[n - key + 1];
    Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices

    for (int i = 0; i < n; i++) { //{44,77,33,44,88,11};
        // Remove elements from the front that are out of the current window
        while (!deque.isEmpty() && deque.peek() < i - key + 1) {
            deque.poll();
        }

        // Remove elements from the rear that are smaller than the current element
        while (!deque.isEmpty() && array[deque.peekLast()] < array[i]) {
            deque.pollLast();
        }

        // Add the current index to the rear
        deque.offer(i);

        // Populate result array with the maximum value of the current window
        if (i >= key - 1 && !deque.isEmpty()) {
            result[i - key + 1] = array[deque.peek()];
        }
    }

    return result;
}
    public static void main(String[] args) {
        Sliding_window_Max obj = new Sliding_window_Max();
        int[] arr = {44,77,33,44,88,11};
        System.out.println(Arrays.toString(obj.maxSlidingWindow(arr, 3)));
    }
}
