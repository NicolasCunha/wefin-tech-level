package com.wefin.tech.person.controller;

import com.wefin.tech.person.domain.Person;
import com.wefin.tech.person.dto.PersonValidationOutput;
import com.wefin.tech.person.service.PersonService;
import com.wefin.tech.person.service.PersonValidationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Endpoint responsible for handling person related operations.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonValidationService personValidationService;
    private final PersonService personService;

    /**
     * Default constructor.
     *
     * @param personValidationService {@link PersonValidationService} instance.
     * @param personService           {@link PersonService} instance.
     */
    @Autowired
    public PersonController(final PersonValidationService personValidationService,
                            final PersonService personService) {
        this.personValidationService = personValidationService;
        this.personService = personService;
    }

    /**
     * Retrieve all persons in database.
     *
     * @return {@link List} of {@link Person persons}.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPeople() {
        final List<Person> people = this.personService.findAll();
        return ResponseEntity.ok().body(people);
    }

    /**
     * Method responsible for creating persons.
     *
     * @param request {@link PersonRequest} instance. Contains person data.
     * @return {@link ResponseEntity}. Returns a "400 - Bad Request" if the code is invalid. Returns "200 - OK" if the operation is ok.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPerson(@RequestBody final PersonRequest request) {
        final PersonValidationOutput output = this.personValidationService.validate(request.getCode());

        if (!output.isValid()) {
            final PersonResponse response = new PersonResponse(output.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        final Person person = this.personService.createPerson(request.getName(), request.getCode());
        return ResponseEntity.ok().body(person);
    }

    /**
     * Updates a {@link Person}
     *
     * @param request {@link PersonRequest} instance containing information regarding the person to be updated and its new values.
     * @return {@link ResponseEntity}. Returns a "400 - Bad Request" if the code is invalid. Returns "200 - OK" if the operation is ok.
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePerson(@RequestBody final PersonRequest request) {
        final PersonValidationOutput output = this.personValidationService.validate(request.getCode());

        if (!output.isValid()) {
            final PersonResponse response = new PersonResponse(output.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        final Person person = this.personService.updatePerson(request.getName(), request.getCode());
        return ResponseEntity.ok().body(person);
    }

    /**
     * Deletes a Person.
     * @param request {@link PersonRequest} instance. Contains person data.
     * @return {@link ResponseEntity} instance. Always returns "200 - OK".
     */
    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePerson(@RequestBody final PersonRequest request) {
        this.personService.deletePerson(request.getName());
        return ResponseEntity.ok(null);
    }

}
