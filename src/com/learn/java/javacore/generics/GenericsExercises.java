package com.learn.java.javacore.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x01027037 on 01.02.2016.
 */
public class GenericsExercises {

    public static <T extends Integer> int countPrimeElements(List<T> myList){
        int result  = 0;
        boolean isPrime = true;
        for(T t: myList){
            if(t.intValue() > 1) {
                for (int i = 2; i < t.intValue(); i++) {
                    if (t.intValue() % i == 0) {
                        isPrime = false;
                        break;
                    } else {
                        isPrime = true;
                    }
                }

                if (isPrime) {
                    System.out.println(t.intValue());
                    result++;
                }
            }
        }
        return result;
    }
}
