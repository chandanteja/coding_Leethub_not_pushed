/**
 * https://leetcode.com/problems/ugly-number-ii/discuss/1128947/Simple-Java-using-Priority-Queue-with-explanation-O(nlogn)
 * 
 *  https://www.geeksforgeeks.org/ugly-numbers/
 * 
 * we need to find the nth ugly number.
 * Ugly number is the number having factors as only 2,3 or 5.
 *  '1' is considered as ugly number.
 * Logic is we generate ugly numbers and store in min-heap.
 * We pop the top element and multiply by 2,3 and 5 and push all to heap. We do this n times and top element after nth time will be ugly number,
 */
package Heaps;

import java.util.*;

public class UglyNumbersUsingHeap {
    
    public static long nthUglyNumber(int n)
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int factors[] = {2,3,5};
        Long result = 1L;
        pq.add(1L);
        for(int i=0;i<n;i++)
        {
             result = pq.poll();
             for(int factor:factors)
             {
                 if(!pq.contains(result*factor))
                        pq.add(result*factor);
             }
        }
        return result; 
    }

    public static void main(String[] args)
    {
        int n = 150;
        System.out.println("nth ugly num: "+nthUglyNumber(n));
    }

}
