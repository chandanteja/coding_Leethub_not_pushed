/**
 * 
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/      --> go thru this article for the approach.
 * 
 * 
 * Algorithm
 * --------------

As in the normal binary search, we keep two pointers (i.e. start and end) to track the search scope. 
At each iteration, we reduce the search scope into half, by moving either the start or end pointer to the middle (i.e. mid) of the previous search scope.

Here are the detailed breakdowns of the algorithm:

Initiate the pointer start to 0, and the pointer end to n - 1.

Perform standard binary search. While start <= end:

Take an index in the middle mid as a pivot.

If nums[mid] == target, the job is done, return mid.

Now there could be two situations:

Pivot element is larger than the first element in the array, i.e. the subarray from the first element to the pivot is non-rotated, as shown in the following graph.


 - If the target is located in the non-rotated subarray:
  go left: `end = mid - 1`.

  - Otherwise: go right: `start = mid + 1`.


  Pivot element is smaller than the first element of the array, i.e. the rotation index is somewhere between 0 and mid. It implies that the sub-array from the pivot element to the last one is non-rotated, as shown in the following graph.

    - If the target is located in the non-rotated subarray:
  go right: `start = mid + 1`.

  - Otherwise: go left: `end = mid - 1`.
 * 
 */

package Arrays;

public class SearchInSortedRotatedArray {

    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;
 
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
 
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }
 
        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
 
        return search(arr, l, mid - 1, key);
    }
    
}

// Iterative



/*
class Solution {
  public int search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] >= nums[start]) {
        if (target >= nums[start] && target < nums[mid]) end = mid - 1;
        else start = mid + 1;
      }
      else {
        if (target <= nums[end] && target > nums[mid]) start = mid + 1;
        else end = mid - 1;
      }
    }
    return -1;
  }
}

*/
