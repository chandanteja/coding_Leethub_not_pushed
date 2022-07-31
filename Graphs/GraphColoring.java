
/**
 * https://www.youtube.com/watch?v=h9M0pQ39ha0  --> watch this video for clear explaination.
 * https://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/
 * Logic is:
 *     1. We maintain an array of what is the color applied using resultant color[] and list of available colors for a node using available[]
 *     1.1   We apply color-0 to the start node.
 *     2. First we will check the colors of adjacent nodes of a node and make those colors as unavailable.
 *     3. After making those colors as unavailable, now get the color which is available for coloring.
 *     4. After getting the color to be applied, we update the resultant color[] and free up the unavailable colors for next iteration.
 * 
 */

package Graphs;

import java.util.*;

public class GraphColoring {

    public static void addEdge(LinkedList<Integer> graph[],int u, int v)
    {
            graph[u].add(v); 
            graph[v].add(u);
    }

    public static int[] colorGraph(LinkedList<Integer> graph[],int n)
    {
        int resultantColor[] = new int[n];      // this array keeps track of what are the final colors assigned to the node at index-i.
        Arrays.fill(resultantColor,-1);     // colors will be from 0 to n-1 but -1 means no color is yet assigned to the node
         // this also tells what are the unavailable colors, which means these colors are used on the neighboring nodes.
        
         boolean available[] = new boolean[n];       // this array keeps track of what all colors are available for a node at any point of time.
        Arrays.fill(available,true);        // true means the color is available and false means not available.

        resultantColor[0] = 0;  // we color initial vertex with color-0

        // now assign ccolors to remaining vertices
        for(int i=1;i<n;i++)
        {
            // process all the adjacent vertices and update their colors
            Iterator<Integer> itr = graph[i].iterator();
            while(itr.hasNext())
            {
                int adj = itr.next();
                if(resultantColor[adj]!=-1) // means the node is colored. so now make the color with which the node colored as unavailable
                {
                    available[resultantColor[adj]]  = false;   
                }
            }

            // picking the next available color to color the node-i
            int color=0;
            for(;color<n;color++)
            {
                if(available[color]==true)  // means the color is available.
                    break;
            }
            resultantColor[i] = color;      // coloring the node-i with the found color which is not assigned to neighboring nodes..
            Arrays.fill(available, true);       // VVV IMP step.  for next iteration, we are making all colors available.

        }

        return resultantColor;
    }

    public static void main(String args[])
    {
        int n=5;
        @SuppressWarnings("unchecked")LinkedList<Integer> graph[] =  new LinkedList[n];

        for(int i=0;i<n;i++)
        {
            graph[i]= new LinkedList<>();
        }


        // addEdge(graph,0, 1);
        // addEdge(graph,0, 2);
        // addEdge(graph,1, 2);
        // addEdge(graph,1, 3);
        // addEdge(graph,2, 3);
        // addEdge(graph,3, 4);

        // System.out.println("Coloring of graph 1");
        // int res[] = colorGraph(graph, n);
        // for(int i=0;i<n;i++)
        //     System.out.print(res[i] + " ");
 
        System.out.println();
       
        addEdge(graph,0, 1);
        addEdge(graph,0, 2);
        addEdge(graph,1, 2);
        addEdge(graph,1, 4);
        addEdge(graph,2, 4);
        addEdge(graph,4, 3);
        System.out.println("Coloring of graph 2 ");
        int res[] = colorGraph(graph, n);
        for(int i=0;i<n;i++)
            System.out.print(res[i] + " ");

    }
    
}
