/**
 * This is topological sort based on DFS + finish times.
 * In dfs, after node is visited and finish time is set, add that node to a list.
 * sort the list in the order of finishing times, i.e highest finish time first.
 * Process is same as DFS but after finish times are set then add the node to final topological sort list and then order the nodes as per,
 * finish times in descending order of times.
 *  This is missing some cases. Follow Kahn's algo for topo sort
 */
package Graphs;

import java.util.*;

public class TopologicalSortDFS {
    static int count=0;
    static ArrayList<Integer> topologicalSort = new ArrayList<>();

    public static void addEdge(LinkedList<Integer> graph[],int u, int v)
    {
            graph[u].add(v);  //directed graph
    }


    public static void dfs(LinkedList<Integer>graph[],int i,boolean visited[],int discovery[],int finish[],int predecessor[])
    {
        visited[i] = true;
        discovery[i] = count++;
        Iterator<Integer> itr = graph[i].iterator();
        while(itr.hasNext())
        {
            int ele = itr.next();
            if(!visited[ele])
            {
                predecessor[ele] = i;
                dfs(graph,ele,visited,discovery,finish,predecessor);
            }

        }
        finish[i] = count++;
        topologicalSort.add(i);     // adding the node to final list after finish time is set bcz node is completely explored.
    
    }

    public static void dfsUtil(LinkedList<Integer>graph[])
    {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        int discovery[] = new int[n];
        int finish[] = new int[n];
        int predecessor[] = new int[n];
        Arrays.fill(visited,false);
        Arrays.fill(discovery, 0);
        Arrays.fill(finish, 0);
        Arrays.fill(predecessor, -2);
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
                {
                    predecessor[i] = -1;
                    dfs(graph, i, visited, discovery, finish, predecessor);
                }
        }
    }

    public static void main(String args[])
    {
        int vertices=2;
        @SuppressWarnings("unchecked")LinkedList<Integer> graph[] = new LinkedList[vertices];
        
        for(int i=0;i<vertices;i++)
            graph[i] = new LinkedList<>();

            // addEdge(graph,5, 2);
            // addEdge(graph,5, 0);
            // addEdge(graph,4, 0);
            // addEdge(graph,4, 1);
            // addEdge(graph,2, 3);
            // addEdge(graph,3, 1);

            addEdge(graph, 0, 1);
            addEdge(graph, 1, 0);

             dfsUtil(graph);
             Collections.reverse(topologicalSort);
            Iterator<Integer> itr =  topologicalSort.iterator();
            while(itr.hasNext())
            {
                System.out.print(itr.next() + " ");
            }
    }
    
}
