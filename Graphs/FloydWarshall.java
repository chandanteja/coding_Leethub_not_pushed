/**
 * This is implementation of All pairs shortest path or Floyd Warshall.
 * 
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/  --> refer this for Floyd warshall code.
 * 
 * T.C : O(V^3)
 * 
 */

package Graphs;

public class FloydWarshall {

    public void shortest_distance(int[][] matrix)
    {
        int v = matrix.length;
        
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if(matrix[i][j]==-1)
                    matrix[i][j] = 100000000;
            }
        }
        
        /* Add all vertices one by one
           to the set of intermediate
           vertices.
        */
        for(int k=0;k<v;k++)
        {
            // Pick all vertices as source one by one
            for(int i=0;i<v;i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for(int j=0;j<v;j++)
                {
                    // If vertex k is on the shortest path from i to j, then update the value of dist[i][j] with min value of the two quantities.
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if(matrix[i][j]==100000000)
                    matrix[i][j] = -1;
            }
        }
        
        for(int i = 0; i < v; i++){
			for(int j = 0; j < v; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
        
        
    }
    
}
