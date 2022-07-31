/**
 * 
 * https://www.youtube.com/watch?v=qmTtAbOTqcg      --> watch the video for understanding
 * 
 * 
 * https://www.youtube.com/watch?v=qmTtAbOTqcg ==> pep coding
  

big picture:

we will start from left and traverse to right of the given string.
at each char i we check if the string [0..i-1] is palindrome or not.
if it is palindrome then adding this will not make it a palindrome, so number of cuts will be 1.

if it is not a palindrome then we have to find the minimum #cuts such that each substring is a palindrome in those partitions.
so if we are i, then check at ith, i-1th, i-2th ... 1st position the following:

    cut at i ==> j=i ==>  [0...i-1][i i]              
    cut at i-1 ==> j=i-1 ==> [0...i-2][i-1 i]
    cut at i-2 ==> j=i-2 ==> [0...i-3][i-2 i-1 i]
    ...

    so at each step:
        if right side part is palindrome (ispalindrome[j][i]) then we have to find the minimum number of cuts
            and if dp[i-1]<min // for left side part...
                min=dp[i-1] // dp[i] stores the minimum number of cuts needed for palindromic partitioning of string [0...i-1]
        
        once u check for all possible left parts and corresponding right parts then in min u will have min cuts possible.

    then add +1 to this min count,(because we are cutting now.) and store in dp[i];

 ----------------------------------------------------------------------------------------------------------------

isPalindrome:
 here we build a 2d array isPalindrome for length nxn. where isPalindrome[i][j] means if the string from i to j is palindrome or not.

 for this we take a variable called "gap", this says the number of elements b/w start and end elements.

 when gap=0, start and end are same. we are considering single character so it will always be a palindrome. 
 so if(gap==0)
        isPalindrome[i][j]=true;
    
if gap==1 then start and end elements are side by side like 0,1 ; 1,2 ; 2,3 ; 3,4 ; 4,5 ....
if both are same then they form the palindrome (true) else false.

if gap>1 then 
    if start and end elements are same and if middle part is palindrome then this is also palindrome ==> str[i]==str[j] && palindrome[i+1][j-1] ==> true
    else false.
 * 
 * 
 */
package DP;

public class PalindromePartitioning {
    
    static int palindromicPartition(String str)
    {
        int n = str.length();

        // 1. palindrome - 2d
        // 2. 1d - dp array.
        
        // palidrome 2d.

        boolean palindrome[][] = new boolean[n][n];
        
        for(int gap=0;gap<n;gap++)
        {
            for(int i=0,j=gap;j<n;j++,i++)
            {
                // gap=0 -> true.
                // gap=1 -> str[i]==str[j] -> true else false;
                // else str[i]==str[j] && ispali[i+1][j-1]
                // when gap=0, start and end are same. we are considering single character so it will always be a palindrome.
                if(gap==0)
                    palindrome[i][j] = true;
                else if(gap==1)     //if gap==1 then start and end elements are side by side like 0,1 ; 1,2 ; 2,3 ; 3,4 ; 4,5 ....
                    palindrome[i][j] = (str.charAt(i) == str.charAt(j));    // if both are same then they form the palindrome (true) else false.
                else
                    palindrome[i][j] = (str.charAt(i)==str.charAt(j))&& palindrome[i+1][j-1];   // if start and end elements are same and if middle part is
                    //palindrome then this is also palindrome ==> str[i]==str[j] && palindrome[i+1][j-1] ==> true
                    
            }
        }
        int dp[] = new int[n];
        dp[0] = 0;
        
        for(int i=1;i<n;i++)
        {
            
            // if the string till ith part is palindrome then no need to do any cut.
            if(palindrome[0][i] == true)
                dp[i] = 0;  // so 0.
        else     // if not palindrome
        {
            int min = Integer.MAX_VALUE;
            for(int j=i;j>0;j--)    // then check at each position when j to 1
            {
            
            if(palindrome[j][i]==true)      // if at any point we have a palindrome (i=j-x:  we are writing j-x because we move from jth
            // position backwards) [j-x....j] then we cut at j-xth i.e. ith position(2 parts are 0..i-1 and i...j). 
            // so min cuts till i-1th position + 1 (cut b/w i-1 and i)
            // we can have multiple such palindromes when we move backwards from jth position. we want min #cuts. 
            // so store in min variable. 
               if(dp[j-1]<min)
                  min = dp[j-1];
            }   
            dp[i] = min+1;
         }
         
         
        }
        return dp[n-1];
        
    }   

}
