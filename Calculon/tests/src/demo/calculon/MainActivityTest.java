package demo.calculon;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class demo.calculon.MainActivityTest \
 * demo.calculon.tests/android.test.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity;

    private TextView text;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button btnRadix;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Button btnClear, btnRemove;
    private Button btnEquals;

    public MainActivityTest() {
        super("demo.calculon", MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        activity = getActivity();

        text = (TextView) activity.findViewById(R.id.text);

        btn1 = (Button) activity.findViewById(R.id.btn1);
        btn2 = (Button) activity.findViewById(R.id.btn2);
        btn3 = (Button) activity.findViewById(R.id.btn3);
        btn4 = (Button) activity.findViewById(R.id.btn4);
        btn5 = (Button) activity.findViewById(R.id.btn5);
        btn6 = (Button) activity.findViewById(R.id.btn6);
        btn7 = (Button) activity.findViewById(R.id.btn7);
        btn8 = (Button) activity.findViewById(R.id.btn8);
        btn9 = (Button) activity.findViewById(R.id.btn9);
        btn0 = (Button) activity.findViewById(R.id.btn0);

        btnRadix = (Button) activity.findViewById(R.id.btnRadix);

        btnAdd = (Button) activity.findViewById(R.id.btnAdd);
        btnSubtract = (Button) activity.findViewById(R.id.btnSubtract);
        btnMultiply = (Button) activity.findViewById(R.id.btnMultiply);
        btnDivide = (Button) activity.findViewById(R.id.btnDivide);

        btnClear = (Button) activity.findViewById(R.id.btnClear);
        btnRemove = (Button) activity.findViewById(R.id.btnRemove);

        btnEquals = (Button) activity.findViewById(R.id.btnEquals);
    }

    public void test_that_1_plus_2_should_equal_3() {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                btn1.performClick();
                btnAdd.performClick();
                btn2.performClick();
                btnEquals.performClick();

                assertEquals("3.0", text.getText());
            }
        });
    }

    public void test_that_10_minus_3_should_equal_7() {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                btn1.performClick();
                btn0.performClick();
                btnSubtract.performClick();
                btn3.performClick();
                btnEquals.performClick();

                assertEquals("7.0", text.getText());
            }
        });
    }

    public void test_that_1_point_2_times_4_should_equal_4_point_8() {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                btn1.performClick();
                btnRadix.performClick();
                btn2.performClick();
                btnMultiply.performClick();
                btn4.performClick();
                btnEquals.performClick();

                assertEquals("4.8", text.getText());
            }
        });
    }

    public void test_that_0_divided_by_0_should_display_an_error() {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                btn0.performClick();
                btnDivide.performClick();
                btn0.performClick();
                btnEquals.performClick();

                assertEquals("Error", text.getText());
            }
        });
    }
}
