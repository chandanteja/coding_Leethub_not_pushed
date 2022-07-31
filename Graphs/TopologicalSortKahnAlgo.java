
/**
 * https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 * Kahn's Algo for topological sorting. This is based on BFS.
 * 
 * First create a graph out of given prerequisites.
 * Logic: First calculate indegree for all nodes in graph and store in an array
 *        Now push all node with indegree=0 to queue.
 *        Pop an element from queue and using this index into graph and decrease the count of indegree of all the nodes connected to popped node by 1.
 *        After decreasing indegree if any node becomes indegree=0 push into queue.
 *        also track using a counter the number of popped ele, and if this count is not equals to the number of vertices, then there is cycle.
 *          
 *        To return empty array in Java do as "new int[0]", returns empty array of type int.
 */

package Graphs;

import java.util.*;

public class TopologicalSortKahnAlgo {

    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u, int v)
    {
            graph.get(u).add(v);  //directed graph
    }


    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> graph)
    {
        int indegree[] = new int[graph.size()];
        Arrays.fill(indegree,0);    
        Queue<Integer> q = new LinkedList<>();
        int cnt=0;


        for(int i=0;i<graph.size();i++)
        {
            ArrayList<Integer> temp = graph.get(i);
            for(int node : temp)
            {
                indegree[node]++;
            }
        }

        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty())
        {
            int node = q.poll();
            res.add(node);

            for(int i:graph.get(node))
            {
                if(--indegree[i]==0)
                    q.add(i);

            }
            cnt++;
        }

        if (cnt != graph.size()) 
        {
            System.out.println( "There exists a cycle in the graph");
            return null;
        }
        return res;

    }

    public static void main(String args[])
    {
        int vertices=6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<vertices;i++)
            graph.add(new ArrayList<>());

            addEdge(graph,5, 2);
            addEdge(graph,5, 0);
            addEdge(graph,4, 0);
            addEdge(graph,4, 1);
            addEdge(graph,2, 3);
            addEdge(graph,3, 1);

           ArrayList<Integer> res= topologicalSort(graph);
        
            Iterator<Integer> itr =  res.iterator();
            while(itr.hasNext())
            {
                System.out.print(itr.next() + " ");
            }
    }
    
}
