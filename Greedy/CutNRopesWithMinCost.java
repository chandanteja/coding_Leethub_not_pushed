
/**
 * https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 * Logic is first we insert all rope costs given into min heap.
 * Now we pop the top 2-elements (if 2-elements exist), add to our min cost and push back the heap the added cost.
 * 
 * 
 */
package Greedy;

import java.util.PriorityQueue;

public class CutNRopesWithMinCost {
    
    static long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++)
            pq.add(arr[i]); // adding all rope costs to heap.
            
        long mincost=0;
        while(!pq.isEmpty())
        {   //we pop top 2-elements if they exist, and add the cost of those 2 elements and push back to heap.
            long temp;
            long temp1 = pq.poll();
            
            if(!pq.isEmpty())   // we pop only if there are two elements in heap. If there is only one element it means, it was already added to min cost.
            {
                 long temp2 = pq.poll();
                  temp=temp1+temp2;
                  mincost=mincost+temp;
                  pq.add(temp);
            }
            
        }
        return mincost;
    }
    public static void main(String args[])
    {
        long len[] = { 4, 3, 2, 6 };
        int size = len.length;
 
        System.out.println("Total cost for connecting ropes is " + minCost(len, size));
    }

}
