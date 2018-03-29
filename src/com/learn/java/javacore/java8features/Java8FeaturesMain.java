package com.learn.java.javacore.java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 14/11/2017.
 * Time: 20:57
 */
public class Java8FeaturesMain {

    public static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args){
        for(int i=1; i<10; i++){
            myList.add(i);
        }

        forEachInIterableInterface();
        lambdaExpressions();
        stream();
    }



    /**
     * Java 8 introduces a forEach(Consumer) method in Iterable interface.
     * Collections can use this method instead of an iterator
     */
    public static void forEachInIterableInterface(){
        System.out.println("---forEach with Consumer---");
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    /**
     * Lambda expressions are used for creating anonymous classes or functional interfaces easily
     * There are lambda expressions, that have only one statement, so we do not need to add  {}
     * There are lambda statements that have multiple statements, so we will have to add {}
     */

    public static void lambdaExpressions(){

        //instantiate functional interface with lambda statement (it has  {})
        Runnable r = () -> {
            System.out.println("Runnable.run() method");
            System.out.println("Functional interface with lambda statement");
        };
        r.run();

        //instantiate functional interface that receives argument with lambda expression (no  {})
        FunctionalInterfaceWithParam fiwp = (s) ->System.out.println(s);
        fiwp.print("Functional interface with lambda expression");

        System.out.println("---forEach with lambda---");
        //for each with lambda expression
        myList.forEach(integer -> System.out.println(integer)); // the notation "(integer)" instead of "integer" can also used
    }

    /**
     * Streams are used for performing filter/map/reduce operations with collections.
     * Allows sequential(Collection.steam()) and parallel execution(Collection.parallelStream()).
     */
    public static void stream(){
        Stream<Integer> sequentialStream = myList.stream();
        Stream<Integer> parallelStream = myList.parallelStream();
        System.out.println("---filter and forEach with sequential stream and lambda---");
        sequentialStream.filter(integer -> integer > 2).forEach(integer -> System.out.println(integer));
        System.out.println("---filter and forEach with parallel stream and lambda---");
        parallelStream.filter(p -> p > 1).forEach(integer -> System.out.println(integer));
    }
}
