package com.learn.java.javacore.generics;

import java.io.Serializable;

/**
 * Inheritance example with generics. Only a generic class can extend other generic class because
 * it is mandatory to add type parameters on the implementor. It has to have the same number of type parameters.
 * Created by x01027037 on 26.01.2016.
 */
public class GenericInheritanceExample<T,U> extends GenericClassExample<T,U> {

    public GenericInheritanceExample(T tField, U uField) {
        super(tField, uField);
    }

    public void print(){
        System.out.println("GenericInheritanceExample class print method is called instead of GenericClassExample");
        super.print();
    }


}
