/**
 * 
 * https://www.geeksforgeeks.org/swap-all-occurrences-of-two-characters-to-get-lexicographically-smallest-string/
 * 
 * 
 * 
 *  First we store the first appearance of every character in a string in a hash array track[].
    The in order to find the lexicographically smaller string, the leftmost character must be replaced with some character which is smaller than it. 
    This will only happen if the smaller character appears after it in the array.
    So, starting traversing the string from the left and for every character, find the smallest character (even smaller than the current character) that appears after swap all of their occurrences to get the required string.
    If no such character pair is found in the previous string then print the given string as it is the smallest string possible.
 * 
 */

package Greedy;

import java.util.Arrays;

public class ChooseAndSwap {

    String chooseandswap(String s){

        // To store the first index of
        // every character of str
        int track[] = new int[26];
        
        int i=0,j=0;
        
        Arrays.fill(track,-1);
        
        // Store the first occurring
        // index every character
        for( i=0;i<s.length();i++)
        {
            // If current character is appearing
            // for the first time in str
            if(track[s.charAt(i)-'a']==-1)
                track[s.charAt(i)-'a']=i;
        }
        
        // Starting from the leftmost character
        for(i=0;i<s.length();i++)
        {
            boolean flag = false;
            
            // For every character smaller than s.charAt(i)
            for(j=0;j<s.charAt(i)-'a';j++)
            {
                // If there is a character in str which is
                // smaller than s.charAt(i) and appears after it
                if(track[j]>track[s.charAt(i)-'a'])
                {
                    flag=true;
                    break;
                }
                
            }
            // If the required character pair is found
            if(flag)
                break;
        }
        
        String res = "";

        // If swapping is possible  
        if(i<s.length())
        {
            // Characters to be swapped
            char c1 = s.charAt(i);
            char c2 = (char)('a'+j);
            
            for(int k=0;k<s.length();k++)
            {
                // Replace every c1 with c2
                // and every c2 with c1
                if(s.charAt(k)!=c1 && s.charAt(k)!=c2)  // if other than c1 and c2 then add it directly to result string
                    res = res+String.valueOf(s.charAt(k));
                else if(s.charAt(k)==c1)
                    res = res+String.valueOf(c2);
                else
                     res = res+String.valueOf(c1);
            }
            
            
        }
        
            // If swapping is not possible then it means given string itself is smallest string
            if(res.length()==0)
                return s;
        
        return res;
        
    }
    
}
