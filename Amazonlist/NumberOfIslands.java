/*
    https://leetcode.com/problems/number-of-islands/    --> qns
    https://www.youtube.com/watch?v=L2NShjXvUNM&t=384s       --> refer this video.


    This is same as number of connected components in 2D Grid.

*/

package Amazonlist;

import java.util.Arrays;

public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        
        for(boolean arr[] :visited)
            Arrays.fill(arr,false);
        
        int numIslands=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')   // we make a call to dfs only if (i,j)==1 bcz if (i,j)==0 thn there is no island at (i,j). So it is waste of making call to dfs
                {
                    dfs(grid,visited,i,j,m,n);
                    numIslands++;
                }
            }
        }
        
       return numIslands;
    }
    
     public void dfs(char[][] grid, boolean visited[][],int i,int j,int m,int n)
        {
            if(i<0 || i>=m || j<0 || j>=n || visited[i][j]==true)   // if(i,j) crosses boundaries or (i,j) is already visited then we return
                    return;
         if(grid[i][j]=='0')        // if (i,j) is '0' it means there is no island area at (i,j). so we return, bcz we need not go further to check as there is no island at current cell itself
                return;
            
            visited[i][j]=true;
            
            dfs(grid,visited,i-1,j,m,n);
            dfs(grid,visited,i+1,j,m,n);
            dfs(grid,visited,i,j-1,m,n);
            dfs(grid,visited,i,j+1,m,n);
        }
}
