package com.learn.java.javacore.colections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Extends Collection interface.
 * Cannot contain duplicate elements.
 * Cannot access elements by index. We can just iterate in order to get a specific element.
 * Can contain at most 1 element that is null.
 * Contains only methods from Collection, and adds the restriction that duplicates are not allowed. Also
 * Models the mathematical set abstraction.
 * All implementations use a Map implementation underneath, where the key is the value passed to the set, and the value is a dummy object.
 * e.g. map.put(3,new Object());
 *
 *
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 16/08/2018.
 * Time: 20:30
 */
public class SetExample {


    /**
     * It is the best performing implementation. Operations(add, remove, contains) are faster than in LinkedHashSet or TreeSet, because
     * it does not provide any order or sorting.
     * Iteration is likely to be slower than LinkedHashSet.
     * HashSet is is backed by a HashMap. It makes no guarantees as to the iteration order of the set. It does not
     * guarantee that the order will remain constant overtime.
     * Permits the null element.
     * Because it is using a HashMap underneath, good hashcode and equals for the elements is needed.
     * All the operations are performed on the backing HashMap.
     * It is not synchronized.
     */
    public void hashSetImplementation() {
        System.out.println("--- HashSet implementation ---");
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(null);
        System.out.println(hashSet);

    }

    /**
     * Extends HashSet.
     * It uses a LinkedHashMap internally that is implemented as a hash table with a doubly linked list running through it.
     * Orders it's elements by insertion order.
     * This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries.
     * The LinkedList defines the iteration ordering.
     * Permits null elements.
     * It is not synchronized.
     * Operations(add, remove, contains) are faster than TreeSet but slower than HashSet, because it does provide an order but no sorting.
     * Iteration is faster than HashSet but slower than TreeSet.
     *
     */
    public void linkedHashSetImplementation(){
        System.out.println("--- LinkedHashSet implementation ---");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(null);
        linkedHashSet.add(2);
        linkedHashSet.add(2);
        System.out.println(linkedHashSet);

    }

    /**
     * Implements SortedSet and NavigableSet.
     * It's operations(add, remove, contains) are the slowest of all because it's elements are sorted.
     * Iteration is the fastest out of all Map implementations.
     * The elements are stored in a red-black tree and are ordered based on the
     * natural ordering of it's values (or Comparator if provided).
     * It uses a TreeMap internally.
     * It is usually better to create a HashSet and convert it into a TreeSet if you want ordering (new TreeSet(myHashSet)).
     * It is not synchronized.
     * Does not permit null.
     */
    public void treeSetImplementation(){
        System.out.println("--- TreeSet implementation ---");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        System.out.println(treeSet);
    }


}
