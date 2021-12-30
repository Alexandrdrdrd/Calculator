package com.avdieiev.calculator;

import com.avdieiev.calculator.history.History;
import com.avdieiev.calculator.history.HistoryInterface;
import com.avdieiev.calculator.input.user.Input;
import com.avdieiev.calculator.input.user.UserCommand;
import com.avdieiev.calculator.input.user.CalculatedExpression;
import com.avdieiev.calculator.model.Commands;
import com.avdieiev.calculator.service.calculate.Calculator;
import com.avdieiev.calculator.service.calculate.RPNCalculator;
import com.avdieiev.calculator.service.print.Printable;
import com.avdieiev.calculator.service.print.Printer;
import java.util.Arrays;
import java.util.Scanner;

public class CalculatorRunner implements Runable {

    /**
     * Responsible for starting the calculator, creating all the necessary objects,
     * creation and conduct of all processes occurring in a conventional calculator.
     */
    @Override
    public void run() {
        Input userCommand = new UserCommand();
        Input userExpression = new CalculatedExpression();
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new RPNCalculator();
        Printable printer = new Printer();
        HistoryInterface history = new History();
        boolean running = true;

        while (running) {
            Commands[] commands = Commands.values();
            System.out.println("Choose command: " + Arrays.toString(commands));
            String command = userCommand.get(sc);

            switch (Commands.valueOf(command)) {
                case calculate -> {
                    System.out.println("Enter expression");
                    String expression = userExpression.get(sc);
                    Double result = calculator.calculate(expression);
                    printer.print(result.toString());
                    history.save(expression+"="+result);
                }
                case history -> {
                    String allHistory = history.getAll();
                    printer.print(allHistory);
                }
                case historyUnique -> {
                    String historyUnique = history.getUnique();
                    printer.print(historyUnique);
                }
                case exit -> running = false;
            }
        }
    }
}



