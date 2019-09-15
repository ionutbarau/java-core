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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 12/11/2017.
 * Time: 18:12
 */
public class Java7FeaturesMain {

    public static final Integer NUMERIC_LITERAL_WITH_UNDERSCORE = 10_000;

    public static void main(String[] args) throws IOException, InterruptedException {
        /*multiCatchAndStringsInSwitchExample("a");
        multiCatchAndStringsInSwitchExample("b");
        multiCatchAndStringsInSwitchExample("c");

        tryWithResources();
        nio();*/
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

    /**
     * The goal is to break a big task into multiple smaller tasks and run them in parallel (divide and conquer), and joining them at the end.
     * It is based on Executor Service(used for processing independent request in parallel), but implements divide an conquer.
     * It is intended only for breaking a big task into smaller subtasks. For any other scenario, use Executor Service.
     *
     */
    public static void forkJoin(){
        int numberOfCPU = Runtime.getRuntime().availableProcessors();
        System.out.println("Running fork and join on " + numberOfCPU + " processors...");
        ForkJoinPool pool = new ForkJoinPool(numberOfCPU); //we can also use the ForkJoinPool.commonPool() which is actually recommended

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            while(!pool.isShutdown()) {
                //check the active threads from other threads, because fork join is blocking
                System.out.println("Active threads : " + pool.getActiveThreadCount());
            }
        });
        //use ForkJoinPool to run on a specific pool that you just created
        System.out.println(pool.invoke(new MyTask(2000)));

        pool.shutdown();
        executorService.shutdown();
        try {
            pool.awaitTermination(3,TimeUnit.SECONDS);

            executorService.awaitTermination(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }








    }

    public static class MyTask extends RecursiveTask<Integer> {

        private int val;

        public MyTask(int val){
            this.val = val;
        }

        @Override
        protected Integer compute() {
            //if the value is too big then use fork join task in order to process in parallel
            if(val > 100){
                List<MyTask> tasks = new ArrayList<>();
                for(int i=0;i<val;i=i+100){

                    int reminderVal = val-i;
                    if(reminderVal < 100){
                        tasks.add(new MyTask(reminderVal));
                    }else{
                        tasks.add(new MyTask(100));
                    }
                }
                return ForkJoinTask.invokeAll(tasks).stream().mapToInt(ForkJoinTask::join).sum();

            }else{
                return doPreocessing();
            }

        }

        private int doPreocessing(){
            int total = 0;
            for(int i = 0;i<val;i++){
                total+=i;
            }

            return total;
        }
    }
}
