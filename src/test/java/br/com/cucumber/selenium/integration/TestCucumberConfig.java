package br.com.cucumber.selenium.integration;

import br.com.cucumber.selenium.SeleniumApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes = {SeleniumApplication.class})
public class TestCucumberConfig {
}
