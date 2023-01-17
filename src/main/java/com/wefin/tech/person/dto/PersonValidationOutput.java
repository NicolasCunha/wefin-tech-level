package com.wefin.tech.person.dto;

/**
 * Represents a validation output. Produced by {@link com.wefin.tech.person.service.PersonValidationService}.
 */
public final class PersonValidationOutput {

    private final boolean valid;

    private final String message;

    private PersonValidationOutput(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    /**
     * Creates an output signaling that the data is valid.
     *
     * @return {@link PersonValidationOutput} instance.
     */
    public static PersonValidationOutput ok() {
        return new PersonValidationOutput(true, null);
    }

    /**
     * Creates an output signaling that the data is invalid.
     *
     * @param message {@link String} error message.
     * @return {@link PersonValidationOutput} instance.
     */
    public static PersonValidationOutput invalid(final String message) {
        return new PersonValidationOutput(false, message);
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

}
