
/**
 * https://www.youtube.com/watch?v=MtFPqCcsoeA  --> watch this video for bipartite graph test.
 */

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckBipartiteOrNot {

    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u,int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    
    public static boolean dfsBipartite(ArrayList<ArrayList<Integer>> graph,int node,int color,boolean visited[],int colorArr[])
    {
        visited[node] = true;
        colorArr[node] = color;

        for(int child:graph.get(node))  // here accessing arraylist of arraylist , bcz when we do graph.get() the o/p is array list but
        // for-each loop takes the array list and iterates inherently, so for iteration we need an index so we give it as 'int child'
        {
            if(!visited[child])
            {
                if(dfsBipartite(graph, child, color^1, visited, colorArr)==false) // color^1 means we are inverting the color that we are applying for adjacent node,and if dfs() returns false we also return false
                    return false;   // it means dfsBipartite() returned false as some of the nodes its adjacent nodes or some in its subgraph didnt satisfy the condition for bi-partite.So, they returned false to this and hence it returned false.
            }
            else 
            {
                if(colorArr[child]==colorArr[node])
                    return false;   // here we are checking, if child is visited (means above if() is false), we check if the child and its parent (node) is having same color.
                                    // if same color is there then its not bipartite.
            }
        }
        return true;    // means the graph is bipartite.

    }

    public static boolean checkBipartite(int n,ArrayList<ArrayList<Integer>> graph)
    {
            boolean visited[] = new boolean[n];
            int colorArr[]  = new int[n];   // keeps track of what color is applied to which node
            Arrays.fill(visited,false);
            Arrays.fill(colorArr,-1);
            
            // we color the first node with color-0. For bipartite graph, only 2 colors shuld be used. So, those 2 colors are 0,1.
            for(int i=0;i<n;i++)
            {
                if(!visited[i])
                {
                    // we color the starting vertex of any iteration/component with color-0
                    if(!dfsBipartite(graph, i, 0, visited, colorArr))
                        return false;   // if graph is not bipartite, we return false.
                }
            }
            return true;
    }

    public static void main(String args[])
    {
        int n=4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);
       // addEdge(graph, 3, 4);

        boolean result = checkBipartite(n, graph);

        if(result)
            System.out.println("Given graph is bipartite");
        else
        System.out.println("Given graph is not bipartite");
    }

    
    // THIS IS 2ND METHOD. THIS IS EASY. 
    // public boolean isBipartite(int[][] graph) {
        
    //     //   ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
          
    //      //  int n =graph1.size();
           
    //            boolean visited[] = new boolean[graph.length];
    //            int colorArr[]  = new int[graph.length];
    //            Arrays.fill(visited,false);
    //            Arrays.fill(colorArr,-1);     // -1 means nodes are uncolored.
    //         for(int i=0;i<graph.length;i++)
    //            {
    //                if(!visited[i])
    //                {
    //                   // System.out.println("Unvisited");
    //                    if(colorArr[i]==-1) // uncolored
   
    //                    {
    //                       //  System.out.println("uncolored");
    //                        if(!dfsBipartite(graph, i, 0, visited, colorArr))    // we give initial color as 0
    //                        {
    //                            System.out.println("came-here:"+i);
    //                            return false;   
    //                        }
    //                    }
    //                }
    //            }
    //            return true;
           
    //    }
       
    //    public boolean dfsBipartite(int[][] graph,int node,int color,boolean visited[],int colorArr[])
    //    {
    //        visited[node] = true;
    //        colorArr[node] = color;
       
    //        int adj[] = graph[node];
    //        for(int child:adj)
    //        {
    //            if(!visited[child])
    //            {
    //                if(dfsBipartite(graph, child, color^1, visited, colorArr)==false)
    //                {
    //                    System.out.println(" inside dfs child:"+child+"  node: "+node);
    //                    return false;  
    //                }
    //            }
    //            else 
    //            {
    //                if(colorArr[child]==colorArr[node])
    //                {
    //                     System.out.println("color check child:"+child+"  node: "+node);
    //                    return false;   
    //            }
    //            }
    //        }
    //        return true; 
    //    }



}
