/**
 *  https://www.youtube.com/watch?v=Rhxs4k6DyMM 
 *  https://www.geeksforgeeks.org/bridge-in-a-graph/
 *  https://www.youtube.com/watch?v=ECKTyseo2H8&t=875s
 * We shuld maintain discovery times, low-times and parent arrays.
 * low-time of a node tells which is the lowest discover time ancestor node of this node, which can be reached thru backedges.
 *  u____v is a bridge if, low[v] > disc[u] means ,either 'u' or ancestors of 'u' are not reachable thru backedge from 'v'. So, as no ancestor of 'u' or 'u',
 *  itself is reachable, the low[v] will be greater than disc[u]. So u____v is a bridge.
 * This is the logic we are going to apply.
 *  We apply dfs  to find bridges.
 */

package Graphs;

import java.util.*;

class Bridge {

    int u,v;
    Bridge(int u,int v)
    {
        this.u = u;
        this.v  = v;
    }
}

public class FindBridges {

    static int timer =0;
    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u,int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    public static void dfsBridges(ArrayList<ArrayList<Integer>> graph,int node, boolean visited[],int discovery[],int low[],int parent[],ArrayList<Bridge> bridges)
    {
        visited[node] = true;
        discovery[node] = low[node] = ++timer;

        for(int child:graph.get(node))
        {
            if(!visited[child])
            {
                parent[child] = node;   // setting the parent of child as node bcz child is adjacent to node and child was discovered from node itself.
                dfsBridges(graph, child, visited, discovery, low, parent, bridges);
                low[node] = Math.min(low[node], low[child]); // we are updating the low value of 'node' bcz, in the above call, dfs tries to find bridges in the sub graph rooted at 'child'
                // If there is a back edge to either 'node' or ancestor of 'node', then the low value of 'child' node will be updated with that value.
                // And as node___child is a link then 'node' can also reach that ancestor which is reachable using low of child.So, we are updating that.

                // If the lowest vertex reachable from subtree under v is below u in DFS tree, then u-v is a bridge
                if(low[child] > discovery[node])    // if the low of child is grater than discovery of 'node' and there is link node___child,
                // it means there is either no back-edge to ancestor of 'node'. So, the link node___child becomes bridge.
                {
                    bridges.add(new Bridge(node, child));
                }
            }
            else if(child!=parent[node])
            {   
                low[node] = Math.min(low[node], discovery[child]);
            }
        }
      
    }

    public static ArrayList<Bridge> findBridges(ArrayList<ArrayList<Integer>> graph,int n)
    {
        boolean visited[] = new boolean[n];
        int discovery[] = new int[n];
        int low[] = new int[n];
        int parent[] = new int[n];

        Arrays.fill(visited,false);
        Arrays.fill(discovery, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        
        ArrayList<Bridge> bridges = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
                dfsBridges(graph,i,visited,discovery,low,parent,bridges);
        }

return bridges;
    }

    public static void main(String args[])
    {
        int n= 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
            // addEdge(graph,1, 0);
            // addEdge(graph,0, 2);
            // addEdge(graph,2, 1);
            // addEdge(graph,0, 3);
            // addEdge(graph,3, 4);
            // ArrayList<Bridge> res = findBridges(graph, n);

            // for(Bridge i:res)
            // {
            //     System.out.println("Bridge is: "+i.u+ "  "+i.v);
            // }

            addEdge(graph,0, 1);
            addEdge(graph,1, 2);
            addEdge(graph,2, 3);
            ArrayList<Bridge> res = findBridges(graph, n);
            for(Bridge i:res)
            {
                System.out.println("Bridge is: "+i.u+ "  "+i.v);
            }
    }
}
