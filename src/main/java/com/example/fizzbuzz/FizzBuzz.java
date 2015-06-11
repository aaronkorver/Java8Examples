package com.example.fizzbuzz;

import java.util.Optional;

/**
 * Created by aaron.korver.
 */
public class FizzBuzz {

    /**
     *  Simple Java solution of FizzBuzz Problem *
     *  @param number
     *  @return Fizz if number divisible by 3, Buzz if number divisible by 5
     *  FizzBuzz if divisible by both 3 and 5, or else the same number */
    public static String fizzBuzz(int number)
    {
        if (number % 15 == 0)
        {
            return "FizzBuzz";
        }
        else if (number % 3 == 0)
        {
            return "Fizz";
        }
        else if (number % 5 == 0)
        {
            return "Buzz";
        }
        return Integer.toString(number);
    }

    /**
     * * FizzBuzz Solution using Java 8 Optional, map and Stream map() function is
     * * really useful here. *
     * * @param number
     * * @return Fizz, Buzz, FizzBuzz or the number itself */
    public static String fizzBuzzInJava8(int number) {
        String result = Optional.of(number)
                .map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : ""))
                .get();
        return result.isEmpty() ? Integer.toString(number) : result;
    }

}
