/**
 * 
 * https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 * 
 * count characters in two strings and check if count is same/zero (if we decrement)
 * 
 */

package Strings;

import java.util.HashMap;
import java.util.Map;

public class CheckIfGivenStringsAreAnagrams {

    public static boolean isAnagram(String a,String b)
    {
      HashMap<Character,Integer> hm = new HashMap<>();
      
      int n = a.length();
      int m = b.length();
      
      int i=0,j=0;
      
      while(i<n)
      {
          if(!hm.containsKey(a.charAt(i)))
            hm.put(a.charAt(i),0);
        
        hm.put(a.charAt(i), hm.get(a.charAt(i))+1);
        i++;
          
      }
      
      for( i=0;i<m;i++)
      {
          if(hm.containsKey(b.charAt(i)))
            {
                hm.put(b.charAt(i), hm.get(b.charAt(i))-1);
            }
            else
                return false;
      }
      
      for (Map.Entry<Character,Integer> entry : hm.entrySet())
      {
       //   Character k = entry.getKey();
          int val = hm.get(entry.getKey());
          if(val!=0)
            return false;
      }
      return true;
        
    }
    
}
