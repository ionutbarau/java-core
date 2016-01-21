package com.learn.java.javacore.generics;

import java.io.Serializable;

/**
 * Use the extends keyword when type variable should be restricted to subtypes of specific classes or interfaces.
 * We can use extends for classes and interfaces(not implements). Multiple interfaces are allowed but only one class,
 * Which has to be the first declared in the list of extends (bounds list). For multiple super types use "&".
 * After compilation, the generic type will be converted to the first bound type (in this case Comparable) and at runtime there will be a cast to Serializable also.
 * Created by Ionut Barau on 21.01.2016.
 */
public class GenericExtends {

    public static <T extends Comparable & Serializable> T min(T[] tArray){
        T minVal = tArray[0];
        for(T t: tArray){
            if(minVal.compareTo(t) > 0){
                minVal = t;
            }
        }

        return minVal;
    }
}
