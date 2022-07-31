/**
 * 
 * https://www.youtube.com/watch?v=qtVh-XEpsJo  --> watch this for soln
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Bruteforce:
 * ============
 * 
 * Intuition

Check all the substring one by one to see if it has no duplicate character.

Algorithm
============
Suppose we have a function boolean allUnique(String substring) which will return true if the characters in the substring are all unique, otherwise false. We can iterate through all the possible substrings of the given string s and call the function allUnique. If it turns out to be true, then we update our answer of the maximum length of substring without duplicate characters.

Now let's fill the missing parts:

To enumerate all substrings of a given string, we enumerate the start and end indices of them. Suppose the start and end indices are i and j, respectively. Then we have 0 ≤ i < j ≤n (here end index j is exclusive by convention). Thus, using two nested loops with ii from 0 to n - 1 and j from i+1 to n, we can enumerate all the substrings of s.

To check if one string has duplicate characters, we can use a set. We iterate through all the characters in the string and put them into the set one by one. Before putting one character, we check if the set already contains it. If so, we return false. After the loop, we return true.
 * 
 * 
 * Code     --> T.C: O(n^3) & S.C: O(min(n,m)). We need O(k) space for checking a substring has no duplicate characters, where k is the size of the Set   
 * =======
 * 
 * public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int res = 0;
        // enumerating all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }

    Approach 2: Sliding Window
    Algorithm
    ==========================

    We use HashSet to store the characters in current window [i,j) (j=i initially). Then we slide the index j to the right. If it is not in the HashSet, we slide jj further. Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of substrings without duplicate characters start with index i. If we do this for all i, we get our answer.


    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            // here we traverse again to find the substring past the duplicate character.
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    T.C: O(2n)
    
    In the above code we keep track of current substring using hashset, if ith char is not repeated in hashset, then we increase the right pointer of window, and keep track of length
    but if ith char is already present in current window of  substring then we traverse entire substring to find the duplicate char and decrease the substring afer that duplicated char.
    While checking for duplicate char, we use left pointer of window.

    So, we traverse the entire string O(2n) times.We can eliminate this duplicate traversal  when we found the duplicate char in substring by using hashmap.

    Using hashmap, we keep track of character, its last occurrence in the entire string traversed till now.
 * 
 */

package Amazonlist;

import java.util.HashMap;

// the logic here is we keep track of character and its last occurred index in string traversed till now.
// we take two pointers, 'left' and 'i', 'left' keeps track of start of substring which doesnt have duplicate chars. If any duplicate char is seen in substring then left is moved to past that duplicate char.
// 'i' keeps track of right most char of substring.
// if hashmap already contains the char, then we update 'left' to be max(left, duplicate-char_index +1).
//  else we insert char into map along with its index.
// update length of substring as len = max(len, i-left+1)
// return len.

public class LongestSubstringWithoutRepeatingCharacters {
    

    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0)
                return 0;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int left=0;
        int maxLen=0;
        
        
        for(int i=0;i<s.length();i++)
        {
            if(hm.containsKey(s.charAt(i)))     
                left = Math.max(hm.get(s.charAt(i))+1, left);       // why we are taking max?? --> trace for 'abcaabde' --> when we are at 2nd 'b',then left will be at 3rd 'a'. So, we take max.
            
            hm.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left+1);
                
        }
        
        return maxLen;
    }

}
