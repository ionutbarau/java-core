package com.learn.java.javacore.java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 14/11/2017.
 * Time: 20:57
 */
public class Java8FeaturesMain {

    public static void main(String[] args){
        forEachInIterableInterface();
    }

    /**
     * Java 8 introduces a forEach(Consumer) method in Iterable interface.
     * Collections can use this method instead of an iterator
     */
    public static void forEachInIterableInterface(){
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        //no lambda expression
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //lambda expression
        myList.forEach(integer -> System.out.println(integer));

        Function<String, String> fn = (p) -> p  + "";

    }
}
