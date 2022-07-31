
/**
 * Logic is same as Top K Frequent Elements In Array.
 * Here we maintain a HashMap of characters of string and frequency of each in string.
 * We push the elements to max-heap based on frequency. If frequency of 2-characters is same then they are sorted in lexicographic order.
 * So to maintain lexicographic order, we put smallest element first.
 * 
 * https://www.geeksforgeeks.org/sort-a-string-according-to-the-frequency-of-characters/ --> refer this only for understanding qns. Logic dont see here.
 * Logic is same as top k freq ele in array.
 */
package Heaps;

import java.util.*;

class Pair
{
    int freq;
    char ele;
    Pair(char ele,int freq)
    {
        this.ele=ele;
        this.freq=freq;
    }
}

class PairComparator implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        // bcz max-heap.
        if(p1.freq<p2.freq)
            return 1;
        if(p1.freq==p2.freq)    // if freq of 2-chars is same then smallest char is stored first then bigger char.
        {
            if(p1.ele<p2.ele)   // smaller char is returned.
                return -1;
            else if(p1.ele>p2.ele)
                return 1;
            else 
                return 0;
        }
        return -1;
    }
}


public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        String res="";
        Map<Character,Integer> map = new HashMap<>();
   
       for(int i=0;i<s.length();i++)
       {
           if(!map.containsKey(s.charAt(i)))
           {
               map.put(s.charAt(i),1);
           }
           else
           {
               int freq= map.get(s.charAt(i));
               map.replace(s.charAt(i),++freq);
               
           }
       }
       PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
       for(Map.Entry<Character,Integer> entry: map.entrySet())
       {
           pq.add(new Pair(entry.getKey(),entry.getValue()));
       }  
  
       
      while(!pq.isEmpty())
      {
          Pair p1 = pq.poll();
    
            int val = p1.freq;
            while(val!=0)   // we get freq of element and we loop for those many  times appending the char.
            {
                res= res+p1.ele;
                val--;
            }
                   
      }
       
       return res;
        
    }
    
}
