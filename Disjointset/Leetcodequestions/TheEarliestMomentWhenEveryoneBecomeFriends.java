package Leetcodequestions;

/**
 * 
 * *https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 * *https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/discuss/1652409/Union-Find-with-steps-or-Java-or-Faster-than-87      --> this has better faster code. Use for reference.
 * 
 * we need to return the latest and smallest timestamp when all become friends.
 * thus we have to first sort the given 2d logs array based on timestamp.
 * 
 * then iterate through all the entries in the log and call union on every entry. As the array is sorted on timestamps, we will take a result var. and store time stamp in that if union of 2 elements doesnt return false.
 * 
 * 
 * We use cnt var to keep track of whether all became friends or not. If not all become frnds then we return -1.
 * 
 * 
 * 
 */

import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriends {

    int parent[];
    int rank[];
    int cnt=0;
    
    public int earliestAcq(int[][] logs, int n) {
        
        if(logs.length==1)
            return logs[0][0];
        
        initialize(n);
        int res=0;
        
//        Arrays.sort(logs, (a,b) -> Integer.compare(a[0], b[0]));      // sorting based on 1st column of multi dimensional array
        Arrays.sort(logs, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
        if(a[0]<b[0])
            return -1;
        else return 1;
    }
});
        
        for(int i=0;i<logs.length;i++)
        {
            if(union(logs[i][1], logs[i][2]) ==false)   // if union of 2 ele's return false then we wont update res with new timestamp.
                continue;
            else
                res=logs[i][0];
        }
        
        
        
        return cnt==1 ? res:-1; // cnt will be used to keep track if all became frnds or not and if not then return -1.
        
        
    }
    
    public void initialize(int n)
    {
        parent = new int[n];
        rank=new int[n];
        
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
        cnt=n;
        
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
        int xrep = find(x);
        int yrep = find(y);
        
        if(xrep ==  yrep)
            return false;
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
        return true;
    }
    
}
