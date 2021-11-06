package com.example;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.example.SeleniumUtils.SeleniumConfig;
import com.example.SeleniumUtils.SeleniumElementUtils;
import com.example.SeleniumUtils.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {

    private SeleniumUtils seleniumUtils;
    private SeleniumElementUtils seleniumElementUtils;
    private final String URL = "https://example.cypress.io/";

    @BeforeClass
    public void setUp() {
        SeleniumConfig sc = new SeleniumConfig();
        seleniumUtils = new SeleniumUtils(sc);
        seleniumElementUtils = new SeleniumElementUtils(sc);
    }

    @AfterClass
    public void tearDown() {
        seleniumUtils.closeWindow();
    }

    @Test
    public void getTitle() {
        seleniumUtils.navigateTo(URL);

        String expectedTitle = "Cypress.io: Kitchen Sink";
        String actualTitle = seleniumUtils.getTitle();

        assertNotNull(actualTitle);
        assertEquals(expectedTitle, actualTitle);
    }

    @Test(testName = "Test a simple page")
    public void getText() {
        Reporter.log("Go to page https://example.cypress.io/");
        seleniumUtils.navigateTo(URL);

        String expectedTitle = "Cypress.io: Kitchen Sink";
        String actualTitle = seleniumUtils.getTitle();

        assertNotNull(actualTitle, "Cant go to page");
        assertEquals(expectedTitle, actualTitle, "Cant go to page");

        Reporter.log("Go to querying");

        String linkText = "Querying";
        WebElement querying = seleniumElementUtils.findElement(By.linkText(linkText));
        seleniumElementUtils.clickElement(querying);

        String expectedURL = "https://example.cypress.io/commands/querying";
        String actualURL = seleniumUtils.getCurrentUrl();
        assertEquals(expectedURL, actualURL);

        Reporter.log("Find test-example");
        WebElement element = seleniumElementUtils.findElementByDataTestId("test-example");
        assertNotNull(element);

        Reporter.log("Get test");
        String expectText = "Div with data-test-id";
        String actualText = element.getText();
        assertEquals(expectText, actualText);
    }

    @Test(testName = "Submit a Form", enabled = false)
    public void getForm() {

        // Click submit Get text

        Reporter.log("Go to page https://example.cypress.io/commands/actions");
        seleniumUtils.navigateTo(URL + "commands/actions");

        String expectedURL = "https://example.cypress.io/commands/actions";
        String actualURL = seleniumUtils.getCurrentUrl();
        assertEquals(expectedURL, actualURL, "Incorrect page");

        Reporter.log("Find input");

        String id = "couponCode1";
        WebElement input = seleniumElementUtils.findElement(By.id(id));

        String inputText = "Test";
        seleniumElementUtils.setInputText(input, inputText);
        assertEquals(seleniumElementUtils.getInputText(input), inputText);

        // Reporter.log("Find test-example");
        // WebElement element = utils.findElementByDataTestId("test-example");
        // assertNotNull(element);

        // Reporter.log("Get test");
        // String expectText = "Div with data-test-id";
        // String actualText = element.getText();
        // assertEquals(expectText, actualText);

    }

}
