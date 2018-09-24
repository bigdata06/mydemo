package com.mydemo.func;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FirstLambda {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one","two","three");

   //     strings.forEach((String t)->{});

        strings.forEach(t -> System.out.println(t));

        Iterable<String> iterable = () -> strings.iterator();
        for(String string : iterable){
            System.out.println(string);
        }

      //  Executor executor = (Runnable command) -> {};

        Executor executor1 = (Runnable command) -> command.run();
        Executor executor2 = (Runnable command) -> Executors.newSingleThreadExecutor().execute(command);

     //   Runnable task = () -> {}

        Runnable task = () -> System.out.println("I am in thread " + Thread.currentThread().getName());

        executor1.execute(task);
        executor2.execute(task);

    }
}
