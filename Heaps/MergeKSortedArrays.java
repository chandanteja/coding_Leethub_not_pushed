package Heaps;


/**
 * The logic here is we maintain Min-heap of nodes. Each node has 3 values 1) element 2) array number from which it came 3) next index in that array
 * We maintain a priority queueu of such nodes. Priority queue will have own comparator.
 * We will insert first element from all k-arrays into heap.
 * We will pop the root node from heap and check the array from which it came and next index we need to pick in that array.
 * We will push the next element from the array from which prev ele was deleted to heap.
 *  We repeat this process till heap is empty.
 * T.C : O(N LogK)
 * 
 *  https://courses.cs.washington.edu/courses/cse331/11sp/lectures/slides/04a-compare.pdf
 *   https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/   && https://www.geeksforgeeks.org/merge-k-sorted-arrays/   
 *  Refer node structure from 2nd link of gfg and logic from 1st link of gfg.
 */

 // V.V.V.V.V.IMP

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;



class HeapNode {
   private int element;
    private int arrayNumber;
    private int nextIndexInArray;
    public HeapNode(int element,int arrayNumber,int nextIndexInArray)
    {
        this.element = element;         // element picked froma array
        this.arrayNumber = arrayNumber;     // array number from which the element came from.
        this.nextIndexInArray = nextIndexInArray;   // the index of the element in the array from which it came.
    }
    public int getElement() {
        return element;
    }
    public void setElement(int element) {
        this.element = element;
    }
    public int getArrayNumber() {
        return arrayNumber;
    }
    public void setArrayNumber(int arrayNumber) {
        this.arrayNumber = arrayNumber;
    }
    public int getNextIndexInArray() {
        return nextIndexInArray;
    }
    public void setNextIndexInArray(int nextIndexInArray) {
        this.nextIndexInArray = nextIndexInArray;
    }
   
    
}


public class MergeKSortedArrays {

    public static ArrayList<Integer> mergeKSortedArray(int arr[][])
    {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(new Comparator<HeapNode>(){
            public int compare(HeapNode h1, HeapNode h2)        
            {
                if(h1.getElement() > h2.getElement())       // if first element is greater than 2nd element return 1.
                    return 1;
                if(h1.getElement() == h2.getElement())      // if first element == 2nd ele return 0
                        return 0;
                return -1;              // if 1st ele < 2nd ele return -1. Refer java comparator notes in Algorithms --> Heaps --> PriorityQueues -JAVA
            }
            
        });
        ArrayList<Integer> mergedKSortedArrays = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            
            HeapNode heapNode = new HeapNode(arr[i][0],i,1);

            minHeap.add(heapNode);
        
        }

        Iterator<HeapNode> itr3 = minHeap.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next().getElement());

        // iterate till heap gets emptied.
        while( !minHeap.isEmpty() )
        {
            HeapNode temp = minHeap.poll();
            mergedKSortedArrays.add(temp.getElement());
            int arrayNum = temp.getArrayNumber();
            int indexInArray = temp.getNextIndexInArray();

        
            if( indexInArray>= arr[arrayNum].length )
                continue;
            
            int element = arr[arrayNum][indexInArray++];
            temp = new HeapNode(element,arrayNum,indexInArray);
            minHeap.add(temp);
            
           itr3 = minHeap.iterator();
        
        }
        return mergedKSortedArrays;
    }

    public static void main(String args[])
    {
        int arr[][] = { { 2, 6, 12 },{ 1, 9 },{ 23, 34, 90, 2000 } };

        ArrayList<Integer> mergedArrays = mergeKSortedArray(arr);

        System.out.println("Merged Sorted Arrays is: ");

        Iterator<Integer> itr=mergedArrays.iterator();
       
        while(itr.hasNext())  //check if iterator has the elements
        {  
            System.out.print(itr.next() + " ");  //printing the element and move to next  
        }  



    }
    
}
