/**
 * 
 * *https://leetcode.com/problems/complement-of-base-10-integer/
 * 
 * T.C : O(1) and S.C: O(1)
 */

public class ComplementOfBase10Integer {

    public int bitwiseComplement(int n) {
        
        if(n==0)
            return 1;
        
        
        int bits = (int)(Math.log(n)/Math.log(2))+1;   // as we dont have log2() directly in Java and we can get it by log(n)/log(2).
        
        int pow = (1<<bits)-1;
        
        return pow^n;
        
        
        
    }
    
}

/*

Refer solutions of this question in leetcode for below two methods


Approach-1
==============
class Solution {
  public int bitwiseComplement(int N) {
    if (N == 0) return 1;
    int todo = N, bit = 1;
    while (todo != 0) {
      // flip current bit
      N = N ^ bit;
      // prepare for the next run
      bit = bit << 1;
      todo = todo >> 1;
    }
    return N;
  }
}


Approach-2
============

Instead of flipping bits one by one, let's construct 1-bits bitmask and flip all the bits at once.

There are many ways to do it, let's start from the simplest one:

Compute bit length of the input number l = [log2(num)]+1.

Compute 1-bits bitmask of length l: = (1 << l) - 1

Return num ^ bitmask.

class Solution {
  public int bitwiseComplement(int N) {
    // l is a length of N in binary representation
    int l = (int)( Math.log(N) / Math.log(2) ) + 1;
    // bitmask has the same length as num and contains only ones 1...1
    int bitmask = (1 << l) - 1;
    // flip all bits
    return bitmask ^ N;
  }
}

*/
