/**
 * https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/
 * https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 * Disconnected case is not handled. Need to handle disconnected graphs case.
 * To handle disconnected case, while calling for cycle check method, maintain a visited array at calling place and run a loop to check while calling 
 * if all the nodes are set to true or not and if any node is not visited, means that node was no reachable in previous call. So now check the cycle,
 * from that unvisited node by sending it to cycle check method.
 * 
 */

package Graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


// if we just go by visited of adjacent nodes, we will report cycle for even 2-nodes bcz both are adjacent to each other. 
//so we need to maintain a parent array and if we visited parent only from current node then its not cycle, else if we visit other nodes, its cycle.
public class CycleInUndirectedGraphBFS {

    public static void createGraph(LinkedList<Integer> graph[] ,int u,int v)
    {
        
        graph[u].add(v);
        graph[v].add(u);
        
    }
    
    public static boolean bfsCycle(LinkedList<Integer> graph[],int v)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        int parent[] = new int[graph.length];       // parent array keeps track of parent of each node.
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);
        q.add(v);
        visited[v] = true;      // visiting the first pushed node.
        while(!q.isEmpty())
        {
            int ele = q.poll();
           
           
            Iterator<Integer> itr = graph[ele].iterator();
            while(itr.hasNext())
            {
                int temp = itr.next();
                if(!visited[temp])          // if a node is not visited then only, visiting it and adding to queue.
                {
                    visited[ele] = true;
                    q.add(temp);
                    parent[temp] = ele;     // setting parent of node.
                }
                // checking if adjacent node(temp) is parent or not of (ele.) node
                else if(parent[ele]!=temp)     // the logic here is , if a 2-nodes have a same parent and if those 2 nodes (not parent) are also connected, then there will be a cycle.
                        return  true;          // it means if there is an adjacent node which is visited but its not parent then it forms cycle.
               

            }
        }
        return false;
    }

    public static void main(String args[])
    {
        int vertices = 5;
        @SuppressWarnings("unchecked") LinkedList<Integer> graph[] = new LinkedList[vertices];

        for(int i=0;i<vertices;i++)
            graph[i] = new LinkedList<>();
        
        createGraph(graph, 0, 1);
        createGraph(graph, 0, 2);
        createGraph(graph, 2, 1);
        createGraph(graph, 0, 3);
        createGraph(graph, 3, 4);
       
        System.out.println("Cycle in graph is: "+ bfsCycle(graph,0));
        

    }

}
