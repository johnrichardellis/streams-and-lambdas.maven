package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {


    public ArrayConverter(Person... people) {


        super(people);
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }

    //TODO
    public List<Person> toList() {
        // array to list
        // super is reference to any classes above this one
        // this class passes objectSequence from our super class
        // to return the array as a list

       return  Arrays.asList(super.objectSequence);

//        return null;
    }

    //TODO
    public Stream<Person> toStream() {
        // array to stream
        // taking the above method and calling it
        // converting the above list to a stream using .stream
        return toList().stream();


//        return null;
    }

    @Override
    public Person[] toArray() {

        // array to array
        return super.objectSequence;
    }
}
