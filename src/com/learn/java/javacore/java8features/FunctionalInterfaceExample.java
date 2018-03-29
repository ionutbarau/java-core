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

    /**
     * A default method can be overridden in the implementation class.
     * It is used to provide a default implementation in case we extend an interface, so it does not affect the implementations.
     * In case 2 Interfaces have the same default method (Diamond Problem), the implementation has to have it's own version of the method (override).
     * Also if any class in the hierarchy has a method with same signature as a default interface method,
     * the one from the interface is not taken into account, that's why methods from Object cannot be implemented as default interface methods, just to avoid confusion
     *
     */
    default void doDefault(){
        System.out.println("Interface default method with implementation called ");
    }

    /**
     * A static method cannot be overridden in the implementation class. This way we can avoid poor implementation that can bring undesired results.
     * This method is visible inside the interface methods only, not in the implementation class.
     * Of course we can call it in the implementation class by using FunctionalInterfaceExample.doStatic().
     * We cannot declare static methods with same signature as Objects methods.
     * If we try to override static methods @Override annotation in subclass, we will get an error. If we do not add the @Override annotation, it will just be a regular method of that class.
     * It is used for providing utility methods.
     */
    static void doStatic(){
        System.out.println("Interface static method with implementation called ");
    }
}
