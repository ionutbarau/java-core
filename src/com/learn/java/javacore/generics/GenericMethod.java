package com.learn.java.javacore.generics;

/**
 * The class is not generic, but it has only a generic method which uses generic types.
 * Generic methods can be defined inside both generic and ordinary classes.
 * !!!! The type <T> is always declared before the actual use of it.
 * Created by x01027037 on 21.01.2016.
 */
public class GenericMethod {

    public static <T> T getT(T[] tArray,T search){
        for(T t : tArray){
            if (t.equals(search)){
                return t;
            }
        }
        return null;
    }
}
