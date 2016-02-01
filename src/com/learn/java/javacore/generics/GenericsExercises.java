package com.learn.java.javacore.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * From https://docs.oracle.com/javase/tutorial/java/generics/QandE/generics-questions.html
 * Created by x01027037 on 01.02.2016.
 */
public class GenericsExercises {

    public static <T extends Integer> void countPrimeElements(List<T> myList){
        List<Integer> primeNumbers = new ArrayList<>();
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
                    primeNumbers.add(t);
                }
            }
        }
        System.out.println("### GenericsExercises.countPrimeElements found " + primeNumbers.size() + " prime numbers : " + primeNumbers);
    }

    public static <T> void exchangePositions(List<T> myList, int pos1, int pos2){
        System.out.println("### GenericsExercises.exchangePosition with pos1 =  " + pos1 + " and pos2 = " + pos2);
        System.out.println("Before: " + myList);
        T temp = myList.get(pos2);
        myList.set(pos2,myList.get(pos1));
        myList.set(pos1,temp);
        System.out.println("After: " + myList);
    }

    public static <T extends Comparable<? super T>> void getMaximalFromRange(List<? extends T> myList, int begin, int end){
        System.out.println("### GenericsExercises.getMaximalFromRange with begin =  " + begin + " and end = " + end);
        T maximalElement = myList.get(begin);
        for(int i = begin + 1; i < end; i++){
            T currentElement = myList.get(i);
            if(currentElement.compareTo(maximalElement) > 0){
                maximalElement = currentElement;
            }

        }

        System.out.println("Maximal element: " + maximalElement);
    }
}
