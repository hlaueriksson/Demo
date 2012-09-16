package demo.calculon.specs.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_calculating_1_point_2_times_4 extends Given_Calculon {

    protected void when() throws Exception {
        calculator.appendDigit("1");
        calculator.appendRadix(".");
        calculator.appendDigit("2");
        calculator.appendOperator("*");
        calculator.appendDigit("4");
        calculator.calculate();
    }

    @Test
    public void then_the_result_should_be_4_point_8() {
        assertEquals("4.8", calculator.toString());
    }
}
