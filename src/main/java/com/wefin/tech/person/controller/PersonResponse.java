package com.wefin.tech.person.controller;

/**
 * Response mapping used in {@link PersonController}.
 */
public class PersonResponse {

    private String message;

    public PersonResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
