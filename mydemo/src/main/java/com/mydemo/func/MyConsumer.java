package com.mydemo.func;


@FunctionalInterface
public interface MyConsumer<T>
{
    void accept(T t);

   default MyConsumer<T> andThen(MyConsumer<T> other){
       return (T t) -> {
           this.accept(t);
           System.out.println("and then ");
           other.accept(t);
       };
   }
}


