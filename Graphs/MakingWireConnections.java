/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/
 * We need to connect all the system by extracting some redundant wires and connect unconnected system.
 * This is same as connected components using DFS.
 * If number of connected components = n then we need atleast (n-1) edges/cables to connect all components.
 *  if the given cables are not sufficient then we need to return saying we can't connect. This is when if number of cables are lessthan  number of systems-1
 *  if number of cables are lessthan number os system-1 then we cant connect all systems.
 */
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MakingWireConnections {

    public static void dfs(ArrayList<ArrayList<Integer>> graph,int i,boolean visited[])
    {
        visited[i] = true;
        Iterator<Integer> itr = graph.get(i).iterator();

        while(itr.hasNext())
        {
            int temp = itr.next();
            if(!visited[temp])
                dfs(graph,temp,visited);
        }

    }

    // n--> number of systems and connections--> Initial connections between systems.
    public static int minConnections(int n, int[][] connections)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        for(int i=0;i<n;i++)
          graph.add(new ArrayList<Integer>());

        boolean visited[]= new boolean[n];
        Arrays.fill(visited,false);
        int connectedComponents = 0;

        for(int i=0;i<connections.length;i++)
        {
            // creation of undirected graph out of given connections with adjacencies.
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }

        if(connections.length<n-1)  // if the number of cables/connections are < n-1 (n-systems). Then we can connect at all.
                return -1;

                for(int i=0;i<n;i++)
                {
                    if(!visited[i])
                    {
                            connectedComponents++;      // keeping track of connected components.
                            dfs(graph,i,visited);
                    }
                }
                
                return connectedComponents-1;   // number of extractions needed is number of connected components-1.
    }
    public static void main(String[] args) {
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
		System.out.println("Min connections needed is: "+minConnections(6,connections));

	}
    
}
