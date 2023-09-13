/***********
 * Dynamic Programming is a technique :
 * In which complex problems are solved by breaking them into smaller chunk of pieces
 * Solving those sub-problems and simply storing the results in the problems
 * Re-use those results when we encounter/overlapped similar problems
 * Finally building up the precise solutions to the complex problems
 *
 * Basically Dynamic Programming is : Recursions + Memorization
 */
public class Data_Structures_Dynamic_Programming
{

    //First off we will start as a fibonacci series
    //inefficient method
    public int fibonacci_numbers(int fib)
    {
        if(fib == 0 || fib == 1) return fib;

        int left = fibonacci_numbers(fib - 1);
        int right = fibonacci_numbers(fib - 2);

        return left + right;
    }


    // dynamical approach for fibonacci numbers

    /*****
     * Bottom up approach
     * Also known as tabular approach
     * Where we will be storing the value in table and use it repeatedly
     * @param num
     * @return
     */
    public long dynamic_approach_for_fibonacci_number(int num)
    {
        long[] table = new long[num + 1]; // 0 -> n

        table[0] = 0;
        table[1] = 1;

        for(int i = 2; i <=  num; i++)
        {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[num];
    }

    /**********
     * Top Down Approach
     * Also part of the Dynamical approach
     * @param memo
     * @param fib
     * @return
     */
    public long fibonacci_numbers_top_to_bottom(long[] memo, int fib)
    {
        if(memo[fib] == 0) {
            if (fib == 0 || fib == 1) memo[fib] = fib;

            else {
                long left = fibonacci_numbers_top_to_bottom(memo, fib - 1);
                long right = fibonacci_numbers_top_to_bottom(memo,fib - 2);

                memo[fib] = left + right;
            }
        }
        return memo[fib];
    }

    public static void main(String[] args)
    {
        Data_Structures_Dynamic_Programming obj = new Data_Structures_Dynamic_Programming();

        long[] memo = new long[100 + 1];
        System.out.println(obj.fibonacci_numbers_top_to_bottom(memo,100));
        System.out.println(obj.dynamic_approach_for_fibonacci_number(5));
    }
}
