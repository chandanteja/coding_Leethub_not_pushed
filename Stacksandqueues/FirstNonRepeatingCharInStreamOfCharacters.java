/**
 * 
 * https://www.youtube.com/watch?v=gbASJJAvAGk
 * 
 * https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/       ---> refer this for clear idea.
 * 
 * https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/  --> another approach.   Using DLL.
 * 
 *  NOTE:   USE "StringBuffer", bcz if we use "String" as String is immutable in JAVA, it will give TLE.
 * 
 */

package Stacksandqueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharInStreamOfCharacters {

    public String FirstNonRepeating(String A)
    {
        // count array of size 26(assuming
        // only lower case characters are present)
        int freq[] = new int[26];
        Arrays.fill(freq,0);
        
        // Queue to store Characters of the string
        Queue<Character> q = new LinkedList<>();
        
        int n = A.length();
        StringBuffer res=new StringBuffer();
        
        for(int i=0;i<n;i++)
        {
            char ch = A.charAt(i);
 
            // push each character in queue
            q.add(ch);
            
            // increment the frequency count
            freq[ch-'a']++;
            
            // check for the non repeating character
            while(!q.isEmpty())
            {
                if(freq[q.peek()-'a'] > 1)
                    q.remove();
                else
                {
                    //res = res+q.peek();
                    res.append(q.peek());
                    
                    break;
                }                   
            }
            if(q.isEmpty())
                //res = res + "#";
                res.append('#');
            
        }
        return res.substring(0);
        
    }
    
}
