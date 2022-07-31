/**
 *  This is iterative solution
 * https://www.geeksforgeeks.org/iterative-depth-first-traversal/  --> dfs iterative
 */

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSIterative {

    public static void addEdge(LinkedList<Integer> graph[],int u, int v)
    {
            graph[u].add(v); 
            graph[v].add(u);
    }

    public static ArrayList<Integer> dfs(LinkedList<Integer> graph[],int startNode,int vertices)
    {
            boolean visited[] = new boolean[vertices];
            Arrays.fill(visited, false);
            Stack<Integer> s = new Stack<>();
            ArrayList<Integer> dfsTraversal = new ArrayList<>();


            s.push(startNode);

            while(!s.isEmpty())
            {
                int tempEle = s.pop();

                // As stack can contain same elements morethan once, we shuld consider that element only if its not visited.
                if(!visited[tempEle])   // We consider the element only if its not visited as the same ele can be multiple times in stack.
                {
                    visited[tempEle] = true;
                    dfsTraversal.add(tempEle);
                }
                Iterator<Integer> itr = graph[tempEle].iterator();

                while(itr.hasNext())
                {
                    int temp = itr.next();
                    if(!visited[temp])      // push only un visited elements to stack.
                    {
                        s.push(temp);
                    }
                }
            }
            return dfsTraversal;
    }
    
    public static void main(String args[])
    {
        int vertices=5;
        @SuppressWarnings("unchecked")LinkedList<Integer> graph[] = new LinkedList[vertices];
        
        for(int i=0;i<vertices;i++)
            graph[i] = new LinkedList<>();

            addEdge(graph,0, 1);
            addEdge(graph,0, 2);
            addEdge(graph,0, 4);
            addEdge(graph,4, 3);
           

            ArrayList<Integer> res= dfs(graph,0,vertices);
            Iterator<Integer> itr = res.iterator();
            while(itr.hasNext()){
                System.out.print(itr.next() + " ");
            }
        
    }
}
