package com.avdieiev.calculator.input.user;

import com.avdieiev.calculator.input.validator.impl.CommandValidator;
import com.avdieiev.calculator.input.validator.Validator;

import java.util.Scanner;

public class UserCommand implements Input {

    /**
     * Responsible for receiving a command from the user.
     *
     * @param sc scanner object.
     * @return validated line.
     */
    @Override
    public String get(Scanner sc) {
        Validator validator = new CommandValidator();
        String command;

        do {
            command = sc.nextLine();
        }
        while (!validator.validate(command));
        return command;
    }
}
