package com.learn.java.javacore.multithreading;

import com.learn.java.javacore.multithreading.MySingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    static MySingleton instance1;
    static MySingleton instance2;

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            instance1 = MySingleton.getInstance();
        });

        Thread t2 = new Thread(()->{
            instance2 = MySingleton.getInstance();
        });

        t1.run();
        t2.run();

        System.out.println("Instances are the same ? " + (instance1 == instance2));

        System.out.println(instance1.getProperties());

        useExecutorFrameworkWithFuture();
        useExecutorFrameworkWithCompletableFuture();

        //System.exit(1);

    }

    private static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum=0;
            for(int i=0;i<100;i++){
                sum+=i;
            }
            return sum;
        }
    }


    public static int sum=0;

    public static void useExecutorFrameworkWithFuture(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = new ArrayList<>();
        for(int i=0;i<1000;i++){
            Callable<Integer> callable = new MyCallable();
            futures.add(executorService.submit(callable));

        }


        futures.forEach(f->{
            if(f.isDone()){
                try {
                    sum+=f.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(sum);
        executorService.shutdown();
        try {
            executorService.awaitTermination(100, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<String> test = new ArrayList<>();

    public static void useExecutorFrameworkWithCompletableFuture(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return 20;
            }, executorService).thenApply(i -> i + "success" );
            System.out.println(future.get());
            executorService.shutdown();
            executorService.awaitTermination(100, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
