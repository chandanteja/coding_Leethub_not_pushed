/**
 * 
 * https://leetcode.com/problems/rotate-array/discuss/1279457/Java-Solution-with-O(1)-Auxiliary-space
 * 
 * Also refer GFG DSA course video.
 * 
 */

package Arrays;

public class RotateArrayByd {


// Consider the array;
// arr[] = {1,2,3,4,5}; and k=2
// First we will reverse the first k element from right --> {4,5} -> {5,4}
// Then we will reverse the remaining elements {1,2,3} -> {3,2,1}
// Now our array is- arr[] = {3,2,1,5,4}
// Finally we will reverse the whole array:
// Result:- {4,5,1,2,3}

    // this rotation is in one direction
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;    // dont forget this. we will update 'k' to be lessthan array size.
        int n=nums.length;
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
    
        // for(int i:nums){
        //     System.out.print(i + " ");
        // }
}

public static void reverse(int[] nums,int low,int high){
    while(low<high){
        int temp=nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
        low++;
        high--;
    }
}

    // This rotation is in other direction. Different from above one. But logic is same as above one just small changes.

    // static void rotateArr(int arr[], int d, int n)
    //     {
    //         int i=0,j=d-1;
            
    //         while(i<=j)
    //         {
    //           int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             i++;
    //             j--;
    //         }
            
    //         i=d;j=n-1;
            
    //         while(i<=j)
    //         {
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             i++;
    //             j--;
    //         }
            
    //         i=0;j=n-1;
    //         while(i<=j)
    //         {
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             i++;
    //             j--;
    //         }
    //     }
    
}
