package com.mydemo.func;

public class FunWithConsumers {


    public static void main(String[] args) {

        MyConsumer<String> eating = s-> System.out.println("Eating " +s);
        eating.accept("chiken");

        MyConsumer<String> drinking = s-> System.out.println("Drinking " +s);
        drinking.accept("coffee");

        MyConsumer<String> eatingAndDrinking = eating.andThen(drinking);
        eatingAndDrinking.accept("nice breakfast");


    }
}
