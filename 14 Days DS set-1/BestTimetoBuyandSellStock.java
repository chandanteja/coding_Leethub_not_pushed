
/**
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Logic is:
 * 
 * We need to find a smallest number and then find a largest number to the right side of smallest number.
 * 
 * For this we take 3 variables currentSmall, Profit and maxProfit.
 * maxProfit --> keeps track of maxprofit we got at any point of time.
 * profit --> keeps track of profit we got with current element of array and currentsmall ele.
 * currentSmall --> keeps track of current smallest element we saw.
 * 
 * Note : when currentSmall element is updated then profit wont get updated (i.e in same iteration both wont be updated, so we use if-else case below)
 * 
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        
        int currSmall = prices[0];  // keeps track of smallest ele
        int profit = 0, maxprofit=0;    // keeps track of current profit and maxprofit.
        
        for(int i=1;i<prices.length;i++)
        {
            // if smallest element is updated then in that iteration profit wont be updated.
            if(prices[i]<currSmall)     // if current ele is smaller than currentsmall ele.
                currSmall = prices[i];
            else    // else update profit and maxprofit.
            {
                profit = prices[i] - currSmall;
                maxprofit = Math.max(profit,maxprofit);
            }
        }
        
        return maxprofit;
    }
    
}
