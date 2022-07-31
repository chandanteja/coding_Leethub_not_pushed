/**
 * 
 * https://www.geeksforgeeks.org/first-strictly-smaller-element-in-a-sorted-array-in-java/
 * 
 */

package SearchingAndSorting;

public class BinarysSearchForStrictlysmallerEleInSortedArr {

    public static int next(int[] arr, int target)
    {
            int low=0;
            int hi = arr.length-1;

            int ans=-1;

            while(low<=hi)
            {
                int mid = (low+hi)/2;
                while(low<=hi)
                {
                    if(arr[mid]<target) // if given ele 'target' is greater than mid. move to right 
                    {
                        ans=mid;
                        low=mid+1;
                    }
                    else    // arr[mid] >= target   i.e // Move to the left side if the target is smaller
                        hi=mid-1;
                }
                

            }
            return ans;
    }
    
}
