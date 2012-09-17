package demo.calculon.specs.robolectric;

import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import demo.calculon.MainActivity;
import demo.calculon.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    private TextView text;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button btnRadix;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Button btnClear, btnRemove;
    private Button btnEquals;

    @Before
    public void setUp() throws Exception {
        activity = new MainActivity();
        activity.onCreate(null);

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

    @Test
    public void should_handle_add_calculation() {
        btn1.performClick();
        btnAdd.performClick();
        btn2.performClick();
        btnEquals.performClick();

        assertEquals("3.0", text.getText());
    }

    @Test
    public void should_handle_subtract_calculation() {
        btn1.performClick();
        btn0.performClick();
        btnSubtract.performClick();
        btn3.performClick();
        btnEquals.performClick();

        assertEquals("7.0", text.getText());
    }

    @Test
    public void should_handle_decimal_multiply_calculation() {
        btn1.performClick();
        btnRadix.performClick();
        btn2.performClick();
        btnMultiply.performClick();
        btn4.performClick();
        btnEquals.performClick();

        assertEquals("4.8", text.getText());
    }

    @Test
    public void should_handle_divided_by_0_error() {
        btn0.performClick();
        btnDivide.performClick();
        btn0.performClick();
        btnEquals.performClick();

        assertEquals("Error", text.getText());
    }
}
