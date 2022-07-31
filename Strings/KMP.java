/**
 * 
 * https://www.cs.ubc.ca/~hoos/cpsc445/Handouts/kmp.pdf
 * https://www.it.iitb.ac.in/frg/wiki/images/7/70/CS213_3x_Session21_Knuth_Morris_Pratt_Algorithm.pdf
 * 
 * https://www.youtube.com/watch?v=4jY57Ehc14Y      --> watch this for LPS.
 * 
 * Refer GFG Self pacced DSA for KMP algo.
 * 
 * 
 * KMP first, we calculate LPS array which tells us how many characters we need to slide in order to find our next match.
 * 
 * 
    fillLPS: O(m)

    kmp: O(n-m)
 * 
 */

package Strings;

public class KMP {

    int computeLPSArray(String str, int lps[]) {
        // code here
        
        int n=str.length(),len=0;   // len keeps track of lps at any point in time. 
        //int lps[] = new int[n];
        lps[0]=0;       // because for 1 character there is no proper prefix.
        int i=1;
        while(i<n)
        {
            if(str.charAt(i)==str.charAt(len))  // when char at i and char at len are same, then
            {
                len++;
                lps[i]=len; // pattern till len + 1 (including char at len) can be used as lps here.
                i++;
            }
            else
            {
                // len keeps track of length of LPS which was seen at any point of time
                if(len==0)          // when chars are not same and len is 0, then it means we havent seen any prefix which is also suffix
                {
                    lps[i]=0;       // no common prefix and suffix.
                    i++;
                }
                else        // len is not 0 means some char before had common prefix and suffix, we take the same LPS as current len and proceed.
                {
                    len=lps[len-1];
                }
            }
        }
        
        return lps[n-1];
        
    }

    void KMPSearch(String pat, String txt)
    {
            /*          0   1   2   3   4   5
        txt:    a   a   a   a   a   b
        pat:    a   a   a   a


        pat:    a   a   a   a
        lps:    0   1   2   3


        match at 0:
                                i
                0   1   2   3   4   5
        txt:    a   a   a   a   a   b
        pat:    a   a   a   a
                                j
        
        so we have matched all chars of the pattern with current window of the text.
        our output is 0 (first occurance)

        what is the next character to be matched? we use lps array to find to which position we have to match next.
        
        now check the lps array for the last matched character. i.e. for j=3.

        lps[3]=3. so index of the character that we need to match in the pattern is 3.

        if we see aaaa: first 3 a's and last 3 a's are the same. so we can skip through these 3
        characters as we found them in the text. 

        "in text we always move forward. in pattern we will use LPS index to find next position".

        now we will match j=3 and i=4 (no change in i)

                                i(is at 4)
        txt:    a   a   a   a   a   b
        pat:        a   a   a   a   
                                j(is at 3)
        again a match so print 4.


        now check lps[last matched character] i.e. lps[3] = 3. i will move forward and goes to 5th position. 
        j will be j=lps[j] = j=lps[3]=3

        so match j(at 3) with i(at 5)

                0   1   2   3   4   5(i)
        txt:    a   a   a   a   a   b
        pat:            a   a   a   a(j)

        didnt match. 


    */


        int M = pat.length();   // length of pattern
        int N = txt.length();   // length of string.
  
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        // length of lPS array will be same as pattern length
        int lps[] = new int[M];     // lps[i] = length of longest proper prefix which is also suffix till ith character in given pattern.
        int j = 0; // index for pat[]
  
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, lps);
  
        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {   
                // move forward in text
                // move forward in pattern
                j++;
                i++;
            }

            if (j == M)         // when we matched all the characters in pattern
            {
                System.out.println("Found pattern " + "at index " + (i - j));
                j = lps[j - 1];     // then use lps array to find to which position we have to go to in pattern.
            }
  
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)     // there were some matches before this mismatch 
                    j = lps[j - 1];     // so we find the position to which we have to move in the pattern using lps array.
                else
                    i = i + 1;      // when j is already at the beginning of the pattern and first character didnt match.
                    // so increment i.
            }
        }
    }
    
}
