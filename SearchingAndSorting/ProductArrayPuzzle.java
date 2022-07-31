/**
 * 
 * https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1#
 * https://www.geeksforgeeks.org/a-product-array-puzzle/    
 * 
 * 
 *  Create two array prefix and suffix of length n, i.e length of the original array, initialize prefix[0] = 1 and suffix[n-1] = 1 and also another array to store the product.
    Traverse the array from second index to end.
    For every index i update prefix[i] as prefix[i] = prefix[i-1] * array[i-1], i.e store the product upto i-1 index from the start of array.
    Traverse the array from second last index to start.
    For every index i update suffix[i] as suffix[i] = suffix[i+1] * array[i+1], i.e store the product upto i+1 index from the end of array
    Traverse the array from start to end.
    For every index i the output will be prefix[i] * suffix[i], the product of the array element except that element.
 * 
 */

package SearchingAndSorting;

public class ProductArrayPuzzle {

    public static long[] productExceptSelf(int arr[], int n) 
	{ 
        // logic is find prefix[] and find suffix[] product[i] = prefix[i]*suffix[i].
        long prefix[] = new long[n];    
        long suffix[] = new long[n];
        
        long res[] = new long[n];
        
        prefix[0]=1;
        suffix[n-1]=1;
        
        for(int i=1;i<n;i++)
            prefix[i] = arr[i-1]*prefix[i-1];
        
        for(int i=n-2;i>=0;i--)
            suffix[i] = arr[i+1]*suffix[i+1];
        
        for(int i=0;i<n;i++)
            res[i] = prefix[i] *suffix[i];
        
        return res;
        
	} 
    
}
