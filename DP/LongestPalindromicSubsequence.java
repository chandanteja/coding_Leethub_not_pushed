/**
 * https://www.geeksforgeeks.org/longest-palindrome-subsequence-space/ -->space optimized.
 * https://www.youtube.com/watch?v=n7zOuIzKGAU --> 2d recursive.
 * 
 * Prefer recursive.
 * 
 */

package DP;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    // iterative --> O(n) space and O(n^2) time.

// iterative 1d approach:

// abcba


// 0-a	1-b	2-c	3-b	4-a
// 	1	1	3	3

// n=5

// i=4
// j=4 to 4
// a[4]=1


// i=3
// j=3 to 4
// a[3] = 1
// a[4] = 
// Backup = a[4] = 1
// a[4] = max(a[3], a[4]) = 1

// -----------------------------
// i=2
// j=2 to 4
// a[2] = 1
// a[3] = 1
// Backup = a[3] = 1
// a[3] = max(a[2], a[3]) = 1

// a[4] =1
// Backup= a[4] = 1
// a[4] = max(a[3], a[4])=1

// --------------------

// i=1
// j=1 to 4
// a[1] = 1
// a[2] = 1
// Backup = a[2]
// a[2] = max(a[1], a[2])=1

// a[3] = [bb]
// Temp = a[3] = 1
// a[3] = backup+2 = 1+2 = 3 
// Backup = 1

// a[4] = [bcba = ba]
// Backup = a[4] = 1
// a[4] = max(a[3], a[4]) = 3

// ----------------------
// i=0
// j=0 to 4

// a[0]=1
// a[1] = [ab]
// Backup=a[1] = 1
// a[1]=max(a[0], a[1])=1

// a[2]=[ac]
// Backup=a[2]=1
// a[2]=max(a[1],a[2])=1

// a[3]=[ab]
// Backup=a[3]=3
// a[3] = max(a[2],a[3])=3

// a[4]=[aa]
// Temp=a[4]=3
// a[4]=3+2 = 5
// Backup=3


// Backup = length of longest palindromic seq seen till now, not including current one if any. (previously seen 
// palindromic subseq leng)

    static int longestPalindromicSubsequence(String s)
    {   
        int n = s.length();
        int dp[] = new int[n];  // dp-state: dp[i] tells the length of longest palindromic subsequence in string of length= 'i' i.e characters from s[0..i-1] are considered.
        Arrays.fill(dp,0);
        int backUp; // this used to keep track of length of longest palindromic subsequence we saw previously (in prev iteration) (not considering current subseq if seen any longest.)
        for(int i=n-1;i>=0;i--) // i-moves from right to left
        {
            backUp=0;
            for(int j=i; j<n;j++)   // j-moves from position of -i to right
            {
                if(i==j)
                    dp[j] =1;   // single character will be palindrome always.
                else if(s.charAt(i)==s.charAt(j))       // if both chars are same => means new palindrome will be formed.
                {
                    int temp = dp[j];   // a[j] will be something other than i, so it will be some right side value to ith char.  so all right side character values store max leng of palindrome seen till that point. so store this 
                    // previous largest palin length in temp.
                    dp[j] = backUp+2;   // add +2 to backup.
                    backUp = temp;  // store previous max len of palindrome in backup.
                } 
                else
                {
                    backUp = dp[j];
                    dp[j] = Math.max(dp[j-1],dp[j]);    // updating length of lps of currently considered element with max of current ele length and previously considered ele length
                }
            }
        }
        return dp[n-1];
        
    }
    public static void main(String[] args)
    {
        String str = "GEEKSFORGEEKS";
        System.out.println("Lengh of LPS: "+longestPalindromicSubsequence(str));

        int dp[][] = new int[str.length()][str.length()];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);

        System.out.println("Lengh of LPS recursive: "+recursiveLPS(str,0,str.length()-1,dp));
    }

    
    static int recursiveLPS(String s, int i, int j, int dp[][])
    {
        // this is the recursive way.
        // if 1st and last char match then remove those 2 and proceed with remaining string: s[0...n-1] if(s[0]==s[n-1]) s[1...n-2]
        // else we have to take max of s[0...n-2], s[1...n-1]

        // this function returns the length of longest palindromic subsequence.

        // dp state = length of longest palindromic subsequence. that starts at i and ends at j i.e. s[i...j]
        if(i==j)    // if i==j means i and j point to same position it means character at i and j will be same character. So a single character will always be palindrome.
            return 1;
        if(i>j) // 'i' move from left to right and 'j' move from right to left. if i and j cross each other it means we have traversed all string
            return 0;
        if(dp[i][j] !=-1)   //if dp[i][j]!=-1 means it has already been filled then return it.
            return dp[i][j];
        
        if(s.charAt(i)== s.charAt(j))      // when both chars are same then lps length increases by 2 and proceed with string after removing first and last chars of the string so dp[i][j] = s[i+1....j-1]+2
            dp[i][j] = recursiveLPS(s,i+1,j-1,dp)+2;
        else    
            dp[i][j] = Math.max(recursiveLPS(s, i+1, j, dp), recursiveLPS(s, i, j-1, dp));
            // when chars are not equal then the lps length = max( (lps of string from 0..n-2), (lps of string from 1...n-1))

        return dp[i][j];

    }
    
}
