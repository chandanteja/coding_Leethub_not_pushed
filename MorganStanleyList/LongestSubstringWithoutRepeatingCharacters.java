/**
 * 
 * https://www.youtube.com/watch?v=qtVh-XEpsJo      --> watch this.
 * 
 * Brute force takes O(n^3) bcz we need to generate all substrings and check which doesnt contain repeating characters and is longest.
 * There will be (n(n-1))/2 substrings.
 * 
 * Efficient:  O(n) both time and space.
 * 
 * Logic is we store the occurrence of every character with its index in map.
 * For repeated chars, we store the latest index of the repeated char.
 * 
 * 
 */

package MorganStanleyList;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        
        int left=0;     // keeps track of start of the current window. If in current window there is any repeated char, we will reset the left pointer.
        int len=0;      // keeps track of max length seen.
        
        Map<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++)   // 'i' keeps track of end of current window. Also this will be used to extend the window.
        {
            char c = s.charAt(i);
            // if the char is already in  map, then we take the last index where that character is occurred and move the left pointer after that last occurrence position of repeated char.
            // we check which is maximum either the last occurrence of repeated char+1 or left index itself.
            if(hm.containsKey(s.charAt(i)))
            {
                left = Math.max(hm.get(c)+1,left);
                
            }
            
            len = Math.max(len,i-left+1);   // (i-left+1) -->  length of current window. max of length of current window and previous len is taken
            hm.put(c,i);    // updating/adding the index of curr character. Updating happens when repeated char occurs.
            
        }
        
        return len;
    }
    
}
