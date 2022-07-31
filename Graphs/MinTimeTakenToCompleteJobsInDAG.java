/**
 * https://www.geeksforgeeks.org/minimum-time-taken-by-each-job-to-be-completed-given-by-a-directed-acyclic-graph/
 * Logic: Use Kaahn's algo for topological sort. In kahns algo after finding the indegrees, we push the nodes with indegree=0 to queue.
 *  While pushing, increment the timer for those nodes whose indegree=0 bcz these jobs can be started off independently.
 *  Now pop the elements from queue after poping eacch element, we will decrement the indegree of its adjacent nodes. Now while, decrementing indegree,
 *  also make sure that we push the nodes whose indegree becomes 0 and also set the time of completion for these nodes whose indegree is decreased,
 *  to time of its parent node +1.
 */

package Graphs;

import java.util.*;

public class MinTimeTakenToCompleteJobsInDAG {
    
    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u, int v)
    {
            graph.get(u).add(v);  //directed graph
    }

    public static int[] minTimeForJobsInDAG(ArrayList<ArrayList<Integer>> graph,int n)
    {
        int indegree[] = new int[n];
        int finishTimes[] = new int[n];
        // calculating indegree of nodes.
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> temp = graph.get(i);
            for(int node:temp)
            {
                indegree[node]++;
            }
        } 

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
                if(indegree[i]==0)
                {
                    q.add(i);
                    finishTimes[i] = 1;
                }        
        }

        while(!q.isEmpty())
        {
            int ele = q.poll();

            for(int i: graph.get(ele))
            {
                if(--indegree[i] == 0)
                {
                    q.add(i);
                    finishTimes[i] = finishTimes[ele] +1;
                }
            }
        }
        return finishTimes;
    }

    public static void main(String[] args)
{
     
    // Given Nodes N and edges M
    int n, m;
    n = 10;
    m = 13;
     ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
    for(int i = 0; i < n; i++)
        graph.add( new ArrayList<>());
         
    // Given directed edges of graph
    addEdge(graph,0, 2);
    addEdge(graph,0, 3);
    addEdge(graph,0, 4);
    addEdge(graph,1, 2);
    addEdge(graph,1, 7);
    addEdge(graph,1, 8);
    addEdge(graph,2, 5);
    addEdge(graph,3, 5);
    addEdge(graph,3, 7);
    addEdge(graph,4, 7);
    addEdge(graph,5, 6);
    addEdge(graph,6, 7);
    addEdge(graph,7, 9);
 
   int res[] = minTimeForJobsInDAG(graph,n);

   for(int i=0;i<res.length;i++)
   {
       //System.out.print("Job: "+i);
       System.out.print(res[i]+ " ");
   }

}

}
