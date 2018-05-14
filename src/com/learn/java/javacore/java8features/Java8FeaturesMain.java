package com.learn.java.javacore.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
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
        System.out.println("---forEach with Consumer sa lambda expression---");
        myList.forEach(i -> System.out.println(i));//could also be written like this : myList.forEach((i) -> System.out.println(i));
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
     * Streams are used for performing filter, map (apply some function to all the elements),reduce (perform some computation on the list eg. min, max and return the result) operations with collections.
     * Allows sequential(Collection.steam()) and parallel execution(Collection.parallelStream()).
     * The result of a stream operation will always be another Stream and it will not modify the initial collection
     */
    public static void stream(){
        Stream<Integer> sequentialStream = myList.stream();
        Stream<Integer> parallelStream = myList.parallelStream();
        System.out.println("---filter and forEach with sequential stream and lambda---");
        sequentialStream.filter(integer -> integer > 2).forEach(integer -> System.out.println(integer));
        System.out.println("---filter and forEach with parallel stream and lambda---");
        parallelStream.filter(p -> p > 1).forEach(integer -> System.out.println(integer));


        System.out.println("---map and forEach with sequential stream and lambda---");
        //need to create the stream again so we don't get java.lang.IllegalStateException: stream has already been operated upon or closed
        myList.stream().map(integer -> integer * 10).forEach(integer -> System.out.println(integer));
        System.out.println("---map and forEach with parallel stream and lambda---");
        myList.parallelStream().map(p -> p * 10).forEach(integer -> System.out.println(integer));

        System.out.println("---reduce and forEach with sequential stream and lambda---");
        //the :: notation is a shortcut for (integer, integer2) ->  Math.max(integer, integer2)
        System.out.println(myList.stream().reduce(Math::max).get());
        System.out.println("---reduce and forEach with parallel stream and lambda---");
        System.out.println(myList.parallelStream().reduce((integer, integer2) -> integer + integer2).get());

        //TODO sorted and flatmap

        //convert back from Stream to Collection example
        System.out.println(myList.stream().collect(Collectors.toList()));
        System.out.println(myList.stream().collect(Collectors.toMap(integer -> "index" + integer, integer -> integer)));
        System.out.println(myList.stream().collect(Collectors.toSet()));
        //convert from Stream to array
        System.out.println(Arrays.toString(myList.stream().toArray()));

    }
}
