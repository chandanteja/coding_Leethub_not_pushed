/**
 * 
 * https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 * 
 * Logic is we create a Hashmap and push all elements in array and increment their frequencies.
 * Now we create a max-heap of 'Pair' based on frequency of elements in hashmap i.e we create a pair with highest freq being on top of heap.
 * We create comparator in such a way that if two elements have same frequency, then the elements in heap will be inserted based on which is larger element.
 */

package Heaps;

import java.util.*;

// this class 'pair' keeps track of element and its frequency. Used to insert elements into max-heap based on freq value. Elements are taken from hash map.
class Pair
{
    int ele,freq;
    Pair(int ele,int freq)
    {
        this.ele=ele;
        this.freq=freq;
    }
}
class PairComparator implements Comparator<Pair>
{
    // We are creating a max-heap based on freq of elements.
    public int compare(Pair p1,Pair p2)
    {
        // bcz max-heap.
        if(p1.freq<p2.freq)     // for max-heap if p1.freq<p2.freq return 1; for min-heap if p1.freq<p2.freq return -1;
            return 1;
        if(p1.freq==p2.freq)    // if the frequency  of 2 elements are same then we need to insert into priority queue based on element which is larger.
        {
            if(p1.ele<p2.ele)   // as freq of 2 ele are same, we need to put largest element first. For max heap if p1.ele<p2.ele return 1 and for min-heap p1.ele < p2.ele return -1;
                return 1;
            else if(p1.ele>p2.ele)
                return -1;
            else 
                return 0;
        }
        return -1;  // ths is when above two 'freq' comditions are not satisfied.
    }
}   

public class TopKFreqEleInArray {


    public static int[] topK(int[] nums, int k) {
        
        int res[] =  new int[k];
        Map<Integer,Integer> map = new HashMap<>();
   
       for(int i=0;i<nums.length;i++)   // creating a hashmap of (ele,freq).
       {
           if(!map.containsKey(nums[i]))    // if key is not there, we insert. The freq will be '1' bcz we saw one occurrence of this ele.
           {
               map.put(nums[i],1);
           }
           else
           {        // if key is already there, then we increment the freq value.
               int freq= map.get(nums[i]);
               map.replace(nums[i],++freq);
               
           }
       }
       PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
       for(Map.Entry<Integer,Integer> entry: map.entrySet())
       {
           pq.add(new Pair(entry.getKey(),entry.getValue()));   // adding elements to priority queue.
       }  
  
       
      for(int i=0;i<k;i++)  // pop -k elements from priority queue and add to result.
      {
        Pair p1 = pq.poll();
        res[i]= p1.ele;
                   
      }
       
       return res;
    }
    
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1,2 };
        //int n = arr.length;
        int k = 2;
        // Function call
        int res[] = topK(arr, k);
        for(int i:res)
        {
            System.out.print(" "+ i);
        }
    }
}
