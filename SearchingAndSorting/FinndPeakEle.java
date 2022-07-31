/**
 * 
 * T.C : O(logn)    --> though the array is not sorted, we use binary search bcz of below idea.
 * 
 * The idea is based on the technique of Binary Search to check if the middle element is the peak element or not. 
 * If the middle element is not the peak element, then check if the element on the right side is greater than the middle element then there is always a peak element on the right side. 
 * If the element on the left side is greater than the middle element then there is always a peak element on the left side. 
 * Form a recursion and the peak element can be found in log n time. 
 * 
 * 
 * https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * 
 * Also refer GFG self paced DSA course.
 * 
 */

package SearchingAndSorting;

public class FinndPeakEle {

    public int peakElement(int[] arr,int n)
    {
       int low =0;
       int hi=n-1;
       
       while(low<=hi)
       {
           int mid = (low+hi)/2;
           
        // Compare middle element with its
        // neighbours (if neighbours exist)
           if((mid==0 || arr[mid-1]<=arr[mid]) &&(mid==n-1 || arr[mid+1]<=arr[mid]))
                return mid;

        // If middle element is not peak
        // and its left neighbor is
        // greater than it, then left half
        // must have a peak element
            else if(mid>0 && arr[mid]<=arr[mid-1])
                hi=mid-1;
            
        // If middle element is not peak
        // and its right neighbor
        // is greater than it, then right
        // half must have a peak
        // element
            else
                low=mid+1;
       }
       return -1;
    }
    
}
