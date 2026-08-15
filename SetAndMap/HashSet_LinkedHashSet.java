package SetAndMap;
import java.util.*;
class HashSet_LinkedHashSet{
    public static void main(String[] args) {
        /*----------HashSet---------- */

        //Constructors of HashSet (Same for LinkedHashSet, replace HashSet->LinkedHashSet)

        //1: Empty HashSet with standard capacity of 16
        Set<Integer> s1 = new HashSet<>();

        //2. HashSet with some initial capacity
        Set<Integer> s2 = new HashSet<>(100);

        //3. HashSet with initial capacity and load factor
        Set<Integer> s3 = new HashSet<>(100,0.8f);

        //4. Using another collection
        Set<Integer> s4 = new HashSet<>(List.of(1,2,3,4,5,6,7,8));
    }
}