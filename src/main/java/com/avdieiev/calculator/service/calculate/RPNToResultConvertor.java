package com.avdieiev.calculator.service.calculate;

import com.avdieiev.calculator.service.parser.IsParsableToDigit;
import com.avdieiev.calculator.model.Operators;
import com.avdieiev.calculator.service.parser.Parsable;

import java.util.List;
import java.util.Stack;

public class RPNToResultConvertor {

    Parsable parser = new IsParsableToDigit();

    /**
     * Calculates expressions written according to the rules of reverse Polish notation.
     *
     * @param RPNList - a list of strings formatted according to the rules of reverse Polish notation.
     */
    Double getAnswer(List<String> RPNList) {
        double result = 0;
        Stack<Double> resultStack = new Stack<Double>();

        for (int i = 0; i < RPNList.size(); i++) {
            if (parser.isParsable(RPNList.get(i))) {
                resultStack.push(Double.parseDouble(RPNList.get(i)));
            } else {
                double a = resultStack.pop();
                double b = resultStack.pop();
                result = Operators.getByShortCut(RPNList.get(i)).makeOperation(a, b);
                resultStack.push(result);
            }
        }
        return resultStack.peek();
    }
}

