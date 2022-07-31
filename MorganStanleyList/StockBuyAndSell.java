
/**
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/       --> for solutions of both brute force and optimized refer this
 * 
 * 
 * Here we are allowed to buy and sell stocks multiple times. We need to maximize profit.
 * 
 * Brute force approach is try all possible combinatione i.e buy and sell on alternative days and buy and sell on particular days etc check all combinations.
 *  T.C:  Exponential
 * 
 * Optimized:   Valley-peak method.
 * 
 * We simply check if current day price Minus prev day price is not negative i.e (>0) we add it to profit, hoping that we can make max profit.
 * 
 * This is greedy method i.e here we hope for every transaction which results in increment of current profit we perform that transaction 
 * 
 * i.e if price[i] - price[i-1] i.e current day price- previous day price is >0 we can do that transaction
 * 
 * 
 * 
 */
package MorganStanleyList;

public class StockBuyAndSell {

    public int maxProfit(int[] prices) {
        int profit = 0;
        
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]-prices[i-1]>0)
                    profit = profit+prices[i]-prices[i-1];
        }
        return profit;
    }
    
}
