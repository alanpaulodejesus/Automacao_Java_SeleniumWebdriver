package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class DriverFactory {

    private static WebDriver driver;

    protected DriverFactory() {}

    public static synchronized WebDriver getDriver() throws Exception {

        if (driver == null) {

                if (Property.browser.name().equals( "FIREFOX" )) {
                    WebDriverManager.firefoxdriver().setup();

                    FirefoxOptions options = new FirefoxOptions();
                    options.setHeadless(true);
                    options.addArguments("--width=1920");
                    options.addArguments("--height=1080");
                    options.addPreference("dom.webnotifications.enabled", false);
                    options.addPreference("media.volume_scale", "0.0");

                    driver = new FirefoxDriver(options);
                } else {
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    driver = new ChromeDriver(options);
                    WebDriverManager.chromedriver().avoidResolutionCache().setup();

                }

        }
            driver.manage().window().maximize();
            return driver;

        }
}
