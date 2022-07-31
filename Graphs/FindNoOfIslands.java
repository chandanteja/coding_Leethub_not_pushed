/**
 * 
 * https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1     --> visit this link for qns what islands mean.
 * 
 * https://www.youtube.com/watch?v=L2NShjXvUNM&t=384s       --> refer this video.
 * 
 * This is same as number of connected components in 2D Grid.
 * 
 */

package Graphs;

import java.util.Arrays;

public class FindNoOfIslands {

    public void dfs(int i,int j,int visited[][],char grid[][],int n,int m)
    {
        if(i<0 || j<0 || i>=n || j>=m )
            return;
        if(grid[i][j]=='0')     // if (i,j) is '0' it means there is no island at (i,j). so we return
                return;
        if(visited[i][j]==0)        // if not visited, we visit in all 8 directions. checking if island can be extended.
        {
            visited[i][j] =1;
            dfs(i+1,j,visited,grid,n,m);
            dfs(i-1,j,visited,grid,n,m);
            dfs(i,j+1,visited,grid,n,m);
            dfs(i,j-1,visited,grid,n,m);
            dfs(i+1,j+1,visited,grid,n,m);
            dfs(i-1,j+1,visited,grid,n,m);
            dfs(i+1,j-1,visited,grid,n,m);
            dfs(i-1,j-1,visited,grid,n,m);
        }
    }
    
    public int numIslands(char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][] = new int[n][m];
        for(int arr[]:visited)
            Arrays.fill(arr,0);
        
        int nIslands=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j] =='1')    // we make a call to dfs only if (i,j)==1 bcz if (i,j)==0 thn there is no island at (i,j). So it is waste of making call to dfs
                { 
                    dfs(i,j,visited,grid,n,m);
                    nIslands++;
                }
            }
        }
        return nIslands;
    }
    
}
