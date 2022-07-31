/**
 * 
 * Here we are only interested in the last value of this lps array because it shows us the largest suffix of the reversed string that matches the prefix of the original string 
 * i.e these many characters already satisfy the palindrome property. 
 * Finally minimum number of character needed to make the string a palindrome is length of the input string minus last entry of our lps array. Pease see below code for better understanding
 

        https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/        -->> refer this article

        For string = AACECAAAA
        Concatenated String = AACECAAAA$AAAACECAA
        LPS array will be {0, 1, 0, 0, 0, 1, 2, 2, 2, 0, 1, 2, 2, 2, 3, 4, 5, 6, 7}
 * 
 */

package Strings;

public class MinCharactersAddedAtFrontOfStringToMakePalindrome {

    public static int[] computeLPSArray(String str)
{
    int n = str.length();
    int lps[] = new int[n];
    int i = 1, len = 0;
    lps[0] = 0; // lps[0] is always 0
     
    while (i < n)
    {
        if (str.charAt(i) == str.charAt(len))
        {
            len++;
            lps[i] = len;
            i++;
        }
        else
        {
            // This is tricky. Consider the example.
            // AAACAAAA and i = 7. The idea is similar
            // to search step.
            if (len != 0)
            {
                len = lps[len - 1];
                 
                // Also, note that we do not increment
                // i here
            }
            else
            {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}
 
// Method returns minimum character to be added at
// front to make string palindrome
static int getMinCharToAddedToMakeStringPalin(String str)
{
    StringBuilder s = new StringBuilder();
    s.append(str);
     
    // Get concatenation of string, special character
    // and reverse string
    String rev = s.reverse().toString();
    s.reverse().append("$").append(rev);
     
    // Get LPS array of this concatenated string
    int lps[] = computeLPSArray(s.toString());
    return str.length() - lps[s.length() - 1];
}
    
}
