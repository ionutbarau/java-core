package com.learn.java.javacore.java7features;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 12/11/2017.
 * Time: 18:12
 */
public class Java7FeaturesMain {

    public static final Integer NUMERIC_LITERAL_WITH_UNDERSCORE = 10_000;

    public static void main(String[] args){
        multiCatchAndStringsInSwitchExample("a");
        multiCatchAndStringsInSwitchExample("b");
        multiCatchAndStringsInSwitchExample("c");

        tryWithResources();
        nio();
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

    public static void tryWithResources(){
        try(
                FileReader fr = new FileReader("src/com/learn/java/javacore/java7features/tryWithResources.txt");
                BufferedReader br = new BufferedReader(fr)
        ){
            String msg;
            while((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void nio(){
        String directoryPath = "src/com/learn/java/javacore/java7features/nio";
        try {
            Path nioDirectory = Files.createDirectories(Paths.get(directoryPath));
            Path nioFile = Files.createFile(Paths.get(directoryPath,"nio.txt"));
            Files.write(nioFile, NUMERIC_LITERAL_WITH_UNDERSCORE.toString().getBytes());
            byte[] msg = Files.readAllBytes(nioFile);
            System.out.println(new String(msg));
            Files.deleteIfExists(nioFile);
            Files.deleteIfExists(nioDirectory);
        }catch (IOException e){
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
