/**
 * https://www.youtube.com/watch?v=DD-_hZwEkXY
 *  https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/    ---> BFS based.
 * https://www.geeksforgeeks.org/minimum-steps-reach-target-knight-set-2/   ---> DP based
 */


 // This solution is based on BFS.
package Graphs;

import java.util.Arrays;
import java.util.Vector;

class Cell{

    int x,y;
    int dist;
    Cell(int x,int y,int dist)
    {
        this.x = x;
        this.y=y;
        this.dist = dist;
    }

}
// Here we are considering  1-based indexing.
public class MinDistForKnightToTarget {
// first the knight can move to 8 positions from where it is currently. These 8 positions are at distance=1 from current position of knight.
// Also we need to check knight doesn't cross boundary.

static boolean isInsideBoard(int x,int y,int n)
{
    if(x<1 || x>n || y<1 || y>n  )
        return false;
    return true;
}

static int minStepsForKnight(int knightPos[],int targetPos[],int n)
{
    // x and y directions in which a knight can move. For example, if knight is curently at (x,y) then it can move to (x-2,y+1),(x-1,y+2),(x+1,y+2),(x+2,y+1)
        // and (x-2,y-1),(x-1,y-2),(x+1,y-2),(x+2,y-1) . See the above posted video for clear idea.
        // both dx and dy will have coordinates in correspondance i.e dx[0] and dy[0] will be the values from (x,y) to (x +/- dx[0],y +/- dy[0])
        // we can store dx,dy in either clockwise or anti-clockwise direction
    int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

    Vector<Cell> q =  new Vector<>();       // this is used as queue in BFS to store all the states of knight on the board.

    q.add(new Cell(knightPos[0], knightPos[1], 0));             // push starting position of knight with 0 distance as dist is 0 from current position to starting position

    Cell temp;
    int x, y;
    boolean visit[][] = new boolean[n + 1][n + 1];
    
    // for(int i=1;i<=n;i++)
    //     for(int j=1;j<=n;j++)
    //         visit[i][j] = false;
   
    for(boolean arr[]: visit)
        Arrays.fill(arr,false);

   visit[knightPos[0]][knightPos[1]] = true;        // as initial position is visited, we make it as true

   while(!q.isEmpty())
   {
       temp = q.firstElement();
       q.remove(0);

       // if current cell is equal to target cell,
            // return its distance
       if(temp.x == targetPos[0] && temp.y == targetPos[1])
            return temp.dist;
        
        // loop for all reachable states
        for(int j=0;j<8;j++)
        {
            x = temp.x+dx[j];       // calculating from the currently popped element position (x,y) to all 8 possible moves which are valid are pushed to queue
            y = temp.y +dy[j];

            if(isInsideBoard(x, y, n) && visit[x][y]==false)        // moves are vvalid if the next point is inside board and not visited.
                {
                    visit[x][y] = true;
                    q.add(new Cell(x, y, temp.dist+1));
                }
        }

   }
   return Integer.MAX_VALUE;

}
public static void main(String[] args)
    {
        int N = 30;
        int knightPos[] = { 1, 1 };
        int targetPos[] = { 30, 30 };
        System.out.println("min steps for knight:" + minStepsForKnight(knightPos, targetPos, N));
    }
    
}
