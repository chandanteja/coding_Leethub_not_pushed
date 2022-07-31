/**
 * 
 * https://www.youtube.com/watch?v=jvTa0t3-GQo
 * https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
 * 
 * https://leetcode.com/problems/word-ladder/
 * 
 * 
 * Solution: The idea is to use BFS. 

    Approach: 

    Start from the given start word.
    Push the word in the queue
    Run a loop until the queue is empty
    Traverse all words that adjacent (differ by one character) to it and push the word in a queue (for BFS)
    Keep doing so until we find the target word or we have traversed all words.

    Time complexity: O(n²m)

     
 */

package Amazonlist;

import java.util.*;

public class WordLadder {

    // Returns length of shortest chain
    // to reach 'target' from 'start'
    // using minimum number of adjacent moves.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // here we are taking a hashset bcz searching in hashset will be O(1) in avg and worst cases.
        HashSet<String> hs = new HashSet<>();
        
        
        for(int i=0;i<wordList.size();i++)
                hs.add(wordList.get(i));
        
                // If the target String is not
                // present in the dictionary
        if(!hs.contains(endWord))
            return 0;
        
        if(beginWord.equals(endWord))
                return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);           // Push the starting word into the queue
        
            // To store the current chain length
            // and the length of the words
        int pathlen=0;
        int strsize = beginWord.length();

        // While the queue is non-empty
        while(!q.isEmpty())
        {
            // Increment the chain length
            ++pathlen;
            int qlen = q.size();        // Current size of the queue
            
            for(int i=0;i<qlen;i++)
            {
                // Remove the first word from the queue and convert to array of char
                char words[] = q.peek().toCharArray();
                q.remove();
                
                // For every character of the word we got above from queue front
                for(int pos=0;pos<strsize;pos++)
                {
                    // Retain the original character
                   // at the current position
                    char temp = words[pos];

                // Replace the current character with
                // every possible lowercase alphabet
                    for(char c='a'; c<='z';c++)
                    {
                        words[pos] = c;
                        
                        // If the new word is equal  to the target word
                        if(String.valueOf(words).equals(endWord))
                                return ++pathlen;
                        // if we dont use hashset then the below operation will take O(n) if we search in given arraylist itself. So, to avoid that we take hashset.
                        if(!hs.contains(String.valueOf(words)))     // if the word is not there in set continue. 
                                continue;

                        // Remove the word from the set  if it is found in it, we are removing this as we use any word only once.
                        hs.remove(String.valueOf(words));

                        // And push the newly generated word which will be a part of the chain
                        q.add(String.valueOf(words));
                    }
                    // Restore the original character at the current position
                    words[pos] = temp;
                }   
            }
        }
        
        return 0;
        
    }
    
}
