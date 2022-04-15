package com.SS10_DSA_Stack_Queue.bai_tap.DeployQueueUseCircularLinkedList;

public class Queue {
    public Node front;
    public Node rear;

    public void enQueue(Queue  queue, int value)
    {
        Node  temp = new Node();
        temp.data = value;
        if (queue.front ==  null){
            queue.front = temp;
        }
        else{
            queue.rear.link = temp;
        }

        queue.rear = temp;
        queue.rear.link = queue.front;
    }

    public int deQueue(Queue queue)
    {
        if (queue.front ==  null) {
            System.out.printf ("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int value;
        if (queue.front == queue.rear) {
            value = queue.front .data;
            queue.front =  null;
            queue.rear =  null;
        }
        else {
            Node temp = queue.front;
            value = temp.data;
            queue.front = queue.front.link;
            queue.rear.link= queue.front;
        }
        return value ;
    }
    public void displayQueue(Queue  queue)
    {
        Node  temp = queue.front;
        System.out.printf("\n Elements trong hàng chờ Queue là: ");
        while (temp .link != queue.front)
        {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }
}
