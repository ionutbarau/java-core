package com.learn.java.javacore.colections;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 22/05/2017.
 * Time: 14:41
 */
public class MainCollections {

    public static CollectionExample collectionExample = new CollectionExample();
    public static SetExample setExample = new SetExample();
    public static MapExample mapExample = new MapExample();
    public static ListExample listExample = new ListExample();
    public static QueueExample queueExample = new QueueExample();

    public static void main(String[] args){
        collectionExample.basicOperations();
        collectionExample.bulkOperations();
        collectionExample.traverseCollectionOperations();
        collectionExample.toArrayOperation();

        setExample.hashSetImplementation();
        setExample.linkedHashSetImplementation();
        setExample.treeSetImplementation();

        mapExample.basicOperations();
        mapExample.bulkOperations();
        mapExample.collectionViews();
        mapExample.hashMapImplementation();
        mapExample.linkedHashMapImplementation();
        mapExample.treeMapImplementation();

        listExample.positionalAccessAndSearchOperations();
        listExample.listAlgorithms();
        listExample.arrayListImplementation();
        listExample.linkedListImplementation();
        listExample.copyOnWriteArrayListImplementation();

        queueExample.queueExample();


        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<100;i++) {
            hashSet.add(i);treeSet.add(i);
        }

        LocalDateTime hashSetStart = LocalDateTime.now();
        for(int i:hashSet){
            System.out.println(i);
        }
        LocalDateTime hashSetEnd = LocalDateTime.now();

        LocalDateTime treeSetStart = LocalDateTime.now();
        for(int i:treeSet){
            System.out.println(i);
        }
        LocalDateTime treeSetEnd = LocalDateTime.now();

        System.out.println("HashSet iteration :" + Duration.between(hashSetStart, hashSetEnd).getNano());
        System.out.println("TreeSet iteration :" + Duration.between(treeSetStart, treeSetEnd).getNano());

    }

}
