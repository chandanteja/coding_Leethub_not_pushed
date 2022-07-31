/**
 * 
 * https://www.youtube.com/watch?v=2NaaM_z_Jig     --> watch this video.
 * 
 * Watch above video for clarity.
 * 
 */

package Amazonlist;

import java.util.ArrayList;

public class WordBreak {
    public static boolean wordBreak(String A, ArrayList<String> B )
    {
       int dp[] = new int[A.length()];  // here we store count of possible strings i.e dp[i] is the count of possible string from given dictionary by considering from 0th character till ith character in given string.
       
       if(A.length()==0)
            return false;
        
       // here we use 2D loop to consider all suffixes
       /*
            Let string be "pepcodingloves" --> then if 'i' points to 's' (in loves) , using 'j' we iterate from j=0 to j=i,
            so, in this process we consider all suffixes like "pepcodingloves"  , "epcodingloves" ,"pcodingloves" etc.
            We consider all suffixes and check all possible words.

            Ex: Dict[] ={ pep,coding,pepcoding,loves}
            when considering word as "pepcoding", we check different splits as pepcoding, p-epcoding,pe-pcoding,pep-coding,pepc-oding,pepco-ding,pepcod-ing etc...
            here the split "pep-coding" and "pepcoding" are our interest strings as they contribute to count
            here if we append "coding" to "pep", we  get 1-word and w/o any splitting  also we get "pepcoding" which is also there in dictionary, so these are the 2-splits
            Now when we get "coding" as the word, if we append it to "pep", we get 2nd split then, so we consider dp[index-'coding'] + dp[index value of ending of 'pep'].
       */
       for(int i=0;i<dp.length;i++)
       {
           // 'i' will be pointing to an index, which we consider the end of the current word we consider.
           // we check all the prefixes of the above formed word using 'i'.
           // we take all possible suffixes using 'j' 
           // 'j' to 'i' will form a suffix of word pointed by 'i'
           for(int j=0;j<=i;j++)
           {
               // we are taking 'i+1' bcz (p,q] here 'q' index is exculusive.
               String wordToCheck = A.substring(j,i+1); // taking substring which acts as suffix.
               
               if( B.contains(wordToCheck) )    // we check if  above substring is part of dictionary given, if true then we check if any previous strings are there till before 'j' i.e 
               // if substring [j,i+1) --> is there in given dict, we check if there is any string formed from [0,j-1] there in given dict (whose length will be in dp[j-1]) every time.
               {
                   if(j>0)      // if the substring is part of dictionary given, then we add current count dp[i] to previous valid count dp[j-1] (valid count is where we last got valid string)
                        dp[i] = dp[i]+dp[j-1];
                    else    // this the case when 'j'  is still poining at-0 and but i is point to a end of word which is in dictionary 
                    // consider "pep", 'j'  points to 'first-p' and i points to 'last-p', so, here j=0 when we do j-1 we get error, but this is a valid word as it is there in dictionary, so we add this count too.
                         dp[i] = dp[i]+1;
               }
               // if string is not there in given dict then we do nothing.
               // say the split above is pe-pcoding, here 'pcoding' is not part of the given dict, so we dont do anything.
           }
       }
       return dp[A.length()-1]>0 ? true:false;
    }
    
}
