/**
 * 
 * 
 * https://leetcode.com/problems/number-of-provinces/
 * 
 * 
 * Approach #1 Using Depth First Search[Accepted]

 Algorithm
===============
The given matrix can be viewed as the Adjacency Matrix of a graph. By viewing the matrix in such a manner, our problem reduces to the problem of finding the number of connected components in an undirected graph. In order to understand the above statement, consider the example matrix below:
 * 
 * In order to find the number of connected components in an undirected graph, one of the simplest methods is to make use of Depth First Search starting from every node. We make use of visitedvisited array of size N(M is of size NxN). This visited[i] element is used to indicate that the ith node has already been visited while undergoing a Depth First Search from some node.

To undergo DFS, we pick up a node and visit all its directly connected nodes. But, as soon as we visit any of those nodes, we recursively apply the same process to them as well. Thus, we try to go as deeper into the levels of the graph as possible starting from a current node first, leaving the other direct neighbour nodes to be visited later on.

Thus, to find the number of connected components, we start from every node which isn't visited right now and apply DFS starting with it. We increment the countcount of connected components for every new starting node.

Time complexity : O(n^2) ,The complete matrix of size n^2 is traversed.

Space complexity : O(n). visited array of size n is used.
 */

package Amazonlist;

// This is same as number of connected components in 2D matrix.

public class NumOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
        int visited[]  = new int[n];
        int provinces=0;
        
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                dfs(isConnected,visited,i,n);
                provinces++;
                
            }
        }
       return provinces; 
    }
    
    void dfs(int[][] isConnected,int visited[],int node, int n)
    {
        visited[node] = 1;
        
        for(int j=0;j<n;j++)
        {
            if(visited[j]==0 && isConnected[node][j]==1)
                dfs(isConnected,visited,j,n);
        }
    }
    
}


/*

BFS based solution
====================

 public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }

*/
