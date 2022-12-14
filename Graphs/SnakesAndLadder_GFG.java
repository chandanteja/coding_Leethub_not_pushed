/**
 * 
 * https://www.youtube.com/watch?v=qrLUChzN1-w      --> refer this.
 * 
 * https://www.geeksforgeeks.org/snake-ladder-problem-2/
 * 
 * This is 2D BFS problem.
 * 
 * Here, we consider each cell as one node (directed) and every cell is connected to 6-adjacent cells (bcz dice max number is 6 only), if there is no snake or ladder.
 * If there is snake or ladder the every cell connects to 6-cells (bcz dice max number is 6 only) but all the cells need not be adjacent.
 * 
 * We push every cell into queue. Each cell has the index-number of that cell and number of hops to reach that cell from 1st cell.
 * Here cells are considered from 1st cell i.e 1st cell, 2nd cell... 
 * 
 * So first cell will be (1,0) --> index of 1st cell=1 and #hops to reach 1st cell from 1st cell =0.
 * We iterate till queue is empty.
 * 
 */
package Graphs;

import java.util.*;

// here we are considering 0-based indexing.
public class SnakesAndLadder_GFG {

    static class cell 
    {
        int index;     // Vertex number
        int hops;// Distance of this vertex from source
    }
  
    // This function returns minimum number of dice 
    // throws required to Reach last cell from 0'th cell 
    // in a snake and ladder game. move[] is an array of 
    // size N where N is no. of cells on board If there 
    // is no snake or ladder from cell i, then move[i] 
    // is -1 Otherwise move[i] contains cell to which 
    // snake or ladder at i takes to.
    static int getMinDiceThrows(int move[], int n) 
    {
        int visited[] = new int[n];
        Queue<cell> q = new LinkedList<>();
        cell qe = new cell();
        qe.index = 1;
        qe.hops = 0;
  
        // Mark the node 0 as visited and enqueue it.
        visited[0] = 1;
        q.add(qe);
  
        // Do a BFS starting from vertex at index 0
        while (!q.isEmpty()) 
        {
            qe = q.remove();
            int v = qe.index;
  
            // If front vertex is the destination 
            // vertex, we are done
            if (v == n - 1)
                break;
  
            // Otherwise dequeue the front vertex and 
            // enqueue its adjacent vertices (or cell 
            // numbers reachable through a dice throw)
            for (int j = v + 1; j <= (v + 6) && j < n; ++j) 
            {
                // If this cell is already visited, then ignore
                if (visited[j] == 0)
                {
                    // Otherwise calculate its distance and 
                    // mark it as visited
                    cell a = new cell();
                    a.hops = (qe.hops + 1);
                    visited[j] = 1;
  
                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'j'
                    if (move[j] != -1)
                        a.index = move[j];
                    else
                        a.index = j;
                    q.add(a);
                }
            }
        }
  
        // We reach here when 'qe' has last vertex
        // return the distance of vertex in 'qe'
        return qe.hops;
    }
  
    public static void main(String[] args) 
    {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;
  
        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;
  
        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
  
        System.out.println("Min Dice throws required is " +  getMinDiceThrows(moves, N));
    }
    
}
