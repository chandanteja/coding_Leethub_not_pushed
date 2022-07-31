/**
 * 
 * We perform insertion at the end of LL and deletion at beginning of LL. So we need to implement those logics.
 * 
 */

package Stacksandqueues;

public class QueueUsingLinkedList {

    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int data,QueueNode next)
        {
            this.data = data;
            this.next = next;
        }

    }

    QueueNode front= null;
    QueueNode rear = null;

    public boolean isEmpty()
    {
        if(front == rear)
            return true;
        return false;

    }

    public void enqueue(int x)
    {
        QueueNode temp =new QueueNode(x, null);

        if(rear == null)
        {
            rear = temp;
            front = temp;
        }
        else
        {
            rear.next = temp;
            rear = rear.next;
        }
    }

    public int dequeue()
    {
        if(front==rear)
        {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        else
        {
            int data = front.data;
            front = front.next;
            return data;
        }
    }

    public int front()
    {
        if(front==rear)
        {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    public int rear()
    {
        if(front==rear)
        {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }  

        return rear.data;
    }

    public static void main(String[] args)
    {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
 
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());

        System.out.println("\n"+queue.dequeue() + " dequeued from queue\n");
 
        System.out.println("Front item is " + queue.front());

        System.out.println(queue.dequeue() + " dequeued from queue\n");

        System.out.println("Front item is " + queue.front());
 
        System.out.println("Rear item is " + queue.rear());
    }


    
}
