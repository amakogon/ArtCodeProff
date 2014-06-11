package ua.artcode.week1.day2;

import ua.artcode.week1.homework.MyHashMap;

import java.util.*;

/**
 * Created by amakogon on 08.06.2014.
 */
public class TestCollections {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Some","New","Elem","String");
        // List, Set, Map
        //List ArrayList LinkedList
        //Set TreeSet TreeMap
        // Map TreeMap

        // Use interface referense
        Set<String> set = new TreeSet<String>();
        set.addAll(stringList);

        for (String s : set){
            System.out.println(s);
        }

        set = new HashSet<String>();
        set.addAll(stringList);
        System.out.println("");
        for (String s : set){
            System.out.println(s);
        }

        ManForHash man1 = new ManForHash("Vova",25);
        ManForHash man2 = new ManForHash("Vova",25);
        ManForHash man3 = new ManForHash("Vasia",45);
        ManForHash man4 = new ManForHash("Bogdan",23);

        Set<ManForHash> manForHashSet = new HashSet<ManForHash>();
        manForHashSet.add(man1);
        manForHashSet.add(man2);
        manForHashSet.add(man3);
        manForHashSet.add(man4);
        System.out.println("Men set");

        Iterator<ManForHash> iterator = manForHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println(man1.equals(man2));
        System.out.println(man1.hashCode() + " | " + man2.hashCode());


        Map<String,String> map = new MyHashMap<String, String>();
//        map = new HashMap<String, String>();
        map.put("one","Apple");
        map.put("one","apple");
        System.out.println(map.get("one"));
    }
}
