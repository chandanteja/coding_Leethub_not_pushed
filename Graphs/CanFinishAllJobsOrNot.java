/**
 * https://www.geeksforgeeks.org/find-whether-it-is-possible-to-finish-all-tasks-or-not-from-given-dependencies/
 * Since pair is inconvenient for the implementation of graph algorithms, we first transform it to a graph.
 * Idea is to transform the jobs and theri dependencies to a Directed graph and check if it is possible to find cycle or not
 */
package Graphs;

import java.util.*;

public class CanFinishAllJobsOrNot {

     // class to store dependencies as a pair
     static class pair{
        int first, second;
         
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static boolean dfsDirectedCycleDetection(ArrayList<ArrayList<Integer>> graph,int i, boolean visited[],boolean recStack[])
    {
        visited[i] = true;
        recStack[i] = true;

        for(int u: graph.get(i))
        {
            if(visited[u]==false && dfsDirectedCycleDetection(graph, u, visited, recStack)== true) // We are checking if dfs() returns true bcz if any of its sub-graph has cycle, that will return true and this also shudl return true.
                    return true;    // cycle there.
            else if(recStack[u] == true)
                return true;    // cycle there
        }
        recStack[i] = false;
        return false;       // no cycle

    }

    public static boolean canFinish(int numTasks, Vector<pair> jobs)
    {
        // We get i/p as form of vector, now transform it to a graph.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numTasks;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<jobs.size();i++)
        {
            pair p = jobs.get(i);       // first we are fetching the pair
            graph.get(p.second).add(p.first);   // we are adding first element as dependent on 2nd element as per GFG link
        }

        boolean visited[] = new boolean[numTasks];
        boolean recStack[] = new boolean[numTasks];
        Arrays.fill(visited,false);
        Arrays.fill(recStack, false);

        for(int i=0;i<numTasks;i++)
        {
            if(!visited[i])
            {
                if(dfsDirectedCycleDetection(graph,i,visited,recStack)) // if dfs() returns true it means cycle is there, so return false as we cant complete all jobs
                    return false;
            }
        }
    return true;    // means dfs() returned false.
}

public static void main(String args[])
{
    int numTasks = 4;
 
    Vector<pair> prerequisites = new Vector<pair>();;
 
    // for prerequisites: [[1, 0], [2, 1], [3, 2]]
 
    // prerequisites.add(new pair(1, 0));
    // prerequisites.add(new pair(2, 1));
    // prerequisites.add(new pair(3, 2));

    // for prerequisites: [[1, 0], [0, 1]]
    prerequisites.add(new pair(1, 0));
     prerequisites.add(new pair(0, 1));
     
    if (canFinish(numTasks, prerequisites)) {
        System.out.println("Possible to finish all tasks");
    }
    else {
        System.out.println("Impossible to finish all tasks");
    }
}

    
}
