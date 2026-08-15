package SetAndMap;
import java.util.*;

public class DeclarationOfSetAndMap {
    public static void main(String[] args) {
        /*-------SET-------- */
        Set<String> set = new HashSet<>();
        //adding elements to set
        set.add("Prakhar");
        set.add("Tushar");   
        set.add("Aman");
        
        //checking if set contains a specific element
        System.out.println(set.contains("Prakhar")); //true

        /*-------MAP-------*/
        Map<Integer,String> map = new HashMap<>();
        //adding elements to map
        map.put(1,"Prakhar");
        map.put(2,"Tushar");
        map.put(3,"Aman");
        
        //checking if key is present in map
        System.out.println(map.containsKey(1)); //true

        //get value corresponding to the key
        System.out.println(map.get(1)); //Prakhar
    }
}
