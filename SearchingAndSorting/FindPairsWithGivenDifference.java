/**
 * https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
 * 
 * https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
 * 
 * T.C : O(nlogn)
 * 
 *  First sort the array and take 2-pointers i,j.
 * 
 *  i=0 and j=1, as array is sorted, 'j' will point to ele greater than or equal to ele pointed by 'i'.
 * 
 *  So check if arr[j]-arr[i] > x ==> the smaller number (ele pointed by 'i') needs to be increased so that difference can deccrease --> increase i.
 *  if arr[j] - arr[i] <x ==> means larger number (ele pointed by 'j') is more ,so increase j.
 * 
 */

package SearchingAndSorting;

import java.util.Arrays;

public class FindPairsWithGivenDifference {

    public boolean findPair(int arr[], int n, int x)
    {
        Arrays.sort(arr);
        
        int i=0,j=1;
        
        while(i<n && j<n)
        {
            if(i!=j && arr[j]-arr[i]==x)
                return true;
           else if(arr[j]-arr[i] < x)
                j++;
            else    //(arr[j]-arr[i]>x)
                i++;
           
        }
        return false;
    }
    
}
