/**
 * 
 * A simple approach is to use two pointer technique and sliding window.

    1. Find count of all elements which are less than or equals to ‘k’. Let’s say the count is ‘cnt’
    2. Using two pointer technique for window of length ‘cnt’, each time keep track of how many elements in this range are greater than ‘k’. Let’s say the total count is ‘bad’.
    3. Repeat step 2, for every window of length ‘cnt’ and take minimum of count ‘bad’ among them. This will be the final answer.


        https://www.youtube.com/watch?v=DkOaYAfolnQ&t=144s
        https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
 * 
 */

package Arrays;

public class MinSwapsToBringAllEleLessThanKTogether {

    static int minSwap(int arr[], int n, int k) 
    {
  
        // Find count of elements which are
        // less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
        if (arr[i] <= k)
            ++count;
      
        // Find unwanted elements in current
        // window of size = 'count'
        int bad = 0;    // keeps track of all elements which are greater than 'k' in current window.
        for (int i = 0; i < count; ++i)
        if (arr[i] > k)
            ++bad;
      
        // Initialize answer with 'bad' value of
        // current window
        int ans = bad;
        // i points to start of window and j points to end of windo.
        for (int i = 0, j = count; j < n; ++i, ++j) {
      
        // Decrement count of previous window. As current window is completed, so we move the window by '1' so we remove the prev ele, and check if the removed ele is >k then we decrease bad
        if (arr[i] > k)
            --bad;
      
        // Increment count of current window, if the newly added ele to window is >k then bad is increased.
        if (arr[j] > k)
            ++bad;
      
        // Update ans if count of 'bad'
        // is less in current window
        ans = Math.min(ans, bad);
        }
        return ans;
    }
    
}
