package com.learn.java.javacore.java7features;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.sql.SQLException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 12/11/2017.
 * Time: 18:12
 */
public class Java7FeaturesMain {

    public static final Integer NUMERIC_LITERAL_WITH_UNDERSCORE = 10_000;

    public static void main(String[] args) throws IOException, InterruptedException {
        multiCatchAndStringsInSwitchExample("a");
        multiCatchAndStringsInSwitchExample("b");
        multiCatchAndStringsInSwitchExample("c");

        tryWithResources();
        nio();
        forkJoin();
        System.exit(1);
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

    public static void nio() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        String directoryPath = "src/com/learn/java/javacore/java7features/nio";

        Path nioDirectory = Files.createDirectories(Paths.get(directoryPath));
        nioDirectory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        Path nioFile = Files.createFile(Paths.get(directoryPath,"nio.txt"));
        Files.write(nioFile, NUMERIC_LITERAL_WITH_UNDERSCORE.toString().getBytes());
        byte[] msg = Files.readAllBytes(nioFile);
        System.out.println(new String(msg));
        Files.deleteIfExists(nioFile);
        Files.deleteIfExists(nioDirectory);
        while(true){
            WatchKey key = watchService.take();
            for(WatchEvent<?> event : key.pollEvents()) {

                WatchEvent.Kind<?> kind = event.kind();

                System.out.println("Event on "+ event.context().toString() + " is "+ kind);

            }
            break;
        }
    }

    public static void forkJoin(){
        int numberOfCPU = Runtime.getRuntime().availableProcessors();
        System.out.println("Running fork and join on " + numberOfCPU + " processors...");
        ForkJoinPool pool = new ForkJoinPool(numberOfCPU);
        pool.invoke(new MyTask());

    }

    public static class MyTask extends RecursiveAction{

        @Override
        protected void compute() {
            System.out.println("Compute..");
        }
    }
}
