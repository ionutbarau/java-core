package com.learn.java.javacore.colections;

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

        queueExample.queueExample();
    }

}
