package DSL;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CampoTexto {

    public static void preencher(WebElement elemento, String valor) {
        elemento.clear();
        elemento.sendKeys(valor);
    }

    public static void preencherComEnter(WebElement elemento, String valor) {

        elemento.clear();
        elemento.sendKeys(valor);
        elemento.sendKeys( Keys.ENTER);
    }

    public static void preencherAutomatico(WebElement elemento, Faker valorFake) {
        String valor = String.valueOf( valorFake );
        elemento.clear();
        elemento.sendKeys( valor );
    }


    public static void limpar(WebElement elemento) {

        elemento.clear();
    }


}
