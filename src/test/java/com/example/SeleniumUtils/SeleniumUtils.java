package com.example.SeleniumUtils;

import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    private WebDriver driver;

    public SeleniumUtils(SeleniumConfig config) {
        driver = config.getDriver();
    }

    public void closeWindow() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
