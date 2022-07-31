/**
 * 
 * https://www.geeksforgeeks.org/job-sequencing-problem/
 * 
 * https://www.youtube.com/watch?v=bID397v7ja4&t=689s
 * 
 * 
 */

package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Job
{
    int id,profit,deadline;

    Job(int i,int p,int d)
    {
        id = i;
        profit=p;
        deadline =d;
    }

}

class JobCompare implements Comparator<Job>
{
    public int compare(Job j1,Job j2)
    {
        if(j2.profit<j1.profit)
            return -1;
        if(j2.profit>j1.profit)
            return 1;
        return 0;
    }
}

public class JobSequencingWithDeadlines {

    int[] JobScheduling(Job arr[], int n)
    {

        // Sort all jobs according to
        // decreasing order of profit
       Arrays.sort(arr,new JobCompare());
        
     //  Arrays.sort(arr,(a,b)-> (b.profit-a.profit));      // sorting using lambda function.
       int profit=0;
       int jobs=0;
       
        // To keep track of free time slots
       boolean visited[] = new boolean[n];
       
       Arrays.fill(visited,false);
       
       for(int i=0;i<n;i++)
       {
           // Find a free slot for this job
            // (Note that we start from the
            // last possible slot)
           for(int j= Math.min(n,arr[i].deadline)-1;j>=0;j--)
           {
               // Free slot found
               if(visited[j]==false)
               {
                   visited[j]=true;
                   profit=profit+arr[i].profit;
                   jobs++;
                   break;
               }
           }
       }
       
       return (new int[]{jobs,profit});
       
    }
    
}
