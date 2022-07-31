/**
 *  https://github.com/mrpkdeveloper/450-DSA-Questions/blob/main/Java/graphs/floodfill.java
 *  https://www.youtube.com/watch?v=RwozX--B_Xs
 */
package Graphs;

public class FloodFill {

    // the 2d array need not be square array
    public static int[][] floodFill(int arr[][],int newColor,int x,int y, int oldColor)
    {
        // x--> row
        // y--> col
        // checking if (x,y) is crossing boundaries of matrix, i.e <0 or >= size of matrix.
        // also checking if the color at (x,y) is not the color which we wan to replacce with new color, then we return old image only.
        if(x<0 || y<0 || x>=arr.length || y>=arr[0].length || arr[x][y]!=oldColor)
                return arr;     // if any of the above condition is met, return old image
        if(arr[x][y]==newColor) // if (x,y) is having new color already, then we need not fill it again. Return the old image only
                return arr;
        arr[x][y] = newColor;   // fill with new color and recurse in 4-directions i.e x+1, y+1, x-1,y-1
        floodFill(arr, newColor, x+1, y, oldColor);
        floodFill(arr, newColor, x, y+1, oldColor);
        floodFill(arr, newColor, x-1, y, oldColor);
        floodFill(arr, newColor, x, y-1, oldColor);
    
        return arr;

    }

    public static int[][] floodFillUtil(int arr[][],int x,int y,int newColor)
    {
        int oldColor = arr[x][y];
        floodFill(arr, newColor, x, y, oldColor);
        return arr;

    }
    public static void main(String args[])
    {
        int image[][] = {{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 0, 0},{1, 0, 0, 1, 1, 0, 1, 1},{1, 2, 2, 2, 2, 0, 1, 0},{1, 1, 1, 2, 2, 0, 1, 0},
                        {1, 1, 1, 2, 2, 2, 2, 0},{1, 1, 1, 1, 1, 2, 1, 1},{1, 1, 1, 1, 1, 2, 2, 1}
                    };
        int x=4;
        int y=4;
        int newColor = 3;
        floodFillUtil(image,x,y,newColor);
        
        for(int i=0; i<image.length; i++)
        {
            for(int j=0;j<image[0].length;j++)
            {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
