package demo.calculon;

import java.util.LinkedList;

/* Hi, I am Antonio Calculon, Sr! */
public class Calculon implements Calculator {

    private LinkedList<String> expression = new LinkedList<String>();

    @Override
    public void appendDigit(String digit) {
        if (isOperand(expression.peekLast())){
            String value = expression.pollLast();
            expression.addLast(value + digit);
        }
        else {
            expression.addLast(digit);
        }
    }

    @Override
    public void appendRadix(String radix) {
        if (isOperand(expression.peekLast())){
            String value = expression.pollLast();
            expression.addLast(value + radix);
        }
        else {
            expression.addLast("0" + radix);
        }
    }

    @Override
    public void appendOperator(String operator) {
        expression.add(operator);
    }

    @Override
    public void clear() {
        expression.clear();
    }

    @Override
    public void remove() {
        if (isOperand(expression.peekLast())){
            String value = expression.pollLast();

            if(!value.isEmpty()) {
                expression.addLast(value.substring(0, value.length() - 1));
            }
        }
        else {
            expression.pollLast();
        }
    }

    @Override
    public void calculate() throws Exception {
        while(expression.size() > 1) {
            double result = 0, a = 0, b = 0;
            String operator = null;

            if(isOperand(expression.peek())) a = toDouble(expression.pop());
            if(isOperator(expression.peek())) operator = expression.pop();
            if(isOperand(expression.peek())) b = toDouble(expression.pop());

            if(operator == null) break;

            if (operator.equals("+")) result = add(a, b);
            else if (operator.equals("-")) result = subtract(a, b);
            else if (operator.equals("*")) result = multiply(a, b);
            else if (operator.equals("/")) result = divide(a, b);

            expression.addFirst(toString(result));
        }

        if(isError(expression.peek())) {
            //Log.d(TAG, "Error");

            expression.clear();

            throw new Exception("Error");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String value : expression) {
            sb.append(value);
        }

        return sb.toString();
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        return a / b;
    }

    private boolean isOperator(String value) {
        if(value == null) return false;

        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }

    private boolean isOperand(String value) {
        if(value == null) return false;

        return !isOperator(value);
    }

    private double toDouble(String value) {
        return Double.parseDouble(value);
    }

    private String toString(double value) {
        return Double.toString(value);
    }

    private boolean isError(String value) {
        if(value == null) return false;

        return isError(toDouble(value));
    }

    private boolean isError(double value) {
        return Double.isNaN(value);
    }
}
