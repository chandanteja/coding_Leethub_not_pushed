package Amazonlist;

/**
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * 
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Refer GFG video on this topic in Complete Interview preparation course track.
 * 
 * The first container (max-heap) will have smaller half of ele (of sorted arr) and 2nd container (min-heap) will have greater half of ele(of sorted arr).
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MedianInStreamOfInt {

    public static ArrayList<Integer> findMediansOfStream(int arr[])
    {
        ArrayList<Integer> medians = new ArrayList<>();
        // maintain 2-heaps. One as max-heap and other as min-heap. The sizes of min and max-heaps will be either SAME or max-heap will have 1 more element than min-heap at anytime
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // To avoid getting null pointer exceptions at times, initialize the 2 heaps with max and min values just after creation.
        maxHeap.add(Integer.MIN_VALUE);
        minHeap.add(Integer.MAX_VALUE);

        // first add an element to max-heap.
        maxHeap.add(arr[0]);
        medians.add(maxHeap.peek());

        // we always maintain that left half ele of sorted(smaller half) array will be in max-heap and right half ele of sorted array(greater half) will be in min-heap.

        for(int i=1;i<arr.length;i++)
        {
            int x= arr[i];

            if(maxHeap.size()>minHeap.size())       // now we need to add the new element to min heap as maxheap already has 1-ele more
            {
                // If size of max-heap > size of minheap then we always try to maintain largest ele in max-heap as lessthan or equal to smallest ele in min-heap.
                // while adding an element always, we make sure that largest ele in max-heap is lessthan the smallest ele in min-heap.
                if(maxHeap.peek()>x)
                {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(x);
                }
                else
                    minHeap.add(x);
            
                // As this will maintain that both max and min will have same size then it means even number of elements.
            medians.add( (maxHeap.peek()+minHeap.peek())/2 );
                
            }
            else    // Now as sizes of both are same, we need to add to max-heap
            {
                 // while adding an element always, we make sure that largest ele in max-heap is lessthan the smallest ele in min-heap.
                 if(x<=maxHeap.peek())  // as x is less than max element in max heap and also as we need to add to max-heap, we add this way.
                    maxHeap.add(x);
                else
                {
                    // here as 'x' > top ele of maxheap, we add ele to min-heap (as left container will have left half of sorted arr and right container will have right half of sorted arr)   
                    // after adding 'x' to min-heap the size of min-heap will be greater than size of max-heap, so we will remove one ele from min heap and add to max heap.
                    minHeap.add(x);
                    maxHeap.add(minHeap.poll());
                }
            
                medians.add(maxHeap.peek());
            }
        }
        return medians;
    }

    public static void main(String args[])
    {
        int arr[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        ArrayList<Integer> result = findMediansOfStream(arr);

        Iterator<Integer> itr = result.iterator();
        System.out.println("Medians are:  ");

        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }

    }
    
}
