/**
 * https://www.youtube.com/watch?v=CqgK_qi4SKQ --> O(n) solution.
 * 
 * Refer GFG course video for O(n^2) using DP solution.
 * O(n) solution:
 * ==============
 *  1. We maintain 3 variables, maxReachable distance that can be traversed, jumps taken till now and steps remaining in current maxReachable .
 *  We initialize maxRem and steps with 1st element and jumps with '1', now if at anytime current-position we are at-i is greater than maxReachable then it means we have crossed past what is  maxReachable,
 *  So, we cant move forward. Else we caan move forward.
 *  2. Now if steps become zero and i(current pos) > maxReachable then we re-initialize possible steps with  maxRem-i 
 *  3. When steps become '0' it means we can acount for one-jump as with arr[i] this is the max possible jump we can make.
 * 
 */

package Arrays;

public class MinJumpsToReachEndOfArray {
    
    public static int minJumps(int arr[])
    {
        int maxReachable = arr[0];      // tracks wat is the point that is maxreachable from current position
        
        int stepsRemaining = arr[0];    // what is the remaining steps from current position to reach steps=0;
        int noOfJumps = 1;

        int n = arr.length;
        
        if(arr.length==1)   // if only one element is there in array then its the last position
            return 0;   
        else if(arr[0] == 0)
            return -1;
        else 
        {
            for(int i=1;i<n;i++)
            {
                if(i==n-1)
                    return noOfJumps;
                maxReachable = Math.max(maxReachable,i+arr[i]); // i+arr[i] means we from current position i.e 'i', we can jump arr[i] values at a time
                // so if we just take arr[i] then we can only jump from 0th position always but we want to jump from current position i.e 'i', so we need to add 'i' to arr[i]( tells max # of positions we can jump from current position)

                stepsRemaining--;

                if(stepsRemaining==0)   // we have reached end of current maxReachable.
                {
                    noOfJumps++;    // when we reach a position where remaining steps =0 it means we need to take value at current position where step=0 to jump from here to next node.

                    if(i>=maxReachable) // current position have crossed past maxreachable position so it means we cant reach end of array. So return -1.
                        return -1;
                    
                    stepsRemaining = maxReachable-i;        // updating steps remaining from current position to max reachable position
                }
            } 
        }
        return -1;
        
    }
}
