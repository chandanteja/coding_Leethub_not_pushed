/**
 * 
 * https://practice.geeksforgeeks.org/problems/jump-game/1/?track=md-arrays&batchId=144#        --> qns
 * 
 * Logic is same as minimum jumps to reach end of array but here we need to check whether we can reach or not.
 * 
 */

package Arrays;

public class JumpGame {

    static int canReach(int[] arr, int N) {
        // code here
        
        int maxReachable = arr[0];      
        
        int stepsRemaining = arr[0];
        int noOfJumps = 1;

        int n = arr.length;
        
        if(arr.length==1)   // if only one element is there in array then its the last position
            return 1;   
        else if(arr[0] == 0)
            return 0;
        else 
        {
            for(int i=1;i<n;i++)
            {
                if(i==n-1)
                    return 1;
                maxReachable = Math.max(maxReachable,i+arr[i]); // i+arr[i] means we from current position i.e 'i', we can jump arr[i] values at a time
                // so if we just take arr[i] then we can only jump from 0th position always but we want to jump from current position i.e 'i', so we need to add 'i' to arr[i]( tells max # of positions we can jump from current position)

                stepsRemaining--;

                if(stepsRemaining==0)   // we have reached end of current maxReachable.
                {
                    noOfJumps++;    // when we reach a position where remaining steps =0 it means we need to take value at current position where step=0 to jump from here to next node.

                    if(i>=maxReachable) // current position have crossed past maxreachable position so it means we cant reach end of array. So return -1.
                        return 0;
                    
                    stepsRemaining = maxReachable-i;        // updating steps remaining from current position to max reachable position
                }
            } 
        }
        return 0;
    }
    
}
