package com.learn.java.javacore.generics;

/**
 * Created by x01027037 on 21.01.2016.
 */
public class MainGenerics {

    public static void main (String[] args){
        //GenericClass
        //We can use the diamond operator "<>" in order to have a shorter statement. The diamond operator is present starting with Java 7.
        //If we don't use generic type (<String,Integer>) for declaration than it falls back to raw type which is unchecked.
        GenericClass<String,Integer> simpleGenericClass = new GenericClass("abc", 1);
        simpleGenericClass.print();

        //GenericMethod
        String[] tArray = new String[]{"one","two","three"};
        //Can be called with explicit type like so: GenericMethod.<String>getT(tArray, "two") but is not needed because compiler can infer the type parameters.
        //If we do not use explicit type, the compiler will warn us if we try to do the following : String s = GenericMethod.getT(tArray, 1)
        System.out.println("GenericMethod.getT() result is: " + GenericMethod.getT(tArray, "two"));

        //GenericExtends
        //The type parameter has to be a subtype of Comparable and Serializable
        System.out.println("GenericExtends.min(tArray) result is: " + GenericExtends.min(tArray));

    }
}
