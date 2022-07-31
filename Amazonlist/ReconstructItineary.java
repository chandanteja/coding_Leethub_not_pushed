/**
 * 
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * https://www.youtube.com/watch?v=j31ZOupyrAs&t=1733s
 * 
 * Logic is we form a graph using the given itinearies. For graph here, we use hashmap<String, Priorityqueue>
 * 
 * WHy priority queue??  --> to reconstruct itineary, if there are multiple ways, we need to give lexicographically sorted order list.
 * 
 * What is reconstruction of itineary --> given different travel tickets of one person, we need to find the order of his travel/trip, i.e which city he visited first and which he visited last.
 * 
 * If there are multiple ways possible, we need to find lexicographically sorted one among those multiple ways.
 * 
 * There can be duplicates present in priority_queue of graph. This is bcz he can visit same city multiple times.
 * We do DFS starting from "JFK" city. While doing DFS, we will not use any visited array to keep track of visited cities bcz as said, there can be duplicates allowed in cities, so we can visity city again.
 * But to avoid looping, what we do is after visitng a city( traversing an edge ), we will remove that edge.
 * While doing, DFS, push all the cities visited into stack (implicit stack), and after the end of DFS call, we will store the result in List<> i.e during tail recursion we will add all the elements to the front of list.
 * 
 * 
 * 
 */

package Amazonlist;

import java.util.*;
public class ReconstructItineary {

    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
        
        for(List<String> adj : tickets)
        {
            
            // insert if city in get(0) is not present in graph
            graph.putIfAbsent(adj.get(0),new PriorityQueue<>());
            graph.get(adj.get(0)).add(adj.get(1));      // here when we do graph.get(adj.get(0)) --> we get priority queue and on that we doe add(get(1)).
            
            
        }
        
        LinkedList<String> res = new LinkedList<>();    // we need LinkedList bcz we need to add the elements to te front of list.
        
        dfs(graph,res,"JFK");
        
        
        return res;
    }
    
    public void dfs(HashMap<String, PriorityQueue<String>> graph, LinkedList<String> res, String src)
    {
        PriorityQueue<String> curr = graph.get(src);
        
            while(curr!=null && !curr.isEmpty())
            {
                 String next = curr.poll();
                 dfs(graph,res,next);
            }
            res.addFirst(src);      // V.V.IMP i.e here we add the elements after recursion to front of the list. Hence we need to maintain LinkedList.
        
       
    }
    
}
