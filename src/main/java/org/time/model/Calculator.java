package org.time.model;

public class Calculator {
    public double calculate(double operand1, double operand2, char operator) throws ArithmeticException {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Khong the chia cho 0");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Toán tử không hợp lệ");
        }
    }
}
