/**
 * https://ide.geeksforgeeks.org/c3InL3WPWX
 * See gfg video by sandeep jain sir.
 * Logic is,
 *  1. We do dfs on given graph. Order the vertices in finishing order(descending) of times and pick the vertex with highest finishing time.
 *  2. Now reverse the above graph, and do dfs in the order of finishing times we got in step-1.
 *  3. we get the strongly connected components.
 */

package Graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponentsKosaraju 
{
    int vertices;
    LinkedList<Integer> graph[];

    @SuppressWarnings("unchecked")
    StronglyConnectedComponentsKosaraju(int vertices)
    {
        this.vertices = vertices;
        
        graph = new LinkedList[vertices];
        for(int i=0;i<vertices;i++)
        {
            graph[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) { graph[v].add(w); } 

    public  void dfs1(int v,boolean visited[], Stack<Integer> stack)
    {
        visited[v] = true;
        Iterator<Integer> itr = graph[v].listIterator();
        while(itr.hasNext())
        {
            int ele = itr.next();
            if(!visited[ele])
                dfs1(ele,visited,stack);
        }

        stack.push(v);
    }

    public void dfs2(LinkedList<Integer> transposeGraph[],int v,boolean visited[])
    {
        visited[v] = true;
        System.out.print(v+ " "); // printing strongly connected components of one component.
        Iterator<Integer> itr = transposeGraph[v].listIterator();
        while(itr.hasNext())
        {
            int ele = itr.next();
            if(!visited[ele])
                dfs2(transposeGraph,ele,visited);
        }
    }

        public void stronglyConnectedComponentsUtil()
        {
            boolean visited[] = new boolean[vertices];
            Arrays.fill(visited,false);
            Stack<Integer> stk = new Stack<>();
            
            for(int i=0;i<vertices;i++)
            {
                if(!visited[i])
                    dfs1(i,visited,stk);
            }
        // Now we do graph transpose. Take new linked list for this purpose.
        @SuppressWarnings("unchecked") LinkedList<Integer> transposeGraph[] = new LinkedList[vertices];

            for(int i=0;i<vertices;i++)
                transposeGraph[i] = new LinkedList<>();

            for(int i=0;i<vertices;i++)
            {
                Iterator<Integer> itr = graph[i].listIterator();
                while(itr.hasNext())
                {
                    int node = itr.next();
                    transposeGraph[node].add(i);
                }
            }
        Arrays.fill(visited,false);
        
        while(!stk.empty())
        {
            int v = stk.pop();
            if(visited[v]==false)
            {
                dfs2(transposeGraph,v,visited); 
                System.out.println(); 
            }

            }
     }

     public static void main(String args[]) 
	{ 
		StronglyConnectedComponentsKosaraju g = new StronglyConnectedComponentsKosaraju(5); 
		g.addEdge(1, 0); 
		g.addEdge(0, 2); 
		g.addEdge(2, 1); 
		g.addEdge(0, 3); 
		g.addEdge(3, 4); 

		System.out.println("Following are strongly connected components "+ 
						"in given graph "); 
		g.stronglyConnectedComponentsUtil(); 
	} 

}