package com.avdieiev.calculator.input.validator.impl;

import com.avdieiev.calculator.model.Commands;
import com.avdieiev.calculator.input.validator.Validator;

public class CommandValidator implements Validator {

    /**
     * Checks the command entered by the user for the presence in the list of available commands.
     * @param input user entered string.
     * @return true or false depending on whether the expression matches the conditions.
     */
    @Override
    public boolean validate(String input) {

            try {
                Commands.valueOf(input.replaceAll(" ", ""));
                return true;
            } catch (RuntimeException ex) {
                System.out.println("Invalid command \n");
                return false;
            }
    }
}
