/**     This is adj matrix implementation
 *  
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/  --> adj matrix
 * 
 *  Logic: we maintain 2 arrays, one to maintain distance from source to every other vertex and other is visited, which tells what all nodes are visited and the distances of those are finalized.
 *  distance[i] --> means shortest distance from source vertex to node -i.
 * If a vertex is visited then it is included in Spanning tree.
 * we initilalize distance with INT_MAX value and visited with false. For source node we change distance to 0.
 * Now, we find shortest paths for all nodes in graph. To do so, we do as below.
 *  1. we find among all un visited verices, the node with shortest distance and we take its index, let this be 'u'
 *  2. we take all the adjacent and unvisited nodes  of the node-u we got in step-1.
 *  3. We also we check that the distance of NODE-u,we got in step-1 is not INT_MAX value, this tells that the node is visited  and we check the distance to adj vertices of 'u', and check if we get less distane if travelled thru node-'u'
 *  4. If we get direct distance of adjacent node of 'u' is morethan the distance thru adj node-u, we modify the distance of adjacent node of 'u'.
 */
package Graphs;

public class DijkstrasAdjMatrix {

    public static int minDistanceNode(boolean visited[],int distance[],int n)
    {
        int minDist = Integer.MAX_VALUE;
        int mindDistIndex=-1;
        for(int i=0;i<n;i++)
        {
            if(!visited[i]&& distance[i]<=minDist)  // we consider only unvisited nodes.
            {
                minDist = distance[i];      // here we find minimum distance node and its index.
                mindDistIndex = i;
            }
        }
        return mindDistIndex;
    }

public static int[] dijkstraShortestPath(int [][]graph,int n, int source)
{
    int distance[] = new int[n];    // The output array. dist[i] will hold
    // the shortest distance from src to i

    // visited[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
    boolean visited[] = new boolean[n];

    // initialization.// Initialize all distances as INFINITE and visited[] as false
    for(int i=0;i<n;i++)
    {
        distance[i] = Integer.MAX_VALUE;
        visited[i] = false;
    }
    distance[source] = 0;   // distance from soure to itself will be 0.

    // now check shortest paths for all nodes from source

    for(int i=1;i<n;i++)
    {
        // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
        int u = minDistanceNode(visited, distance, n);
        visited[u] = true;      // we mark the minimum distance node we got as visited.It means we are freezing the distance of the node as the shortest distance from source

        // Update dist value of the adjacent vertices of the
            // picked vertex.
        for(int v=0;v<n;v++)
        {
            // Update dist[v] only if is not in visited[], there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
            if(!visited[v]&& graph[u][v]!=0 && distance[u]!=Integer.MAX_VALUE && 
                distance[v]> distance[u]+graph[u][v])       //distance[u] == Integer.MAX_VALUE means that node is not yet visited itself. So, we can't process its neighbors. 
                                                            //if dist[u] != integer.max_value then 'u' is processed.
                {
                    distance[v] =   distance[u] + graph[u][v];
                }
        }
    }
    return distance;
}
public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        int n=9;
        int dist[]=dijkstraShortestPath(graph, n,0);    // source vertex =0

       for(int i=0;i<dist.length;i++)
       {
           System.out.println("verex : "+i+"  Dist: "+dist[i]);
       }

    }
    
}
