package com.avdieiev.calculator.service.parser;

/**
 * Checks a string to see if it can be changed to a numeric type.
 */
public interface Parsable {
    boolean isParsable(String element);
}
