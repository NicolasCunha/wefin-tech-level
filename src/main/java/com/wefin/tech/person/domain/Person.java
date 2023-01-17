package com.wefin.tech.person.domain;

import javax.persistence.*;

/**
 * Represents a "Person".
 */
@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
    @Column(name = "code_type")
    private CodeType codeType;

    public Person() {
    }

    public Person(String name, String code, CodeType codeType) {
        this.name = name;
        this.code = code;
        this.codeType = codeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CodeType getPersonType() {
        return codeType;
    }

    public void setPersonType(CodeType codeType) {
        this.codeType = codeType;
    }
}
