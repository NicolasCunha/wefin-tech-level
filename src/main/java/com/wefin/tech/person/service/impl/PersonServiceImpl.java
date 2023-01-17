package com.wefin.tech.person.service.impl;

import com.wefin.tech.person.domain.DocumentLength;
import com.wefin.tech.person.domain.Person;
import com.wefin.tech.person.domain.CodeType;
import com.wefin.tech.person.repository.PersonRepository;
import com.wefin.tech.person.service.PersonService;
import com.wefin.tech.person.util.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Default implementation for {@link PersonService}.
 */
@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(final PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> findAll() {
        final List<Person> people = new LinkedList<>();
        repository.findAll().forEach(people::add);
        return people;
    }

    @Override
    public Person createPerson(String name, String code) {
        final CodeType codeType = getCodeType(code);
        final Person person = new Person(name, code, codeType);
        return this.repository.save(person);
    }

    @Override
    public Person updatePerson(String name, String code) {
        final Person person = this.repository.findById(name).orElse(null);

        if (person == null) {
            return null;
        }

        final CodeType codeType = getCodeType(code);
        person.setCode(code);
        person.setPersonType(codeType);
        return this.repository.save(person);
    }

    @Override
    public void deletePerson(String name) {
        this.repository.findById(name).ifPresent(this.repository::delete);
    }

    private CodeType getCodeType(final String code) {
        final int filteredLen = RegexUtils.removeSpecialCharactersAndNumbers(code).length();
        return filteredLen == DocumentLength.CPF.getSize() ? CodeType.CPF : CodeType.CNPJ;
    }

}
