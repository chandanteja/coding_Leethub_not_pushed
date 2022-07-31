package Heaps;

/**
 * Approach: Here we maintain a deque of indices. We maintain the indices of elements which are larger in current running window at the rear-end
 * The front end element will be the max element in the current window.
 * We will insert any index at the rear-end and while inserting we will check the element is greater than the already exesting element (we store only indices),
 *  then we will pop all the elements which are less than currently being inserted element.
 * 
 *  https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/  --> refer Method-3 which uses Deque.
*   T.C: O(n)
    Space: O(k).
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MaxOfSubarraysOfSizeKDeque {

    public static ArrayList<Integer> maxOfSubarraysOfSizeKUsingDeque(int arr[],int n,int k)
    {
        Deque<Integer> dq = new LinkedList<>();
       // int res[] = new int[n-k+1] ;    // (n-k+1) is the number of window slides possible in n-elements with k as the sliding value.

       ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<k;i++)
        {
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])       // we check if deque is not empty and if the currently inserting element is greater
            // than the exesting elements at rear-end we remove all such elements from the last.
                dq.removeLast();        
            dq.addLast(i);      // we insert index at rear end.
        }
       

        for(int i=k;i<n;i++)
        {
            res.add(arr[dq.peek()]);    // peek() returns element at front w/o removing it, it means the element at front will be the max, element
                // at the end of current window.

            while(!dq.isEmpty() && dq.peek()<=i-k)      // here we remove the elements which moved out of window, i.e (i-k) means from 'i' we move k-positions
                // backward so that we get the element which moved out of window currently and it will be removed from the frontend.For example, 
                // if i=4 means currently i is at 4 and if k=3 then current window elements would be 2,3,4 but we need to remove the index-1 which would be
                // present at font end. so we remove all such elements <=1.
                dq.removeFirst();

            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])      //  same as first for-loop
                dq.removeLast();
            dq.addLast(i);

            
        }
        res.add(arr[dq.peek()]);        // as the last window evaluation won't happen, we will add that element manually.
        return res;
    }

    public  static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        ArrayList<Integer> res = maxOfSubarraysOfSizeKUsingDeque(arr, arr.length, k);

        Iterator<Integer> itr = res.iterator();

        while(itr.hasNext())
        {
            System.out.print(itr.next()+ " ");
        }

    }
    
}
