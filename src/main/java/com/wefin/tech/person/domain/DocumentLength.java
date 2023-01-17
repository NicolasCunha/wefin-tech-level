package com.wefin.tech.person.domain;

/**
 * Enum containing document lengths.
 */
public enum DocumentLength {

    /**
     * Represents a CPF length.
     */
    CPF(11),
    /**
     * Represents a CNPJ length.
     */
    CNPJ(14);
    private final int size;

    DocumentLength(int bound) {
        this.size = bound;
    }

    public int getSize() {
        return size;
    }

}
