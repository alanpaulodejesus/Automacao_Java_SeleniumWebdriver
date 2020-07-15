package Test;

import Core.Property;
import Pages.createAccountPage;
import Utils.GeneretorDatas;
import org.junit.*;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;


public class createAccountTest {

    createAccountPage createAccountInvalid = new createAccountPage();

    public createAccountTest() throws Exception {
    }



    @Before
    public void setUp() throws Exception {
        getDriver().get( Property.URL);
        startRelatorio();
    }


    @Test
    public void createAccountInvalid() throws Exception {

        createAccountInvalid.clickCommandSignin();
        createAccountInvalid.fillInputCreateEmailAdrees( GeneretorDatas.email);
        createAccountInvalid.clickCommandCreateAccount();
        createAccountInvalid.fillInputFirstName(GeneretorDatas.firstName );
        createAccountInvalid.fillInputLastName(GeneretorDatas.lastName);
        createAccountInvalid.fillInputCompany(GeneretorDatas.company);
        createAccountInvalid.clickCommandRegister();
    }

    @After
    public void tearDown() throws Exception {

        Assert.assertTrue( createAccountInvalid.validCreateAccountInvalid() );


    }

    @AfterClass
    public static void finishTearDown()throws Exception {
        closeRelatorio();
    }

}


