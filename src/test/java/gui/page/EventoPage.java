package gui.page;

import gui.dsl.CampoTexto;
import gui.dsl.Comando;
import gui.dsl.Label;
import org.openqa.selenium.*;
import utils.Tempo;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.DriverFactory.getDriver;

public class EventoPage {


    @FindBy(id = "nomeEvento") private WebElement inputNomeEvento;
    @FindBy(id = "descricaoEvento") private WebElement inputDescricaoEvento;
    @FindBy(id = "dataEvento") private WebElement inputDataEvento;
    @FindBy(xpath = "//*[contains(text(),'Criar Evento')]") private WebElement comandoCriarEvento;
    @FindBy(xpath = "//*[contains(text(),'Excluir')]") private WebElement comandoExcluirEvento;
    @FindBy(id = "btnConfirmarExclusao") private WebElement comandoConfirmaExcluirEvento;

    @FindBy(id = "mensagem") private WebElement labelMensagem;

    public Integer tempo = 5;

    public EventoPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }

    public void preencherNomeEvento(String valor) throws Exception {
        Tempo.aguardar(tempo, inputNomeEvento );
        CampoTexto.preencher( inputNomeEvento, valor );
    }

    public void preencherDescricaoEvento(String valor) throws Exception {
        Tempo.aguardar(tempo, inputDescricaoEvento );
        CampoTexto.preencher( inputDescricaoEvento, valor );
    }

    public void preencherDataEvento(String valor) throws Exception {
        Tempo.aguardar(tempo, inputDataEvento );
        CampoTexto.preencher( inputDataEvento, valor );
    }

    public void clicarCriarEvento() throws Exception {
        Tempo.aguardar(tempo, comandoCriarEvento );
        Comando.clicar( comandoCriarEvento);
    }

    public void clicarExcluirEvento() throws Exception {
        Tempo.aguardar(tempo, comandoExcluirEvento);
        Comando.clicar( comandoExcluirEvento );
        Tempo.aguardar(tempo, comandoConfirmaExcluirEvento);
        Comando.clicar( comandoConfirmaExcluirEvento );


    }

    public String recuperarMensagem() throws Exception {
        Tempo.aguardar(tempo, labelMensagem );
        return Label.recuperaTexto( labelMensagem);
    }

}
