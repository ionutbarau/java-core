package com.learn.java.javacore.colections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Extends Collection interface.
 * It is ordered (sequence) by index.
 * Can contain duplicate elements.
 * Element access is done by index.
 *
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 16/08/2018.
 * Time: 22:33
 */
public class ListExample {

    public void positionalAccessAndSearchOperations(){
        System.out.println("--- List positional access and search operations ---");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println("List after add " + list);
        System.out.println("Get element at position 0 is " + list.get(0));
        System.out.println("Element at position 0 after set() " + list.set(0,3));
        System.out.println("The removed value is " + list.remove(0));
        System.out.println("Index of value 2 is " + list.indexOf(2));
        System.out.println("Last Index of value 2 is " + list.lastIndexOf(2));

        List<Integer> listToAdd = new ArrayList<>();
        list.addAll(listToAdd);
        System.out.println("List after addAll() is " + list);
        list.removeAll(listToAdd);
        System.out.println("List after removeAll() is " + list);

    }


    /**
     * Most Collections class algorithms apply to lists.
     */
    public void listAlgorithms(){
        System.out.println("--- List algorithms ---");
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(4);
        System.out.println("List at the beginning " + list);
        list.sort((o1,o2) ->  o1.compareTo(o2));
        System.out.println("List after sort " + list);
        Collections.reverse(list);
        System.out.println("List after reverse " + list);
        Collections.shuffle(list);
        System.out.println("List after shuffle " + list);
        Collections.rotate(list, 1);
        System.out.println("List after rotate " + list);
        Collections.swap(list,0,1);
        System.out.println("List after swapping an element " + list);
        Collections.replaceAll(list,5,10);
        System.out.println("List after replacing all elements " + list);
        Collections.fill(list,25);
        System.out.println("List after fill() " + list);
        System.out.println("Result of binarySearch : " + Collections.binarySearch(list,25));


    }

    /**
     * Maintains insertion order.
     * It is a resizable array.(new array is created and the old one is copied into it)
     * Permits null elements.
     * It is not synchronized.
     * Search and retrieval is faster in ArrayList compared to LinkedList.
     * Deletion and insertion is slower than LinkedList, because all the elements need to be shifted.
     *
     */
    public void arrayListImplementation(){
        System.out.println("--- ArrayList implementation ---");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(null);
        System.out.println(arrayList);
    }

    /**
     * Implements Deque and List interfaces.
     * Maintains insertion order.
     * It is a doubly linked list with 2 nodes that point to prev and next elements.
     * Permits null elements.
     * It is not synchronized.
     * Search and retrieval is slower in LinkedList compared to ArrayList.
     * Deletion and insertion is faster than ArrayList, because it requires only a change in the pointer location.
     *
     */
    public void linkedListImplementation(){
        System.out.println("--- LinkedList implementation ---");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(null);
        System.out.println(linkedList);
        //stack operations
        System.out.println("Peek : " + linkedList.peek());
        linkedList.push(3);
        System.out.println("Pop : " + linkedList.pop());
    }
}
