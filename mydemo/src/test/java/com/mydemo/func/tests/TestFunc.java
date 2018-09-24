package com.mydemo.func.tests;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class TestFunc {

    private List<Integer> numbers;

        @Before
        public void init() {

             numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);

        }

        @Test
        public void test1(){

            System.out.printf(" -->");
            numbers.stream().
                    map(k->String.valueOf(k))
                    .map(j-> "valeur : "+j)
                    .forEach(System.out::println);

        }

    @Test
    public void test2(){
        System.out.println(
    numbers.stream().reduce(0,(total,val)->Integer.sum(total,val))
        );

        System.out.println(
                numbers.stream().
                        reduce(0,Integer::sum)
        );
}

    private static int compute(int number){
        //assume this is time intensive

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return number*2;
    }
    @Test
    public void test3(){
        Timeit.code(() ->
        System.out.println(
                 numbers.parallelStream()      //mumbers.stream
                        .filter(e->e%2==0)
                        .mapToDouble(TestFunc::compute)    //e -> e*2
                        .reduce(0,Double::sum)
        ));
    }
}

class Timeit {
public static void code(Runnable block){

    long start = System.nanoTime();
    try {
        block.run();
    }
    finally {
        long end = System.nanoTime();
        System.out.println("time taken :" + (end -start)/1.0e9);
    }
}
}

