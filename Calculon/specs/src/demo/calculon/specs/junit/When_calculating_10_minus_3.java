package demo.calculon.specs.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_calculating_10_minus_3 extends Given_Calculon {

    protected void when() throws Exception {
        calculator.appendDigit("1");
        calculator.appendDigit("0");
        calculator.appendOperator("-");
        calculator.appendDigit("3");
        calculator.calculate();
    }

    @Test
    public void then_the_result_should_be_7() {
        assertEquals("7.0", calculator.toString());
    }
}
