package demo.calculon.specs.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_calculating_1_plus_2 extends Given_Calculon {

    protected void when() throws Exception {
        calculator.appendDigit("1");
        calculator.appendOperator("+");
        calculator.appendDigit("2");
        calculator.calculate();
    }

    @Test
    public void then_the_result_should_be_3() {
        assertEquals("3.0", calculator.toString());
    }
}
