package com.example.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumElementUtils {

    private WebDriver driver;

    public SeleniumElementUtils(SeleniumConfig config) {
        driver = config.getDriver();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void setInputText(WebElement element, String input) {
        element.sendKeys(input);
    }

    public String getInputText(WebElement element) {
        return element.getAttribute("value");
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement findElementByDataTestId(String testId) {
        String xpathExpression = String.format("//*[@data-test-id=\"%s\"]", testId);
        return driver.findElement(By.xpath(xpathExpression));
    }

}
