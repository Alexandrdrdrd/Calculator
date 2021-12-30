package com.avdieiev.calculator.service.parser;


public class IsParsableToDigit implements Parsable {
    /**
     * Checks a string for the possibility of changing the type from string to numeric.
     *
     * @param element item to check.
     */
    @Override
    public boolean isParsable(String element) {
        try {
            Double.parseDouble(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

