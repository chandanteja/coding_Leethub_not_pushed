/**
 * 
 * Reference is GFG Self-paced DSA course.
 * 
 * https://www.youtube.com/watch?v=m18Hntz4go8  --> watch this for O(1) space soln. Uses 2-pointer approach
 * 
 * Logic is the left-most bar and right-most bar cant hold any water. So, we start our traversal from 2nd bar to (n-1)th bar.
 * 
 * For every bar-i, we calculate the max height bar on its left side and max-height bar on its right side.
 * 
 * Amount of water that can be stored on bar-i ==> bar[i] = Math.min(leftmax[i],rightmax[i])-height[i].
 * We are taking minimum bcz if one bar is ht =10 and other bar is of ht=7 then only 7-units of water can be stored if height[i] =0 else,
 * from '7', we need to remove height[i] i.e height of bar[i].
 * 
 * Naive solution doesnt pre-calculate left and right max's for all elements of array.  --> O(n^2)
 * In eficient solution we do this calculation.
 * 
 * 
 */

package Arrays;

public class TrappingRainWater {

    static int trappingWater(int arr[], int n) { 
        
        if(n==0)    // base case
            return 0;

        int left_max[] = new int[n];
        int right_max[] = new int[n];
        
        left_max[0] = arr[0];   // there is no max height tower on its left , so we consider this tower itself as left max for 1st tower.
        for(int i=1;i<n;i++)
        {
            left_max[i] = Math.max(arr[i],left_max[i-1]);
        }
        
        right_max[n-1] = arr[n-1];
        
        for(int i=n-2;i>=0;i--)
        {
            right_max[i] = Math.max(arr[i],right_max[i+1]);
        }
        
        int max_water=0;
        
        for(int i=1;i<n-1;i++)
        {
            max_water = max_water+Math.min(left_max[i],right_max[i])-arr[i];
        }
        
        return max_water;
    } 

    // The above soln uses O(n) both time and space.
    // The below soln uses O(n) time and O(1) space.
    // refer the Striver(TUF) video for this approach.

    /**
     * 
     * public int trap(int[] height) {
        
        int leftmax=0, rightmax=0;
        
        int left,right;
        
        left=0;
        right = height.length-1;
        int res=0;
        
        while(left<=right)
        {
            if(height[left]<=height[right])
            {
                if(height[left]>=leftmax)
                {
                    leftmax = height[left];
                }
                else
                    res = res+leftmax-height[left];
                
                left++;
            }
            else
            {
                if(height[right]>=rightmax)
                {
                    rightmax = height[right];
                }
                else
                    res = res+rightmax-height[right];
                right--;
            }
        }
        return res;
        
        
    }
     * 
     */
    
}
