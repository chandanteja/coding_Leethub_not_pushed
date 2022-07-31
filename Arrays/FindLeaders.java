/**
 * 
 * https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/?track=DSASP-Arrays&batchId=155
 * 
 * Leader is an ele which is greater than or equal to all ele on its right side.
 * Last ele will always will be leader.
 * So Start from right end and compare every element with previous leader.
 * If any ele is greater than prev leader thn it means it will be greater than all ele on its right side too.
 * 
 */

package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FindLeaders {

    static ArrayList<Integer> leaders(int arr[], int n){
        
        ArrayList<Integer> leader_list = new ArrayList<>();
        int leader = arr[n-1];
        leader_list.add(leader);
        
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>=leader)
            {
                leader=arr[i];
                leader_list.add(leader);
            }
            
        }
        Collections.reverse(leader_list);
        return leader_list;
    }
    
}
