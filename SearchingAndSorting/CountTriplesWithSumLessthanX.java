/**
 * 
 * https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 * 
 * 
 *  1) Sort the input array in increasing order.
    2) Initialize result as 0.
    3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
    triplets with arr[i] as first element.
        a) Initialize other two elements as corner elements of subarray
            arr[i+1..n-1], i.e., j = i+1 and k = n-1
        b) Move j and k toward each other until they meet, i.e., while (j<k),
                (i) If arr[i] + arr[j] + arr[k] >= sum
                    then k--
                // Else for current i and j, there can (k-j) possible third elements
                // that satisfy the constraint.
                (ii) Else Do ans += (k - j) followed by j++ 


                T.C : O(n^2)
 * 
 */


package SearchingAndSorting;

import java.util.Arrays;

public class CountTriplesWithSumLessthanX {

    long countTriplets(long arr[], int n,int sum)
    {
       int res=0;
       
       Arrays.sort(arr);    // first sort the array and take 3-pointers i,j,k
       
       for(int i=0;i<n-2;i++)
       {
           int j=i+1,k=n-1;
           
           while(j<=k)
           {
               if(arr[i]+arr[j]+arr[k]>=sum)
                    k--;
               else
                {
                    res = res+(k-j);    // as arr[] is sorted all elements b/w [j,k] will contribute to result.
                    j++;
                }
           }
       }
       return res;
    }
    
}
