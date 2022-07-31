/**
 * 
 * ALgorithm:
 * 
 *  1. Maintain an array (visited) of maximum possible characters (256 characters) and as soon as we find any in the string, mark that index in the array (this is to count all distinct characters in the string).
    2. Take two pointers start and end which will mark the start and end of window.
    3. Take a counter=0 which will be used to count distinct characters in the window.
    4.Now start reading the characters of the given string and if we come across a character which has not been visited yet increment the counter by 1.
    5.If the counter is equal to total number of distinct characters, Try to shrink the window.
    6.For shrinking the window -: 
        If the frequency of character at start pointer is greater than 1 increment the pointer as it is redundant.
        Now compare the length of present window with the minimum window length.


        https://www.geeksforgeeks.org/smallest-window-contains-characters-string/       --> refer this article
 * 
 */

package Strings;

import java.util.HashSet;

public class SmallestWindowContainingAllCharactersOfString {

    public String findSubString( String str) {
        int n = str.length();
        
        if(n<=1)
            return str;
            
        HashSet<Character> hs = new HashSet<>();
        
        for(int i=0;i<n;i++)        // put all the chars into set and take size of set.
            hs.add(str.charAt(i));
        
        int distinct_count = hs.size();         // Count all distinct characters.
        
        // min_len: length of window.
        // start: starting position of the current window
        // start_index: startng position of min length window
        // count: #unique characters in the current window.

        int startIndx=-1,start=0;
        int curr_count=0,min_len = Integer.MAX_VALUE;
        int char_freq[] = new int[256]; // unique characters in the current window. ie curr window count
        
        //We basically maintain a window of
        // characters that contains all characters of given
        // string.
        for(int end=0;end<n;end++)
        {
            char_freq[str.charAt(end)]++;       // Count occurrence of characters of string
            
            // If any distinct character matched,
            // then increment count
            if(char_freq[str.charAt(end)]==1)
                curr_count++;
            
                // if all the characters are matched
            if(curr_count==distinct_count)  // if count is distinct_count then 
            {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of
                // times than its occurrence in pattern, if
                // yes then remove it from starting and also
                // remove the useless characters.
                while(char_freq[str.charAt(start)]>1)       // if the current window has some chars which are repeated (more than once)
                {
                    if(char_freq[str.charAt(start)]>1)
                        char_freq[str.charAt(start)]--;
                    start++;        // move the window. so start will also change.
                }
                
                // Update window size
                if(min_len>end-start+1)
                {
                    min_len = end-start+1;
                    startIndx=start;
                }
            }

        }
        return str.substring(startIndx,startIndx+min_len);
        
    }
    
}
