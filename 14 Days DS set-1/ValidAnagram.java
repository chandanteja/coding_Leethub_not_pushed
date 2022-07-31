import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/valid-anagram/
 * 
 */

        // anagram means these 2 strings must be made up of same characters. if u rearrange one string you should get another string.
        // if thats the case, then return true, else return false.

        // so while traversing 1 string, increment the counts.
        // while traversing another string, decrement the counts.
        // now traverse the map. if the count of all characters is 0 then they are anagrams(they both contain
        // same characters with same counts for each character), else they are not.
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        
        int freq[] = new int[26];
        Arrays.fill(freq,0);
        
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<t.length();i++)
        {
            freq[t.charAt(i)-'a']--;
        }
        
        for(int i=0;i<26;i++)
        {
            if(freq[i]!=0)
                return false;
        }
        return true;
        
    }
    
}
