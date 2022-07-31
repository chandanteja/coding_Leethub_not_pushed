/**
 * 
 * No reference is used.
 * 
 */

package Strings;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedStringInSequence {

    String secFrequent(String arr[], int N)
    {
        HashMap<String,Integer> hm = new HashMap<>();   // to store frequence of each string.
        
        for(int i=0;i<N;i++)
        {
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],0);
            hm.put(arr[i],hm.get(arr[i])+1);
            
        }
        
        String res="", prevres="";  // prevresult stores first max string,, result stores 2nd max string.
        int max=Integer.MIN_VALUE,secmax=Integer.MIN_VALUE; // max and secondMax integers are for storing first max frequency and 2nd max frequency.
        
        for(Map.Entry<String,Integer> entry : hm.entrySet())
        {
            int ele = entry.getValue();
            
            
            if(ele>max)
            {
                 // assign previous max to second max.
                // assign previous string to result string
                 // string of current max value.
// current max value.
               res=prevres;
               prevres=entry.getKey();
                
                secmax=max;
                max=ele;
               
            }
            else    // update 2nd-max.
            {
                if(ele>secmax && ele<max)
                {
                    secmax=ele;
                    res=entry.getKey();
                }
            }
            
        }
        return res;
    }
    
}
