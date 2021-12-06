package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/29/17.
 * The warehouse is responsible for storing, retrieving, and filtering personSequence
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonWarehouse implements Iterable<Person> {
    private final LoggerHandler loggerHandler = LoggerWarehouse.getLogger(PersonWarehouse.class);
    private final List<Person> people = new ArrayList<>();

    /**
     * @param person the Person object to add to the warehouse
     * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this method
     */
    public void addPerson(Person person) {
        loggerHandler.disbalePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public List<String> getNames() {

        List<String> listOfNames =
        people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        return listOfNames;












//
//             // streaming through people list (instance field above)
//        List<String> listOfNames = people.stream()
//                // creating map of Person names
//                .map(Person::getName)
//                // where is getName coming from?
//                // collecting as a list
//                .collect(Collectors.toList());
//
//        return listOfNames;


//        return null;
    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public Stream<Person> getUniquelyNamedPeople() {

        List<String> listOfUniqueNames = people.stream()
                .map(Person::getName)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        List<Person> uniqueNames = new ArrayList<>();
        people.stream()
                .forEach(person -> {
                    if (listOfUniqueNames.contains(person.getName())) {
                        uniqueNames.add(person);
                        listOfUniqueNames.remove(person.getName());
                    }
                });

        return uniqueNames.stream();


//        return null;
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        Stream<Person> newListofPplStartingWithCharacter =
                getUniquelyNamedPeople().filter(person ->
                        person.getName()
                                .charAt(0) == character);

        return newListofPplStartingWithCharacter;


//        return null;
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {

        // getting ppl up to a certain point

        return getUniquelyNamedPeople().limit(n);


//        return null;
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {

        Map<Long, String> newIdMap = people.stream()
                .collect(Collectors.toMap(Person::getPersonalId, Person::getName));
        // Person newPerson = new Person();
        // newPerson.getPersonId();                 // these two lines are the same thing as one one line above

        return newIdMap;


//        return null;
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {

        return Stream.of(getAllAliases());


//        return null;
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {

        return people.stream()
                .flatMap(person ->
                        Arrays.stream(person.getAliases())
                );

//        return null;
    }

    // DO NOT MODIFY
    public Boolean contains(Person p) {
        return people.contains(p);
    }

    // DO NOT MODIFY
    public void clear() {
        people.clear();
    }

    // DO NOT MODIFY
    public int size() {
        return people.size();
    }

    @Override // DO NOT MODIFY
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
