/**
 * 
 * https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 * 
 * Logic is we perform insertion and deletion at the beginning of LL.
 * 
 * 
 */

package Stacksandqueues;

public class StackUsingLinkedList {

   static class StackNode
    {
        int data;
        StackNode next;

        StackNode(int data, StackNode next)
        {
            this.data = data;
            this.next = next;
        }
        StackNode()
        {
            this.data = 0;
            this.next = null;
        }

    }

    public boolean isEmpty(StackNode top)
    {
        if(top==null)
            return true;
        return false;
    }

    public StackNode push(int x, StackNode top)
    {
        StackNode curr = new StackNode(x,null);
        
        if(top == null)
        {
            
            top = curr;
            System.out.println("top.data: "+ top.data);
            return top;
        }
        else
        {
            curr.next = top;
            top = curr;
            return top;
        }


    }

    public int peek( StackNode top )
    {
        if(top==null)
        {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        else
            return top.data;
    }

    public int pop(StackNode top)
    {
        if(top==null)
        {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        else
        {
            int data = top.data;
            top = top.next;
            return data;
        }
    }
    public static void main(String[] args)
    {
 
        StackUsingLinkedList sll = new StackUsingLinkedList();
        StackNode node1 = null;
        node1 = sll.push(10,node1);
        System.out.println("Top element is " + sll.peek(node1));
        node1= sll.push(20,node1);
        System.out.println("Top element is " + sll.peek(node1));
        node1= sll.push(30,node1);
        System.out.println("Top element is " + sll.peek(node1));
        node1= sll.push(40,node1);
        System.out.println("Top element is " + sll.peek(node1));
 
        System.out.println(sll.pop(node1) + " popped from stack");
 
        System.out.println("Top element is " + sll.peek(node1));
    }
    
}
