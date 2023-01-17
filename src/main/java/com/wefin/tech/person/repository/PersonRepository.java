package com.wefin.tech.person.repository;

import com.wefin.tech.person.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository mapping for {@link Person}.
 */
public interface PersonRepository extends CrudRepository<Person, String> {
}
