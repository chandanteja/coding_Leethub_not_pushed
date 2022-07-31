
package Leetcodequestions;

/**
 * 
 * * https://leetcode.com/problems/smallest-string-with-swaps/
 * 
 * * https://leetcode.com/problems/smallest-string-with-swaps/discuss/1615090/Java-Solution-using-Union-Find-and-HashMap     --> good solution
 * 
 * 
 * * problem statement:

You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] 
indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.
 * 
 * we can swap given pairs any number of times to get smallest string.
 * 
 * steps:
 * 1. combine given pairs i.e. perform union on each pair in the given pairs
 * 2. then once we get unions then for each parent put all its children in a map.
 *    how to do this? - so first iterate through the string, for each character (i.e. s[i]) find its parent/representative.
 *    now add this representative as the key to the map.
 *    now for this map insert the current element i.e. s[i].
 *    
 *    repeat this for all characters of the String.
 * 3. then take values from the map and iterate through this list. while iterating, reverse sort each values list.
 *    we are sorting in reverse because we want smallest string possible.
 * 4. once all the values lists are reverse sorted now do the following:
 *    traverse the string.
 *    for each character in the string find the parent. now get the list for that parent from the map.
 *    after getting that list, now take the last element from that list and add it to the result.
 * 
 *    in this step 2 points are important: 
 *      1. traversing the string from left to right. --> this is performed to ensure that 
 *          we want our resultant string to be smallest possible order of the current string obtained by performing 
 *          swaps on given pairs. so while considering these swaps we will consider swapping 1st elemnt first to get alphabetically
 *          smallest string. thus we need to traverse from left to right.
 * 
 *      2. finding the parent for each element and getting its list from the map and taking the last element.
 *          this step is performed to get alphabetically smallest string.
 *          the map essentially contains reverse sorted characters for each component.
 *          so traverse from left to right and keep adding to the result string.
 * 
 * 
 */


import java.util.*;

public class SmallestStringWithSwaps 
{
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        UnionFind uf = new UnionFind(s.length());
        
        // performing union for all given pairs
        for(List<Integer> l: pairs) // take each pair and perform union operation on them.
        {
            int x = l.get(0);
            int y = l.get(1);
            uf.unionByRank(x, y);
        }
        
        // then put them in map based on parent.
        HashMap<Integer, ArrayList<Character>> m = new HashMap<Integer, ArrayList<Character>>();
        
        for(int i=0;i<s.length();i++) // traverse String left to right and 
        {
            int parent = uf.findByPathCompression(i); // for each character find the parent.
            if(!m.containsKey(parent)) m.put(parent, new ArrayList<Character>()); // put the parent in the map and
            m.get(parent).add(s.charAt(i)); // add the current character to the parent's list because "current character" belongs
            // to the component whose root is "parent"
        }
        
        // reverse sort the characters in each map list.
        for(List<Character> c: m.values()) // now iterate through the list of values from the map and 
        // in this above step, List reference is returned thus when we performed reverse sorting, original values are
        // effected instead of copy.
        {
            Collections.sort(c, Collections.reverseOrder()); // reverse sort them.

            
        }
        
        // now take characters list and take its last element and put in the result;
        StringBuilder result=new StringBuilder(); // we have to append to the result this take StringBuilder object.
        
        for(int i=0;i<s.length();i++) // now traverse the string from left to right
        {
            List<Character> li = m.get(uf.findByPathCompression(i)); // for each character find the parent of this character.
            // get the values for this parent.
            Character currentMin = li.remove(li.size()-1); // from the obtained list remove the last element.
            
            result.append(currentMin); // add this last element to the result.
            
        }
        return result.toString(); // return the result. to convert StringBuilder to String, use toString() method.
        
    }
    
}

class UnionFind
{
    int parent[], rank[];
    
    public UnionFind(int size)
    {
        parent = new int[size];
        rank = new int[size];
        
        for(int i=0;i<size;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
    }   
    
    public int findByPathCompression(int x)
    {
        if(x==parent[x])
            return x;
        
        parent[x]=findByPathCompression(parent[x]);
        return parent[x];
    }
    
    public void unionByRank(int x, int y)
    {
        int xRep = findByPathCompression(x);
        int yRep = findByPathCompression(y);

        if(xRep == yRep)
            return;
        if(rank[xRep]<rank[yRep])
            parent[xRep]=yRep;
        else if(rank[yRep]<rank[xRep])
            parent[yRep]=xRep;
        else
        {
            parent[yRep]=xRep;
            rank[xRep]++;
        }
    }
    
}