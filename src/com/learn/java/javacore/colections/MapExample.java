package com.learn.java.javacore.colections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Does not extend Collection interface like the others.
 * Maps keys to a values.
 * Cannot contain duplicate keys.
 * Each key can map to at most one value.
 * It models the mathematical function abstraction.
 * User: Ionut Barau (ionutbarau)
 * Maps work on th principle of hashing. It uses the hashcode of the key in order to decide in which bucket to put the key-value pair.
 * If 2 keys have the same hashcode, then it puts both pairs in the same bucket, and upon retrieval is uses the equals
 * method of the key in order to differentiate between pairs.
 * Iterators are fail-fast (which means they will throw ConcurrentModificationException if Collection
 * is modified structurally once Iteration begins).
 *
 * ConcurrentHashMap should be used instead of Hashtable if we want to have thread-safety.
 *
 * Project: java-core
 * Date: 16/08/2018.
 * Time: 22:33
 */
public class MapExample {

    public void basicOperations(){
        System.out.println("--- Map basic operations ---");
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"John");
        map.put(2,"Joe");
        map.put(3,"Jane");
        System.out.println("Map after put : " + map);
        System.out.println("Map size : " + map.size());
        System.out.println("Map is empty ? " + map.isEmpty());
        System.out.println("Map contains key 1 ? " + map.containsKey(1));
        System.out.println("Map contains value John ? " + map.containsKey("John"));
        map.remove(1);
        System.out.println("Map after remove John : " + map);
        map.replace(2,"Gina");
        System.out.println("Map after replace Joe with Gina : " + map);
    }

    public void bulkOperations(){
        System.out.println("--- Map bulk operations ---");
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"John");
        map.put(2,"Joe");
        map.put(3,"Jane");
        System.out.println("Map at the beginning : " + map);
        Map<Integer,String> mapToPut = new HashMap<>();
        mapToPut.put(6,"Greg");
        map.putAll(mapToPut);
        System.out.println("Map after putAll : " + map);
        map.replaceAll((integer,s) ->  "test");
        System.out.println("Map after replaceAll : " + map);
        map.clear();
        System.out.println("Map after clear : " + map);
    }

    public void collectionViews(){
        System.out.println("--- Map collection views ---");
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"John");
        map.put(2,"Joe");
        map.put(3,"Jane");

        System.out.println("Map keySet : " + map.keySet());
        System.out.println("Map entrySet : " + map.entrySet());
        System.out.println("Map values : " + map.values());
    }

    /**
     * Permits null values and null keys. However if we decide to put a null key twice, it will override the first.
     * It is not synchronized.
     * The bucket itself is a simple linked list with one node (Not java.util.LinkedList because it is doubly linked, has 2 nodes).
     * Makes no guarantees as to the order of the map.
     * The order is not guaranteed to be constant over time.
     * Operations (add, contains, remove) are faster than LinkedHashMap and TreeMap.
     * Iteration is slower than LinkedHashMap and TreeMap.
     * It is not synchronized.
     */
    public void hashMapImplementation() {
        System.out.println("--- HashMap implementation ---");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,"John");
        hashMap.put(2,"Joe");
        hashMap.put(3,"Jane");
        hashMap.put(null,null);
        hashMap.put(null,null);
        System.out.println(hashMap);
    }

    /**
     * Permits null values and null keys. However if we decide to put a null key twice, it will override the first.
     * Is implemented as a hash table with a doubly linked list running through it.
     * The bucket itself is a doubly linked list with 2 nodes (java.util.LinkedList).
     * Elements are order by insertion order.
     * Operations (add, contains, remove, size) are slower than HashMap but faster than TreeMap.
     * Iteration is slower than TreeMap but faster than HashMap.
     * It is not synchronized.
     */
    public void linkedHashMapImplementation(){
        System.out.println("--- LinkedHashMap implementation ---");
        Map<Integer, String> linkedHashMap = new HashMap<>();
        linkedHashMap.put(1,"John");
        linkedHashMap.put(2,"Joe");
        linkedHashMap.put(3,"Jane");
        linkedHashMap.put(null,null);
        linkedHashMap.put(null,null);
        System.out.println(linkedHashMap);
    }


    /**
     * Does not permit null keys, but permits null values.
     * It is sorted according with the natural ordering of it's keys, or by a Comparator depending on the constructor.
     * Operations (add, contains, remove, size) are slower than HashMap and LinkedHashMap.
     * It uses Red Black algorithm.
     * Iteration is the fastest.
     * It is not synchronized.
     */
    public void treeMapImplementation(){
        System.out.println("--- TreeMap implementation ---");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1,"John");
        treeMap.put(2,"Joe");
        treeMap.put(3,null);
        System.out.println(treeMap);
    }


}
