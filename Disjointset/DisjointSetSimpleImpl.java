/**
 * 
 * https://ide.geeksforgeeks.org/oEnntBv34C     --> code
 * 
 * https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3881/  --> theory of Disjoint set
 * 
 * Refer GFG selfpaced DSA Course --> Disjointset videos for implementation.
 * 
 *  https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3878/     --> disjoint set simple implementation
 */

 /*
    The primary use of disjoint sets is to address the connectivity between the components of a network.
     For instance, we can use a disjoint set to determine if two people share a common ancestor.
     Also we can use it to check if 2 nodes are connected?

  */

public class DisjointSetSimpleImpl 
{

     int n;      // number of elements/nodes
     int parent[];      //this array is used to store parents/representative of every node

     DisjointSetSimpleImpl(int n)
     {
         this.n = n;
     }
    
     public  void initialize()  // we are initializing the parent[i] as i bcz initially every element has itself as representative.
     {
        parent = new int[n];    // initially as every node will be isolated, the node itself will be its parent.
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
        }
     }

     public int find(int x)     // returns the representative of element-x.
     {
         if(parent[x] == x)     // it means if parent[x] == x then it means we have reached root node and root node is the only node whose parent will be itself i.e 'x' is the rootnode itself.
            return x;           // all other nodes have parent as root node but root node has parent as itself.
        else
            return find(parent[x]);     // else find the representative of parent of element-x.
     }  

     public boolean connected(int x, int y) {       // if x and y both belong to same set i.e they both have same parent/represntative then they are in same set and hence cconnected.
        return find(x) == find(y);
    }

     public void union(int x,int y)     // make y-representative as child of x-representative.
     {
         int xRep = find(x);        // find x's representative
         int yRep = find(y);        // find y's representative

         if(xRep == yRep)       // if both x's rep and y's rep are same then they already belong to same set.
            return;
        else
            parent[yRep] = xRep;            // in simple implementation, we make 2nd(y) node representative  as child of 1st(x) node representative and this is the step we do that.
                                            // to make y's repr as child of x's repr, we go to parent array and replace y's repr with x's repr.
}

     public static void main(String args[])
     {
         int n = 5;
        DisjointSetSimpleImpl d = new DisjointSetSimpleImpl(n);
         d.initialize();

         d.union(0, 2);
         d.union(0, 4);

         System.out.println("Representative of 4:" + d.find(4));
         System.out.println("Representative of 3:" + d.find(3));
     }
    
}
