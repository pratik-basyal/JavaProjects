package Problems;

import java.util.Arrays;

public class product_except_self
{
    /*******
     * This is trash algorithm with time complexity of 0(n^2)
     * @param array
     * @return
     */
    public int[] product(int[] array)
    {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++)
        {
            int j = 0, k = array.length - 1;
            int num = 1;
            while(j < i)
            {
                num *= array[j];
                j++;
            }

            while(k > i)
            {
                num *= array[k];
                k--;
            }
            result[i] = num;
        }
        return result;
    }

    /******
     * This is the right algorithm with time complexity 0(n)
     * @param array
     * @return
     */
    public int[] product_ex_self(int[] array) // {2,3,4,5}
    {
        int[] result = new int[array.length];
        int leftProduct = 1;
        for(int i = 0; i < array.length; i++)
        {
            result[i] = leftProduct;
            leftProduct = leftProduct * array[i];
        }
         //result = {1,2,6,24}
        int rightProduct = 1;
        for(int j = array.length - 1; j >= 0; j--)
        {
            result[j] *= rightProduct;
            rightProduct *= array[j];
        }

        return result;
    }
    public static void main(String[] args) {
        product_except_self obj = new product_except_self();
        int[] array = {1,2,3,4};

        System.out.println(Arrays.toString(obj.product_ex_self(array)));
    }
}
