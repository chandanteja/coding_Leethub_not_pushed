/**
 * 
 * https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1/?track=DSASP-Arrays&batchId=155  ---> qns
 * 
 * This approach follow valley-peak method.
 * As we can buy and sell any number of times, we can buy when its low and we can sell when price is > price at which we brought.
 * SO, we continue this way.
 * 
 * Watch GFG self paced DSA course video.
 * 
 * {100,180,260,310,40,535,695} 
 * 
 * Buy at 100 and sell at 180 --> profit = 80
 * Buy at 180 and sell at 260 --> prof = 80
 * buy at 260 and sell at 310, --> prof = 50
 *                                Profit till now = 210. We would get same when we buy at 100 and sell at 310. This is the logic we follow.
 * Continue as above.
 * 
 */

package Arrays;

import java.util.ArrayList;

public class StockBuyAndSell_2ndVariation {

    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        int profit = 0;
        
        for(int i=1;i<n;i++)
        {
            if(A[i]>A[i-1]) // if arr[i] > arr[i-1] then we will buy on (i-1)th day and sell on ith day.
            {
                profit = profit+A[i]-A[i-1];
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i-1);
                temp.add(i);
                res.add(temp);
            }
        }
        return res;
     }
    
}
