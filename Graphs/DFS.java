/**
 *  This is recursive solution.. For recursive solution,, follow Murali sir slides or cormen text.
 * https://www.geeksforgeeks.org/iterative-depth-first-traversal/  --> dfs iterative
 */

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    public static void addEdge(LinkedList<Integer> graph[],int u, int v)
    {
            graph[u].add(v);  //directed graph
    }

public static void dfs(LinkedList<Integer> graph[],int v,boolean visited[],int predecessor[],ArrayList<Integer> res )
{
    visited[v] = true;      // it means when we come here into this function with a node, it means we have visited that node.
     // we can put discovery time here as disc[v] = count++;
    res.add(v);
    Iterator<Integer> itr = graph[v].iterator();
    while(itr.hasNext())
    {
        int ele = itr.next();
        if(visited[ele]==false)
        {
            predecessor[ele] = v;
            dfs(graph,ele,visited,predecessor,res);
        }
        
    }
    // here we can put finish time as finish[u] = count++;
     
}


public static ArrayList<Integer> dfsVisit(LinkedList<Integer> graph[],int v, int vertices)
{
    boolean visited[] = new boolean[vertices];
    Arrays.fill(visited, false);
    int predecessor [] = new int[vertices];
    Arrays.fill(predecessor,-2);
    ArrayList<Integer> res = new ArrayList<>();
    for(int i=0;i<vertices;i++)
    {
        if(visited[i] == false)     // this also handles disconnected graphs case.
        {
            predecessor[i] = -1;  // as this is the first node before calling dfs it means it is the root node. So, it will be -1
            dfs(graph,v,visited,predecessor,res);
        }
    }
    return res;

}
    public static void main(String args[])
    {
        int vertices=4;
        @SuppressWarnings("unchecked")LinkedList<Integer> graph[] = new LinkedList[vertices];
        
        for(int i=0;i<vertices;i++)
            graph[i] = new LinkedList<>();

            addEdge(graph,0, 1);
            addEdge(graph,0, 2);
            addEdge(graph,1, 2);
            addEdge(graph,2, 0);
            addEdge(graph,2, 3);
            addEdge(graph,3, 3);

            ArrayList<Integer> res= dfsVisit(graph,2,vertices);
            Iterator<Integer> itr = res.iterator();
            while(itr.hasNext()){
                System.out.print(itr.next() + " ");
            }
        
    }
    
}
