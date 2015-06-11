package com.example.fizzbuzz;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by aaron.korver.
 */
public class TestFizzBuzz {

    @Test
    public void testFizzBuzz()
    {
        IntStream.range(0,100).boxed().map(FizzBuzz::fizzBuzz).forEach(System.out::println);

    }
}
