package SetAndMap;
import java.util.*;
public class TreeSet_Methods {
    public static void main(String[] args) {
        /*--------Tree Set--------- */

        //Constructors:

        //1. Empty TreeSet
        TreeSet<Integer> s1 = new TreeSet<>();

        //2. TreeSet from another collection
        // TreeSet<Integer> s2 = new TreeSet<>(List.of(2,5,7,9));

        //adding to tree set;
        s1.add(80);
        s1.add(90);
        s1.add(23);
        s1.add(10);
        s1.add(50);

        /*----Methods from Sorted Set Interface--------*/

        //smallest value
        System.out.println(s1.first());

        //largest value
        System.out.println(s1.last());

        //elements strictly less than the element passed in the argument
        System.out.println(s1.headSet(50)); //50 exlusive

        //elements greater than the element passed in the argument
        System.out.println(s1.tailSet(50)); //50 inclusive
        
        //range of elements
        System.out.println(s1.subSet(23,90)); //fromElement is inclusive, toElement is exclusive

        /*---------Navigable Set------------*/
        
        //returns largest number which is smaller than the input number
        System.out.println(s1.lower(80));

        //returns greatest element less than or equal to input number
        System.out.println(s1.floor(80));

        //returns smallest number which is greater than the input number
        System.out.println(s1.higher(80));

        //returns smallest element greater than or equal to input number    
        System.out.println(s1.ceiling(80));

        //returns and removes the smallet number from the TreeSet
        System.out.println(s1.pollFirst());

        //returns and removes the largest number from the TreeSet
        System.out.println(s1.pollLast());

        //return set in descending order
        System.out.println(s1.descendingSet());

        //descendingIterator
        Iterator<Integer> it = s1.descendingIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //Same methods from Sorted Set but with choice of including the fromElement, toElement by using boolean
        System.out.println(s1.headSet(80, true));
        System.out.println(s1.tailSet(80, false));
        System.out.println(s1.subSet(23, false, 80, false));
    }
}
