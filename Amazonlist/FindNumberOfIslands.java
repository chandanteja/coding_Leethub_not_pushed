/**
 * 
 * https://leetcode.com/problems/number-of-islands/     --> qns here.
 * 
 * This is an application of DFS on 2D grids.
 * This is same as finding connected components in 2D grid. So, we can use DFS.
 * 
 * 
 */

package Amazonlist;

import java.util.Arrays;

public class FindNumberOfIslands {

    public int numIslands(char[][] grid) {
        
        int visited[][] = new int[grid.length][grid[0].length]; // uesd to keep track of visited components.So, that we can visit only unvisited components in future.
        int numIslands=0;
        
        for(int arr[]:visited)
            Arrays.fill(arr,0);
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(visited[i][j]==0 && grid[i][j]=='1') // check if the component is not visited and also if grid[i][j]==1 then only start our exploration from there.
                {
                    dfs(i,j,grid,visited,n,m);
                    numIslands++;       // if we havent visited (i,j) and also if grid(i,j)==1 then we it will be part of one island. We start our exploration from here and explore till we reach water on allsides of island.
                                    // and then increase our island count by 1. WHile visiting island we change status of visited as '1'.
                }
            }
        }
        return numIslands;
        
    }
    
    public void dfs(int i,int j, char grid[][],int visited[][],int n,int m)
        
    {
        if(i<0 || i>=n || j<0 || j>=m)  // if we are going out of boundaries then we need to retreat back.
                return ;
        if(grid[i][j]=='0')     // if grid[i][j] == 0 means it's water which is not needed for us. So, we return.
            return;
        if(visited[i][j]==0)    // not visited
        {
            visited[i][j]=1;

            // we can travel only in 4-directions i.e up,down,left,right.
            dfs(i+1,j,grid,visited,n,m);
            dfs(i-1,j,grid,visited,n,m);
            dfs(i,j-1,grid,visited,n,m);
            dfs(i,j+1,grid,visited,n,m);
        }
            
    }
    
}
