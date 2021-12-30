package com.avdieiev.calculator.model;

import java.util.Arrays;

public enum Operators {
    Plus("+") {
        @Override
        public Double makeOperation(double firstOperand, double secondOperand) {
            return firstOperand + secondOperand;
        }

        @Override
        public Integer getPriority() {
            return 2;
        }
    },
    Minus("-") {
        @Override
        public Double makeOperation(double firstOperand, double secondOperand) {
            return firstOperand - secondOperand;
        }

        @Override
        public Integer getPriority() {
            return 3;
        }
    },
    Multiply("*") {
        @Override
        public Double makeOperation(double firstOperand, double secondOperand) {
            return firstOperand * secondOperand;
        }

        @Override
        public Integer getPriority() {
            return 4;
        }
    },
    Split("/") {
        @Override
        public Double makeOperation(double firstOperand, double secondOperand) {
            return firstOperand / secondOperand;
        }

        @Override
        public Integer getPriority() {
            return 4;
        }
    },
    ClosingParenthesis(")") {
        @Override
        public Double makeOperation(double firstOperand, double secondOperand) {
            return null;
        }

        @Override
        public Integer getPriority() {
            return 1;
        }
    },
    OpeningParenthesis("(") {
        @Override
        public Double makeOperation(double firstOperand, double secondOperand) {
            return null;
        }

        @Override
        public Integer getPriority() {
            return 0;
        }
    };

    public abstract Integer getPriority();

    public abstract Double makeOperation(double firstOperand, double secondOperand);

    public final String shortCut;

    Operators(String shortCut) {
        this.shortCut = shortCut;
    }

    public static Operators getByShortCut(String shortCut) {
        return Arrays.stream(Operators.values()).filter(v -> v.shortCut.equals(shortCut)).findAny().orElse(null);
    }
}

