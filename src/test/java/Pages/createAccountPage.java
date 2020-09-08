package Pages;

import DSL.CampoTexto;
import DSL.Comando;
import DSL.Label;
import Utils.RelatórioStatus;
import Utils.Tempo;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.extent;

public class createAccountPage {


    @FindBy(linkText = "Sign in") private WebElement commandSignin;
    @FindBy(id = "email_create") private WebElement inputCreateEmailAdrees;
    @FindBy(id = "SubmitCreate") private WebElement commandCreateAccount;
    @FindBy(id="customer_firstname") private  WebElement inputFirstName;
    @FindBy(id="customer_lastname") private  WebElement inputLastName;
    @FindBy(id="company") private  WebElement inputCompany;
    @FindBy(id="submitAccount") private  WebElement commandRegister;
    @FindBy(xpath = "//div/p[contains(text(),'errors')]") private WebElement messageCreateInvalid;

    public static  ExtentTest test1=null;

    RelatórioStatus relatorio = new RelatórioStatus();

    public createAccountPage() throws Exception {
        PageFactory.initElements(getDriver(), this);
    }


    public void clickCommandSignin() throws Exception {
        Tempo.aguardar(2, commandSignin );
        Comando.clicar( commandSignin );

    }

    public void fillInputCreateEmailAdrees (String valor) throws Exception {
        Tempo.aguardar(2, inputCreateEmailAdrees );
        CampoTexto.preencher( inputCreateEmailAdrees, valor );
    }

    public void clickCommandCreateAccount() throws Exception {
        Tempo.aguardar(2, commandCreateAccount );
        Comando.clicar( commandCreateAccount );
    }

    public void fillInputFirstName(String valor) throws Exception {
        Tempo.aguardar(2, inputFirstName );
        CampoTexto.preencher( inputFirstName, valor );
    }

    public void fillInputLastName(String valor) throws Exception {
        Tempo.aguardar(2, inputLastName );
        CampoTexto.preencher( inputLastName, valor );
    }

    public void fillInputCompany(String valor) throws Exception {
        Tempo.aguardar(2, inputCompany );
        CampoTexto.preencher( inputCompany, valor );
    }

    public void clickCommandRegister() throws Exception {
        Tempo.aguardar(2, commandRegister );
        Comando.clicar( commandRegister );
    }


    public boolean validCreateAccountInvalid() throws Exception {
        Tempo.aguardar(2, messageCreateInvalid );

        test1 = extent.createTest( "Create Account Invalid" );
        if(Label.elementoPresente( messageCreateInvalid ))
        {
            relatorio.testStatusPass( test1,"Create Invalid.png" );
            return true;
        }else {
            relatorio.testStatusFail( test1,"Create Invalid Fail.png");
            return false;
        }
    }


}
