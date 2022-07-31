package SearchingAndSorting;

import java.util.Arrays;

public class SortBySetBitsCount {

    static void sortBySetBitCount(Integer arr[], int n)
    { 
        Arrays.sort(arr,(a,b)->Integer.compare(Integer.bitCount(b),Integer.bitCount(a)));   // lambda function
    } 
    
}
