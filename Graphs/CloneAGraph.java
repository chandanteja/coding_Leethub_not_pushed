/**
 * Reference is leetcode discussion.
 * https://leetcode.com/problems/clone-graph/discuss/1221795/Depth-First-Search-Simple-Java-Solution
 * https://leetcode.com/problems/clone-graph/
 * 
 * https://github.com/mrpkdeveloper/450-DSA-Questions/blob/main/Java/graphs/clonegraph.java  ---> Another method using hashmaps.
 * 
 * trace on 1--2
 *          |  |  graph
 *          4--3
 */

package Graphs;

import java.util.*;

class NodeCloning {
    public int val;
    public List<NodeCloning> neighbors;
    public NodeCloning() {
        val = 0;
        neighbors = new ArrayList<NodeCloning>();
    }
    public NodeCloning(int _val) {
        val = _val;
        neighbors = new ArrayList<NodeCloning>();
    }
    public NodeCloning(int _val, ArrayList<NodeCloning> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public  class CloneAGraph {

    static NodeCloning visited[] = new NodeCloning[101];   // in leetcode max constratint on number of nodes is 101. In interview bit max constratin it 1000000.
    // in this array, indices are the values of origial graph i.e we use the original graph val to index this array and the elements are the copy nodes corresponding to that root.val
    
    public static NodeCloning dfs(NodeCloning node)
    {
        
        if(node == null)
            return null;
        
        if(visited[node.val] == null)
        {
            NodeCloning copy = new NodeCloning();
            copy.val = node.val;
            visited[node.val] = copy;   // node.val will be the index of node i.e 1,2,3... index of node. This tells that if a node is present at node.val then that node was visited
            for(int i=0;i<node.neighbors.size();i++)
            {
                copy.neighbors.add(dfs(node.neighbors.get(i)));   // a node gets added to the copy list of neighbors, after it is visited and created and stored in visited[] previously
                // when dfs is called on a node which is already visited (means aalready created), then that wont come into 2nd if condition
                // it will go to else part and the dfs() will return the copy node stored at that index as we go to else part only if a copy node was already created and stored in visited[]
            }
            return copy;
        }
        else
            return visited[node.val];   // this returns the node which was visited and created earlier and in the list of neighbors of a node.

    }

    public static NodeCloning cloneGraph(NodeCloning node) {
        Arrays.fill(visited,null);
        return dfs(node);
    }

    public static void main(String args[])
    {
        NodeCloning node1 = new NodeCloning(1);
        NodeCloning node2 = new NodeCloning(2);
        NodeCloning node3 = new NodeCloning(3);
        NodeCloning node4 = new NodeCloning(4);

        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors = new ArrayList<>();
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        NodeCloning result = cloneGraph(node1);
        // do bfs before and after cloning.

    }
    
}
