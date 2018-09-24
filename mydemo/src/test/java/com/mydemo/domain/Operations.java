package com.mydemo.domain;

import java.util.function.IntBinaryOperator;

public enum Operations {
    ADD(Addition::add),                                 //(x,y)->Addition.add(x,y)),  //ADD((x,y)->x+y),
    SUBS((x,y)->x-y),
    MULTIPLY((x,y)->x*y),
    DIVIDE((x,y)->x/y);

    private final IntBinaryOperator operator;

    Operations(IntBinaryOperator operator) {
        this.operator = operator;
    }
}

class Addition{
    static int add(int x, int y){
        return x+y;
    }
}

class MainApp {
    public static void main(String[] args) {

    }
}
