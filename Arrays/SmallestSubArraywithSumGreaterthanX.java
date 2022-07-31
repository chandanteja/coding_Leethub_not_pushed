/**
 * 
 * Idea is to use a similar approach to a sliding window. Start with an empty subarray, add elements to the subarray until the sum is less than x. 
 * If the sum is greater than x, remove elements from the start of the current subarray.
 * 
 * https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 * 
 * https://www.youtube.com/watch?v=21tQXPbGg7k  --> watch this.
 * 
 * Logic is we take 2-pointers i,j. First using 'j' we travel till the end of array adding all ele till sum is <=x.
 * 
 * Once sum crosses x i.e sum > x then using 'i' we start removing elements from the start checking if removing any ele keeps sum as greater than x while decresing the subarray size.
 */

package Arrays;

public class SmallestSubArraywithSumGreaterthanX {

    public static int sb(int a[], int n, int x) {
        int i=0,j=0;
        int sum=0;
        int min = Integer.MAX_VALUE;
        
        while(i<=j && j<n)
        {
            while(sum<=x && j<n)
                sum = sum+a[j++];
            
            while(sum>x && i<j)
            {
                min = Math.min(min,j-i);
                sum =sum-a[i];
                i++;
            }
        }
        return min;
    }
    
}
