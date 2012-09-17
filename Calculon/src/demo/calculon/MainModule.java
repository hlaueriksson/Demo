package demo.calculon;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Calculator.class).to(Calculon.class);
        bind(Logger.class).to(AndroidLogger.class);
    }
}
