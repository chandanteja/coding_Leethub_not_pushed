package Leetcodequestions;

import java.util.HashSet;

/**
 * 
 * https://leetcode.com/problems/number-of-provinces/
 * 
 * 
 * We use disjoint-set for counting number of provinces.If all elements have same representative then they all belong to one province
 * We if an element has different representative then it belongs to different province. 
 * We use above logic.
 * 
 */

public class NumberOfProvinces {

    int parent[];
     int rank[];
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        initialize(n);
        
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1)
                        union(i,j);
            }
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<parent.length;i++)
        {
           // System.out.println("Parent[i]: "+parent[i]);
            hs.add(find(parent[i]));
        }
        
        return hs.size();
        
        
    }
    
    public void initialize(int n)
    {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
        
    }
    
    public  int find(int x)
    {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    
    public  void union(int x,int y)
    {
        int xRep = find(x);
        int yRep = find(y);
        
        if(xRep == yRep)
            return;
        if(rank[xRep] < rank[yRep])
                parent[xRep] = yRep;
        else if(rank[yRep] < rank[xRep])
                parent[yRep] = xRep;
        else
        {
            parent[yRep] = xRep;
            rank[xRep]++;
        }
    }
    
    
}
