package demo.calculon.specs.junit;

import demo.calculon.Calculator;
import demo.calculon.Calculon;
import demo.calculon.Logger;

import static org.mockito.Mockito.mock;

public class Given_Calculon extends BaseSpec {
    protected Calculator calculator;
    protected Logger logger;

    protected void given() {
        logger = mock(Logger.class);
        calculator = new Calculon(logger);
    }
}
