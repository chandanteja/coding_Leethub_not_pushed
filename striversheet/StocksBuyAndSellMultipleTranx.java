/**
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * Solution:
 * ==========
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 * 
 * https://www.youtube.com/watch?v=Q7v239y-Tik
 * 
 * Valley-Peak method as we can do multiple transactions.
 * 
 */

public class StocksBuyAndSellMultipleTranx {

    public int maxProfit(int[] prices) {
        
        if(prices.length == 1)
                return 0;
        
        int profit = 0;
        for(int i=1; i<prices.length;i++)
        {
            if(prices[i] > prices[i-1])
                profit += prices[i]-prices[i-1];
        }
        return profit;
        
    }
    
}
