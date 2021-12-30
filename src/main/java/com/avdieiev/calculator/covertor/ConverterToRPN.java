package com.avdieiev.calculator.covertor;


import com.avdieiev.calculator.service.parser.IsParsableToDigit;
import com.avdieiev.calculator.service.parser.Parsable;
import com.avdieiev.calculator.model.Operators;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ConverterToRPN {

    /**
     * Creates a list of strings (numbers and operators) according to OPN rules.
     * @param input validated string with math expression.
     * @return - list of strings.
     */
    public List<String> getRPN(String input) {
        Parsable parser = new IsParsableToDigit();
        List<String> RPNList = new LinkedList<>();
        Stack<String> operatorStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            if (parser.isParsable(String.valueOf(input.charAt(i)))) {
                String digit = "";
                while (parser.isParsable(String.valueOf(input.charAt(i)))) {
                    digit += input.charAt(i);
                    i++;

                    if (i == input.length()) break;
                }
                RPNList.add(digit);
                i--;
            }
            if (Operators.getByShortCut(String.valueOf(input.charAt(i))) != null) {

                if (Operators.getByShortCut(String.valueOf(input.charAt(i))) == Operators.OpeningParenthesis) {
                    operatorStack.push(String.valueOf(input.charAt(i)));
                } else if (Operators.getByShortCut(String.valueOf(input.charAt(i))) == Operators.ClosingParenthesis) {

                    String s = operatorStack.pop();
                    while (Operators.getByShortCut(String.valueOf(input.charAt(i))) != Operators.OpeningParenthesis) {
                        RPNList.add(String.valueOf(s));
                        s = operatorStack.pop();
                    }
                } else {
                    if (operatorStack.size() > 0)
                        if (Operators.getByShortCut(String.valueOf(input.charAt(i))).getPriority() <= Operators.getByShortCut(operatorStack.peek()).getPriority())

                            RPNList.add(String.valueOf(operatorStack.pop()));

                    operatorStack.push(String.valueOf(input.charAt(i)));
                }
            }
        }

        while (operatorStack.size() > 0) {
            String ch = operatorStack.pop();
            RPNList.add(String.valueOf(ch));
        }
        return RPNList;
    }
}
