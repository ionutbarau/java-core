package com.learn.java.javacore.java7features;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 12/11/2017.
 * Time: 18:12
 */
public class Java7FeaturesMain {

    public static final int NUMERIC_LITERAL_WITH_UNDERSCORE = 10_000;

    public static void main(String[] args){
        multiCatchAndStringsInSwitchExample("a");
        multiCatchAndStringsInSwitchExample("b");
        multiCatchAndStringsInSwitchExample("c");
    }



    public static void multiCatchAndStringsInSwitchExample(String s) {
        try {
            switch (s){
                case "a" :
                    throw new SQLException();
                case "b" :
                    throw new FileNotFoundException();
                default:
                    System.out.println("No exception caught !");
            }
        }catch(SQLException | FileNotFoundException e){
            System.out.println(e.getClass() + " caught !");
        }
    }
}
