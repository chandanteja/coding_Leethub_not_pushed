import java.util.*;

/**
 * 
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * This is done using DP.
 * 
 * Logic is if numRows==1 then pascal triangle will contain only 1-row i.e 1st row.
 * 
 */
public class PascalTriangle {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        
        // base case. when rows=1, add 1 and return i.e when numRows==1 then only 1 row will be in pascal triangle which is [[1]]
        if(numRows == 1)
        {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            res.add(row);
            return res;
        }
       
        else
        {
            generate(numRows-1);        // recursively calling generate function with numRows-1 each time.
          //  System.out.println("numRows: "+numRows);
          // numRows-1 will work in 1-based indexing and we do numRows-1 to get previously calculated row.
            List<Integer> row = res.get(numRows-2);     // here we will get previous row in pascal triangle which is calculated in previous recursion call. Here we are doing numsRow-2 bcz numsRow-1 will only work for 1-based indexing but as JAVA follows 0-based indesxing we do numRows-2.
            int len = row.size();   // get the length of row list fetched above.
            ArrayList<Integer> r1 = new ArrayList<>();  // create another list for storing new list which we calculate now.
            int temp=0;
            
            for(int i=0;i<=len;i++)
            {
                if(i==0 || i==len)  // the first and last element of each list must be 1 so add 1.
                {
                    r1.add(1);
                }             
                else
                {
                    temp = row.get(i)+row.get(i-1);
                     // like if we are filling 3rd rows 2nd element, it is the sum of 2nd rows 1st and 2nd elements.
                     // result[i][j] = result[i-1][j-1]+result[i-1][j]; 
                    r1.add(temp);   // add that integer to list.
                }
            }
            
            res.add(r1);     // add this list to the result.
            
            return res;
        }
        
        
    }
    
}
