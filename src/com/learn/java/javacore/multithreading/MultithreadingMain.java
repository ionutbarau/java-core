package com.learn.java.javacore.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * We can create a thread by either extending Thread or implementing Runnable(preferred way).
 * Threads have priorities from 1 to 10, 10 being the highest.Threads with higher priority are ,are important to the program,
 * and should be allocated processor time before the ones with lowest priority.
 * However, thread priorities cannot guarantee the order in which threads execute and are very much platform dependent.
 * Default thread priority is 5.
 * Threads have 5 states: NEW (thread is created but not started), RUNNABLE (after the thread is started - thread.start())
 * RUNNING (when the run methods executes), WAITING (when it is waiting for another thread to complete - sleep(), wait())
 * DEAD(when it terminates by completing the task ot throwing an error).
 *
 *
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 19/08/2018.
 * Time: 16:58
 */
public class MultithreadingMain {

    public static List<Integer> list = new ArrayList<>(10000);

    public static void main (String[] args) {
        System.out.println("Main Thread started");

        for(int i=0;i<100;i++){
            list.add(i);
        }

        //New state
        Thread t1 = new Thread(() -> {
            list.subList(0,49).stream().forEach((integer) -> {
                //when this executes, the thread is in Running state
                System.out.println(Thread.currentThread().getName() + " prints : " + integer);
                if(integer == 10){
                    try {
                        //Causes the currently running thread to block for at least the specified number of milliseconds.
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("T1's sleep was interrupted by Main Thread");
                    }
                }
            });
        },"T1");
        //Set the priority to be highest for T1
        t1.setPriority(Thread.MAX_PRIORITY);

        //New state
        Thread t2 = new Thread(() -> {
            list.subList(49,99).stream().forEach((integer) -> {
                //when this executes, the thread is in Running state
                if(integer == 49){
                    System.out.println(" Yielding T2 ");
                    //causes the currently executing thread object to temporarily pause and allow other threads to execute
                    Thread.yield();
                    System.out.println("Yielding for T2 stopped");
                }
                System.out.println(Thread.currentThread().getName() + " prints : " + integer);
            });
        },"T2");
        //Set the priority to be lowest for T2
        t2.setPriority(Thread.MIN_PRIORITY);



        //Runnable state
        t1.start();
        //Runnable state
        t2.start();


        //interrupts T1, causing it to continue execution if it was blocked for any reason.
        t1.interrupt();

        //Let T1 finish before main thread finishes with the help of join(). Main thread will continue after T1 is dead
        try{
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        //Wait after T2 200 milliseconds or until is dead(if it finishes in under 200 milliseconds).
        // Main thread will continue after 200 milliseconds or faster if T2 becomes dead
        try{
            t2.join(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //Check if T2 is alive
        if(!t2.isAlive()){
            System.out.println("T2 is dead and managed to finished before Main Thread");
        }

        synchronized (MultithreadingMain.class){
            if(Thread.holdsLock(MultithreadingMain.class)){
                System.out.println("Main Thread holds the lock on MultithreadingMain.class");
            }
        }


        System.out.println("Main Thread finished");

    }


}
