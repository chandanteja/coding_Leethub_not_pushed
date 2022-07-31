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
package DP;

public class MinJumpsToReachEndOfArray {

    // O(n) solution. and Auxiliary Space: O(1). 
    public static int minJumps(int arr[])
    {
        int maxReachable = arr[0];  // tracks wat is the point that is maxreachable from current position
        int stepsRemaining = arr[0];    // what is the remaining steps from current position to reach steps=0;
        int jumpCount =1;

        if(arr.length==1)   // if only one element is there in array then its the last position
            return 0;
        else if(arr[0] ==0)
            return -1;
        else
        {
            for(int i=1;i<arr.length;i++)
            {
                if(i==arr.length-1)
                    return jumpCount;
                maxReachable = Math.max(maxReachable,i+arr[i]); // i+arr[i] means we from current position i.e 'i', we can jump arr[i] values at a time
                // so if we just take arr[i] then we can only jump from 0th position always but we want to jump from current position i.e 'i', so we need to add 'i' to arr[i]( tells max # of positions we can jump from current position)

                stepsRemaining--;
                if(stepsRemaining==0)
                {
                    jumpCount++;    // when we reach a position where remaining steps =0 it means we need to take value at current position where step=0 to jump from here
                    
                    if(i >= maxReachable)   // current position have crossed past maxreachable position so it means we cant reach end of array. So return -1.
                    {
                        return -1;
                    }
                    stepsRemaining = maxReachable-i;    // updating steps remaining from current position to max reachable position
                }
            }
        }
        return -1;
}
public static void main(String[] args)
{
    int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

    // calling minJumps method
    System.out.println("Min jumps: "+minJumps(arr));
}

// Method 2: Dynamic Programming. 
// Approach: 

// In this approach, make a jumps[] (dp-state) array from left to right such that jumps[i] indicate the minimum number of jumps needed to reach arr[i] from arr[0].
// To fill the jumps array run a nested loop inner loop counter is j and outer loop count is i.
// Outer loop from 1 to n-1 and inner loop from 0 to n-1.
// if i is less than j + arr[j] then set jumps[i] to minimum of jumps[i] and jumps[j] + 1. initially set jump[i] to INT MAX
// Finally, return jumps[n-1].

// watch gfg course video for this O(n^2) method with O(n) space.

    static int minJumpsDP(int[] arr, int n)
    {
        int jumps[] = new int[n];   // dp -state where jumps[i] tells min number of steps needed to reach arr[i] from arr[0]

        // if first element is 0,
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

            jumps[0] = 0;   // to reach arr[0] from arr[0] we need 0-steps.

            for (int i = 1; i < n; i++) {   // i -- runs on all possible elements of array from 1 to n i.e jumps[i] represent min jumps from arr[0] to arr[i]

                jumps[i] = Integer.MAX_VALUE;   // initialize with max value.
                for (int j = 0; j < i; j++)
                {   // j- runs on all elements from 0 to i bcz for an i-value, we need to check min possible jumps from 0 to i.
                    
                    if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)   
                    {
                        jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                        break;
                    }
                }
            }
            return jumps[n - 1];
    }
    
}
