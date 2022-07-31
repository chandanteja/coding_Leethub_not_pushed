/**
 * 
 * 
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * 
 * 
 *  Sort the given array.
    Loop over the array and fix the first element of the possible triplet, arr[i].
    Then fix two pointers, one at i + 1 and the other at n – 1. And look at the sum, 
            If the sum is smaller than the required sum, increment the first pointer.
            Else, If the sum is bigger, Decrease the end pointer to reduce the sum.
            Else, if the sum of elements at two-pointer is equal to given sum then print the triplet and break.
 * 
 */

package Arrays;

import java.util.Arrays;

public class TripletSumArray {

    public static boolean find3Numbers(int A[], int n, int X) { 
    
        Arrays.sort(A);
        for(int i=0;i<n-1;i++)
        {
            int l=i+1;
            int h = n-1;
            
            while(l<h)
            {
                if(A[i]+A[l]+A[h]==X)
                  return true;
                else if(A[i]+A[l]+A[h]<X)
                  l++;
                else
                  h--;
            }
        }
          return false;
      }
    
}
