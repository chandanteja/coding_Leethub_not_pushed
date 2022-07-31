package Heaps;

/**
 * Approach: We PRE-CALCULATE  the prefix sums and the sum of contiguous sub array can be found as sum[i:j] = sum[j]-sum[i-1]
 * Now wq will push only first k-elements of sum[] array to min-heap. 
 * After pushing k-elements, we check from (k+1)th element onwards, if (k+1)the ele is greater than root of heap then pop the root and push the (k+1)th ele.
 * Continue this process till the end of sum[] array i.e (k+2), (k+3)...ele/
 */

 // V.V.V.V.V.IMP 

import java.util.PriorityQueue;

public class KthLargestSumContiguousSubarray {

    public static int kthLargestSumContiguousSubarray(int arr[],int n,int k)
    {
            // pre calculate sub array sums and store in separate array
            int sums[] = new int[n+1];
            sums[0] = 0;
            sums[1] = arr[0];
            for(int i=2; i<=n;i++)
            {
                sums[i] = sums[i-1]+arr[i-1];
            
            }

            // Now we have pre-calculated sum array.
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();     // by default java gives min-heap

            // now iterate over all sums and push first k sums into heap. Calculate contiguous sums.
            // i  j
            // 10 20 0 30 40
            //  i    j
            // 10 20 0 30 40  ---> to calculate contiguous sub array sum[i:j] = sum[j] - sum[i-1]

            for(int i=1; i<=n;i++)
            {
                // j-loop shuld run from i to n bcz to calculate sum[j] - sum[i-1] we dont need values before i.
                for(int j=i; j<=n;j++)  // --> j will move forward and 'i' will be behind 'j' as we need to calculate sum[j] - sum[i-1]
                {
                    int sum = sums[j] - sums[i-1];      // calculating contiguous sub array sum sum[i:j] = sum[j] - sum[i-1]

                    // if queue has less then k elements,
                     // then simply push it
                    if(minHeap.size()<k)        // we only want to have k-ele in heap
                    {
                        minHeap.add(sum);
                    }
                    else{
                        // if heap is full, then check if current sum we have is greater than the sum at root ele, if so the pop the root and insert new sum.
                        if(sum > minHeap.peek())
                        {
                            minHeap.poll();
                            minHeap.add(sum);
                        }
                    }
                }
            }
            return minHeap.peek();
            
    }

    public static void main(String args[])
    {
        int arr[] = { 10, -10, 20, -40 };
        int k=6;
        System.out.println("kth largest sum is: "+ kthLargestSumContiguousSubarray(arr, arr.length, k));
    }
    
}
