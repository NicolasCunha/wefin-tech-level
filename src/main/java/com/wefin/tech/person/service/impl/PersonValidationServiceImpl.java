package com.wefin.tech.person.service.impl;

import com.wefin.tech.person.domain.DocumentLength;
import com.wefin.tech.person.dto.PersonValidationOutput;
import com.wefin.tech.person.service.PersonValidationService;
import com.wefin.tech.person.util.RegexUtils;
import org.springframework.stereotype.Component;

/**
 * Default implementation for {@link PersonValidationService}.
 */
@Component
public class PersonValidationServiceImpl implements PersonValidationService {

    @Override
    public PersonValidationOutput validate(final String code) {

        if (code == null) {
            return PersonValidationOutput.invalid(ValidationMessages.CODE_IS_NULL.toString());
        }

        final String filteredCode = RegexUtils.removeSpecialCharactersAndNumbers(code);
        final int len = filteredCode.length();

        if (!isValidCpfOrCnpj(len)) {
            return PersonValidationOutput.invalid(ValidationMessages.CODE_LENGTH_OUT_OF_BOUNDS.toString());
        }

        return PersonValidationOutput.ok();
    }

    /**
     * Checks if a length is according to a CPF or CNPJ bounds.
     * A valid CPF has 11 characters, and a valid CNPJ has 14 characters.
     * If the length is below CPF length and above CNPJ length, the length is invalid.
     * If the length is above CPF length and below CNPJ length, the length is invalid.
     * @param len {@link Integer} length.
     * @return {@link Boolean} value.
     */
    private boolean isValidCpfOrCnpj(int len) {
        return !((len < DocumentLength.CPF.getSize() || len > DocumentLength.CNPJ.getSize())
                || (len > DocumentLength.CPF.getSize() && len < DocumentLength.CNPJ.getSize()));
    }

    private enum ValidationMessages {
        CODE_IS_NULL("Person unique code is null."),
        CODE_LENGTH_OUT_OF_BOUNDS("Person unique code doesn't fit CPF or CNPJ criteria.");
        private final String message;

        ValidationMessages(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }

}
