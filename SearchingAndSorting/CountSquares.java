/**
 * 
 * https://practice.geeksforgeeks.org/problems/count-squares3649/1
 * 
 *      for any N value, if sqrt of N is x
            then any value above x will have its square greater than N.

            N=9
            x=3

            N=16,25,36....
            x=4,5,6,....

            so iterate till floor(sqrt(N)) then if (i*i)<N then cnt++;
 * 
 */

package SearchingAndSorting;

public class CountSquares {

    static int countSquares(int N) {
        
        int cnt=0;
        for(int i=1;i<=Math.sqrt(N);i++)
        {
            if(i*i < N)
                cnt++;
        }
        return cnt;
    }
    
}
