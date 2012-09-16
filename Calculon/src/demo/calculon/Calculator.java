package demo.calculon;

public interface Calculator {
    void appendDigit(String digit);

    void appendRadix(String radix);

    void appendOperator(String operator);

    void clear();

    void remove();

    void calculate() throws Exception;

    String toString();
}
