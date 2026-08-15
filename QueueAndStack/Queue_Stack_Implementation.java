package QueueAndStack;
import java.util.*;

public class Queue_Stack_Implementation {
    public static void main(String[] args) {        
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        /*---ArrayDeque as Single Ended Queue---*/

        //adding elements to queue -> enqueue
        queue.add(1); //Throws exception if fails
        queue.offer(2); //Never throws exception, instead returns false, safer than add
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        //print front element
        System.out.println(queue.peek()); //Will return null, safer
        System.out.println(queue.element());//Throws exception

        //remove element
        queue.remove();//throws exception
        queue.poll(); //safer

        /*               
                            Queue
                              |
                    ----------------------
                    |          |          |
                Insert        Remove      Inspect
                add(E e)      remove()    element() }unsafe
                offer(E e)    poll()      peek()    }safe
        */


         /*               
                     Doubly Ended Queue
                              |
                    ---------------------------------
                    |               |               |
                Insert             Remove           Inspect
                addFirst(E e)     removeFirst()     getFirst()       }unsafe 
                addLast(E e)      removeLast()      getLast()        }unsafe
                offerFirst(E e)   pollFirst()       peekFirst()      }safe
                offerLast(E e)    pollLast()        peekLast()       }safe
        */    
       
        /*-----Stack-----*/

        /* This uses deque's functions as follows
        
            Stack      Deque
            push(E e)  offerFirst()
            pop()      pollFirst()
            peek()     peekFirst()
        */
    }
}
