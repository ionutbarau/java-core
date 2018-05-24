package com.learn.java.javacore.java8features;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: java-core
 * Date: 14/11/2017.
 * Time: 20:57
 */
public class Java8FeaturesMain {

    public static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args){
        for(int i=1; i<10; i++){
            myList.add(i);
        }

        forEachInIterableInterface();
        lambdaExpressions();
        stream();
        dateTimeApi();
        collectionApi();
    }



    /**
     * Java 8 introduces a forEach(Consumer) method in Iterable interface.
     * Collections can use this method instead of an iterator
     */
    public static void forEachInIterableInterface(){
        System.out.println("---forEach with Consumer---");
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("---forEach with Consumer sa lambda expression---");
        myList.forEach(i -> System.out.println(i));//could also be written like this : myList.forEach((i) -> System.out.println(i));
    }

    /**
     * Lambda expressions are used for creating anonymous classes or functional interfaces easily
     * There are lambda expressions, that have only one statement, so we do not need to add  {}
     * There are lambda statements that have multiple statements, so we will have to add {}
     */

    public static void lambdaExpressions(){

        //instantiate functional interface with lambda statement (it has  {})
        Runnable r = () -> {
            System.out.println("Runnable.run() method");
            System.out.println("Functional interface with lambda statement");
        };
        r.run();

        //instantiate functional interface that receives argument with lambda expression (no  {})
        FunctionalInterfaceWithParam fiwp = (s) ->System.out.println(s);
        fiwp.print("Functional interface with lambda expression");

        System.out.println("---forEach with lambda---");
        //for each with lambda expression
        myList.forEach(integer -> System.out.println(integer)); // the notation "(integer)" instead of "integer" can also used
    }

    /**
     * Streams are used for performing filter, map (apply some function to all the elements),reduce (perform some computation on the list eg. min, max and return the result) operations with collections.
     * Allows sequential(Collection.steam()) and parallel execution(Collection.parallelStream()).
     * The result of a stream operation will always be another Stream and it will not modify the initial collection
     */
    public static void stream(){

        //1. Create streams

        Stream<Integer> s1 = Stream.of(1,2,3,4);
        Stream<Integer> s2 = Stream.of(new Integer[]{1,2,3,4});
        Stream<String> s3 = Stream.generate(() -> "abc");
        Stream<String> s4 = Stream.iterate("abc", s -> s);
        IntStream s5 = Arrays.stream(new int[]{1,2,3});
        IntStream s6 = "abc".chars();
        Stream<Integer> sequentialStream = myList.stream();
        Stream<Integer> parallelStream = myList.parallelStream();

        //2. Filter
        System.out.println("---Filter example---");
        System.out.println("---filter and forEach with sequential stream and lambda---");
        sequentialStream.filter(integer -> integer > 2).forEach(integer -> System.out.println(integer));
        System.out.println("---filter and forEach with parallel stream and lambda---");
        parallelStream.filter(p -> p > 1).forEach(integer -> System.out.println(integer));

        //3. Map
        System.out.println("---Map example---");
        System.out.println("---map and forEach with sequential stream and lambda---");
        //need to create the stream again so we don't get java.lang.IllegalStateException: stream has already been operated upon or closed
        myList.stream().map(integer -> integer * 10).forEach(integer -> System.out.println(integer));
        System.out.println("---map and forEach with parallel stream and lambda---");
        myList.parallelStream().map(p -> p * 10).forEach(integer -> System.out.println(integer));

        //4.Flatmap
        System.out.println("---Flat map example---");
        Stream<List<String>> listStream = Stream.of(Arrays.asList("Ionut"), Arrays.asList("Barau"));
        Stream<String> stringStream = listStream.flatMap(list -> list.stream());
        stringStream.forEach(string -> System.out.println(string));

        //5. Reduce
        System.out.println("---Reduce example---");
        System.out.println("---reduce and forEach with sequential stream and lambda---");
        //the :: notation is a shortcut for (integer, integer2) ->  Math.max(integer, integer2)
        System.out.println(myList.stream().reduce(Math::max).get());
        System.out.println("---reduce and forEach with parallel stream and lambda---");
        System.out.println(myList.parallelStream().reduce((integer, integer2) -> integer + integer2).get());


        //6. Sort
        System.out.println("---Sort example---");
        System.out.println("---sort and forEach with sequential stream and lambda---");
        myList.stream().sorted().forEach(integer -> System.out.println(integer));
        System.out.println("---reverse sort and forEach with sequential stream and lambda---");
        myList.stream().sorted(Comparator.reverseOrder()).forEach(integer -> System.out.println(integer));

        //7. Count
        System.out.println("---Count example---");
        System.out.println("Number of elements in myList is " + myList.stream().count());

        //8. Match
        System.out.println("---Match examples---");
        System.out.println("AllMatch < 10 = " + myList.stream().allMatch(i -> i<10));
        System.out.println("AnyMatch < 5 = " + myList.stream().anyMatch(i -> i<5));
        System.out.println("NoneMatch < 5 = " + myList.stream().noneMatch(i -> i<5));

        //9. Find first
        System.out.println("---Find first example---");
        Optional<Integer> resultFirst = myList.stream().filter(i -> i < 5).findFirst();
        System.out.println("FindFirst result = " + (resultFirst.isPresent()? resultFirst.get() : "no result found"));

        //10. Find any
        System.out.println("---Find first example---");
        Optional<Integer> resultAny = myList.stream().filter(i -> i < 5).findAny();
        System.out.println("FindAny result = " + (resultAny.isPresent()? resultAny.get() : "no result found"));

        //11. Limit (short circuit operation)
        System.out.println("---Limit example---");
        myList.stream().limit(2).forEach(i -> System.out.println(i));

        //12. Skip (short circuit operation)
        System.out.println("---Skip example---");
        myList.stream().skip(7).forEach(i -> System.out.println(i));

        //13. Convert back from Stream to Collection example
        System.out.println("---Conversion from stream to collection example---");
        System.out.println(myList.stream().collect(Collectors.toList()));
        System.out.println(myList.stream().collect(Collectors.toMap(integer -> "index" + integer, integer -> integer)));
        System.out.println(myList.stream().collect(Collectors.toSet()));
        //convert from Stream to array
        System.out.println(Arrays.toString(myList.stream().toArray()));
    }

    public static void dateTimeApi(){
        //1.LocalDate
        LocalDate ld1  = LocalDate.now();
        System.out.println(ld1);
        LocalDate ld2 = LocalDate.of(1999, Month.APRIL, 4);
        System.out.println(ld2);
        LocalDate ld3 = LocalDate.now(ZoneId.of("Europe/Bucharest"));
        System.out.println(ld3);
        //getting date from a base date
        LocalDate ld4 = LocalDate.ofYearDay(2014, 100);
        System.out.println(ld4);

        //2.LocalTime
        LocalTime lt1 = LocalTime.now();
        System.out.println(lt1);
        LocalTime lt2 = LocalTime.of(22,12,20,40);
        System.out.println(lt2);
        LocalTime lt3 = LocalTime.now(ZoneId.of("Europe/Bucharest"));
        System.out.println(lt3);
        LocalTime lt4 = LocalTime.ofSecondOfDay(10000);
        System.out.println(lt4);

        //3.LocalDateTime
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);
        LocalDateTime ldt2 = LocalDateTime.of(2014, Month.APRIL, 22,22,12,20,40);
        System.out.println(ldt2);
        LocalDateTime ldt3 = LocalDateTime.now(ZoneId.of("Europe/Bucharest"));
        System.out.println(ldt3);

        //4.Instant (machine readable unix timestamp)
        Instant instant1 = Instant.now();
        System.out.println(instant1);
        Instant instant2 = Instant.ofEpochMilli(1000);
        System.out.println(instant2);
        Duration duration = Duration.ofDays(30);
        System.out.println(duration);

        //5. TemporalAdjuster
        LocalDate today = LocalDate.now();
        System.out.println(today.isLeapYear());
        System.out.println(today.isBefore(LocalDate.of(2015,1,1)));
        System.out.println(today.plusDays(2));
        System.out.println(today.atTime(LocalTime.now()));
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()));
        Period period = today.until(LocalDate.of(2019,1,1));
        System.out.println(period.getMonths());

        //6.Parsing and formatting
        LocalDate now = LocalDate.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        //7.Conversion from legacy classes
        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        System.out.println(Date.from(Instant.now()));

    }

    public static void collectionApi(){
        myList.removeIf(integer -> integer > 5);
        myList.iterator().forEachRemaining(integer -> System.out.println(integer));
        myList.spliterator().forEachRemaining(integer -> System.out.println(integer));
        myList.replaceAll(integer -> integer *10);
        myList.forEach(integer -> System.out.println(integer));

        Map<String, Integer> myMap = myList.stream().collect(Collectors.toMap(integer -> "index" + integer, integer -> integer));
        myMap.compute("index10",(key, value) -> value * 10);
        myMap.forEach((key,val) -> System.out.println(key+ "-" + val));
    }

}
