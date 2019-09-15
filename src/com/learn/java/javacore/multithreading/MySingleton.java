package com.learn.java.javacore.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 19/09/2018.
 * Time: 21:08
 */
public class MySingleton {

    private static MySingleton INSTANCE;

    public Map<String,String> properties;

    private MySingleton(){
        readFileNio();
    }

    private void readFileNio(){
        String path = getClass().getResource("test.properties").getPath();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            properties = new HashMap<>();
            lines.stream().forEach(l-> {
                String[] prop = l.split("=");
                if(prop.length !=2){
                    throw new IllegalArgumentException("Properties should be in the form of prop1=value");
                }
                properties.put(prop[0],prop[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFileClassic(){

    }

    public static MySingleton getInstance(){
        if(INSTANCE == null){
            synchronized (MySingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new MySingleton();
                }
            }
        }
        return INSTANCE;
    }

    public synchronized Map<String,String> getProperties(){
        return properties;
    }
}
