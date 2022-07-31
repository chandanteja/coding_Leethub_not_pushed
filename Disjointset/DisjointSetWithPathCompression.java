/*
    In the previous implementation of the “disjoint set”, notice that to find the root node, we need to traverse the parent nodes sequentially until we reach the root node. 
    If we search the root node of the same element again, we repeat the same operations. 

    After finding the root node, we can update the parent node of all traversed elements to their root node.  --> This is called path compression

    https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3880/ -->  path compression notes

    https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3843/         --> Optimized Disjoint set with Path compression and union by rank.
*/

public class DisjointSetWithPathCompression {

    // In path compression we optimize only find() of Disjoint set and the union() will be same as Union by Rank of Disjoint set.
    // In path compression, we make all the children as child of root node in the path of x i.e if find(x) is called then in path compression, 
    // we will make all the nodes in path to x from root as children of root.

    int n;  // number of nodes/ele
    int parent[] = new int[n];
    public int find(int x)
    {
        if(parent[x] == x)      // this condition is same as old implementation
            return x;
        parent[x] = find(parent[x]);    // this is the step where we will make all the nodes in path from root to x  as child to root.
        return parent[x];           // we return parent[x].

    }
    
}
