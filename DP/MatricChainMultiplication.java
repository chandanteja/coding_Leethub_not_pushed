/**
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/ --> see dp solution
 * https://www.youtube.com/watch?v=xWni5uErQhI&t=1s --> refer for idea of how the problem is solved.
 * 
 * http://iiitdm.ac.in/old/Faculty_Teaching/Sadagopan/pdf/DAA/new/dp.pdf    --> refer logic and tracing of logic from here.
 * 
 *  Time Complexity: O(n^3 )
    Auxiliary Space: O(n^2)
 */
package DP;

public class MatricChainMultiplication {

    // arr[] contains dimenstion of all given matrices i.e arr[0],arr[1] is the dim of 1st matrix and arr[1],arr[2] is the dim of 2nd matrix and so on.
    // arr[2],arr[3] is the dim of 3rd matrix
    static int matrixMultiplication(int N, int arr[])
    {
        /* For simplicity of the program, one extra row and one extra column are allocated in dp[][].  
            0th row and 0th column of dp[][] are not used */
        /* dp[i, j] = Minimum number of scalar multiplications needed to compute the matrix product of A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is arr[i-1] x arr[i] */    
        // A[i] is ith matrix wiyh dimesnions arr[i-1]*arr[i]
        int dp[][] = new int[N][N];

        // filling 0s in diagonal elements bcz matrix-i need not be multiplied with itself as we need not calculate square of a matrix.
        // As matrix-i need not be multiplied with itself the number of multiplications are =0.
        for(int i=1;i<N;i++)
            dp[i][i] = 0; 
        
        for(int l=2;l<N;l++)    // length of chain to be considered l=2 means all 2-length matrices are considerd like A[1]A[2], A[2]A[3] etc 
        {                       // if l=3 all 3-length matrices i.e A1A2A3, A2A3A4 etc
            for(int i=1;i<N-l+1;i++)    // if l=2 means i=1 and j=2 tell what all matrices can be multiplied.
            {                           // if l=3 means i=1 and j=3 i.e A1 can be multiplied with result of A2A3 multiplied earlier.
                                        //  or l=3 can also be A1A2(multiplied earlier) multiplied with A3.
                int j = i+l-1;      // refer IIITDM kancheepuram algos notes on DP MCM for clear tracing.
                if(j==N)        
                    continue;
                dp[i][j] = Integer.MAX_VALUE;          
                   
                /*
                Refer traccing from IIITDM kancheepuram Algos notes pdf.
                    l = 2
                    i = 3
                    j = 4
                    (k = 3 to 3) ==> q = M[3; 3] +M[4; 4]+ product of dimensions.

                    l = 3
                    i = 1
                    j = 3
                    (k = 1 to 2) ==>  k = 1 ==> q = M[1; 1] +M[2; 3] + product of dimensions
                                      k = 2 ==> q = M[1; 2] +M[3; 3] + product of dimensions
                */

                for(int k=i;k<j;k++)
                {
                    int q = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j]; // MCM formula

                    if(q<dp[i][j])  // if current calculated value is minimum then update with it.
                        dp[i][j] =q;
                }
            }
        }
        return dp[1][N-1];
    }

    public static void main(String args[])
    {
        int arr[] = new int[] { 1, 2, 3, 4 };
        int size = arr.length;
 
        System.out.println( "Minimum number of multiplications is " + matrixMultiplication(size ,arr ));
    }
    
}
