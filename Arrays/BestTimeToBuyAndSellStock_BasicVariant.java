/**
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1286991/Java-Solution-or-Multiple-Approach
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/       ---> qns
 * 
 * 
 * Logic is we need to find smallest ele and also find largest element on right side of the previously found smallest element.
 * 
 * {7,1,2,3,4,5,6}      --> smallest ele=1 and largest ele on right of smallest ele =6.
 * 
 * 
 * This is basic variation of stock buy and sell problem.
 * 
 * We need to find the largest peak following the smallest valley. 
 * We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
 * 
 */

package Arrays;

public class BestTimeToBuyAndSellStock_BasicVariant {

    // logic  is  we take min and max, initialize min and max accordingly.
    // if arr[i] < min then we update min only and continue.
    // if arr[i] > min it means this can contribute to max profit. So we will check (arr[i]-min,max) which is large among them we take that.

    public int maxProfit(int[] prices) {
        
        // logic is we want to find smallest valley and largest peak after smallest valley. 
        // so we maintain 2-variables.
        // min --> keeps track of smallest valley
        // max--> keeps track of max profit acheived tii 'i'.
        int maxProfit=0,minPrice=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++)
        {
            // if prices[i] < min --> means we found new lowest valley.
            if(prices[i]<minPrice)
                minPrice = prices[i];
            else if(prices[i]-minPrice > maxProfit)     // it means above condition failed. So, we will check for max profit i.e if prices[i] > minPrice it means there could be possibility of prices[i]-minprice can eb larger than maxprofit seen till now
                maxProfit = prices[i]-minPrice;
        }
        return maxProfit;
        
    }
    
}
