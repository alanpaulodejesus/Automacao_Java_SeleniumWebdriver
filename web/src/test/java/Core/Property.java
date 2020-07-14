package Core;

import java.io.File;

public class Property {

    public static final String URL = "http://automationpractice.com/index.php";

    public static final String htmlRelatorio = System.getProperty( "user.dir" )+ File.separator + "web"  + File.separator +
            "src" + File.separator + "test" + File.separator + "resources" + File.separator + "relatorio.html";

    public static final Browsers browser = Browsers.CHROME;


    public  static enum Browsers {
        CHROME,
        FIREFOX

    }


}
