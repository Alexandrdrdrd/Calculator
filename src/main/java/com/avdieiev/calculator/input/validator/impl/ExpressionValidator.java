package com.avdieiev.calculator.input.validator.impl;

import com.avdieiev.calculator.service.parser.IsParsableToDigit;
import com.avdieiev.calculator.model.Operators;
import com.avdieiev.calculator.input.validator.Validator;

public class ExpressionValidator implements Validator {

    IsParsableToDigit parser = new IsParsableToDigit();

    /**
     * Checks the expression character by character, if the character is not a number
     * or the expression is considered invalid by the operator.
     *
     * @param input user entered string.
     * @return true or false depending on whether the expression matches the conditions.
     */
    @Override
    public boolean validate(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!parser.isParsable(String.valueOf(input.charAt(i))) &
                    Operators.getByShortCut(String.valueOf(input.charAt(i))) == null) {
                System.out.println(Operators.getByShortCut(String.valueOf(input.charAt(i))));
                System.out.println("Invalid expression");
                return false;
            }
        }
        return true;
    }
}
