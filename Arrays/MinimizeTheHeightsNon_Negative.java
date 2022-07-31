/**
 * 
 * https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
 * 
 * Sort the heights and try every possible split into two halves [0, i-1] and [i, n-1], where you add B to the left half and subtract B from the right half.
 *  Then the difference for that split is max(a[n-1] - B, a[i-1] + B) - min(a[0] + B, a[i] - B).
 * 
 * For any given tower, if you choose to increase its height from Hi to Hi + K, then you can also increase the height of all shorter towers as that won't affect the maximum. Similarly, if you choose to decrease the height of a tower from Hi to Hi − K, then you can also decrease the heights of all taller towers.
We will make use of this, we have n buildings, and we'll try to make each of the building the highest and see making which building the highest gives us the least range of heights(which is our answer).
Let me explain:

So what we want to do is -
1) We first sort the array(you will soon see why).

2) Then for every building from i = 0 to n-2[1] , we try make it the highest (by adding K to the building, adding K to the buildings on its left and subtracting K from the buildings on its right).

So say we're at building Hi, we've added K to it and the buildings before it and subtracted K from the buildings after it.

So the minimum height of the buildings will now be min(H0 + K, Hi+1 - K),
i.e. min(1st building + K, next building on right - K).

(Note: This is because we sorted the array. Convince yourself by taking a few examples.)

Likewise, the maximum height of the buildings will be max(Hi + K, Hn-1 - K),
i.e. max(current building + K, last building on right - K).

3) max - min gives you the range.

[1]Note that when i = n-1. In this case, there is no building after the current building, so we're adding K to every building, so the range will merely be height[n-1] - height[0] since K is added to everything, so it cancels out.
 * 
 * 
 * 
 * 
 * https://stackoverflow.com/questions/63000076/minimize-the-maximum-difference-between-the-heights     --> approach explaination
 * 
 * https://codeforces.com/blog/entry/68823  --> solution explaination.  
 * 
 */

package Arrays;

import java.util.Arrays;

/*
    Logic is as the array will be sorted, let there be a point 'i' in array so that, we add 'k' to all elements before it and we subtract 'k' from all elements after it.
    We repeat this process for all values of 'i' in [0,..n-1]

    This works because if we add 'k' to smaller elements and remove 'k' from larger elements then the difference b/w largest and smalest elements can be minimized.

    So, for every 'i' in [0,n-1], we consider the ith element as current element and (i-1)th element as prevvious element.

    So, we check by adding 'k' to arr[i-1] with largest element i.e arr[n-1] {remember, we add 'k' to all elements before the current considering element}.
    We also check by removing 'k' from current ele i.e arr[i] with smallest ele i.e arr[0].
    arr[n-1] and arr[0] will be largest and smallest as they are sorted.


    here we are given array of numbers. they are not in sorted order. and a number k.

for each number we can either add k or subtract, but the end result is difference between max and min number must be minimum.

for each number, we can either do +k or -k so 2 possibilities for each number thus we have 2^n possibilities overall.

if we do bruteforce by doing +k for each elt and checking, -k and again checking it wud take exponential time. 

so we want to minimize the diff so we sort it.(1)

after sorting we will get elts: minimum to maximum.

so the minimum difference is obtained ideally by  +k to minimum elt and -k to max elt. this may not always be the case though.

so we will use this concept.

iterate through each elt.
let the elt position be i.

-> all the elts to left of i are smaller than i and all elts to right of i are larger than i.
-> so assume we have added k to all left elts and subtracted k from all right elts.

so minimum element can be 0th position elt (1st elt) as the array is sorted OR
elt in i+1th position. This is because when u r at i and u added k to all left and subtracted k from all right, i+1th elt can
become less than minimum elt (depending on k value.) and we are comparing with only i+1th elt bcoz array is in sorted order,
i+1th elt will be smaller than i+2th so for minimum we take i+1 only.

compare 0th elt+k and i+1th elt-k ==> min_elt=min(arr[0]+k, arr[i+1]-k)


similarly we want max_elemnt.
-> max_elt can be i-1th elt or last elt.
-> because after adding k to i-1th and subtracting k from n-1th, i-1th elt might become larger than n-1th depending on value of k.
-> and we take only i-1 and not any other left elt because among all left side elts to i, i-1th is the largest.
-> so compare it with known largest i.e. n-1th
max_elt = max(arr[i-1]+k, arr[n-1]-k)


now range=min(max_elt-min_elt, previous range)


*/

// Logic is completely same as 'MinimizeTheHeightsNegativeAllowed' except here as neative heights are not allowd, we check if arr[i] >=k then only we proceed further

public class MinimizeTheHeightsNon_Negative {

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1]-arr[0];
        int max_ele,min_ele;
        
        for(int i=1;i<n;i++)
        {
            //Logic is completely same as 'MinimizeTheHeightsNegativeAllowed' except here as neative heights are not allowed, we check if arr[i] >=k then only we proceed further
            if(arr[i]>=k)
            {
                max_ele = Math.max(arr[n-1]-k,arr[i-1]+k);
                min_ele = Math.min(arr[0]+k,arr[i]-k);
                ans = Math.min(ans,max_ele-min_ele);
            }
            else
                continue;
        }
        return ans;
    }
    
}
