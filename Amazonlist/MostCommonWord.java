/**
 * 
 * https://leetcode.com/problems/most-common-word/
 * 
 * Input: 
		paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
		banned = ["hit"]

		-> "Bob hit a ball the hit BALL flew far after it was hit"
		-> "bob hit a ball the hit ball flew far after it was hit"
		-> ["bob", "hit", "a", "ball", "the", "ball", "flew", "far", "after", "it", "was", "hit"]

		-> {"hit"}

		-> {
				ball:   2
				bob:    1
				a:      1
				the:    1
				flew:   1
				far:    1
				after:  1
				it:     1
				was:    1
                hit:   -1
			}

		Result: "ball"


        ALGORITHM
			STEP 1: ensure the passed string is not null or blank
			STEP 2: Put banned words in map with freq=-1 so that they need not be used.
			STEP 3: create a map to store word and count
			STEP 4: remove all other characters from the paragraph except A-Z or a-z
			STEP 5: tranform paragraph to have all lowercase letters
			STEP 6: create a string array containing the words of pargraph spilt by space
			STEP 7: populate the set with the banned words
			STEP 8: loop through all the words
				STEP 9: if the word is not in the banned list
						-> add the word to the map with an updated count
			STEP 810: return the most common word from map 
 * 
 */

package Amazonlist;

import java.util.HashMap;
import java.util.Map;



public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i=0;i<banned.length;i++)
        {
            hm.put(banned[i],-1);
        }
        
        String words[] = paragraph.replaceAll("[^A-Za-z]"," ").toLowerCase().split(" ");
        
        for(int i=0;i<words.length;i++)
        {
            String temp = words[i];
            
            if(temp.equals("") || temp.equals(" "))
                    continue;
           if(hm.containsKey(temp)==false)  
           {
               hm.put(temp,1);
               continue;
           }
            
                int val = hm.get(temp);
                if(val==-1)
                    continue;
                else
                    hm.put(temp,val+1);
            
            
        }
        
        int max_freq=Integer.MIN_VALUE;
        String res="";
        
        for(Map.Entry<String,Integer> entry: hm.entrySet())
        {
            String key = entry.getKey();
            int freq = entry.getValue();
            
            System.out.println("Key: "+key+"  freq: "+freq);
            
            if(freq>max_freq)
            {
                max_freq=freq;
                res=key;
            }
            
           
        }
        return res;
    }
    
}
