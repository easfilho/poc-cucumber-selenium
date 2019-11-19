package br.com.cucumber.selenium.account.loginsimulador;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration
@CucumberOptions(features = {"src/test/resources/features/US003-LoginSimulador.feature"},
        glue = "br.com.cucumber.selenium.account.loginsimulador",
        strict = true)

public class LoginSimuladorTest {
}
