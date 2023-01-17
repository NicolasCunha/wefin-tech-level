package com.wefin.tech.person.service;

import com.wefin.tech.person.dto.PersonValidationOutput;

/**
 * Service responsible for validating {@link com.wefin.tech.person.domain.Person} related data.
 */
public interface PersonValidationService {

    /**
     * Validates if a person code is valid.
     * A valid is not null; has at least 11 characters (CPF) and at max 14 characters (CNPJ).
     * @param code {@link String} code.
     * @return {@link PersonValidationOutput} instance.
     */
    PersonValidationOutput validate(final String code);

}
