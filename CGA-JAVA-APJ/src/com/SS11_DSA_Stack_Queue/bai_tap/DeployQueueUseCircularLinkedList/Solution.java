package com.SS11_DSA_Stack_Queue.bai_tap.DeployQueueUseCircularLinkedList;

public class Solution {
    public static void main(String args[])
    {
        Queue queue = new Queue();
        queue.front = queue.rear =  null;

        queue.enQueue(queue,15);
        queue.enQueue(queue,2);
        queue.enQueue(queue,11);

        queue.displayQueue(queue);

        System.out.printf(" \n Xóa giá trị = %d", queue.deQueue(queue));
        System.out.printf(" \n Xóa giá trị = %d", queue.deQueue(queue));

        queue.displayQueue(queue);

        queue.enQueue(queue, 7);
        queue.enQueue(queue, 14);
        queue.displayQueue(queue);
    }
}
