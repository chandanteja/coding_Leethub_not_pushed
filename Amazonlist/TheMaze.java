/**
 * 
 * Premium qns
 * 
 * https://leetcode.com/problems/the-maze/
 * 
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

    Maze1.png       --> example-1
    Maze2.png       --> Example-2
    
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
Output: false
Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
 * 
 */

 /*
Approach 1: Depth First Search

MazeDfsSoln.png

We can view the given search space in the form of a tree. The root node of the tree represents the starting position. Four different routes are possible from each position i.e. left, right, up or down. 
These four options can be represented by 4 branches of each node in the given tree. 
Thus, the new node reached from the root traversing over the branch represents the new position occupied by the ball after choosing the corresponding direction of travel.

In order to do this traversal, one of the simplest schemes is to undergo depth first search. In this case, we choose one path at a time and try to go as deep as possible into the levels of the tree before going for the next path. 
In order to implement this, we make use of a recursive function dfs(maze, start, desination, visited). This function takes the given mazemaze array, the startstart position and the destinationdestination position as its arguments along with a visitedvisited array. 
visitedvisited array is a 2-D boolean array of the same size as that of mazemaze. A True value at visited[i][j]visited[i][j] represents that the current position has already been reached earlier during the path traversal. We make use of this array so as to keep track of the same paths being repeated over and over. 
We mark a True at the current position in the visitedvisited array once we reach that particular positon in the mazemaze.

From every startstart position, we can move continuously in either left, right, upward or downward direction till we reach the boundary or a wall. Thus, from the startstart position, we determine all the end points which can be reached by choosing the four directions. 
For each of the cases, the new endpoint will now act as the new start point for the traversals. The destination, obviously remains unchanged. Thus, now we call the same function four times for the four directions, each time with a new start point obtained previously.

If any of the function call returns a True value, it means we can reach the desination.


Time complexity : O(mn). Complete traversal of maze will be done in the worst case. Here, m and n refers to the number of rows and coloumns of the maze.

Space complexity : O(mn). visitedvisited array of size m*n is used.


 */



package Amazonlist;

// dfs based soln
public class TheMaze {

    public class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            return dfs(maze, start, destination, visited);
        }
        public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
            
            // if already visited the cell return false.
            if (visited[start[0]][start[1]])
                return false;
            
                // if we reached destination then destination is reachable.
            if (start[0] == destination[0] && start[1] == destination[1])
                return true;
            
                // if above 2 are not satisfied, then we visit the current cell. And from current cell we move in pattern of right, left,up, down exploring all directions.
            visited[start[0]][start[1]] = true;

            // if current cell is {start[0], start[1]} then right = start[1]+1 as only column changes but not row.
            // left = start[1]-1;
            // up = start[0]-1 --> here only row changes.

            int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
            while (r < maze[0].length && maze[start[0]][r] == 0) // right
                r++;
            if (dfs(maze, new int[] {start[0], r - 1}, destination, visited))   // here we send (r-1) bcz as we have initially pointed 'r' to current cell's right i.e if current cell is (x,y) we have pointed r = (x,y+1) initially
                return true;                   //we send r-1 bcz we increment 'r' first, then verify condition so after end of all iterations, 'r' will have '1' extra as we first increment 'r' and then check condition so at time of condition failing ,'r' would have incremented '1' extra.
            // return above one as true if the if() returns true.
            // the analogy of 'r' is same for other values of 'l','u','d'.
            while (l >= 0 && maze[start[0]][l] == 0) //left
                l--;
            if (dfs(maze, new int[] {start[0], l + 1}, destination, visited))
                return true;    // return true if the if() returns true.
            while (u >= 0 && maze[u][start[1]] == 0) //up
                u--;
            if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
                return true;
            while (d < maze.length && maze[d][start[1]] == 0) //down
                d++;
            if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
                return true;
            return false;
        }
    }
    
}

/*
Approach 2: Breadth First Search
Algorithm

The same search space tree can also be explored in a Depth First Search manner. In this case, we try to explore the search space on a level by level basis. i.e. We try to move in all the directions at every step. When all the directions have been explored and we still don't reach the destination, then only we proceed to the new set of traversals from the new positions obtained.

In order to implement this, we make use of a queuequeue. We start with the ball at the startstart position. For every current position, we add all the new positions possible by traversing in all the four directions(till reaching the wall or boundary) into the queuequeue to act as the new start positions and mark these positions as True in the visitedvisited array. When all the directions have been covered up, we remove a position value, ss, from the front of the queuequeue and again continue the same process with ss acting as the new startstart position.

Further, in order to choose the direction of travel, we make use of a dirdir array, which contains 4 entries. Each entry represents a one-dimensional direction of travel. To travel in a particular direction, we keep on adding the particular entry of the dirsdirs array till we hit a wall or a boundary. For a particular start position, we do this process of dirdir addition for all all the four directions possible.

If we hit the destination position at any moment, we return a True directly indicating that the destinationdestination position can be reached starting from the startstart position.



IMPLEMENTATION

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}



Time complexity : O(mn). Complete traversal of maze will be done in the worst case. Here, m and n refers to the number of rows and coloumns of the maze.

Space complexity : O(mn). visitedvisited array of size m*n is used and queuequeue size can grow upto m*n in worst case.
*/