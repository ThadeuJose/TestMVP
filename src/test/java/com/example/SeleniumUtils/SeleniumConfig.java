package com.example.SeleniumUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumConfig {

    private WebDriver driver;

    static {
        System.setProperty("webdriver.gecko.driver", findDriver());
    }

    public SeleniumConfig() {
        Capabilities capabilities = DesiredCapabilities.firefox();
        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private static String findDriver() {
        String path = "src/test/java/com/example/resources/geckodriver.exe";
        File resourcesDirectory = new File(path);
        if (resourcesDirectory.exists())
            return resourcesDirectory.getAbsolutePath();
        return "";
    }

    public WebDriver getDriver() {
        return driver;
    }

}