/**
 *  https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {
    public static void createGraph(LinkedList<Integer> graph[] ,int u,int v)
    {
        // This is directed graph creation.
        // For undirected graph, add also    graph.get(v).add(u);
        //graph.get(u).add(v);
        graph[u].add(v);
        
    }
    public static void printGraph(LinkedList<Integer> graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            System.out.println("Adj List of node "+i+": ");
            System.out.print(i);
            for(int j=0;j<graph[i].size();j++)
                System.out.println("-->"+graph[i].get(j));
            System.out.println();
        }
    }

    // we store graph in form of Array of Linkedlists.
    public static ArrayList<Integer> bfs(LinkedList<Integer> graph[], int n,int start)
    {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();    // output of bfs traversal
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);    // filling all values of array with 0.
        Queue<Integer> q = new LinkedList<>();
        
        visited[start] = true;
        q.add(start);   // pushed the root ele
        while(!q.isEmpty())
        {
            int node = q.peek();
            q.poll();
            bfsTraversal.add(node);     // adding to traversal list as this node is traversed.
            
            Iterator<Integer> itr = graph[node].iterator();     // iterating for adjacent nodes of the popped node.
            while(itr.hasNext())
            {
                int p = itr.next(); 
                    if(!visited[p])     // if not visited any adjacent node of popped node, push to queue.
                    {
                        visited[p] = true;
                        q.add(p);
                    }
            }

        }

        return bfsTraversal;
    }

    public static void main(String args[])
    {
        int vertices = 4;
        @SuppressWarnings("unchecked") LinkedList<Integer> graph[] = new LinkedList[vertices];

        for(int i=0;i<vertices;i++)
            graph[i] = new LinkedList<>();
        
        createGraph(graph, 0, 1);
        createGraph(graph, 0, 2);
        createGraph(graph, 1, 2);
        createGraph(graph, 2, 0);
        createGraph(graph, 2, 3);
        createGraph(graph, 3, 3);

        ArrayList<Integer> res = bfs(graph, vertices, 2);
        Iterator<Integer> itr = res.iterator();

        while(itr.hasNext())
            {
                System.out.print(itr.next() + " ");
            }
        

    }
}
