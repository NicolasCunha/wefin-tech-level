package com.wefin.tech.person.controller;

import com.wefin.tech.person.domain.CodeType;

/**
 * Request mapping used in {@link PersonController}.
 */
public class PersonRequest {

    private final String name;
    private final String code;

    private final CodeType codeType;

    public PersonRequest(String name, String code, CodeType codeType) {
        this.name = name;
        this.code = code;
        this.codeType = codeType;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public CodeType getCodeType() {
        return codeType;
    }
}
