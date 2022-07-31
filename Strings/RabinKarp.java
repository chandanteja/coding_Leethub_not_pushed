/**
 * 
 * https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/        --> refer this article
 * 
 * https://www.youtube.com/watch?v=8j9wOsI4cx8&t=1243s      --> Watch this video and refer murali sir slides.
 * 
 * 
 * 
 */

package Strings;

import java.util.ArrayList;

public class RabinKarp {

    final int d = 256;
    ArrayList<Integer> res = new ArrayList<>();
    
    
    ArrayList<Integer> search(String pat, String S)
    {   
      int prime = 257;  // prime number to avoid gng beyond int range
      rabinKarp(pat,S,prime);
      
      if(res.size()==0)
            res.add(-1);
            
      
      return res;
        
    }
    
    void rabinKarp(String pat,String text,int prime)
    {
        int pat_len = pat.length();
        int text_len = text.length();
        int p=0;    // stores hash for pattern
        int t=0;    // stores hash for text
        int power=1;    // precomputed power used in rolling hash subtraction.
        
        for(int i=0;i<pat_len-1;i++)    // precomputing the value for h and storing it.
            power = (power*d)%prime;
        
        for(int i=0;i<pat_len;i++)      // hash for first patLen characters.
        {
            p = ((d*p)+pat.charAt(i))%prime;
            t = ((d*t)+text.charAt(i))%prime;
            
        }
        
        int i,j;

        // so from next on we will just remove 1st char from txt and add next char to txt hash.
        // in sliding window way.
        // this is called as rolling hash.
        
        
        for( i=0;i<=text_len-pat_len;i++)
        {
            if(p==t)    // when pattern and text hash values are equal. it doesnt mean the chars are equal so check the chars.
            {
                for( j=0;j<pat_len;j++)
                {
                    if(pat.charAt(j)!=text.charAt(i+j)) // if any char is not equal break of the loop.
                        break;
                }
                if (j == pat_len)   // when all chars are same then j will stop at last index of pattern. so pattern is found in text.
                    res.add(i+1);   // +1 is added bcz it is asking as position..
            }
            
            if(i<text_len-pat_len)
            {
                 // t: current hash value: <di di+1 di+2>
                
                // 
                // txt[i]: char to be removed<di>. we cant directly remove this character. 
                // while adding to hash it was multiplied by d, patLen-1 number of times.
                // so we precomputed this value and stored it in h. so use it here directly.
                
                // now we have hash value of <di+1 di+2>
                // for this we have to add next char i.e. <di+3>
                
                // so multiply <di+1 di+2> hash by d and add <di+3>
                
                // %q to ensure it wont go beyond int range.
                t = (d*(t-text.charAt(i)*power) + text.charAt(i+pat_len))%prime;
            }
            if(t<0)     // if t goes -ve add q.
                t = t+prime;
        }
    }
    
}
