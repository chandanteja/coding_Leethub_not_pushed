package Leetcodequestions;

import java.util.Arrays;

/**
 * 
 * *https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * * This we solved using union-find DS.Can be solved using DFS also.
 */

public class NumberOfConnectedComponents {

    int parent[];
    int rank[];
    int cnt=0;
    
    public int countComponents(int n, int[][] edges) {
        
        if(n==1)
                return 1;
        
        initialize(n);
        
        for(int i=0;i<edges.length;i++)
        {
            union(edges[i][0],edges[i][1]);
            
        }
        
            
        return cnt;
    }
    
    public void initialize(int n)
    {
        parent = new int[n];
        rank = new int[n];
        
        Arrays.fill(rank,0);
        for(int i=0;i<n;i++)
            parent[i] = i;
        cnt=n;
        
    }
    
    public int find(int x)
    {
        if(x==parent[x])
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x,int y)
    {
        int xrep = find(x);
        int yrep = find(y);
        
        if(xrep ==  yrep)
            return ;
        if(rank[xrep] < rank[yrep])
            parent[xrep] = yrep;
        else if(rank[yrep] < rank[xrep])
                parent[yrep] = xrep;
        else
        {
                parent[yrep] = xrep;
            rank[xrep]++;
        }
        cnt--;
        
    }
    
}
