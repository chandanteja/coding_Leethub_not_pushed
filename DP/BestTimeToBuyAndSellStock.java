/**
 * 
 * Qns: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * Here we can buy and sell stock only once.
 * 
 */

public class BestTimeToBuyAndSellStock {
    /**
     * 
     * Approach-1:
     * ============
     * In this approach, we traverse the array from the end, and take the last element as current largest value seen till now.
     * Logic is while we traverse the array from the end, we subtract the numbers like  arr[n] - arr[n-1] and arr[n-1] and arr[n-2] so on, so if at any point the 
     * difference goes negative say arr[n-2] - arr[n-3] is negative it means arr[n-3] is bigger than arr[n-2] and there is one bigger number before current ele.
     * So we update "currLarge" with that value and continue the search.
     * In this approach we record the largest ele seen till that point of time.
     * At every step we record maxProfit till that step in a separate variable.
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int currLarge = prices[prices.length-1];
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length-1;
        int temp=0;
        for(int i=n-1;i>=0;i--)
        {
            temp=currLarge-prices[i];
            if(temp<0)
                currLarge = prices[i];
            maxProfit = Math.max(maxProfit,temp);
        }
        return maxProfit<0 ? 0 : maxProfit;
    }

    /**
     * 
     * Approach-2:
     * ============
     * Here we traverse the array from start and here instead of subtracting we check if ith element of the array is smaller than current smallest then we update the currsmall with ith ele.
     * In this approach we record the smallest ele seen till that point of time.
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        
        int currSmall = prices[0];
        int profit = 0, maxprofit=0;
        
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<currSmall)
                currSmall = prices[i];
            else
            {
                profit = prices[i] - currSmall;
                maxprofit = Math.max(profit,maxprofit);
            }
        }
        
        return maxprofit;
    }
}
