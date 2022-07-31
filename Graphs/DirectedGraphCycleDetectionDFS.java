/**
 * T.C : O(V+E)
 *  https://ide.geeksforgeeks.org/3sN2hN1Fx4
 *  watch gfg video in Complete interview prep course.
 * 
 * In directed graphs, there will be a cycle when there is a back-edge.
 * Back edge is an edge from an element to its ancestor which is still ACTIVE in recursion stack.
 * So, to track whether a node is still active in reccursion stack, we take an array to keep track of recursion stack elements which are still active.
 */
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectedGraphCycleDetectionDFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u, int v)
    {
            graph.get(u).add(v);  //directed graph
    }
   
    public static boolean dfsCycle(ArrayList<ArrayList<Integer>> adj,int s,boolean visited[],boolean recSt[])
    {
        visited[s]=true;
    	recSt[s]=true;

        for(int u:adj.get(s))
        {
            // logic is if we see an adjacent node which is  visited and present in recursion call stack of parent node then there is cycle.
            if(visited[u]==false && dfsCycle(adj,u,visited,recSt)==true)        // this means, if 'u' is not visited then only, we call dfsCycle() on 'u'.
            {      // We are checking if dfs() returns true bcz if any of its sub-graph has cycle, that will return true and this also shudl return true.
                //if a node is not visited then function is called and if its visited then not called and checked for if this node is present in call stack of parent.
                return true;
            }
            else if(recSt[u]==true) // 'u' is visited but 'u' is still active in recursion stack it means there is a backedge.
            {
                return true;
            }
        }
        recSt[s]=false;     // after an element has explored all its descendants, it will be removed from stack. hence we marked it as false i.e not active.
        return false;
    }
    

public static boolean dfsCycleUtil(ArrayList<ArrayList<Integer>> graph, int vertices)
{
        boolean visited[] = new boolean[vertices];
        boolean recStackActive[] = new boolean[vertices];   // used to track active elements in recursion stack. if there is a back edge to an active element in stack then its cycle.
       
        Arrays.fill(visited,false);
        Arrays.fill(recStackActive,false);

        for(int i=0;i<vertices;i++)     // this loop covers the disconnected graphs case also as,if any node is not reached then its visited will be false and hence it will be visited .
        {
            if(visited[i] == false)
                if(dfsCycle(graph,i,visited,recStackActive))
                    return true;
        }
        return false;

}

public static void main(String args[])
    {
        int vertices=4;
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<vertices;i++)
            graph.add(new ArrayList<>());

            addEdge(graph,0, 1);
            addEdge(graph,0, 2);
            addEdge(graph,1, 2);
            addEdge(graph,2, 0);
            addEdge(graph,2, 3);
            addEdge(graph,3, 3);

            System.out.println("Cycle is present: "+ dfsCycleUtil(graph,vertices));
        
    }
    


}
