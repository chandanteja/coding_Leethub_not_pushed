import java.util.HashMap;

/**
 * 
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 * https://leetcode.com/problems/first-unique-character-in-a-string/solution/
 * 
 * The best possible solution here could be of a linear time because to ensure that the character is unique you have to check the whole string anyway.

    The idea is to go through the string and save in a hash map the number of times each character appears in the string. That would take \mathcal{O}(N)O(N) time, where N is a number of characters in the string.

    And then we go through the string the second time, this time we use the hash map as a reference to check if a character is unique or not
 * 
 */

public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        
        if(s.length() == 0)
                return -1;
        HashMap<Character,Integer> hm = new HashMap<>();        // store the characters count in this unordered_map. 
        
        for(int i=0;i<s.length();i++)
        {
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1  );
            else
                hm.put(s.charAt(i), 1);
            
        }

        // now once again iterate through the string, and  if some character appeared just once then return it's index.
        for(int i=0;i<s.length();i++)
        {
            int cnt = hm.get(s.charAt(i));
            if(cnt == 1)
                return i;
        }
        return -1;      // if no character appeared once then return -1.
    }
    
}
