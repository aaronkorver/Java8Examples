package com.example.fizzbuzz;

/**
 * Created by aaron.korver.
 */
@FunctionalInterface
public interface Func3<T,U,V,R> {
    R apply(T t, U u,V v);
}
