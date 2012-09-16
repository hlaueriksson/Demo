package demo.calculon.specs.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class When_calculating_0_divided_by_0 extends Given_Calculon {

    private Exception exception;

    protected void when() {
        calculator.appendDigit("0");
        calculator.appendOperator("/");
        calculator.appendDigit("0");
        try {
            calculator.calculate();
        } catch (Exception e) {
            exception = e;
        }
    }

    @Test
    public void then_an_exception_should_be_thrown() {
        assertNotNull(exception);
        assertEquals("Error", exception.getMessage());
    }
}
