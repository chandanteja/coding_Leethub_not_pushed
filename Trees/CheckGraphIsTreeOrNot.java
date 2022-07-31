/**
 * https://www.geeksforgeeks.org/check-given-graph-tree/#:~:text=Since%20the%20graph%20is%20undirected,graph%20is%20connected%2C%20otherwise%20not.
 * 
 * Logic is Tree is Acyclic graph.
 * So if there are n-vertices and n-1 edges then graph is tree as there won't be any cycle. If there are more than n-1 edges then there will be cycle.
 * So, using either DFS/BFS check for cycle existence.
 * Also the graph is tree only if graph is connected. SO, check for connectivity also.
 * 
 */

package Trees;

import java.util.*;

public class CheckGraphIsTreeOrNot {

   static int numVertices;
   static LinkedList<Integer> adj[];

   static void addEdge(int v,int w) 
   { 
       adj[v].add(w); 
       adj[w].add(v); 
   } 

   public static boolean checkCycle(int node, boolean visited[],int parent)
   {
       visited[node] = true;
       for(int i: adj[node])
       {
           if(!visited[i])
           {
               // if there is a cycle in the subtree/subgraph then that part returns true to caller function. So, it   also shuld return true.
                if(checkCycle(i, visited, node)!=false)   // bcz i came from 'node' itself, so parent of 'i' is node
                    return true; 
           }
            else if(i!=parent)
                return true;
       }
       return false;
   }

   public static boolean isTree()
   {
       boolean visited[] = new boolean[numVertices];
       Arrays.fill(visited,false);

       if(checkCycle(0, visited, -1))
            return false;
        for(int i=0;i<numVertices;i++)
        {
            if(!visited[i])
                return false;
        }
        return true;
   }

   @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        numVertices=5;

        adj = new LinkedList[numVertices];
        for(int i=0;i<numVertices;i++)
            adj[i]=new LinkedList<>();
       
        // addEdge(1, 0); 
        // addEdge(0, 2); 
        // addEdge(0, 3); 
        // addEdge(3, 4); 
        // if (isTree()) 
        //     System.out.println("Graph is Tree"); 
        // else
        //     System.out.println("Graph is not Tree"); 
  
      
        addEdge(1, 0); 
        addEdge(0, 2); 
        addEdge(2, 1); 
        addEdge(0, 3); 
        addEdge(3, 4); 
  
        if (isTree()) 
            System.out.println("Graph is Tree"); 
        else
            System.out.println("Graph is not Tree"); 

    }

}
