/**
 * 
 * https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1#
 * 
 * Note: If two elements have same frequency, then the element which occur at first will be taken on the left of Binary Tree and other one to the right.
 * 
 * 
 * Refer GFG self paced DSA course --> Greedy
 * 
 * 
 */

package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node{
    
    char c;
    int freq;
    Node left,right;
    
    Node(char ch,int f,Node l,Node r)
    {
        c=ch;
        freq=f;
        left=l;
        right=r;
    }
}

public class HuffmanCoding {

    ArrayList<String> res = new ArrayList<>();
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        //PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)-> (n1.freq-n2.freq));
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.freq == o2.freq)      // this check is added bcz of note given above. i.e if 2 elements have same freq then element which came first will be left of Binary tree.
                    return 1;
                return Integer.compare(o1.freq, o2.freq);
            }
        });

       for(int i=0;i<N;i++)
       {
           pq.add(new Node(S.charAt(i),f[i],null,null));
       }
       
       while(pq.size()>1)
       {
           Node l = pq.poll();
           Node r = pq.poll();
           pq.add(new Node('$',l.freq+r.freq,l,r));
       }
       
       
        preOrder(pq.peek(),"");
        return res;
    }
    
    public void preOrder(Node root,String s)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            {
                res.add(s);
                return;
            }
        
        preOrder(root.left,s+"0");
        preOrder(root.right,s+"1");
    }
    
}
