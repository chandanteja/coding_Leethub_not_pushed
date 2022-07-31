/**
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * T.C: O(n^2)
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        res.add(firstList);
        
        for(int i=1;i<numRows;i++) {
            List<Integer> prevList = res.get(i-1);
            List<Integer> currList = new ArrayList<>();
            currList.add(1);
            for(int j=1;j<prevList.size();j++)
            {
                int n = prevList.get(j)+prevList.get(j-1);
                currList.add(n);
            }
            currList.add(1);
            res.add(currList);
        }
        return res;
                
    }
   /**
   
Explaination:
=============
As we know that the numRows can never be 0, we will take the result array and add the initial array with only one ele i.e [1].
Then we will iterate for the remaining numrows and create the rest of the result array.
While iterating, we will fetch the last most array (ex: [1,2,1] if [1,2,,1] was last pushed to resultant array) from the resultant array and then we will operate on it.
We will create a list for current iteration and add '1' into it as we know this 1 will be there for sure, and then iterate on previous array, by taking jth ele and j-1th ele from previously fetched array and adding them and store in the current array.
After the loop add the last 1 to the array (bcz we know it will be there at the end) and store in result array.
*/
}
