/**
 * https://www.youtube.com/watch?v=1_SRfUUTXEc  --> watch this video for clear idea.
 * 
 * https://www.geeksforgeeks.org/assembly-line-scheduling-dp-34/
 * 
 * Also refer IIITDM - Kancheepuram DP pdf.
 * 
 * Logic is we will have two assembly lines with n-stations on each line. A car passing thru them shuld come out in minimum time by  considering all times given in qns.
 * 
 * To minimize the outgoing time, i.e time for getting out of last station from 2-lines, we need to minimize the times in before stations too.
 * To find minimum time for making a car, we need to minimize the time at every possible stations so that the final time will be minimum.
 * If we stay on same line there will be no additional cost but if we transfer from one station to other then there will be extra transfer time will be incured.
 * 
 */
package DP;

public class AssemblyLineScheduling {

    // arr-> waiting times at every station
    // t-> transfer time for every station from one line to other line
    // e-> starting time
    // x-> ending time.
    static int carAssembly(int arr[][],int t[][],int e[],int x[])
    {
        int line1[] = new int[arr[0].length];
        int line2[] = new int[arr[0].length];

        line1[0] = e[0] + arr[0][0];    // initialize the starting minimum time for line-1 by adding waiting time of station-1 in line-1 with start time of line-1
        line2[0] = e[1] + arr[1][0];    // initialize the starting minimum time for line-2 by adding waiting time of station-1 in line-2 with start time of line-2

        // line1[i] and line2[i] --> tells min time for stage-i in respective lines.
        // we calculate min time for every stage i.e stages have min time. So, we need to think from perspective of stage i.e for stage-i what are possible inputs we need to think.
        for(int i=1;i<arr[0].length;i++)
        {
            // here we calculate transfer time as part of respective line i.e in line1[i], we calculate if any car from line-2 is transferred to line-1 then wats the cost. That is the reason why we add line2[i-1]+arr[0][i]+t[1][i] i.e if car is sent from line-2 to line-1 thn we calculate time at line 1 i.e arr[0][i] and transfer time from line-2 to line-1 i.e t[1][i]
            line1[i] = Math.min(line1[i-1]+arr[0][i], line2[i-1]+arr[0][i]+t[1][i]);    // t[1][i] --> contains the time for transfering from 2nd line to 1st line form i-1th stage to ith stage 
            line2[i] = Math.min(line2[i-1]+arr[1][i], line1[i-1]+t[0][i]+arr[1][i]);
        }
        
        return Math.min(line1[arr[0].length-1]+x[0],line2[arr[0].length-1]+x[1]);   // adding exit times for last stage times in respective lines and taking min among them
    }

    public static void main (String[] args)
    {
        // waiting times at each stations in respective lines.
        int a[][] = {{4, 5, 3, 2},
                    {2, 10, 1, 4}};
        // transfer times from one line to other.
        int t[][] = {{0, 7, 4, 5},
                    {0, 9, 2, 8}};
        // start and end times.
        int e[] = {10, 12}, x[] = {18, 7};
     
        System.out.println("Min time to assemble car: "+carAssembly(a, t, e, x));   
     
    }

    
}
