package IterableInterface;
import java.util.*;

public class IterableInterface{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // List<Integer> list = new LinkedList<>(); This will also work for iteration, no need to change the code
        //Collection<Integer> list = new LinkedList<>(); This will also work fine, no need to change the code.
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        
        //according to heirarchy of collection framework, List interface extends Collection interface and Collection interface extends Iterable interface. Therefore, whatever methods are there in Iterable interface, must be overriden by the concrete classes, therefore Iterator() method in Iterable interface should be overridden by ArrayList.
        
        Iterator<Integer> it = list.iterator(); //list.iterator() returns and object iterator of type Iterator<Integer>, which will be used to iterate over the elements.

        while(it.hasNext()){ //hasNext() return true or false depending on existence of next element in the collection.
            System.out.println(it.next()); //it.next() return the next element and moves the iterator forward
        }

        /* -----------Concurrent Modification Exception */

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        Iterator<Integer> i = list2.iterator();
        while(i.hasNext()){
            int value = i.next();
            if(value == 3){
                list2.remove(value); 
                /*Note - We are using remove() method of List and not Iterator and hence we get the exception. Iterator's remove() method does not take any arguments and removes last traversed element and hence is safe. */

                //we will get exception here
            }
            System.out.println(value);
        }
    }
}