/**
 * 
 * https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
 * 
 * 1. Sort all pairs(Meetings) in ascending order of Finish time of each pair.
 * 2. Select first meeting of sorted pair as the first Meeting in the room and push it into result vector and set a variable time_limet(say) with the second value(Finishing time) of the first selected meeting.
   3. Iterate from the second pair to last pair of the array and if the value of the first element(Starting time of meeting) of the current pair is greater then previously selected pair finish time (time_limit), 
    ,then select the current pair and update the result vector (push selected meeting number into vector) and variable time_limit.
 * 
 */

package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Comparator function which can compare
// the ending time of the meeting ans
// sort the list
class mycomparator implements Comparator<meeting>
{
    // sort in ascending order of end times
    @Override
    public int compare(meeting o1, meeting o2)
    {
        if (o1.end < o2.end)
        {
             
            // Return -1 if second object is
            // bigger then first
            return -1;
        }
        else if (o1.end > o2.end)
         
            // Return 1 if second object is
            // smaller then first
            return 1;
             
        return 0;
    }
}
 
// Custom class for storing starting time, 
// finishing time and position of meeting.
class meeting
{
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
 

public class FindMaximumMeetingsInOneRoom {

    public static void maxMeeting(ArrayList<meeting> al, int s)
{
     
    // Initialising an arraylist for storing answer
    ArrayList<Integer> res = new ArrayList<>();
     
    // this contains the finish time of previously selected meeting pair.
    int time_limit = 0;
     
    // Sorting of meeting according to
    // their finish time in ascending order.
    Collections.sort(al, new mycomparator());
     
    // Initially select first meeting.
    res.add(al.get(0).pos);
     
    
    time_limit = al.get(0).end;         // finish time of 1st meeting
     
    // Check for all meeting whether it 
    // can be selected or not.
    for(int i = 1; i < al.size(); i++)
    {
        if (al.get(i).start > time_limit)   // if start time of current mmeeting is > end time of previously selected meet
        {
             
            // Add selected meeting to arraylist
            res.add(al.get(i).pos);
             
            // Update time limit with end time of currently seleccted meet
            time_limit = al.get(i).end;
        }
    }
     
    // Print final selected meetings.
     for(int i = 0; i < res.size(); i++)
        System.out.print(res.get(i) + 1 + " ");
}
    
}
