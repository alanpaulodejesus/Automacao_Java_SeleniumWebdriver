package Test;

import Core.Property;
import Core.PropertyDatas;
import Pages.filterPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Core.DriverFactory.getDriver;
import static Utils.RelatorioExtentReport.closeRelatorio;
import static Utils.RelatorioExtentReport.startRelatorio;


public class filterTest {

    //Faker datas = new Faker();
    filterPage fillForm = new filterPage();

    public filterTest() throws Exception {
    }



    @Before
    public void setUp() throws Exception {
        getDriver().get( Property.URL);
        startRelatorio();
    }


    @Test
    public void fillForm() throws Exception {

        fillForm.inserirPesquisa(PropertyDatas.dataInformation);
        fillForm.acionarComandoPesquisa();

    }

    @After
    public void tearDown() throws Exception {

        Assert.assertTrue( fillForm.resultadoPesquisa() );
        closeRelatorio();

    }

}
