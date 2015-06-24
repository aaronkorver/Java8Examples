package com.example.streaming;

import com.example.model.Person;
import org.junit.Test;

import java.util.Comparator;

/**
 * Created by aaron.korver.
 */
public class TestPersonComparator {

    @Test
    public void testPersonComparator()
    {
        PersonFixture.getPersons().stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .forEach(System.out::println);

    }
}
