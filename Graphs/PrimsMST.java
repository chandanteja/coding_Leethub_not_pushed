/**
 * https://www.youtube.com/watch?v=oP2-8ysT3QQ  --> see this why we need different mechanisms to have contains() and decreasekey() in O(logn)
 * https://www.youtube.com/watch?v=PzznKcMyu0Y&t=3s  --> for understanding the implementation of gfg.
 *  https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/ --> dont study this. This is not working for all cases.
 *      https://www.youtube.com/watch?v=Vw-sktU1zmc --> pep coding(watch this)
 *      https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/PrimMST.java
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/BinaryMinHeap.java
 * https://www.youtube.com/watch?v=agNQb6rme8U  ---> this is also good.
 * 
 * // This is heap based implementation of Prims
 */

package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class PrimsMST {

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        
        //actual intuition behind algo is while adding each vertex to MST
        //we need to decreaseKey the adjacent vertex distance if they're not 
        //processed yet and if we can get better distace using edge u-v
        // from all the vertices(assume we have 0, 1, 2 vertices in MST)in MST, we 
        //try to pick the min distance vertex from all the adjacent vertices of(0,1,2)
        // and include it in MST and so on
        
        //crux of prims -- from all the vertices that are in MST
        //search all the adjacent vertices of (already included vertices in MST), try to
        // include the min distance vertex. (i.e vertex that have min distace from any of
        // the already included vertices in MST)
        
        
        boolean visited[]=new boolean[V];//to keep track of already visited nodes
        //once the node is processed make visited[node] as true.
        int distance[]=new int[V]; //to save distance to a node from source vertex.
        for(int i=0;i<V;i++)        // Initially distance to all nodes will be INFINITY.
            distance[i]=Integer.MAX_VALUE;
            
        PriorityQueue<Node> min_heap= new PriorityQueue<Node>(new CustomComparator());
        //starting with vertex 0
        distance[0]=0;// dist from starting vertex to itself is 0
        min_heap.add(new Node(0, distance[0])); 

        for(int i=0;i<V;i++)//adding all the vertices to min_heap
            min_heap.add(new Node(i, distance[i])); //initially all distances are infinite
        
        
        
        while(min_heap.isEmpty()==false)
        {
            
            //we look at all the edges from vertex ‘u’ and try to do decreasekey on ‘v’.
            // if u-v is an edge, we compare the distance d[v] with edge weight w(u,v)
            // and update the distance to 'v' if we can get better distance
            //just decreasing the distance to reach the adjacent vertices of 'u'
            //so that in next iteration we pick the min edge to reach non visited vertices
            Node cur= min_heap.poll();
            int u= cur.v;   // the popped node will be the source node u.
            //we implement decreaseKey by just deleting the processed edge
            if(visited[u]==true)//vertex is already processed i.e included in MST set
                continue;
            
            visited[u]=true; //processing this edge.. i.e including in MST set
            distance[u]=cur.weight;
            //decreasing the distance to reach the adjacent vertices of 'u' if we get
            //any better distance.
            //each inner list contains edge information ( vertex, weight )
            
            ArrayList<ArrayList<Integer>> list= adj.get(u);
            for(ArrayList<Integer> edge: list)// looping over all edges of vertex u
            {
                int v= edge.get(0), weight=edge.get(1);
                //if distance[v] is greater the weight of edge
                if(visited[v]==false && distance[v]>weight) // the current dist of 'v' is > the dist of u-v edge. then we update it.
                {
                    distance[v]=weight; //updating distance of 'v'
                    min_heap.add(new Node(v, weight));
                }
                
            }
        } // end of while loop to pick edge(node, weight) from min_heap
        
        int total_cost=0;
        for(int cost: distance)
            total_cost+=cost;
            
        return total_cost;
        
    }//end of spanningTree method
}


//Node object & CustomComparator to give priority to min weight edge in Priority Queue 
class Node
{
    int v, weight;
    public Node(int v, int weight)
    {
        this.v=v;
        this.weight=weight;
    }
}
class CustomComparator implements Comparator<Node>
{
    public int compare(Node edge1, Node edge2)
    {
        if(edge1.weight < edge2.weight) //priority to min weight edge
            return -1;
        
        return 1;
    }

}

