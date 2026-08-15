package QueueAndStack;
import java.util.*;

class Priority_Queue{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(20);
        pq.offer(40);
        pq.offer(30);
        pq.offer(50);

        //Since PriorityQueue uses Min Heap by default, poll() should return and delete minimum element from the PQ Array

        System.out.println(pq.poll()); //returns 10 and deletes it from the PQ

        //To make Max Heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->b-a);
        pq2.offer(10);
        pq2.offer(20);
        pq2.offer(40);
        pq2.offer(30);
        pq2.offer(50);

        //Now if I poll, max element will be returned and delete
        System.out.println(pq2.poll());

        /*               
                        Priority Queue
                              |
                    ----------------------
                    |          |          |
                Insert        Remove      Inspect
                add(E e)      remove()    element() }unsafe
                offer(E e)    poll()      peek()    }safe
        */
    }
}