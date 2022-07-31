/**
 * 
 * https://practice.geeksforgeeks.org/problems/smallest-number5829/1#   --> qns
 * 
 * 
 */

package Greedy;

import java.util.Arrays;

public class SmallestNumberWithGivenDigits {

    static String smallestNumber(int sum, int d){
        if(sum > 9*d)
             {
                 return "-1";
             }
             
             sum = sum-1;
             int arr[] = new int[d];
             
             Arrays.fill(arr, 0);
             for(int i = d-1; i > 0; i--)
             {
                 if(sum > 9)
                 {
                     arr[i] = 9;
                     sum = sum-9;
                 }
                 else
                 {
                     arr[i] = sum;
                     sum = 0;
                 }
             }
             arr[0] = 1 + sum;
           String str = "";
           for(int i=0;i<arr.length;i++)
           str = str +(char) (arr[i]+'0');
           return str;
     }
    
}
