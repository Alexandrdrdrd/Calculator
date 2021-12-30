package com.avdieiev.calculator.service.print;

public class Printer implements Printable {

    /**
     * Prints information to the console.
     */
    @Override
    public void print(String printableElement) {
        System.out.println(printableElement);
    }
}
