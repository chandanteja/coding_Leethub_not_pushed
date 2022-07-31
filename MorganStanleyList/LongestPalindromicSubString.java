/**
 * https://www.youtube.com/watch?v=jCOJk4UyO8w --> watch this video.
 * https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/ 
 * 
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/        --> see the naive soln T.C: O(n^3)
 * 
 *  Method 1: Brute Force. 
    Approach: The simple approach is to check each substring whether the substring is a palindrome or not. 
    There will be (n(n-1))/2 number of substrings and checking each substring is palindrome or not, total time will go to O(n^3)
    To do this first, run three nested loops, the outer two loops pick all substrings one by one by fixing the corner characters, 
                the inner loop checks whether the picked substring is palindrome or not. 
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Time complexity: O(n^2)
 * S.C : O(1)
 */

package MorganStanleyList;

public class LongestPalindromicSubString {

/* 
        
here the palindrome can be of even length or odd length.

if it is of even length then we have to find 2 same chars which are side-side and from there we move 1 pointer towards right
and other pointer towards left - to expand this palindrome if possible. also we keep track of start of longest palindromic substring
and its length to print the string.
low=i-1
high=i


if it is of odd length then we will have 1 extra char in the middle of 2 same characters. like aca
same as above case we move 1 ptr to left and other to right to expand this palindrome. also we keep track of start of longest palindromic substring
and its length to print the string.
low=i-1
high=i+1
so at ith position we have extra character.


*/


static String longestPalin(String s){
        
    int len = s.length();
    int low,start=0,high,maxlen=1;  // maxlen to keep track of longest palindrome length and is initialized with '1' bcz single char is always palindrome.
    
    // for each length of string we have to check both even and odd length palindromes.
    // max length palindrome can be of even or odd length.
    for(int i=1;i<len;i++)
    {
        low=i-1;     // even length case.
        high=i;     // low+1 = high... for even case.
        while(low>=0 && high<len && s.charAt(low)==s.charAt(high))
        {
            if(high-low+1>maxlen)   // if maxlen till now is smaller than current length (of string i.e high-low+1 gives current string len), we update.
            {
                maxlen = high-low+1;
                start = low;        // to keep track of the start of longest palindromic string.
            }
            low--;  // move low ptr to left.
            high++; // move high ptr to right.
        }
        
        //for odd case we cant take pointers as we took in even case as it cant find odd length palindromes, Also as the length shuld be odd, we need to leave a char in middle of 2-ptrs.
        low=i-1;
        high=i+1;
        // Remaining everything is same as in even case.    
        while(low>=0 && high<len && s.charAt(low)==s.charAt(high))
        {
            if(high-low+1>maxlen)
            {
                maxlen = high-low+1;
                start = low;
            }
            low--;
            high++;
        }
    }
    String res="";
    for(int i=start;i<start+maxlen;i++)
        res=res+s.charAt(i);
    return res; // or return res.substring(start,start+maxlen);
    
}

public static void main(String[] args)
{

    String str = "forgeeksskeegfor";
    System.out.println("Length is: " + longestPalin(str));
}
   
}
