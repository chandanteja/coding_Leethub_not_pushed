/**
 * 
 * https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1#  
 * 
 * https://www.youtube.com/watch?v=KtrAWsfyBaA      -->> watch this.
 * 
 * T.c : O(N) but we need not do n-1 comparisions, bcz we are given the adjacent ele will be differing by atmost value=k. 
 * So, We wont compare all elements to find 'x' but we will first check current ele and we skip adjacent ele and then check only elements which are useful.
 * 
 * 
 * 
 */

package SearchingAndSorting;

public class SearchInArrayWhereAdjacentEleDifferByAtmostK {

    public static int search (int arr[], int n, int x, int k) {
        int res=-1;
        int i=0;
        while(i<n)
        {
            if(arr[i] == x)
            {
                res= i ;
                break;
            }
            i = i+Math.max(1,Math.abs(arr[i]-x)/k);     // as adjacent ele differ by atmost k, it means if x=11 and currently we are ele= 5 and k=2 then we know that after 5, 11 wont be there
            // as adj ele will differ by atmost '2' so it means  adj ele for '5' will be either 6 or 7. so we will skip comparing with these ele.

            // formula for skipping ele are given above.
        }
        
        return res;
    }
    
    
}
