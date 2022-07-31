
/**
 * https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 * 
 * https://leetcode.com/problems/course-schedule/
 * 
 * Kahn's Algo for topological sorting. This is based on BFS.
 * 
 * First create a graph out of given prerequisites.
 * Logic: First calculate indegree for all nodes in graph and store in an array
 *        Now push all node with indegree=0 to queue.
 *        Pop an element from queue and using this index into graph and decrease the count of indegree of all the nodes connected to popped node by 1.
 *        After decreasing indegree if any node becomes indegree=0 push into queue.
 *        also track using a counter the number of popped ele, and if this count is not equals to the number of vertices, then there is cycle.
 *          
 *        To return empty array in Java do as "new int[0]", returns empty array of type int.
 */

package Amazonlist;

import java.util.*;

public class TopologicalSortKahnAlgo {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
                graph.add( new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++)
        {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
            
        return kahnsTopoSort(numCourses,graph);
        
        
    }
    
    public boolean kahnsTopoSort(int n,ArrayList<ArrayList<Integer>> graph)
    {
        int indegree[] = new int[n];
        
        for(int i=0;i<n;i++)
        {
           for(int node : graph.get(i))
                indegree[node]++;
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        
        int cnt=0;
        while(!q.isEmpty())
        {
          int temp = q.poll();
          
            for(int ele : graph.get(temp))
            {
                if(--indegree[ele]==0)
                    q.add(ele);
            }
            
            cnt++;
        }
        
        if(cnt!=n)
            return false;
        return true;
        
    }
    
}
