package br.com.cucumber.selenium.account.create;

import io.cucumber.java8.Pt;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncluirContaUsuarioPassos implements Pt {

    private WebDriver webDriver;

    public IncluirContaUsuarioPassos() {
        Before(() -> {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            webDriver = new ChromeDriver();
            webDriver.get("http://automationpractice.com/index.php");
        });

        After(() -> {
            webDriver.close();
        });

        Dado("que clico no botão {string}", (String string) -> {
            Thread.sleep(1000);
            webDriver.findElement(By.className("header_user_info")).click();
        });

        Dado("que informo um email válido", () -> {
            Thread.sleep(1000);
            String prefixo = RandomStringUtils.randomAlphanumeric(20);
            String email = prefixo + "@gmail.com";
            webDriver.findElement(By.id("email_create")).sendKeys(email);
        });

        Quando("clicar no botão {string}", (String string) -> {
            Thread.sleep(3000);
            webDriver.findElement(By.id("SubmitCreate")).click();
        });

        Então("deve mostrar a mensagem de validação {string}", (String mensagemEsperada) -> {
            Thread.sleep(2000);
            String mensagem = webDriver.findElement(By.cssSelector("#create_account_error > ol > li")).getText();
            Assert.assertEquals(mensagemEsperada, mensagem);
        });

        Então("deve redirecionar para a página de cadastro", () -> {
            Thread.sleep(3000);
            String tituloPaginaCadastro = webDriver.findElement(By.cssSelector("#account-creation_form > div:nth-child(1) > h3")).getText();
            Assert.assertEquals("YOUR PERSONAL INFORMATION", tituloPaginaCadastro);
        });
    }
}
