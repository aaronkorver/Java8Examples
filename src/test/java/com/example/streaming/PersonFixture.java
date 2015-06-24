package com.example.streaming;

import com.example.model.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aaron.korver.
 */
public class PersonFixture {

    public static List<Person> getPersons()
    {
        return Arrays.asList(
                new Person("Aaron","Korver"),
                new Person("Danielle","Korver"),
                new Person("Bob","Smith"),
                new Person("Frank","Hubert"));
    }
}
