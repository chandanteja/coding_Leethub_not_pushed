/**
 * 
 * https://www.geeksforgeeks.org/count-possible-ways-to-construct-buildings/      --> refer this link for soln
 * 
 * 
 */

package DP;

public class CountWaysToConstructBuildings {

    public int TotalWays(int N)
    {
       if(N==1)
        return 4;

        /*
            N=3
            --- || ---
            if we calculate for 1 side then for the other side also it will be same and the total result will be the square of the result.

            so ---
            at 1 position: building can be there or space can be there.
            so res = space(N) + building(N)

            lets say at position i we have space. then at its next position space can come or building can come.
            if at position i if we have building, then in the next position we cant have building we shud have space only.

            so  space(N) = space(N-1)+building(N-1)
                building(N) = space(N-1)


        Let countB(i) be count of possible ways with i sections ending with a building.
    
        countS(i) be count of possible ways with i sections ending with a space.

        // A space can be added after a building or after a space.
        countS(N) = countB(N-1) + countS(N-1)

        // A building can only be added after a space.
        countB[N] = countS(N-1)

        // Result for one side is sum of the above two counts.
        result1(N) = countS(N) + countB(N)

        // Result for two sides is square of result1(N)
        result2(N) = result1(N) * result1(N) 

    */

        long mod = 1000000007;
        
        long countB=1,countS=1;
        long prev_countB,prev_countS;
        
        for(int i=2;i<=N;i++)
        {
            prev_countB=countB;
            prev_countS=countS;
        
            countS= (prev_countB % 1000000007 + prev_countS % 1000000007)%1000000007;
            countB = prev_countS;
        }
        
        long result = (countS %1000000007 +countB %1000000007)%1000000007;
        return (int) ( (result%1000000007 * result%1000000007)%1000000007);
    }
    
}
