/**
 * https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 * 
 * https://www.youtube.com/watch?v=gc6ShDTldb4      --> watch this for solution.
 * 
 * This is application of Minimum spanning tree. We can solve this using prims+min-heap.
 * 
 * Here we create a graph as Houses as nodes and pipeline connections as edges b/w houses with weights.
 * 
 * As we also need to have cost of digging well at every house. So, for this cost to be maintained, we add a dummy node called Node-0, amd we connect all houses (nodes) with this dummy node.
 * 
 * The edge weights for connecting with dummy node will be the cost of digging well at respective house.
 * 
 * After forming graph, using prims, we find Minimum cost spanning tree. 
 * 
 */

package AugChallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
    int vtx;
    int wt;
    
    Node(int vtx,int wt)
    {
        this.vtx = vtx;
        this.wt = wt;
    }
}
public class OptimizeWaterDistributionToVilleges {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        // graph creation.
         // here we create graph with (n+1)nodes as the houses will be numbered from 1,2..n and we use the 0th node as dummy node
        for(int i=0;i<=n;i++)
        {
            graph.add(new ArrayList<>());
        }
        
        // adjacency list creation with nodes as houses and pipe connections as edges.
        for(int i=0;i<pipes.length;i++)
        {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];
            
            graph.get(u).add(new Node(v,wt));
            graph.get(v).add(new Node(u,wt));
        }
        
        // adding dummy node i.e node-0 to all other nodes.
        // edge weight for this node connections will be weight of digging well at respective node(house).
        // we start from i=1 bcz houeses are numbered from 1,2,..n
        for(int i=1;i<=n;i++)
        {
            graph.get(0).add(new Node(i,wells[i-1]));
            graph.get(i).add(new Node(0,wells[i-1]));
        }
        
        ////// Apply prims now on the above graph
        
        boolean visited[] = new boolean[n+1];   // to keep track of visited nodes.
        int minCost = 0;    //min cost of spanning tree.
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
           
            public int compare(Node edge1,Node edge2)
            {
                if(edge1.wt < edge2.wt)
                        return -1;
                return 1;
            }
            
        });
        
        // 0- is the source node. And it will be pushed into heap with cost of reaching source node from source node is 0.
        pq.add(new Node(0,0));
        
        
        while(!pq.isEmpty())
        {
            // pop the node and check if its visited or not
            Node curr = pq.poll();
          
            // if the node is visited already then continue.
            if(visited[curr.vtx]==true)
                continue;
            
            // add the popped node cost to min spanning tree cost.
            minCost += curr.wt;
            

            int u = curr.vtx;
            visited[u] = true;  // marking current node as visited.
            
            // taking neighbors of the popped node.
            ArrayList<Node> adj = graph.get(u);
            
            for(Node neighbr : adj)
            {
                // if the neighbor of popped node is not visited, then add to heap.
               if(visited[neighbr.vtx]==false)
               {
                   pq.add(neighbr);
                  
               }
            }
        }
        return minCost;
    }
    
}
