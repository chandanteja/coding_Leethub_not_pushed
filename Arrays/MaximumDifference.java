/**
 * 
 * https://practice.geeksforgeeks.org/problems/maximum-difference-1587115620/1#     --> qns
 * 
 * No reference is used. 
 * Logic is find smallest and nearest ele on left for every ele in array and do same for smallest and nearest ele on right side for every ele too.
 * 
 * Now find the diff as LS[i] - RS[i] and take the diff which gives max value.
 * 
 * 
 * 
 */

package Arrays;

import java.util.Stack;

public class MaximumDifference {

    int findMaxDiff(int a[], int n)
{    
    int [] RS = rs(a);
    int [] LS = ls(a);
    int max = Integer.MIN_VALUE;
    for(int i=0;i<LS.length;i++)
    { 
        int diff=Math.abs(LS[i]-RS[i]);
        if(diff>max)
        {
            max=diff;
        }
    }
    return max;
}

// method to find smallest and nearest ele on left side for every ele of array (refer stacks)
public int[] ls(int[] arr)
{
    int[] ls = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    ls[0]=0;
    stack.push(0);
    for(int i =1; i<arr.length;i++)
    { 
        while(stack.size()>0&&arr[i]<=arr[stack.peek()])
        {
            stack.pop();
        }
        if(stack.size()==0)
        {
            ls[i]=0;
        }
        else
        {
             ls[i]=arr[stack.peek()];
        }
         stack.push(i);
    }
    return ls;
}

// method to find smallest and nearest ele on right side for every ele of array     (refer stacks)

public int[] rs (int [] arr)
{
    int [] rs = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    rs[arr.length-1]=0;
    stack.push(arr.length-1);
    for(int i =arr.length-2; i>=0;i--)
    {
        while(stack.size()>0&&arr[i]<=arr[stack.peek()])
        {
            stack.pop();
        }
        if(stack.size()==0)
        {
            rs[i]=0;
        }
        else
        {
          rs[i]=arr[stack.peek()];
        }
        stack.push(i);
    }
    return rs;
}
    
}
