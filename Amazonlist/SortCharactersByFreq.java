/**
 * https://leetcode.com/problems/sort-characters-by-frequency/      --> qns
 * 
 * 
 * use a HashMap to count how many times each character occurs in the String; the keys are characters and the values are frequencies.
 * Next, extract a copy of the keys from the HashMap and sort them by frequency using a Comparator that looks at the HashMap values to make its decisions.
 * Finally, initialise a new StringBuilder and then iterate over the list of sorted characters (sorted by frequency). Look up the values in the HashMap to know how many of each character to append to the StringBuilder.
 * 
 * Time and Space complexities:
 * =============================
 * 
 * There are two ways of approaching the complexity analysis for this question.

We can disregard k, and consider that in the worst case, k = n.
We can consider k, recognising that the number of unique characters is not infinite. This is more accurate for real world purposes.
I've provided analysis for both ways of approaching it. I choose not to bring it up for the previous approach, because it made no difference there.

Time Complexity : O(nlogn) OR O(n+klogk).

Putting the characters of s into the HashMap has a cost of O(n), because each of the n characters s must be put in, and putting each in is an O(1) operation.

Sorting the HashMap keys has a cost of O(klogk), because there are k keys, and this is the standard cost for sorting. If only using n, then it's O(nlogn). For the previous question, the sort was carried out on n items, not k, so was possibly a lot worse.

Traversing over the sorted keys and building the String has a cost of O(n), as n characters must be inserted.

Therefore, if we're only considering nn, then the final cost is O(nlogn).

Considering k as well gives us O(n+klogk), because we don't know which is largest out of n and klogk. We do, however, know that in total this is less than or equal to O(nlogn).

Space Complexity : O(n).

The HashMap uses O(k) space.

However, the StringBuilder at the end dominates the space complexity, pushing it up to O(n), as every character from the input String must go into it. Like was said above, it's impossible to do better with the space complexity here.
 * 
 */

package Amazonlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortCharactersByFreq {

    public String frequencySort(String s) {
        
        if(s==null||s.length()==0)
                return "";
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        // convert the string to char[]
        char arr[] = s.toCharArray();
        
        // put in may every char and its freq.
        for(char c : arr)
        {
            if(!hm.containsKey(c))
                hm.put(c,0);
            int cnt = hm.get(c);
            hm.put(c,++cnt);
        }
        
        // convert the keyset() of map i.e all keys of map to arraylist
        // contains only keys of map (no duplicates as elements are keys of map)
        ArrayList<Character> temp = new ArrayList<>(hm.keySet());
        
        // sort the key in arraylist using the freq of respective keys of map..
        Collections.sort(temp, (a,b) -> hm.get(b) - hm.get(a) ) ;  // giving preference to 2nd char i.e 'b'. This sorts the chars in array in descending order of count of occurrences in map.
        
       
        StringBuilder sb = new StringBuilder();                         
       // now append the chars to string frequency wise.                  
         for(char ch: temp)
         {
             int count = hm.get(ch);
           
            for(int i=0;i<count;i++)
                sb.append(ch);
         }                         
        
        return sb.toString();
    }
    
}
