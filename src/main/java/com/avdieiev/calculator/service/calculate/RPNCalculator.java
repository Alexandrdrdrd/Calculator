package com.avdieiev.calculator.service.calculate;

import com.avdieiev.calculator.covertor.ConverterToRPN;

import java.util.List;

/**
 * Responsible for starting the calculation in the calculator.
 */
public class RPNCalculator implements Calculator {

    ConverterToRPN converter = new ConverterToRPN();
    RPNToResultConvertor rpnToResult = new RPNToResultConvertor();

    @Override
    public Double calculate(String expression) {
        List<String> RPNList = converter.getRPN(expression);
        return rpnToResult.getAnswer(RPNList);
    }
}
