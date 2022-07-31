import java.util.HashMap;

/**
 * 
 * https://leetcode.com/problems/ransom-note/
 * 
 * 
 *      // asked if ransomNote can be made from magazine.
        // magazine might have extra characters but ransomNote can't have characters that are not there in magazine.
        // store all the characters of magazine and their count in a map.
        // now traverse the ransomNote, while traversing, decrement the count of each character.
        // now traverse the map again if any character's count is -ve itmeans this is present in ransomNote and not in magazine 
        // and thus ransomNote cant be formed from magazine. then return false. else return true.
 * 
 * 
 */

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        
        if(ransomNote.length() != 0 && magazine.length()==0)
                return false;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<magazine.length();i++)
        {
            if(hm.containsKey(magazine.charAt(i)))
                hm.put(magazine.charAt(i) , hm.get(magazine.charAt(i))+1);
            else
                hm.put(magazine.charAt(i) ,1);
        }
        for(int i=0;i<ransomNote.length();i++)
        {
            if(hm.containsKey(ransomNote.charAt(i)) && hm.get(ransomNote.charAt(i))>0)
                    hm.put(ransomNote.charAt(i) , hm.get(ransomNote.charAt(i))-1);
            else
                return false;
        }
        return true;
            
        
    }
    
}
