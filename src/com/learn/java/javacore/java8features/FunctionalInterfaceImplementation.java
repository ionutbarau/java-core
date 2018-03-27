package com.learn.java.javacore.java8features;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 23/03/2018.
 * Time: 22:07
 */
public class FunctionalInterfaceImplementation implements FunctionalInterfaceExample {
    @Override
    public void doSomething() {
        System.out.println("doSomething from implementor called");
    }

}
