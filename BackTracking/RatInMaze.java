/**
 *  https://www.youtube.com/watch?v=rKo9MPe0c5A   --> see this video for understanding.
 *  https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
 * 
 * Logic is if rat is at any point (x,y) it can move in any direction (x+1,y),(x-1,y),(x,y+1),(x,y-1) only if it is inside given boundary, there is no blockage there , it is not visited already.
 *  
 * Constraints are Rat shuld be inside maze only, the cell it is going is not blocked, and that cell is not visited previously.
 * We maintain a visited[][] array to keep track of what all cells are visited. So, we can keep track of whether we can visit a cell or not.
 * 
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RatInMaze {

    public static void findPaths(int maze[][],int visited[][],int x,int y, int n,ArrayList<String> result,String path)
    {
        if(x<0 || y<0 || x>=n || y>=n || visited[x][y]==1 || maze[x][y]==0) // if we cross boundary or if the cell is already visited or cell has blockage, we dont go forward, we return back.
            return;
        if(x==n-1 && y==n-1)    // if we have reached end of maze, we add that path to result array and return i.e backtrack.
        {
            result.add(path);   
            return ;
        }
        // if none of the above is satisfied, then we visit that cell and updated visited [][].
        visited[x][y]=1;
        findPaths(maze, visited, x+1, y, n, result, path+'D');  // X moves up and down. Y- moves left and right
        findPaths(maze, visited, x-1, y, n, result, path+'U');
        findPaths(maze, visited, x, y+1, n, result, path+'R');
        findPaths(maze, visited, x, y-1, n, result, path+'L');

        visited[x][y]=0; // we are backtracking, so this path again becomes available as we backtrack from that path, so marking as unvisited.
    }

    public static ArrayList<String> solveMaze(int maze[][],int n)
    {
        // if any cell (x,y) = 0 it means the cell is blocked.
        ArrayList<String> result = new ArrayList<>();
        if(maze[0][0] ==0 || maze[n-1][n-1]==0) // this is because if the start point or ending point itself are blocked, then we can find paths.
            return result;    
        int visited[][] = new  int[n][n];
        for(int[] row:visited)
            Arrays.fill(row,0);

        String path="";

        findPaths(maze, visited,0,0,n,result,path);
        Collections.sort(result);   // to get paths in lexicographic order.
        return result;


    }
    public static void main(String args[])
    {
        
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
 
        int n = maze.length;
        ArrayList<String> paths= solveMaze(maze,n);
        for(String s : paths)
        {
            System.out.println("Path: "+s);
        }
    }
    
}
