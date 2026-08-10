package ListInterface;
import java.util.*;

public class ListInterface {
    public static void main(String[] args) {

        /*
         * List Interface
         *
         * - Child interface of Collection.
         * - Maintains insertion order.
         * - Allows duplicate elements.
         * - Allows index-based access.
         * - Implementations: ArrayList, LinkedList, Vector, Stack.
         */

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // get(int index)
        // Returns the element present at the specified index.
        System.out.println("Element at index 1 is: " + list.get(1));

        // set(int index, E element)
        // Replaces the existing element at the specified index.
        // Returns the old element that was replaced.
        list.set(1, 10);
        System.out.println("Element at index 1 is now: " + list.get(1));

        // addAll(Collection c)
        // Adds all elements of the given collection at the end.
        // addAll(int index, Collection c)
        // Inserts all elements starting from the specified index.
        list.addAll(0, List.of(9, 8, 7));
        System.out.println(list);

        /* ---------------- List.of() ---------------- */

        /*
         * List.of()
         *
         * Factory method introduced in Java 9.
         * Creates an immutable (read-only) List.
         *
         * Characteristics:
         * - Cannot add, remove or modify elements.
         * - Preserves insertion order.
         * - Does not allow null elements.
         * - Returns an implementation of ImmutableCollections.
         */

        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);

        System.out.println(immutableList);

        // immutableList.add(6);      // UnsupportedOperationException
        // immutableList.remove(0);   // UnsupportedOperationException
        // immutableList.set(0, 100); // UnsupportedOperationException


        /* ---------------- List.copyOf() ---------------- */

        /*
         * List.copyOf(Collection c)
         *
         * Creates an immutable copy of an existing Collection.
         *
         * Characteristics:
         * - Returned List is immutable.
         * - Does not allow null elements.
        * - Changes made to the original collection after copy creation
        *   are NOT reflected in the copied List.
        */

        List<Integer> originalList = new ArrayList<>();
        originalList.add(10);
        originalList.add(20);
        originalList.add(30);

        List<Integer> copiedList = List.copyOf(originalList);

        System.out.println("Original List : " + originalList);
        System.out.println("Copied List   : " + copiedList);

        originalList.add(40);

        System.out.println("Original List after modification : " + originalList);
        System.out.println("Copied List remains unchanged   : " + copiedList);

        // copiedList.add(50); // UnsupportedOperationException


        // remove(int index)
        // Removes the element present at the specified index.
        // Returns the removed element.
        list.remove(0);
        System.out.println(list);

        // indexOf(Object o)
        // Returns index of first occurrence of the element.
        // Returns -1 if element is not present.
        System.out.println("First occurrence of 10: " + list.indexOf(10));

        // lastIndexOf(Object o)
        // Returns index of last occurrence of the element.
        // Useful when duplicate elements are present.
        list.add(10);
        System.out.println("Last occurrence of 10: " + list.lastIndexOf(10));

        /* ---------------- ListIterator ---------------- */

        /*
         * listIterator()
         * Returns a ListIterator object.
         *
         * ListIterator is a child interface of Iterator.
         *
         * Advantages over Iterator:
         * 1. Can traverse in forward direction using next().
         * 2. Can traverse in backward direction using previous().
         * 3. Can add elements during iteration.
         * 4. Can replace elements using set().
         *
         * Available only for List implementations because
         * Lists support positional (index-based) access.
         */

        ListIterator<Integer> it = list.listIterator();

        // Forward Traversal
        while (it.hasNext()) {

            // hasNext() checks whether a next element exists.
            // next() returns the next element and moves cursor forward.
            System.out.println(it.next());
        }

        // Backward Traversal
        while (it.hasPrevious()) {

            // hasPrevious() checks whether a previous element exists.
            // previous() returns the previous element and moves cursor backward.
            System.out.println(it.previous());
        }

        /*
         * Important ListIterator Methods:
         *
         * add(E e)
         * -> Inserts an element at current cursor position.
         *
         * set(E e)
         * -> Replaces the last element returned by next()/previous().
         *
         * remove()
         * -> Removes the last element returned by next()/previous().
         *
         * nextIndex()
         * -> Index of element that would be returned by next().
         *
         * previousIndex()
         * -> Index of element that would be returned by previous().
         */
    }
}