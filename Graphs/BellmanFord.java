/**
 * This is implementation of bellmanford algo and also this can be used to find if there exists a negative cycle in directed graph or not.
 * https://www.youtube.com/watch?v=YbbGemzQ5ok --> watch this video.
 * 
 * https://www.geeksforgeeks.org/detect-negative-cycle-graph-bellman-ford/  --> refer this.
 * 
 * T.C : O(V.E)
 * 
 * 
 */

package Graphs;

import java.util.Arrays;

public class BellmanFord {

    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int dist[] = new int[n];
        int e = edges.length;
        
        // Step 1: Initialize distances from src to all other vertices as INFINITE
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] =0;

        // Step 2: Relax all edges |V| - 1 times.
        // A simple shortest path from src to any
        // other vertex can have at-most |V| - 1
        // edges
        
        // for all vertices (n-1 vertices only considered)
        for(int i=1;i<n;i++)
        {
            // for all edges
            for(int j=0;j<e;j++)    // this iterates for all edges in graph.
            {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                
                // dist[u] --> dist from source node to u
                // dist[v] --> dist from source node to v
                // so from source node to u i.e dist[u] shuld not be INFINITY
                if(dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + wt)        // wt --> dist from u to v.
                    dist[v] = dist[u] + wt;
            }
            
        }

        // Step 3: check for negative-weight cycles.
        // The above step guarantees shortest distances
        // if graph doesn't contain negative weight cycle.
        // If we get a shorter path again now, then there
        // is a negative-wt cycle.
         for (int i = 0; i < e; i++) 
         {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            if (dist[u] != Integer.MAX_VALUE &&  dist[v]> dist[u] + weight )
                return 1;
        }
        return 0;
    }
    
}
