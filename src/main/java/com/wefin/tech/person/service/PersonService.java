package com.wefin.tech.person.service;

import com.wefin.tech.person.domain.Person;

import java.util.List;

/**
 * Service responsible for handling {@link Person} business logic.
 */
public interface PersonService {

    /**
     * Retrieves all {@link Person} instances in the database.
     * @return {@link List} of {@link Person persons}.
     */
    List<Person> findAll();

    /**
     * Creates a new {@link Person}.
     * @param name Name.
     * @param code Code.
     * @return {@link Person} instance.
     */
    Person createPerson(final String name, final String code);

    /**
     * Updates a {@link Person}.
     * @param name Person name.
     * @param code New person code.
     * @return {@link Person} instance.
     */
    Person updatePerson(final String name, final String code);

    /**
     * Deletes a {@link Person}.
     * @param name Name of the person to be deleted.
     */
    void deletePerson(final String name);

}
