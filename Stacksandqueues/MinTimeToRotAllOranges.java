/**
 *  https://www.youtube.com/watch?v=XiUmnWXh-9E     --> watch this for idea or soln.
 * 
 *   Logic is as rotting happens in neighbors of distance=1, so we can apply BFS on 2d-grid.
 * 
 *   https://www.youtube.com/watch?v=M4xxztqh8rQ&t=395s   --> BFS on 2D grid.
 * 
 */

package Stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

class pair{
    
    int x,y;
    pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}


public class MinTimeToRotAllOranges {

    public int orangesRotting(int[][] grid)
    {
        Queue<pair> rotten = new LinkedList<>();
        
        int r = grid.length;
        int c = grid[0].length;
        int time=0;
        int fresh=0;
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j] ==2)
                {
                    rotten.add(new pair(i,j));
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        
        while(!rotten.isEmpty())
        {
            int size = rotten.size();
            
            for(int i=0;i<size;i++)
            {
                pair p =rotten.poll();
                int x = p.x;
                int y = p.y;
                
                // 'x' is inside boundary and grid[x-1][y] contains 1 (i.e fresh orange).
               if(x>0 && grid[x-1][y]==1)
               {
                   grid[x-1][y] = 2;
                   fresh--;
                   rotten.add(new pair(x-1,y));
               }
               
               // 'y' is inside boundary and grid[x][y-1] contains 1 (i.e fresh orange).
               if(y>0 && grid[x][y-1]==1)
               {
                   grid[x][y-1] = 2;
                   fresh--;
                   rotten.add(new pair(x,y-1));
               }
               
               if(x<r-1 && grid[x+1][y]==1)
               {
                   grid[x+1][y] = 2;
                   fresh--;
                   rotten.add(new pair(x+1,y));
               }
               
               if(y<c-1 && grid[x][y+1]==1)
               {
                   grid[x][y+1] = 2;
                   fresh--;
                   rotten.add(new pair(x,y+1));
               }
                    
            }
            
            // if rotten queue is empty it means, we have visited all rotten oranges and there are no oranges that can be rotten.
            
            if(!rotten.isEmpty())
                time++;
        }
        
        return (fresh==0) ? time : -1;
    }
    
}
