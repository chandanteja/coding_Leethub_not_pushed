/**
 * 
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1  --> qns
 * 
 * Refer GFG self paced DSA course.
 * 
 * Sort based on finish times and include the first activity after sorting in our solution.
 * ANd check current activity with previously included activity.
 * 
 */

package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Activity{
    
    int start;
    int finish;
    
    Activity(int s,int f)
    {
        start = s;
        finish = f;
    }
}

class ActivityCompare implements Comparator<Activity>
{
    public int compare(Activity a1,Activity a2)
    {
        return a1.finish-a2.finish;
    }
}

public class ActivitySelectionProblem {

    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Activity> a = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            a.add(new Activity(start[i],end[i]));  
        }
        
        Collections.sort(a,new ActivityCompare());
        
        int res=1;
        int prev=0;
        for(int i=1;i<n;i++)
        {
            Activity a1 = a.get(prev);
            Activity a2 = a.get(i);
            
            if(a1.finish<a2.start)
            {
                res++;
                prev=i;
            }
            
        }
        return res;
    }
    
}
