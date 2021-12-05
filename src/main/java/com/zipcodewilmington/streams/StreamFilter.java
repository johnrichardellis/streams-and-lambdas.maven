package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        //this is creating the new PersonFactory, create person Stream with a 100 objects, randomly create character
        this(new PersonFactory().createPersonStream(100), RandomUtils.createCharacter('A','Z'));
    }

    /**
     * @param people            - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        //creating new PersonFactory, creates Person stream w 100 objects, randomly creates character
        this(Arrays.stream(people), startingCharacter);
    }

    /**
     * @param people            - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {


        this(people.stream(), startingCharacter);
    }


    /**
     * @param people            - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     *
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {

        List<Person> listWithMultiLine = personStream.filter(person ->
                person.getName()
                        //go through the list and look for the name starting with starting character, collect
                        .startsWith(this.startingCharacter)).collect(Collectors.toList());

        return listWithMultiLine;
//        return null;
    }


    /**
     * Using one-line lambda syntax
     *
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {

        return personStream.filter(person -> person.getName().startsWith(this.startingCharacter)).collect(Collectors.toList());
//        return toListMultiLine;

//        return null;
    }


    /**
     * Using one-line lambda syntax
     *
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {



        return toArrayMultiLine();
//        return personStream.filter(person -> person.getName().startsWith(this.startingCharacter)).toArray(Person[]::new);
//        return null;
    }


    /**
     * Using multi-line lambda syntax
     *
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {



        return personStream.filter(person ->
                        //get the person name
                        person.getName()
                                //check for starting character in this array
                                .startsWith(this.startingCharacter))
                //because it is a stream, we convert it into a new Array
                .toArray(Person[]::new);


//        return null;
    }

}
