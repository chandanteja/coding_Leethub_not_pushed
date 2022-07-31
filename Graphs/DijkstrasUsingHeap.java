/**
 * 
 * https://ide.geeksforgeeks.org/j1grK0wW9a  --> refer this.
 * 
 * Logic is same as PRIMs algo using heaps. Just 2-3 lines of modification needs to be done to prims algo.
 * 
 */

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
    int v;
    int dist;
    Node(int v,int dist)
    {
        this.v=v;
        this.dist=dist;
    }
}

class NodeComparator implements Comparator<Node>
{
    public int compare(Node n1,Node n2)
    {   // this is ordering for shortest elements to be retrieved first.
        if(n1.dist<n2.dist)
            return -1;
        if(n1.dist==n2.dist)
            return 0;
        return 1;
    }
}


public class DijkstrasUsingHeap {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dist[] = new int[V];    // to keep track of dist from source node to vertex-i.
        boolean visited[]  = new boolean[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        
        dist[S] = 0;    // the dist of src vertex to itself is 0.
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        pq.add(new Node(S,0));  // adding source vertex to heap
        
        while(!pq.isEmpty())
        {
            int u = pq.poll().v;
            
            if(visited[u] == true)
                continue;
            
            visited[u]  = true;
            // find neighbors of u.

        ArrayList<ArrayList<Integer>> list= adj.get(u);
        for(ArrayList<Integer> edge : list)
        {
            int v = edge.get(0);    // the other end point of node-u i.e adjacent of 'u'
            
            // dist[v] --> means dist to 'v' from source node.
            if(!visited[v] && dist[v] > dist[u]+edge.get(1))
            {
                
            
                dist[v] = dist[u]+edge.get(1);  // edge.get(1) --> wt of edge u-v
                
                pq.add(new Node(v,dist[v]));
                
            }
        }
        }
        
        return dist;
    }
    
}
