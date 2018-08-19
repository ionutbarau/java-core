package com.learn.java.javacore.colections;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * It is the root collection interface out of which every other interface extends (besides Map).
 * It is used instead of child interfaces when maximum generality is desired.
 *
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 16/08/2018.
 * Time: 22:59
 */
public class CollectionExample {

    private final Collection<Integer> col = new ArrayList<>();

    private void initCollection (){
        Integer[] vals = new Integer[]{1,2,3,4,5,6,7,8,9};
        Arrays.stream(vals).forEach(integer -> {
            col.add(integer);
        });

    }

    public void basicOperations(){
        initCollection();
        System.out.println("--- Basic operation ---");
        System.out.println("Size of the collection is " + col.size());
        System.out.println("Collection is empty ? " + col.isEmpty());
        System.out.println("Collection contains element 9 ? " + col.contains(9));
        boolean elementAdded = col.add(10);
        System.out.println("Collection contains element 10 after adding ? " + col.contains(10));
        boolean elementRemoved = col.remove(10);
        System.out.println("Collection contains element 10 after removing ? " + col.contains(10));
    }

    public void bulkOperations() {
        initCollection();
        System.out.println("--- Entire collection operation ---");
        boolean collectionChanged = false;
        Collection subset = new ArrayList<>();
        subset.add(1);
        subset.add(2);
        System.out.println("Collection contains subset ? " + col.containsAll(subset));
        collectionChanged = col.removeAll(subset);
        System.out.println("Collection contains subset after removing ? " + col.containsAll(subset));
        collectionChanged = col.addAll(subset);
        System.out.println("Collection contains subset after adding ? " + col.containsAll(subset));
        collectionChanged = col.retainAll(subset);
        System.out.println("Collection contains subset after retain ? " + col.containsAll(subset) + " and size is " + col.size());
        col.clear();
        System.out.println("Size of the collection after clear() is " + col.size());

        //JDK 8
        col.stream();
        col.parallelStream();

    }

    public void traverseCollectionOperations(){
        System.out.println("--- Traverse collection operations ---");

        System.out.println("Traverse with Iterator");
        initCollection();
        //with Iterator we can remove element while iterating
        Iterator<Integer> it = col.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            it.remove(); //remove the last element returned by next()
        }

        System.out.println("Traverse with classic for-each");
        initCollection();
        for(Integer i : col){
            System.out.println(i);
        }

        System.out.println("Traverse with new for-each");
        col.forEach(i -> System.out.println(i));

        System.out.println("Traverse with streams");
        col.stream().forEach(i -> System.out.println(i));
        col.parallelStream().forEach(i -> System.out.println(i));

    }

    public void toArrayOperation() {
        System.out.println("--- To Array ---");
        System.out.println(col.toArray().getClass());
        System.out.println(col.toArray(new Integer[0]).getClass());
    }


}
