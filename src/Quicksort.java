import java.util.List;

/*
 * Quicksort algorithm, recursive implementation
 * Time complexity: worst: O(n^2), average: O(nlogn), best: O(nlogn)
 * n is the number of elements in the array 
 */
public class Quicksort {
    
    // utility method
    private static void swap(List<Integer> arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    
    // Lomuto partition scheme, i.e., it selects the last element of the array as pivot
    private static int partition(List<Integer> arr, int lo, int hi)
    {
        int pivot = arr.get(hi);
        int i = (lo - 1);
        for (int j = lo; j < hi; j++)
        {
            if (arr.get(j) <= pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        
        i++;
        swap(arr, i, hi);
        
        return i;
    }
    
    public static void run(List<Integer> arr, int lo, int hi)
    {
        if ((lo > hi) || (lo < 0))
        {
            return;
        }

        int p = partition(arr, lo, hi);
        run(arr, lo, p - 1);
        run(arr, p + 1, hi);

        return;
    }

}
