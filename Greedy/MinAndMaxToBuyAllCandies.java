/**
 * 
 * https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1#       --> qns
 * 
 * 
 */

package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MinAndMaxToBuyAllCandies {

    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        int min=0;
        int max=0;
        int i=0,j=N-1;
        
        Arrays.sort(candies);
        
        while(i<=j)
        {
            min=min+candies[i];
            i++;
            j=j-K;
        }
        
        i=0;
        j=N-1;
        
        while(i<=j)
        {
            max=max+candies[j];
            j--;
            i=i+K;
        }
        
        ArrayList<Integer> res=  new ArrayList<>();
        res.add(min);
        res.add(max);
        
        return res;
    }
    
}
