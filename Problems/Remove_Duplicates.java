package Problems;

public class Remove_Duplicates
{
    /*******
     * I approached with this method
     * @param array
     * @return
     */
    public int remove_duplicates(int[] array) // 0,0,1,1,1,2,2,3,3,3
    {
        int i = 0;
        for(int j = 1; j < array.length; j++)
        {
            if(array[i] != array[j])
            {
                array[i+1] = array[j];
                i++;
            }
        }
        return i + 1;
    }

    /*******
     * Just the same thing
     * @param array
     * @return
     */
    public int remove_dup(int[] array) // 0,0,1,1,1,2,2,3,3,3
    {
        int i = 1;
        for(int j = 1; j < array.length; j++)
        {
            if(array[i - 1] != array[j])
            {
                array[i] = array[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        Remove_Duplicates obj = new Remove_Duplicates();
        System.out.println(obj.remove_dup(array));
    }

    public static class Sliding_Window_Max
    {

    }
}
