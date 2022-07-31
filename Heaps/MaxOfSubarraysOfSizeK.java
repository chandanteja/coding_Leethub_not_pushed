package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * We need to calculate max element in all subarrays of size-k.
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * Approach: First push the k-element i.e push first window max-heap.
 * Now after first window onwards, pop/remove the first element which will leave the window. Tracked this using "last" in variable in code. This keeps track of the 1st ele which will leave window.
 * Before poping/removing the 1st ele which will leave window, take the top/root ele and store in temp var.
 * Now pop the first element of window and push the next element which came into window after sliding window.
 * The popped element is added to array.
 *  T.C = O((n-k)n + (n-k)logn) = O(n^2) bcz the remove() method takes O(n) as to remove given ele, it needs to traverse all the ele in heap. logn is for heapify.
 * This is inefficient method. Efficient method uses Deque.
 */

public class MaxOfSubarraysOfSizeK {
    
public static ArrayList<Integer>  maxOfSubarraysofSizek(int arr[],int n, int k)
{
   ArrayList<Integer> result = new ArrayList<>();
   PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());     // MAX-HEAP

     // push first k-elements to heap.
    for(int i=0;i<k;i++)
    {
        pq.add(arr[i]);
    }

    int temp;
    int last = arr[0];
    for(int i=k,j=1;i<n & j<n;i++,j++)
    {
        temp = pq.peek();
        result.add(temp);
        pq.remove(last); // O(n)
        pq.add(arr[i]);
        last = arr[j];

    }
    result.add(pq.peek());
    return result;
}

public static void main(String args[])
{
   // int arr[] = { 12, 1, 78, 90, 57, 89, 56 }; 
   int arr[] = {1,2,3,4,5,6,7,8,9,10};
    int k=3;
    ArrayList<Integer> result = maxOfSubarraysofSizek(arr, arr.length, k);
    
    Iterator<Integer> itr = result.iterator();
    while(itr.hasNext())
    {
        System.out.print(itr.next()+" ");
    }

}

}
