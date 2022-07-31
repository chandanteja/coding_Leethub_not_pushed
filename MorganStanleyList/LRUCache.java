/**
 * 
 * https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * 
 * Watch LRU cache implementation in self paced DSA in Linkedlist section. 
 * 
 * We insert element at end of linkedhashmap and hence, the most recently used element will be at the end of list.
 * And the least recently used element will be at the beginning of the list. 
 * 
 * put() of linked hash map adds the elements at the end of list as it maintains insertion order.
 * 
 * 
 * We use two data structures to implement an LRU Cache.  (WHy 2 DS needed?)

    Queue which is implemented using a doubly linked list. The maximum size of the queue will be equal to the total number of frames available (cache size). The most recently used pages will be near front end and least recently pages will be near the rear end. 
    A Hash with page number as key and address of the corresponding queue node as value.

    Note:
    
    Only DLL is not enough bcz in DLL we store only page-numbers but if a page is in memory, we also need to know its address exactly where page is stored.
    So, to achieve this, we use Map to maintain a page number and its corresponding address where actually page is stored.


    When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it to the front of the queue. 
    If the required page is not in memory, we bring that in memory. In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. If the queue is full, i.e. all the frames are full, we remove a node from the rear of the queue, and add the new node to the front of the queue.



    https://leetcode.com/submissions/detail/511977673/

    LinkedHashMap<>()
    ======================

    1. In linked hashmap, order of insertion is maintained.
    2. Duplicate ele are not allowed.
    3. put() method of linked hashmap will insert element at the end of hashmap.
    4. to remove we need to give 'key' to be removed.
 * 
 */

package MorganStanleyList;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    
    LinkedHashMap<Integer,Integer> lhm;
    int totalSize;
    int currSize;

    public LRUCache(int capacity) {
        
        currSize=0;
        totalSize=capacity;
        lhm = new LinkedHashMap<>();
        
        
    }
    
    // most recently used ele will be at the end of list
    // least recently used ele will be at the start of the list.
    public int get(int key) {
        
        if(!lhm.containsKey(key))
                return -1;
        
        // remove node from in-between and insert at the end as the latest accessed
        int val = lhm.remove(key);
        lhm.put(key,val);   // adds element at the end
        return val;
        
        
    }
    
    public void put(int key, int value) {
       
        // this case is where key is already present in hash table.
        if(lhm.containsKey(key))
        {
            lhm.remove(key);
            // remove from in-between and insert at the end as the latest accessed
                // add at last of map as the most recent
            lhm.put(key,value);   // adds element at the end
        }
        else    // doesnt contain key
        {
                if(currSize < totalSize)
                {
                    lhm.put(key,value);
                    currSize++;
                }
                else
                {
                    int firstEle=0;
                    
                    // in linkedhashmap, we have to give key of the element to be removed, there is no provision to remove the element at the front of the map.
                    // so that is the reason why we are trying  to get the first element by iterating thru the map and get the first element and break the loop.
                    for(Map.Entry<Integer,Integer> entry : lhm.entrySet())
                    {
                        firstEle = entry.getKey();
                        break;
                    }
                    
                    lhm.remove(firstEle);   // removing the first node
                    lhm.put(key,value);
                }
        }
        
    }
}
