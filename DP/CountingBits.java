/**
 * 338. Counting Bits (https://leetcode.com/problems/counting-bits/description/)
 * 
 * Solution:  https://leetcode.com/problems/counting-bits/solutions/127448/counting-bits/
 * 
 */
public class CountingBits {
    /**
     * Optimal Solution --> O(n)
     * Logic is as below
     * Let look at the relation between xxx and x′=x/2

x = (1001011101)_2 = (605)_{10}
x' = (100101110)_2 = (302)_{10}
​We can see that x′ is differ than x by one bit, because x′ can be considered as the result of removing the least significant bit of x.
Thus, we have the following transition function of pop count P(x):
P(x) = P(x / 2) + (x \mod 2)
     * 
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        arr[0] = 0;
        for(int i=1;i<=n;i++)
            arr[i] = arr[i>>1] + (i&1);
        return arr;
    }
    
    /**
     * Bruteforce --> O(nlogn)
     * T.C: will be O(nlogn) bcz we loop for n-times and each 'n' can be represented with O(logn) bits.
     * 
     * Logic is for every number we check if the last digit is 0 or 1 and add the count accordingly and right shift the number once (i.e divide by 2)
     * 
     * @param n
     * @return int arr
     */
    public int[] countBitsBruteforce(int n) {
        int arr[] = new int[n+1];
        arr[0] = 0;
       
        for(int i=1;i<=n;i++) {
            arr[i] = countOnes(i);
        }
        return arr;
    }

    int countOnes(int n) {
       
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if((n&1) == 1) // means last digit is 1
            return 1+countOnes(n>>1);
        else    // means (n&1) ==0 --> means last digit is 0
            return countOnes(n>>1); 
    }
}
