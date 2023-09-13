package Problems;

public class Find_The_Missing_Numbers {
    private static int missing_Number(int[] array, int[] missing_array)
    {
        int missingNumber;
        int arraySum = 0;
        int missingArraySum = 0;

        for(int num : array) {
            arraySum += num;
        }

        for(int num : missing_array) {
             missingArraySum += num;
        }

        missingNumber = arraySum ^ missingArraySum;
        return  missingNumber;
    }

    private static int found(int[] array, int[] missing_array)
    {
        boolean[] arr = new boolean[array.length];

        for(int i = 0; i < array.length; i++)
        {
            if(i <= missing_array.length - 1 && array[i] == missing_array[i] )
            {
                arr[i] = true;
            }

            if(!arr[i]) return array[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(missing_Number(new int[]{1, 2, 3, 4, 5}, new int[]{1,2,3,4}));
        System.out.println(found(new int[]{1, 2, 3, 4, 5}, new int[]{1,2,3,4}));
    }
}
