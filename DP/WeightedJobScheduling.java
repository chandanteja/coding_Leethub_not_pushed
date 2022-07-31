/**
 *  
 * https://www.geeksforgeeks.org/weighted-job-scheduling-log-n-time/ --> O(nlogn) time Efficient solution using binary search.
 * 
 * https://www.geeksforgeeks.org/weighted-job-scheduling/ --> naive and DP based soln ( O(n^2) ).
 * 
 *  1. comparison class
    2. binary search()
    3. jobScheduling()
    4. classes for Job and comparator
    5. main()
 * 
 */

package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Job{
    int startTime;
    int endTime;
    int profit;
    Job(int startTime,int endTime,int profit)
    {
        this.startTime = startTime;
        this.endTime=endTime;
        this.profit=profit;
    }
        
    }

class JobComparator implements Comparator<Job>
{
    public int compare(Job j1,Job j2)   // sorting jobs based on their finish times i.e smallest finish time first
    {
        if(j1.endTime<j2.endTime)       // as we are sorting based on endtimes in ascending order then its natural order so if a<b we need to return -1
            return -1;  
        if(j1.endTime==j2.endTime)      // if a==b return 0 
            return 0;   
        return 1;       // if a>b return 1; for ascending order.
    }
}


public class WeightedJobScheduling {

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) 
    {
        
        ArrayList<Job> jobs = new ArrayList<>();
        int n=startTime.length;
        
        for(int i=0;i<n;i++)
        {
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        Collections.sort(jobs, new JobComparator());
        
        int dp[] = new int[n];  // dp state -> dp[i] = max profit obtained when intervals/jobs 0 to i are considered..
        dp[0] = jobs.get(0).profit; // dp[0]  means when all jobs from 0 to 0 are considered. So we put first job profit itself.
        
        for(int i=1;i<n;i++)        // iterate through all the remaining intervals.
        {
            int inclprofit = jobs.get(i).profit;        // each interval can be included in the profit or it cant be included.

            // it can be included when it is not overlapping with any of the previous jobs. 
            // if it overlaps with any 1 of previous jobs then we cant include it.
            // to find if its overlapping or not we use binary search. also as the ending times are sorted in increasing order we
            // perform binary search. binary search returns the index of the job which is not overlapping with current job and
            // which has maximum finish time among all those jobs which are not overlapping.
    
            int indx = binarysearch(jobs,i);
            
            if(indx!=-1)    // if the index returned is not -1 then add profit to it.
                inclprofit =inclprofit+dp[indx];
            
            dp[i] = Math.max(inclprofit,dp[i-1]);   // take maximum of included part and not included part. not included part is dp[i-1] itself.
        }
        return dp[n-1];
        
    }
    
    public static int binarysearch(ArrayList<Job> jobs,int indx)
    {
        int low=0;
        int high= indx-1;   // we have to perform binary search on value b/w 0 and index-1
        
        while(low<=high)
        {
            int mid = (low+high)/2; // low+(high-low)/2;
            
        // this is for checking if the mid job's finish time is overlapping with our current job's start index.
        
        // if they are overlapping then it means that all jobs b/w mid and high are also overlapping with current job (bcoz they are sorted on finish times.)
        // if mid's finish time is overlapping then all below jobs finish times are bigger than mid job's finish time. so they will also overlap.
        // so we have to search in b/w 0 to mid-1. so high will change to mid-1.
        
        // if they are not overlapping the check b/w mid and current job.
        // there may be the case that we have many jobs b/w mid and current job which are not overlapping with current job.
        // among all these we have to find the one with max finish time + non-overlapping.
        // so for that we check next job after mid (mid+1)'s finish time and current job's start time 
        // if they are not overlapping then we can search b/w mid+1 and current job. 
        // so update low to mid+1

        // if (mid+1) job's values are overlapping with current job then mid is the job which is not overlapping
        // and has maximum finish time.
            if(jobs.get(mid).endTime <= jobs.get(indx).startTime)
            {
                if(jobs.get(mid+1).endTime <= jobs.get(indx).startTime)
                        low = mid+1;
                else
                    return mid;
            }
            else
                high= mid-1;
        }
        return -1;  // if we cant find any such job then return -1.
    }

    public static void main(String[] args)
    {       
        // int startTime[] = {1,3,6,2};
        // int endtime[] = {2,5,19,100};
        // int profit[] ={50,20,100,200};

        int startTime[] ={1,2,3,4,6};
        int endtime[] = {3,5,10,6,9};
        int profit[] ={20,20,100,70,60};
        System.out.println("Optimal profit is " + jobScheduling(startTime,endtime,profit));
    }
    
}
