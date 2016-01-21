package com.learn.java.javacore.generics;

/**
 * A simple generic class. A generic class is a class with one or more type variables(T and U in our case).
 * These type variables make the class act as a template which can receive whatever types as type parameters.
 * Generic code is only compile time. After compilation, type erasure happens and all the generic code is converted to raw for compatibility reasons.
 * In out case both T and U (in field and method usage) will be of replaced with Object. The "<T,U>" from class declaration will be removed and only GenericClass will remain.
 * Created by Ionut Barau on 21.01.2016.
 */
public class GenericClass<T,U> {

    private T tField;

    private U uField;

    public GenericClass(T tField, U uField){
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
