package br.com.cucumber.selenium.account.loginsimulador;

import io.cucumber.java8.Pt;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSimuladorPassos implements Pt {
    private WebDriver webDriver;

    public LoginSimuladorPassos() {

        After(() -> {
            webDriver.close();
        });

        Dado("que acesso o simulador", () -> {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            webDriver = new ChromeDriver();
            webDriver.get("https://credito-hlg.e-unicred.com.br/#/home");
            Thread.sleep(3000);
        });

        Dado("que informo o nome {string}", (String nome) -> {
            webDriver.findElement(By.id("username")).sendKeys(nome);
        });

        Dado("que informo a senha {string}", (String senha) -> {
            webDriver.findElement(By.id("password")).sendKeys(senha);
        });

        Dado("que seleciono a cooperativa {string}", (String cooperativa) -> {
            webDriver.findElement(By.cssSelector("#authForm > div:nth-child(3) > div")).click();
            Thread.sleep(1000);
            webDriver.findElement(By.cssSelector("#authForm > div:nth-child(3) > div > div > ul > li:nth-child(15)")).click();
        });

        Quando("clico no botão entrar", () -> {
            webDriver.findElement(By.id("kc-login")).click();
            Thread.sleep(3000);
        });

        Então("deve fazer o login", () -> {
            //Não faz nada nesse passo
        });

        Então("deve redirecionar para a tela {string}", (String tituloEsperado) -> {
            String texto = webDriver.findElement(By.className("home-title")).getText();
            Assert.assertTrue(texto.toLowerCase().contains(tituloEsperado.toLowerCase()));
        });

    }
}
