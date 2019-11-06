package br.com.cucumber.selenium.account.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration
@CucumberOptions(features = {"src/test/resources/features/US002-LoginContaUsuario.feature"},
        glue = "br.com.cucumber.selenium.account.login",
        strict = true)
public class LoginTest {
}
