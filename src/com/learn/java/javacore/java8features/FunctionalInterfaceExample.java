package com.learn.java.javacore.java8features;

/**
 * An interface that has exactly one abstract method is said to be functional.
 * The @FunctionalInterface is used just to avoid accidental addition of abstract methods.
 * It will generate a compile time error if we add another abstract method.
 * Functional interfaces are heavily used in lambda expressions.
 *
 * In Java 8 interfaces can have methods with implementation.
 * Default and static keywords are used to achieve this.
 *
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 14/11/2017.
 * Time: 21:04
 */
@FunctionalInterface
public interface FunctionalInterfaceExample {

    void doSomething();

    default void doDefault(){
        System.out.println("Interface default method with implementation called ");
    }

    static void doStatic(){
        System.out.println("Interface static method with implementation called ");
    }
}
