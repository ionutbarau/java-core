package com.learn.java.javacore.colections;

import java.util.*;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 22/05/2017.
 * Time: 14:41
 */
public class MainCollections {

    public static void main(String[] args){
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        set.add("de");
        set.add("fg");
        set.stream().filter(l -> l.length()>1).forEach(l -> System.out.println(l));



    }

}
