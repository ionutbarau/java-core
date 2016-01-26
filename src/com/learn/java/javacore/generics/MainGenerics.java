package com.learn.java.javacore.generics;

import com.learn.java.javacore.model.Employee;
import com.learn.java.javacore.model.Manager;
import com.learn.java.javacore.model.Workable;

import java.io.Serializable;

/**
 * Created by x01027037 on 21.01.2016.
 */
public class MainGenerics {

    public static void main (String[] args){
        //GenericClassExample
        //We can use the diamond operator "<>" in order to have a shorter statement. The diamond operator is present starting with Java 7.
        //If we don't use generic type (<String,Integer>) for declaration than it falls back to raw type which is unchecked.
        GenericClassExample<String,Integer> simpleGenericClassExample = new GenericClassExample("abc", 1);
        simpleGenericClassExample.print();

        //GenericMethodExample
        String[] tArray = new String[]{"one","two","three"};
        //Can be called with explicit type like so: GenericMethodExample.<String>getT(tArray, "two") but is not needed because compiler can infer the type parameters.
        //If we do not use explicit type, the compiler will warn us if we try to do the following : String s = GenericMethodExample.getT(tArray, 1)
        System.out.println("GenericMethodExample.getT() result is: " + GenericMethodExample.getT(tArray, "two"));

        //GenericExtendsExample
        //The type parameter has to be a subtype of Comparable and Serializable
        System.out.println("GenericExtendsExample.min(tArray) result is: " + GenericExtendsExample.min(tArray));


        //Generic wildcard subtype example
        GenericClassExample<? extends Employee,? extends Employee> genericSubtypeWildcard = new GenericClassExample<>(new Employee(),new Employee());
        //ERROR because the compiler does not want to corrupt the data with another subtype implementation. It has no clue about the subtype that we pass.
        // Modifying the generic object is
        //genericSubtypeWildcard.settField(new Manager());
        //genericSubtypeWildcard.settField(new Employee())
        Workable s = genericSubtypeWildcard.gettField(); //Works because whatever is in GenericClassExample is a serializable


        //Generic wildcard subtype example
        GenericClassExample<? super Employee,? super Employee> genericSuperWildcard = new GenericClassExample<>(new Employee(),new Employee());
        genericSuperWildcard.settField(new Manager());

    }
}
