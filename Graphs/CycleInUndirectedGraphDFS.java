/**
 * Watch GFG CIP video for DFS based soln.
 * Logic:  if we just go by visited of adjacent nodes, we will report cycle for even 2-nodes bcz both are adjacent to each other.
 * so we need to maintain a parent variable and if we visited parent only from current node then its not cycle, else if we visit other nodes, its cycle. 
 */

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CycleInUndirectedGraphDFS {

    public static boolean dfsCycle(ArrayList<ArrayList<Integer>> adj,int i,boolean visited[],int parent)
    {
        visited[i]= true;
        Iterator<Integer> itr = adj.get(i).iterator();
        while(itr.hasNext())
        {
            int ele = itr.next();
          
            if(!visited[ele])   // if an element is not visited, then we will visit that element by calling function, if the function returns true, we return true as there can be cycle some where in function call.               if(dfsCycle(adj, ele, visited, i) == true)
                if(dfsCycle(adj, ele, visited, i)== true)        
                    return true;

            else if(parent!=ele)    // we set parent value of any node when its called first  time when its still not visited.
                // if parent of node is other than calling element then its cycle. We return true.
                    return true;
        }
        return false;   
        
    }

    public static boolean dfsCycleUtil(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[] =  new boolean[V];
        Arrays.fill(visited,false);
        int parent = -1;    // for initial node parent will be -1.

        for(int i=0;i<V;i++)
        {
            if(visited[i] == false)
                if(dfsCycle(adj,i,visited,parent)==true)
                    return true;
        }
        return false;
    }
    
}
