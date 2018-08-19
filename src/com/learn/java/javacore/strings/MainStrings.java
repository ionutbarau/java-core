package com.learn.java.javacore.strings;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 16/08/2018.
 * Time: 19:04
 */
public class MainStrings {


    public static void main (String[] args){
        String greeting = "Hello World"; //"Hello World is a string literal (series of characters enclosed in double quotes)"

        String newGreeting = new String("Hello World"); //example of using one of the constructors to create a string

        String charArrayGreeting = new String(new char[]{'a','b','c'}); //example of using the array constructor

        stringPool();
    }


    /**
     * String pool exists on the heap memory. Strings that are not part of the pool exists also in heap memory.
     */
    public static void stringPool(){
        System.out.println("String pool test...");
        String s1 = "xyz";
        String s2 = "xyz";// == with s1 because we use string literal, and they are picked up from pool if they already exists
        String s3 = new String("xyz"); // == fails because by using new operator, we force String class to create anew string on the heap
        // instead of picking up from the pool
        System.out.println("S1 should be == with S2 -> " + (s1 == s2));
        System.out.println("S1 should be != with S3 -> " + (s1 == s3));

        System.out.println("Using intern() method..");
        String s4 = "123";
        String s5 = new String("123").intern(); //intern() method is used to put a String created with new operator
        // into the pool or to refer to an existing one from the pool
        System.out.println("S4 should be == with S5 -> " + (s4 == s5));

        // !!! with the new statement we can actually create 2 strings, one in the pool if it is not already there (because of the literal) and one in  the heap because of new.
        String s6 = new String("whatever");




    }
}
