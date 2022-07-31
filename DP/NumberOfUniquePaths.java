/**
 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * 
 * https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
 * 
 *  Time complexity of the above dynamic programming solution is O(mn). 
    The space complexity of the above solution is O(mn).
 */

package DP;

import java.util.Arrays;

public class NumberOfUniquePaths {

    public static int NumberOfPath(int a, int b) 
    {
        int dp[][] = new int[a][b]; //dp[i][j] denotes the number of paths to cell i,j from cell 0,0
        
        for(int i=0;i<a;i++)
            dp[i][0] =1;    // when u have only 1 column, then u can reach the ith cell in only 1 way so put 1 in all the cells of 1st column.
            
        for(int i=0;i<b;i++)
            dp[0][i] =1;    // when u have only 1 row, then u can reach the ith cell in only 1 way so put 1 in all the cells of 1st row.
        
        for(int i=1;i<a;i++)
        {
            for(int j=1;j<b;j++)
            {
                // i--> rows and j--> cols.
                // u can reach a cell (i,j) either from left (i,j-1) or from top (i-1,j). 
                // if ur cell is [i,j] then left = [i,j-1] and up=[i-1, j]
                // so #paths to cell [i,j] = #paths to [i, j-1] + #paths to [i-1, j]
                dp[i][j] =  dp[i-1][j] +dp[i][j-1];
                
            }
        }
        return dp[a-1][b-1];        // return last cell value.
        
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // obstacleGrid has the 1 in the position of obstacle in the grid.

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int dp[][] = new int[m][n];
        for(int arr[]:dp)
            Arrays.fill(arr,0);
        
        if(obstacleGrid[0][0]==0)// if 1st cell itself is 1, then u cant proceed then no use. so we are checking if 
    // this cell doesnt have any obstacle, so put 1 in that position in dp.
                dp[0][0] =1;
        
        for(int i=1;i<m;i++) // if there is only 1 col.
        {
            if(obstacleGrid[i][0]==0)// and if there is no obstacle in any cell then the row-wise path to this cell 
            // = path till previous cell.
            dp[i][0] = dp[i-1][0];
        }
            
         for(int i=1;i<n;i++)// if there is only 1 row
        {
            if(obstacleGrid[0][i]==0)// and if there is no obstacle in any cell then the col-wise path to this cell 
            // = path till previous cell.
            dp[0][i] = dp[0][i-1];
        }
        for(int i=1;i<m;i++)// number of rows.
        {
            for(int j=1;j<n;j++)// number of cols.
            {
                if(obstacleGrid[i][j]==0)// if any cell doesnt have obstacle then path to this cell = path to left cell + path to up cell.
                        dp[i][j] = dp[i-1][j]+dp[i][j-1];
                
                //System.out.print(dp[i][j]+" ");
            }
           // System.out.println();
        }
        
//         for(int i=0;i<m;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
                
                
//                 System.out.print(dp[i][j]+" ");
//             }
//             System.out.println();
//         }
        if(obstacleGrid[0][0]==1)
                return 0;
        return dp[m-1][n-1];
            
    }

    public static void main(String args[])
    {
        System.out.println("# of paths: "+ NumberOfPath(3, 3));
    }
    
}

