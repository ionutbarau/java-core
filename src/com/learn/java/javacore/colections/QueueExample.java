package com.learn.java.javacore.colections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Extends Collection interface.
 * Used to hold multiple elements prior to processing.
 * Typically orders elements in FIFO manner.
 * All new elements are inserted at the tail of the queue.
 * The head of the queue is the one that will always be removed by a call to poll() or remove().
 * Every implementation must provide its ordering properties.
 * Besides the operations inherited from Collection, it
 * provides additional insertion, removal and inspection operations( element(), offer(), peek(), poll(), remove())
 *
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 16/08/2018.
 * Time: 22:34
 */
public class QueueExample {

    public void queueExample(){
        Queue<Integer> queue =  new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("Queue at the beginning : " + queue);
        //Add with offer() which return true or false if it could insert the element. Using add() throws exception if it cannot
        queue.offer(6);
        System.out.println("Queue after offer : " + queue);
        //Return but not remove the head of the queue with element()
        System.out.println("Return but not remove the head of the queue with element() : " + queue.element());
        //Return but not remove the head of the queue with peek()
        System.out.println("Return but not remove the head of the queue with peek() : " + queue.peek());

        //Return and remove the head of the queue with remove()
        System.out.println("Return and remove the head of the queue with remove() : " + queue.remove());
        //Return and remove the head of the queue with poll()
        System.out.println("Return and remove the head of the queue with poll() : " + queue.poll());

    }
}
