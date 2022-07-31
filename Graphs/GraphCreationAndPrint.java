/**
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * 
 */
package Graphs;

import java.util.ArrayList;

public class GraphCreationAndPrint{

    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u,int v)
    {
        // This is undirected graph.
        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    public static void printGraph(ArrayList<ArrayList<Integer>> graph)
    {
        for(int i=0;i<graph.size();i++)
        {
            System.out.println("\nAdjacency list of vertex: " + i);
            System.out.print(i);
            for(int j=0;j<graph.get(i).size();j++)
                System.out.print("-->"+graph.get(i).get(j));
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int v = 5;  // number of vertices.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            graph.add(row);
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        printGraph(graph);
        
        
    }


}