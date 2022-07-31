/**
 * https://www.youtube.com/watch?v=wMMwRK-w0r4  --> refer this video.
 * 
 * https://practice.geeksforgeeks.org/problems/alien-dictionary/1  --> qns is here.
 * 
 * Logic is we first take 2 strings and check if characters being compared are same or not. If not same we add dependency in graph as below.
 *          str1[char] ---> str2[char]  in directed graph.
 *  Now after creating a graph of these characters, we do Topological sorting (using dfs) and append characters and return ans.
 * 
 * 
 * All approaches break the problem into three steps.

Extracting dependency rules from the input. For example "A must be before C", "X must be before D", or "E must be before B".
Putting the dependency rules into a graph with letters as nodes and dependencies as edges (an adjacency list is best).
Topologically sorting the graph nodes.
 * 
 */

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class AlienDictionary {

    String ans = "";
    public void dfs(int i,ArrayList<ArrayList<Integer>> graph,boolean visited[])
    {
        visited[i] = true;
        // iterate in adjacency list of current node.
        for(int adj:graph.get(i))   // here we get ArrayList<Integer> when we do graph.get() but for-each in java inherently loops in 1d- array so, we just needs to give index.
        {
            if(!visited[adj])
                dfs(adj,graph,visited);
        }
        char ch = (char)(i + 'a');  // concatenating o/p
        ans = ch + ans;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();;
        
        for(int i=0;i<K;i++)
            graph.add(new ArrayList<>());
        
        for(int i=0;i<N-1;i++)
        {
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int n = Math.min(s1.length(),s2.length());
            for(int j=0;j<n;j++)
            {
                if(s1.charAt(j)!=s2.charAt(j))  //if corresponding characters of compared string are not same then we add  to graph
                {
                    graph.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');  // str1[char] is src and str2[char] is dst str1[char] --> str2[char]
                    break;
                }
            }
            
        }
        // Apply topological sort.
        boolean visited[] = new boolean[K];
        Arrays.fill(visited,false);
        
        for(int i=0;i<K;i++)
        {
                if(!visited[i])
                    dfs(i,graph,visited);
        }
        return ans;
    }
    
}
