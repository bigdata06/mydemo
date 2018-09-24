package com.mydemo.domain;

public interface B {
    default String a(){
        return "la chaine a from B";
    }
}
