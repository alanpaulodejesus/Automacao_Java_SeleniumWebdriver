package Pages;

import Core.Property;
import Core.PropertyDatas;
import DSL.CampoTexto;
import DSL.Comando;
import DSL.Combo;
import DSL.Label;
import Utils.RegistrarEvidencia;
import Utils.RelatórioStatus;
import Utils.Tempo;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.extent;

public class filterPage {


    @FindBy(id = "search_query_top") private WebElement inputSearch;
    @FindBy(name = "submit_search") private WebElement commandSearch;
    @FindBy(xpath = "//h1[contains(text(),'Search')]") private WebElement resultSearch;


    public static  ExtentTest test1=null;
    RelatórioStatus relatorio = new RelatórioStatus();

    public filterPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }


    public void inserirPesquisa(String valor) throws Exception {
        Tempo.aguardar(2, inputSearch );
        CampoTexto.preencher( inputSearch, valor );

    }

    public void acionarComandoPesquisa () throws Exception {
        Tempo.aguardar(15, commandSearch );
        Comando.clicar( commandSearch );

    }

    public boolean resultadoPesquisa () throws Exception {
        Tempo.aguardar(2, resultSearch );

        test1 = extent.createTest( "Realizar Pesquisa" );
        if(Label.textoPresente( resultSearch ))
        {
            relatorio.testStatusPass( test1,"Pesquisa valida.png" );
            return true;
        }else {
            relatorio.testStatusFail( test1,"Pesquisa invalida.png");
            return false;
        }
    }


    public void IRegistreMessage() throws Exception {
        RegistrarEvidencia.registrar(
                System.getProperty("user.dir") + File.separator + "web" + File.separator +
                        "src" + File.separator + "test" +  File.separator + "java" +File.separator +
                        "Arquivo" + File.separator +"Pesquisa valida.png" );
    }

}
