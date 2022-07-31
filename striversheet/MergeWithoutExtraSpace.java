import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1#
 * 
 * Solution:
 * =========
 * https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 * https://www.youtube.com/watch?v=hVl2b3bLzBw
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 * https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
 * 
 * Another variation:
 * ===================
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Algorithm:
 * 
1) Initialize i,j,k as 0,0,n-1 where n is size of arr1 
2) Iterate through every element of arr1 and arr2 using two pointers i and j respectively
    if arr1[i] is less than arr2[j]
        increment i
    else
        swap the arr2[j] and arr1[k]
        increment j and decrement k

3) Sort both arr1 and arr2 
 * 
 * 
 * 
Time Complexity: The time complexity while traversing the arrays in while loop is O(n+m) in worst case and sorting is O(nlog(n) + mlog(m)). So overall time complexity of the code becomes O((n+m)log(n+m)).
Space Complexity: O(1).
 */

public class MergeWithoutExtraSpace {

    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        
        int left1=0,left2=0,right1=n-1;
        
        while(left1<=right1 && left2<m)
        {
            if(arr1[left1] <= arr2[left2])
                left1++;
            else
            {
                    long temp = arr1[right1];
                    arr1[right1] = arr2[left2];
                    arr2[left2] = temp;
                    right1--;
                    left2++;
                }
            }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    
}
