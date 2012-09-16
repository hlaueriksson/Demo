package demo.calculon;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Calculator calculator = new Calculon();

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

        calculator.appendDigit(digit);

        update();
    }

    public void appendRadix(View view) {
        String radix = ((Button)view).getText().toString();

        Log.d(TAG, "Append radix: " + radix);

        calculator.appendRadix(radix);

        update();
    }

    public void appendOperator(View view) {
        String operator = ((Button)view).getText().toString();

        Log.d(TAG, "Append operator: " + operator);

        calculator.appendOperator(operator);

        update();
    }

    public void clear(View view) {
        Log.d(TAG, "Clear");

        calculator.clear();

        update();
    }

    public void remove(View view) {
        Log.d(TAG, "Remove");

        calculator.remove();

        update();
    }

    public void calculate(View view) {
        Log.d(TAG, "Calculate");

        try {
            calculator.calculate();

            update();
        } catch (Exception e) {
            Log.w(TAG, "Calculate failed.", e);

            update(error);
        }
    }

    private void update() {
        text.setText(calculator.toString());
    }

    private void update(String value) {
        text.setText(value);
    }
}
