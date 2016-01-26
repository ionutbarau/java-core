package com.learn.java.javacore.generics;

/**
 * A simple generic class. A generic class is a class with one or more type parameters(T and U in our case).
 * These type parameters make the class act as a template which can receive whatever types as type arguments.
 * Generic code is only compile time. After compilation, type erasure happens and the generic types becomes raw types.
 * In our case both T and U will be of replaced with Object because they are unbound. The "<T,U>" from class declaration will be removed.
 * After type erasure, the compiler inserts casts. The result of type erasure is an ordinary class.
 * Type erasure helps backward compatibility.
 * !!! Generics must be compiled on java 1.5+, but resulting classes can run on pre java 1.5. (-source 1.5 -target 1.4)
 * Created by Ionut Barau on 21.01.2016.
 */
public class GenericClassExample<T,U> {

    private T tField;

    private U uField;

    public GenericClassExample(T tField, U uField){
        this.tField = tField;
        this.uField = uField;
    }

    public T gettField() {
        return tField;
    }

    public void settField(T tField) {
        this.tField = tField;
    }

    public U getuField() {
        return uField;
    }

    public void setuField(U uField) {
        this.uField = uField;
    }

    public void print(){
        System.out.println("tField is of type " + tField.getClass() + " and has the value " + tField);
        System.out.println("uField is of type " + uField.getClass() + " and has the value " + uField);
    }
}
