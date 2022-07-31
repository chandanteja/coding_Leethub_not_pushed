/**
 * 
 * https://www.geeksforgeeks.org/first-strictly-greater-element-in-a-sorted-array-in-java/
 * 
 * 
 */

package SearchingAndSorting;

public class BinarysSearchForStrictlyGreaterEleInSortedArr {

    public static int next(int[] arr, int x)
    {

        int low = 0;
        int hi = arr.length-1;

        int ans=-1;

        while(low<=hi)
        {

            int mid = (low+hi)/2;

            // Move to right side if target is
            // greater.
            if(arr[mid]<=x)
                low=mid+1;
            // means mid element is greter than 'x' so we found one element which is greater than given 'x' so we will mark it and move left.
            // if we find any element which is greater than(least element) 'x'  then we will update 'ans' again.
            else
            {
                ans=mid;
                hi = mid-1;
            }
        }
        return ans;

    }
    
}
