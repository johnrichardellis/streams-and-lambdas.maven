package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonFactory {


    private Person newPerson;


    public PersonFactory() {
        /** this class is not to be instantiated */
    }




    /**
     * @return a new instance of a person with fields of random values
     */
    public Person createRandomPerson() {
        String name = StringUtils.capitalizeFirstChar(RandomUtils.createString('a', 'e', 3));
        String[] aliases = RandomUtils.createStrings('a', 'z', 3, 5);
        boolean isMale = RandomUtils.createBoolean(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);

        Person randomPerson = new Person(name, isMale, personalId, birthDate, aliases);
        return randomPerson;
    }

    /**
     * Section 8.8
     *
     * @param listSize - number of Person objects to create
     * @return - ArrayList of Person objects
     */ // TODO
    public List<Person> createPersonList(int listSize) {
        // given parameter int listSize (size of a list)
        // return a List<Person> list of type Person
        // create a person List = ArrayList

        // saving this new list to the type we want to return
        // using a stream to do so
        List<Person> newPerson = Stream
                // .generate to create persons using createRandomPerson method in THIS class
                .generate(this::createRandomPerson)
                // setting the size limit using the parameter we are given
                .limit(listSize)
                // .collect to collect these objects in a list using .toList
                .collect(Collectors.toList());

        // return the created list
        return newPerson;


//        return null;
    }


    /**
     * @param arrayLength - number of Person objects to create
     * @return - Array of Person objects
     */ // TODO
    public Person[] createPersonArray(int arrayLength) {

        // same idea as above but given length of array and want to return an array
        Person[] newPerson = Stream
                // .generate to create persons
                .generate(this::createRandomPerson)
                // defining the size of the array using parameter
                .limit(arrayLength)
                // setting this equal to an array of Person[] type
                .toArray(Person[]::new);

                return newPerson;



//        return null;
    }


    /**
     * Section 8.2
     *
     * @param streamCount - number of Person objects to create
     * @return - Stream representation of collection of Person objects
     */ // TODO
    public Stream<Person> createPersonStream(int streamCount) {

        // creating Person objects and placing in a stream
        Stream<Person> newPerson = Stream
                //generating objects
                .generate(this::createRandomPerson)
                // defining size of stream
                .limit(streamCount);


        return newPerson;





//        return null;
    }
}
