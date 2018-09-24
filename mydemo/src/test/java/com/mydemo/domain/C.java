package com.mydemo.domain;

public interface C {

    default String a(){
        return "la chaine a from C";
    }
}
