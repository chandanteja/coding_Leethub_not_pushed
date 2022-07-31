/**
 * https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/   --> Using heaps
 * https://www.geeksforgeeks.org/rearrange-characters-in-a-string-such-that-no-two-adjacent-are-same-using-hashing/  --> using hashing.
 * Idea is: we maintain, Frequency of a character along with character and we store the pair (char,freq) in max-heap according to freq.
 * 
 * The idea is to put the highest frequency character first (a greedy approach). 
 * We use a priority queue (Or Binary Max Heap) and put all characters and ordered by their frequencies (highest frequency character at root). 
 * We one by one take the highest frequency character from the heap and add it to result. 
 * After we add, we decrease the frequency of the character and we temporarily move this character out of priority queue so that it is not picked next time.
 */

package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeStrings {

    static class Key{
        int freq;
        char ch;
        Key(char ch, int freq)
        {
            this.ch = ch;
            this. freq = freq;
        }
    }

    static class KeyComparator implements Comparator<Key> {
        public int compare(Key k1, Key k2)  // we are implementing max-heap. 
        {
            if(k1.freq < k2.freq)
                return 1;       // for max-heap we return 1. For min-heap we return -1 in this case.
            if(k1.freq > k2.freq)
                return -1;  // same as above comment.
            return 0;
        }
    }

    public static String rearrangeString(String str)
    {
        int charFreqArray[] = new int[26];  // in this [] we maintain the frequency of characters given in the string.
        String res = "";        // 'res' that will store resultant value
        int n = str.length();   

        Arrays.fill(charFreqArray,0);

        // Store frequencies of all characters given in the string
        for(int i=0;i<str.length();i++)
            charFreqArray[str.charAt(i)-'a']++;     // 'b' - 'a' == 1 bcz ascii of 'b' and ascii of 'a' are subracted. And we are increasing its frequecy.
        
            PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
            
             // Insert all characters with their frequencies  into a priority_queue
             for (char c = 'a'; c <= 'z'; c++) {
                int val = c - 'a';  // calculating index.
                if (charFreqArray[val] > 0)
                    pq.add(new Key(c,charFreqArray[val]));
            }  
             // here we are creating new key of character and its freq from string.
            // charFreqArray[str.charAt(i)-'a'] --> here first we will get index by subtracting 'a' from current character in string and get freq.
        
        // keeps track of the previous visited element, initial previous element be( '@' and it's frequency '-1' )
        Key prev =  new Key('@',-1);   

        while(!pq.isEmpty())
        {
            // pop top element from queue and add it to string.
            Key temp = pq.poll();
            res = res+temp.ch;

            // If frequency of previous character is less than zero that means it is useless, we need not to push it
            if(prev.freq>0)
                pq.add(prev);
            
            // make current character as the previous 'char' decrease frequency by 'one'
            (temp.freq)--;
            prev=temp;
            
        }
        // If length of the resultant string and original string is not same then string is not valid
       
        if(n!=res.length())
             System.out.println(" Not valid String ");
        else
            System.out.println("Rearranged str: "+res);
    return res;
    }

    public static void main(String args[])
    {
        String str = "bbbaa";
        rearrangeString(str);
    }
    
}
