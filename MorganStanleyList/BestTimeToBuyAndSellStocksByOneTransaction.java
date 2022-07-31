/**
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
 * 
 * Here we are allowed to buy and sell stocks only once.
 * 
 * We need to find the largest peak following the smallest valley. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
 * 
 * 
 * 
 * Logic is we need to find smallest ele and also find largest element on right side of the previously found smallest element.
 * 
 * {7,1,2,3,4,5,6}      --> smallest ele=1 and largest ele on right of smallest ele =6.
 * 
 */

package MorganStanleyList;

public class BestTimeToBuyAndSellStocksByOneTransaction {

    
    public int maxProfit(int[] prices) {

         // logic is we want to find smallest valley and largest peak after smallest valley. 
        // so we maintain 2-variables.
        // minPrice --> keeps track of smallest valley
        // maxProfit--> keeps track of max profit acheived till 'i'.
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit=0;
        
        for(int i=0;i<prices.length;i++)
        {
            // if prices[i] < min --> means we found new lowest valley.
            // if the if() is satisfied then we wont go for else part as we found new smallest ele hence we need to find largest ele after this new found smallest ele.
            if(prices[i]<minPrice)
                minPrice = prices[i];
            else if(prices[i]-minPrice > maxProfit)     // it means above condition failed. So, we will check for max profit i.e if prices[i] > minPrice it means there could be possibility of prices[i]-minprice can eb larger than maxprofit seen till now
                maxProfit = prices[i]-minPrice;     
        }
     
        return maxProfit;
    }
    
}
