/**
 * 
 *  Refer IIT-KGP notes on queues and stacks for conditions
 * 
 * https://cse.iitkgp.ac.in/~ppd/course/pds/Lect-28-Stack-Queue.pdf
 * 
 *  we use logic as below
 *  
 *  front = rear = 0;
 *  
 * empty ==> front == rear
 * full ==> (rear == max_size-1) for normal queue   or  for circular queue ( front == (rear+1) % maxsize)  
 * 
 * enqueue  -- normal queue
 * ==========
 *  add element at rear and increase rear  ==> arr[rear++] = ele
 *  delete element at front and increase front. ==> ele = arr[front++]
 *  
 * enqueue -- circular queue
 * ========================
 * 
 * rear = (rear+1) % size           --> enqueue
 * front = (front + 1) % size;      --> dequeue
 * 
 */

package Stacksandqueues;

public class QueueUsingArrays {
    
    final int MAX_SIZE ;
    int queue[];
    int front;
    int rear;

    QueueUsingArrays()
    {
        MAX_SIZE = 100;
        queue = new int[MAX_SIZE];
        front=rear = 0;

    }

    public boolean isFull()
    {
        if(rear == MAX_SIZE-1)
            return true;
        else
            return false;

            /*
                for circular queue

                front = (rear+1)%size
            */
    }

    public boolean isEmpty()
    {
        if(front==rear)
            return true;
        else
            return false;

            /*
                for circular queue

                same as front == rear
            */

    }

    public void enqueue(int x)
    {
        if(isFull())
        {
            System.out.println("Queue is full");
            return;
        }
        else
        {
            queue[rear++] = x;

        }
        /*
            for circular queue

            rear = (rear+1)%size

        */


    }

    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        else
        {
            int ele = queue[front++];
            return ele;
        }

        /*
            for circular queue

            front = (front+1)%size

        */

    }

    public int frontEle()
    {
        if(isEmpty())
            return Integer.MIN_VALUE;
        else
            return queue[front];
    }

    public int rearEle()
    {
        if(isEmpty() || rear==0)
            return Integer.MIN_VALUE;
        else
            return queue[rear-1];
    }


    public static void main(String[] args)
    {
        QueueUsingArrays queue = new QueueUsingArrays();
 
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front item is " + queue.frontEle());
        System.out.println("Rear item is " + queue.rearEle());
 
        System.out.println("\n"+queue.dequeue() + " dequeued from queue\n");
 
        System.out.println("Front item is " + queue.frontEle());

        System.out.println(queue.dequeue() + " dequeued from queue\n");

        System.out.println("Front item is " + queue.frontEle());
 
        System.out.println("Rear item is " + queue.rearEle());
    }

}
