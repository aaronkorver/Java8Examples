package com.example.streaming;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aaron.korver.
 */
public class LambdaRefactoringExample {

    @Test
    public void inititalMethod() throws Exception {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.forEach(e -> System.out.println(e));
    }


}
