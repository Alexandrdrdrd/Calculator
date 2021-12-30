package com.avdieiev.calculator.input.user;

import com.avdieiev.calculator.input.validator.impl.ExpressionValidator;
import com.avdieiev.calculator.input.validator.Validator;

import java.util.Scanner;

public class CalculatedExpression implements Input {

    /**
     * Responsible for receiving an expression from the user.
     *
     * @param sc scanner object.
     * @return validated line.
     */
    @Override
    public String get(Scanner sc) {
        Validator validator = new ExpressionValidator();
        String expression;

        do {
            expression = sc.nextLine();
        }
        while (!validator.validate(expression));
        return expression;
    }
}
