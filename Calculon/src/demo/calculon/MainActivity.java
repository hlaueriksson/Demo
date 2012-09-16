package demo.calculon;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private LinkedList<String> expression = new LinkedList<String>();

    private TextView text;
    private String error;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        text = (TextView) findViewById(R.id.text);
        error = getString(R.string.error);
    }

    public void appendDigit(View view) {
        String digit = ((Button)view).getText().toString();

        Log.d(TAG, "Append digit: " + digit);

        if (isOperand(expression.peekLast())){
            String value = expression.pollLast();
            expression.addLast(value + digit);
        }
        else {
            expression.addLast(digit);
        }

        update();
    }

    public void appendRadix(View view) {
        String radix = ((Button)view).getText().toString();

        Log.d(TAG, "Append radix: " + radix);

        if (isOperand(expression.peekLast())){
            String value = expression.pollLast();
            expression.addLast(value + radix);
        }
        else {
            expression.addLast("0" + radix);
        }

        update();
    }

    public void appendOperator(View view) {
        String operator = ((Button)view).getText().toString();

        Log.d(TAG, "Append operator: " + operator);

        expression.add(operator);

        update();
    }

    public void clear(View view) {
        Log.d(TAG, "Clear");

        expression.clear();

        update();
    }

    public void remove(View view) {
        Log.d(TAG, "Remove");

        if (isOperand(expression.peekLast())){
            String value = expression.pollLast();

            if(!value.isEmpty()) {
                expression.addLast(value.substring(0, value.length() - 1));
            }
        }
        else {
            expression.pollLast();
        }

        update();
    }

    public void calculate(View view) {
        Log.d(TAG, "Calculate");

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
            Log.d(TAG, "Error");

            expression.clear();
            update(error);
            return;
        }

        update();
    }

    private void update() {
        StringBuilder sb = new StringBuilder();

        for (String value : expression) {
            sb.append(value);
        }

        text.setText(sb.toString());
    }

    private void update(String value) {
        text.setText(value);
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
