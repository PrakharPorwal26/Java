package CollectionInterface;
import java.util.*;
public class CollectionInterface {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();

        //add to the collection using add()
        c.add(1);
        c.add(2);
        c.add(3);

        //size() - return the size of the collection
        System.out.println("Size of the collection is: " + c.size());

        //isEmpty() - checks if collection is empty or not
        System.out.println("Is collection empty? " + c.isEmpty());

        //contains() - takes and object as an argument and checks if the collection contains that object or not. It takes object as argument because Collection interface is generic and can hold any type of object.
        System.out.println("Does the collection contain 2? " + c.contains(2));

        //iterator() - already seen in IterableInterface.java 

        // Object[] toArray()  - returns an array containing all of the elements in the collection in the form of an array.
        Object[] arr = c.toArray();
        for(Object o: arr){{
            System.out.println(o);
        }}

        //T[] toArray(T[] a) - returns an array containing all of the elements in the collection. The runtime type of the returned array is that of the specified array.
        Integer[] a = c.toArray(new Integer[0]); //we pass new Integer[0] because we want the returned array to be of type Integer.

        for(Integer i : a){
            System.out.println(i);
        }
        
        //boolean add(E e) - adds the specified element to the collection. Return true if successful else false.
        boolean added = c.add(4);
        System.out.println("Was the element added? " + added);

        //boolean remove(Object o) - removes the first instance of the specified element from the collection if present, returns true if successful else false.

        //boolean addAll(Collection<? extends E> c) - adds all of the elements in the specified collection to this collection. Argument is ? extends E to ensure typesafety. 
        Collection<Integer> c2 = new ArrayList<>();
        c2.addAll(c);
        System.out.println("Elements in c2: " + c2);

        //boolean containsAll(Collection<?> c) -> Argument is ? because we need to use equals() method of object class.

        //boolean removeAll(Collection<?> c)

        //boolean retainAll(Collection<?> c) - removes all of the elements from the collection apart from those mentioned in the args.
        
        //clear() - empties the container
    }
}
