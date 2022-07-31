/**
 * 
 * https://leetcode.com/problems/gray-code/solution/        ==> approach 5.
 * https://www.geeksforgeeks.org/generate-n-bit-gray-codes-set-2/
 * 
 * T.C : O(2^n).
 * 
 */

package AugChallenge;

import java.util.ArrayList;
import java.util.List;


/*

i       0   1   2   3   4   5   6
G(i)    0   1   3   2   6   7   5

i^G(i)  0   0   1   1   2   2   3 ==> pattern.

we have to derive this pattern

i^G(i) = Y
i^Y = G(i)

when 
i   Y   G(i)
0   0   0
1   0   1
2   1   3
3   1   2
4   2   6
5   2   7
6   3   5

so if we observe Y=floor(i/2)

so thats why we do do xor of i and i/2 to get Gray code.

*/


public class GrayCode {

    public List<Integer> grayCode(int n) {
        int N = 1<<n;
        
        ArrayList<Integer> ar = new ArrayList<>();
        
        for(int i=0;i<N;i++)    // iterate through each number in 0 to 2^n-1
        {
            int temp = i ^ (i>>1);  
            ar.add(temp);    // push back i^(i/2) ==> this is the graycode.
        }
        return ar;
    
        
    }
    
}
