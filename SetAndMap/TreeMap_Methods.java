package SetAndMap;
import java.util.*;
public class TreeMap_Methods {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(101,"Prakhar");
        map.put(102,"Tushar");
        map.put(103,"Aman");

        //similar to TreeSet, majority methods are same in TreeMap also, we just have to add "Key" in the names of methods. Eg: In TreeSet, we have a method of "first", here we have "firstKey".

        /*-----SORTED MAP-----*/
        //firstKey - fetches smallest key 
        map.firstKey();

        //lastKey - fetches largest key
        map.lastKey();

        //firstEntry - fetches first entry (key-value)pair from the map
        map.firstEntry();

        //lastEntry - fetches last entry from the map
        map.lastEntry();

        //headMap - get values lower than input value
        map.headMap(102);

        //tailMap - get values larger than and equal to input value
        map.tailMap(102);

        //subMap - get a subMap-> from inclusive, to exclusive
        map.subMap(102,103);

        /*------NAVIGABLE MAP------*/
        
        //Sorted Map
        //lowerKey(), lowerEntry(), higherKey(), higherEntry(), floorKey(), floorEntry(), ceilingKey(), ceilingEntry(), pollFirstEntry(), pollLastEntry(), descendingMap(), descendingIterator(), headMap(overidden), tailMap(overidden), subMap(overidden) --> Same as TreeSet memthods, for details check TreeSet_Methods.java


    }
}
