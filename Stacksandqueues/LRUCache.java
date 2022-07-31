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

package Stacksandqueues;

import java.util.*;

public class LRUCache {

    static Map<Integer,Integer> lookup;
    static int totalSize;
    static int currSize;

    
    LRUCache(int cap)
    {
        // Intialize the cache capacity with the given
        // cap
         totalSize = cap;
         currSize = 0;
      //  deque = new LinkedList<>();
        lookup = new LinkedHashMap<>();
    }

    // This method works in O(1)
    public static int get(int key)
    {
        if(lookup.containsKey(key))
        {
            int val = lookup.get(key);
            // remove node from in-between and insert at the end as the latest accessed
            lookup.remove(key);
            lookup.put(key,val);
            return val;
        } 
        else 
        {
            return -1;
        }
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
            // this case is where key is already present in hash table.
           if(lookup.containsKey(key))
           {
                lookup.remove(key); // remove from in-between and insert at the end as the latest accessed
                // add at last of map as the most recent
                lookup.put(key,value);  //adds the element at the end of hashtable
           } 
           else 
           {
                if(currSize < totalSize)
                {
                //  deque.addLast(key);
                    lookup.put(key,value);  // add element at the end of map as its recently accessed
                    
                    currSize++;
                } 
                else 
                {
                    int firstEle = 0;
                
                    // in linkedhashmap, we have to give key of the element to be removed, there is no provision to remove the element at the front of the map.
                    // so that is the reason why we are trying  to get the first element by iterating thru the map and get the first element and break the loop.
                    for(Map.Entry<Integer,Integer> entry: lookup.entrySet())
                    {
                        firstEle = entry.getKey();
                        break;
                    }
                    lookup.remove(firstEle); // removing the first node

                    // the below commented code is used when implemented thru deque.
                // int lru = deque.removeLast();
                //  lookup.remove(lru);
                // deque.addFirst(key);

                    lookup.put(key,value);
                }
        }
    }
    
}

// Below is another method with DLL and HashMap

/*      
    class LRUCache {
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int key,int val){
            this.val=val;
            this.key=key;
        }
    }
    
    public HashMap<Integer,Node> map=new HashMap<>();
    public Node head;
    public Node last;
    public int capacity;
    
    public LRUCache(int capacity) {
        head=new Node(0,0);
        last=new Node(0,0);
        this.capacity=capacity;
        
        head.next=last;
        last.prev=head;
    }
    
    public int get(int key) {
        Node node=map.get(key);
        if(node==null){
            return -1;
        }
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        if(map.size()==capacity){
            remove(last.prev);
        }
        insert(new Node(key,value));
    }
    
    // insertion is done at front of DLL
    public void insert(Node node){
        map.put(node.key,node);
        
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
    
    // Deletion is done at last of DLL
    public void remove(Node node){
        map.remove(node.key);
        
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}


*/

// Another method using deque and Hash map.

/*

class LRUCache {

    int size;
    public Deque<Integer> dq;
    public HashMap<Integer,Integer> hm;
    
    public LRUCache(int capacity) {
         size = capacity;
        dq = new LinkedList<>();
        hm = new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))
            return -1;
        dq.remove(key);
        dq.addFirst(key);
        return hm.get(key);
        
    }
    
    public void put(int key, int value) {
        if(!hm.containsKey(key))
       {
           if(dq.size()==size)
           {
                int k = dq.removeLast();
                hm.remove(k);
           }
            dq.addFirst(key);
            hm.put(key,value);
       }
       else
       {
           hm.put(key,value);
           dq.remove(key);
           dq.addFirst(key);
       }
    }
        
    }

*/