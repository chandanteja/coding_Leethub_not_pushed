/**
 *  https://www.youtube.com/watch?v=rKo9MPe0c5A   --> see this video for understanding.
 */
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class RatInMaze {

    public static void dfs(int x,int y,String path,int n,int arr[][],int visited[][],ArrayList<String> result)
    {
        if(x<0 || y<0 || x>=n || y>= n)     // these are boundary of maze cases i.e rat can't go out of boundary. But we are just doing x+1 or y+1 during call
            return;                         // if the rat crosses boundary then there is no path. so we will return.
        if(arr[x][y] == 0 || visited[x][y]==1)       // this checks if in 'arr', any path is blocked i.e 0 then return or in visited array if that path is already visited, then also return as we can't visit same (x,y) pair more than once.
            return;
        if(x==n-1 && y==n-1)        // here, if we have reached end i.e (x,y) = (n-1,n-1) reached last box, then we will add that result to path.
        {
            result.add(path);
            return; // this is the end of path so, we will return
        }
        
        visited[x][y] = 1;  // if none of the above satisfies, then it means we have visited the next point in array. So mark it visited.
        dfs(x+1,y,path+'D',n,arr,visited,result);
        dfs(x-1,y,path+'U',n,arr,visited,result);
        dfs(x,y+1,path+'R',n,arr,visited,result);
        dfs(x,y-1,path+'L',n,arr,visited,result);

        visited[x][y] = 0;      // after completion of visiting a path, now we will unmark it in the visited matrix so that the same (x,y) pair can be used in other path if other path passes thru it.
    }
   
    public static ArrayList<String> ratInMazeUtil(int arr[][],int n)    // n is size of list
    {
        int visited[][] = new int[n][n];
        
        for(int[] row : visited)
            Arrays.fill(row,0);
        
        if(arr[0][0]==0)
            return null;
        if(arr[n-1][n-1]==0)
            return null;
        String path = "";
        ArrayList<String> result = new ArrayList<>();

        dfs(0,0,path,n,arr,visited,result);   // (0,0) are starting point coordinates.
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args)
{
    int arr[][] = { { 1, 0, 0, 0, 0 },
                  { 1, 1, 1, 1, 1 },
                  { 1, 1, 1, 0, 1 },
                  { 0, 0, 0, 0, 1 },
                  { 0, 0, 0, 0, 1 } };
    int n = arr.length;
     
    ArrayList<String> res = ratInMazeUtil(arr, n);
    Iterator<String> itr= res.iterator();
    int i=1;
    while(itr.hasNext())
    {
        System.out.println("Path  "+i +" is: "+ itr.next());
        i++;
    }
}
    
}
