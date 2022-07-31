import java.util.*;

/**
 * * https://leetcode.com/problems/find-the-town-judge/
 * check solution.. it is very good.
 * 
 * judge: every one trusts him + he trusts no one.
 * 
 * trusts[][] = [a, b] => a trusts b
 * to ensure that every one trusts him, we create a map. keys will be b's (people who are being trusted)
 * values will be count of trusts i.e. number of people who trust that key.
 * 
 * so when we iterate through the map if some key's value is n-1 then it means all the people are trusting this person. so he 
 * might be a possible judge.
 * 
 * inorder for him to be judge he should satisfy 2nd criteria also i.e. he should not trust anyone.
 * 
 * for this we are taking a set and putting all the people who are trusting some one in this set. [i.e. we are putting all
 * trust[i][0]'s in this set]
 * 
 * so this set contains all people who trust someone. our probable judge should not be present in this set.
 * 
 */

public class FindTownJudge {

    public int findJudge(int n, int[][] trust) {
        
        if(n==1)
            return 1;
        
        int judge = -1;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashSet<Integer>  hs = new HashSet<>();
        
        for(int i=0;i<trust.length;i++)
        {
            if(hm.containsKey(trust[i][1]))
                hm.put(trust[i][1],hm.get(trust[i][1])+1);
            else
                hm.put(trust[i][1],1);
            
            hs.add(trust[i][0]);        // this set contains all except judge if one judge exists
        }
        
        
        for(Map.Entry<Integer,Integer> m : hm.entrySet())
        {
            if(!hs.contains(m.getKey()) && m.getValue()==n-1)
                judge = m.getKey();
            
                   
        }
        return judge;
        
        
    }

    // Another method from Leetcode solution
    /*
        * https://leetcode.com/problems/find-the-town-judge/solution/

        * The town judge has an outdegree of 0 and an indegree of N - 1 because they trust nobody, and everybody trusts them (except themselves).
        
        Therefore, this problem simplifies to calculating the indegree and outdegree for each person and then checking whether or not any of them meet the criteria of the town judge.
        We can calculate the indegrees and outdegrees for everybody, using a single loop over the input trust array. We'll write the results into two arrays.
        Then, we can simply loop over the people (numbered from 1 to N) and check whether or not they meet the town judge criteria.

        One optimization we can make is to observe that it is impossible for there to be a town judge if there are not at least N - 1 edges in the trust array. This is because a town judge must have N - 1 in-going edges, and so if there aren't at least N - 1 edges in total, then it is impossible to meet this requirement. This observation will also be very useful when we're reasoning about the time complexity.
        * If trust.length < N - 1, then we can immediately return -1.


        Time Complexity : O(E).
        Space Complexity : O(N).
    */
    public int findJudge1(int N, int[][] trust) {
    
        //One optimization we can make is to observe that it is impossible for there to be a town judge if there are not at least N - 1 edges in the trust array. This is because a town judge must have N - 1 in-going edges, and so if there aren't at least N - 1 edges in total, then it is impossible to meet this requirement.
        if (trust.length < N - 1) {
            return -1;
        }
        
        int[] indegrees = new int[N + 1];
        int[] outdegrees = new int[N + 1];
    
        for (int[] relation : trust) {
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++; 
        }
    
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    
}
