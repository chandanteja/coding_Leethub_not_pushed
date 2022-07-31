/**
 * 
 * 
 * https://www.geeksforgeeks.org/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/
 * 
 * We need to find maximum number of consecutive substrings with equal number of 0s and 1s.
 * 
 */

package Strings;

public class SplitBinaryStringIntoEqual0sAnd1s {
    
    static int maxSubStr(String str, int n)
    {
     
        // To store the count of 0s and 1s
        int count0 = 0, count1 = 0;
     
        // To store the count of maximum
        // substrings str can be divided into
        int cnt = 0;        // tells total number of splits.
        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == '0')    // if the character is 0 then increment count0
            {
                count0++;
            }
            else     // if the character is 1 then increment count1
            {
                count1++;
            }
            if (count0 == count1)   // if at any time count0 and count1 are equal then inc final counter.
            {
                cnt++;
            }
        }
     
        // It is not possible to
        // split the string
        if (cnt == 0)
        {
            return -1;
        }
        return cnt;
    }

}
