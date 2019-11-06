package br.com.cucumber.selenium.account.login;

import io.cucumber.java8.Pt;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPassos implements Pt {

    private WebDriver webDriver;

    public LoginPassos() {

        After(() -> {
            webDriver.close();
        });

        Dado("que acesso a página de login", () -> {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            webDriver = new ChromeDriver();
            webDriver.get("http://automationpractice.com/index.php?controller=authentication");
        });

        Dado("que informo no campo {string} o valor {string}", (String campo, String valor) -> {
            Thread.sleep(3000);
            if(campo.equals("Email")) {
                webDriver.findElement(By.id("email")).sendKeys(valor);
            } else {
                webDriver.findElement(By.id("passwd")).sendKeys(valor);
            }
        });

        Quando("clicar no botão {string}", (String string) -> {
            webDriver.findElement(By.id("SubmitLogin")).click();
        });

        Então("deve mostrar a mensagem de validação {string}", (String mensagemEsperada) -> {
            Thread.sleep(3000);
            String mensagem = webDriver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li")).getText();
            Assert.assertEquals(mensagemEsperada, mensagem);

        });

        Quando("clicar no botão esqueci senha", () -> {
            Thread.sleep(3000);
            webDriver.findElement(By.cssSelector("#login_form > div > p.lost_password.form-group > a")).click();


        });

        Então("deve redirecionar para tela de {string}", (String string) -> {
            Thread.sleep(3000);
            String tituloPagina = webDriver.findElement(By.cssSelector("#center_column > div > h1")).getText();
            Assert.assertEquals("FORGOT YOUR PASSWORD?", tituloPagina);
        });

    }
}
