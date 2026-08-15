package SetAndMap;
import java.util.*;
public class Map_Methods {
    public static void main(String[] args) {
        Map<Integer,String> mp = new HashMap<>();
        mp.put(1110,"Prakhar");
        mp.put(1036,"Anant");
        mp.put(1126,"Abhishek");

        //size of map
        mp.size();

        // check if Map is Empty
        mp.isEmpty();

        //does map contain a key and a value? returns true of false
        mp.containsKey(1110);
        mp.containsValue("Prakhar");

        //Note: map.put returns null when a new key is added to the map and returns old value if already existing key is updated with new value
        System.out.println(mp.put(1563,"Aman")); //returns null
        System.out.println(mp.put(1110,"Tushar")); //returns Prakhar
        System.out.println(mp.get(1110)); //returns Tushar

        //remove key fro map
        mp.remove(1110);

        //putAll for adding key-values in bulk
        Map<Integer,String> mp2 = new HashMap<>();
        mp.putAll(mp2); //now whatever is there in mp2 will go in mp

        //clear the map
        // mp.clear();

        /*---IMP Methods of MAP---*/

        //create set of keys in a map
        // Set<Integer> st = mp.keySet();

        //create collection of type string of values
        // Collection<String> c = mp.values();

        //returns key-value pair using Entry
        //Entry is a sub-interface of Map interface. entrySet() returns Set of all the entries of the map.
        Set<Map.Entry<Integer,String>> entries = mp.entrySet();
        System.out.println(entries); //O/p: [1126=Abhishek, 1563=Aman, 1036=Anant]

        //getOrDefault - returns the defaultValue if we try to get a key which is not present in the map, instead of NULL we will get defaultValue
        System.out.println(mp.getOrDefault(1110, "XYZ"));

        //putIfAbsent - if key already present, will NOT update the value, if key does not exist, then create a new entry in the map
        mp.putIfAbsent(1054, "Priyansh");

        //if key and value both matches, only then remove
        mp.remove(1054, "Priyansh");

        //replace - replaces value of the already existing key. If key not present, will not insert it in the map, this is how it is different form the put's default behaviour
        mp.replace(1110, "Prakhar");

        //replaces only if key and value matches
        mp.replace(1110,"Prakhar", "Tushar");

        //getKey and getValue for every entry is Map.Entry
        // Set<Map.Entry<Integer,String>> entries2 = mp.entrySet();
        // for(Map.Entry<Integer,String> entry:entries2){{
            // Integer key = entry.getKey();
            // String value = entry.getValue();
        // }}

        //static method to create immutable map .of()
        // Map<Integer,String> map = Map.of(101,"A", 102,"B");
    }
}
