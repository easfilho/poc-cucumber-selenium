package br.com.cucumber.selenium.account;

import io.cucumber.java8.Pt;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncluirContaUsuarioPassos implements Pt {

    private WebDriver webDriver;

    public IncluirContaUsuarioPassos() {
        Before(() ->{
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

        Quando("clicar no botão {string}", (String string) -> {
            Thread.sleep(3000);
            webDriver.findElement(By.id("SubmitCreate")).click();
        });

        Então("deve mostrar a mensagem de validação {string}", (String mensagemEsperada) -> {
            Thread.sleep(1000);
            String mensagem = webDriver.findElement(By.cssSelector("#create_account_error > ol > li")).getText();
            Assert.assertEquals(mensagemEsperada, mensagem);
        });
    }
}
