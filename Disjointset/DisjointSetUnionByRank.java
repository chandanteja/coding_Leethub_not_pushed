/**
 * https://ide.geeksforgeeks.org/4zd61wxa33     --> Code
 * https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3881/  --> theory of Disjoint set
 * 
 * https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3879/      -->union by rank
 * 
 * Refer DSA self paced course video for understanding concept.
 */

  /*
    The primary use of disjoint sets is to address the connectivity between the components of a network.
     For instance, we can use a disjoint set to determine if two people share a common ancestor.
      Also we can use it to check if 2 nodes are connected?

  */

public class DisjointSetUnionByRank {

    int parent[];       // keeps track of parent/representative  of every node 
    int rank[];         // height of a node is kept track in rank[] i.e rank[i] means i-th node height is stored.
    int n;

    DisjointSetUnionByRank(int n)
    {
        this.n = n;
        parent = new int[n];       
        rank = new int[n];         
    }

    public void initialize()
    {
        for(int i=0;i<n;i++)
        {
            parent[i] = i;       // initially every node is isolated and hence it's parent is node itself.
            rank[i] = 0;        // rank[] array will change only when we Union two representatives of same height. Else it wont change. We consider initially all nodes will be at ht=0.

        }
    }

    public int find(int x)
    {
        if(parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }

    public void union(int x,int y)
    {
        int xRep = find(x);
        int yRep = find(y);

        if(xRep == yRep)
            return;
        // We make the smaller height representative as the child of the larger height representative.
        if(rank[xRep] < rank[yRep])     
            parent[xRep] = yRep;
        else if(rank[yRep] <rank[xRep])
            parent[yRep] = xRep;
        else        
        {   // if both ranks are equal then we can assign in any way.
            parent[yRep] = xRep;
            rank[xRep]++;       // if both x-repr and y-repr are of same height, then we can assign in any way and after assigning, we the height  of the tree increases by '1', so this is the reason why we are incrementing the parent to which the child is assigned by '1'.
        }
        

    }

    public static void main (String[] args) {
		
		int n = 5;
        DisjointSetUnionByRank d = new DisjointSetUnionByRank(n);
		d.initialize();

		d.union(3,4);
		d.union(2,3);
		d.union(1,2);
		d.union(0,1);


		System.out.println("parent[3]: "+ d.parent[3]);
		System.out.println("Rank[3]: "+d.rank[3]);
	}
    
}
