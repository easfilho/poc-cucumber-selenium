package br.com.cucumber.selenium.account.create;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration
@CucumberOptions(features = {"src/test/resources/features/US001-IncluirContaUsuario.feature"},
        glue = "br.com.cucumber.selenium.account.create",
        strict = true)
public class IncluirContaUsuarioTest {
}
