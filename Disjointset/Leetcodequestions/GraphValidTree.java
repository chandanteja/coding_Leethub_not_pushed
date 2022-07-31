package Leetcodequestions;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * The logic is same as Kruskal's algorithm proof.
 * Logic is we use disjoint set DS to check if there is an edge between vertcies of same set i.e the edge b/w vertices of same set then there is a cycle.
 * Then the given graphs is not a tree.
 * 
 */

public class GraphValidTree {

    int parent[];
    int rank[];
    
    public boolean validTree(int n, int[][] edges) {
        
        if(n==0)
            return false;
        if(n==1)
            return true;
        
        if(edges.length==0)
                return false;
        
        if(n-1 != edges.length)
            return false;
        
        initialize(n);
        
        for(int i=0;i<edges.length;i++)
        {
            if(union(edges[i][0],edges[i][1]) == false)
                return false;
                
        }
        return true;
        
                
    }
    
    public void initialize(int n)
    {
        parent = new int[n];
        rank = new int[n];
        
        Arrays.fill(rank,0);
        
        for(int i=0;i<n;i++)
            parent[i] = i;
        
    }
    
    public int find(int x)
    {
        if(x == parent[x])
            return x;
        parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    public boolean union(int x,int y)
    {
        int xRep = find(x);
        int yRep = find(y);
        
        if(xRep == yRep)
            return false;
        if(rank[xRep] < rank[yRep])
            parent[xRep] = yRep;
        else if(rank[yRep] < rank[xRep])
            parent[yRep] = xRep;
        else
        {
             parent[yRep] = xRep;
            rank[xRep]++;
        }
        return true;
    }
    
}
