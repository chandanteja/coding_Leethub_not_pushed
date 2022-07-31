/**
 * 
 * https://www.youtube.com/watch?v=xaKENHcJts4&t=1040s --> watch this for below implementation.
 * 
 */

package DP;

import java.util.Arrays;

public class MobileNumericKeyPad {

    // mobile keypad style of digits and -1 represents # and *
    static int mobile[][] = {{1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {-1,0,-1}};
                    
    public static long count(int i,int j,int n,long dp[][])
    {
        if(n==1)
            return 1;   // bcz only one number can be formed with size=1 i.e only 1-number combination possible
        if(dp[mobile[i][j]][n] != -1)       // if the value is memoized, return it.
            return dp[mobile[i][j]][n];

            // n=2 [00, 11, 22, etc etc] - are also counted. 
        // when we are at i, j position so we will pass i, j only as same number can also be considered. but with n-1 length as we consider one element.
        long self = count(i,j,n-1,dp);


        long left=0,right=0,up=0,down=0;
        
        
        if(j-1>=0 && mobile[i][j-1]!=-1)    // check j-1>=0 bcoz for 0/4/7 we dont have left side values we cant go there. to ensure that this check is needed.
                left= count(i,j-1,n-1,dp); // also if we are at 0, its left is -1 . we cant iterate through it. so mobile[i][j-1]!=-1 check
           
        if(j+1<3 && mobile[i][j+1] !=-1)        // for 3/6/9 -> no right side j+1<3 check
                right = count(i,j+1,n-1,dp);   // for 0 right side = # (cant go there) so mobile[i][j+1]!=-1 check.
            
        if(i-1>=0 && mobile[i-1][j]!=-1)    // for 1/2/3 no up -> i-1>=0 check.
                 up= count(i-1,j,n-1,dp);  //  M[i-1][j]!=-1 == not needed here. u can remove it.
            
        if(i+1<4 && mobile[i+1][j]!=-1)     // for 0 -> no down.
                down = count(i+1,j,n-1,dp); // for 7/9 - bottom one is -1 so M[i+1][j] check 

                // with each move we decrement the length by 1.
            
        dp[mobile[i][j]][n] = self+left+right+up+down;      // for any number we have to add the results obtained from self, right, left, up, down and store in that related number (mobile[i][j]) for value of'n' 
        return dp[mobile[i][j]][n];
          
    }
    
	public static long getCount(int N)
	{
		long dp[][] = new long[10][N+1];
		
		for(long arr[]:dp)
		{
		    Arrays.fill(arr,-1);
		    
		}
		
		long ans=0;
		for(int i=0;i<4;i++)    // iterating thru keypad of mobile  which is 4x3 matrix
		{
		    for(int j=0;j<3;j++)
		    {
		    if(mobile[i][j]!=-1)        // except # and $ we need to calculate for remaining all positions.. so they are replaced by -1 in matrix.
		            ans=ans+count(i,j,N,dp);        // add the result for each number.
		}
		}
		
		return ans;
		
	}

    public static void main(String args[])
    {
        int n = 3;

        System.out.println("Ans is: "+ getCount(n));
        System.out.println("Ans is: "+ getCount(2));
    }
    
}
