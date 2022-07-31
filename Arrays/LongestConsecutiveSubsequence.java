/**
 * 
 * https://www.youtube.com/watch?v=pfv76jZ6NDU
 * 
 * https://www.geeksforgeeks.org/longest-consecutive-subsequence/
 * 
 *  Create an empty hash.
    Insert all array elements to hash.
    Do following for every element arr[i]
    Check if this element is the starting point of a subsequence. To check this, simply look for arr[i] – 1 in the hash, if not found, then this is the first element a subsequence.
    If this element is the first element, then count the number of elements in the consecutive starting with this element. Iterate from arr[i] + 1 till the last element that can be found.
    If the count is more than the previous longest subsequence found, then update this.
 * 
 */

package Arrays;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    static int findLongestConseqSubseq(int arr[], int N)
	{
	   HashSet<Integer> hs = new HashSet<>();
	   
	   for(int i=0;i<N;i++)
	        hs.add(arr[i]);
	   int res=0;
	   for(int i=0;i<N;i++)
	   {
	       if(!hs.contains(arr[i]-1))
	       {
	           int j = arr[i];
	           while(hs.contains(j))
	                j++;
	           res = Math.max(res,j-arr[i]);
	       }
	   }
	   return res;
	}
    
}
