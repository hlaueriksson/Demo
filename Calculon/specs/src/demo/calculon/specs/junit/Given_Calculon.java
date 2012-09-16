package demo.calculon.specs.junit;

import demo.calculon.Calculator;
import demo.calculon.Calculon;

public class Given_Calculon extends BaseSpec {
    protected Calculator calculator;

    protected void given() {
        calculator = new Calculon();
    }
}
