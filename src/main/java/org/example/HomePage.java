package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class HomePage extends Utils {
    LoadProp loadProp = new LoadProp();
    private By _SearchButton = By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/button");
    private By _voteButton =By.id("vote-poll-1");
    private By _faceBookIcon = By.linkText("Facebook");
    private By _welcomeMsg = By.xpath("//div[@class='topic-block-title']/h2");
    private By _detailsButton = By.xpath("//div[@class='news-items']/div[2]/div[3]/a");
    private By _searchBox = By.id("small-searchterms");
    private By _currency =By.id("customerCurrency");
    private By _currencySymbol = By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='prices']");
    private By _electronicsbutton = By.linkText("Electronics");
    public void clickOnSearchButton() {
        //Click On Search Button
        clickOnElement(_SearchButton);
    }

    public void verifyAlertMsg() {
        // Capturing the Alert Msg
        String actualAlertMsg = capturingTextFromAlert();
        // Accept The Alert
        acceptingAlert();
        // Verifying Alert Msg
        Assert.assertEquals(loadProp.getProperty("ExpectedSearchAlertMsg"), actualAlertMsg, "Search box should not empty ");

    }

    public void clickOnVoteButton() {
        //Click On Vote Button
        clickOnElement(_voteButton);
    }

    public void verifyingVoteAlertMsg() {
        // Capturing the Alert Msg
        Alert alert = driver.switchTo().alert();
        String actualVoteAlertMsg = alert.getText();
        // Accept The Alert
        acceptingAlert();
        // Verifying Alert Msg
        Assert.assertEquals(actualVoteAlertMsg, loadProp.getProperty("ExpVoteMsg"), "Please select any one Option");
    }

    public void clickOnFaceBookIcon() {
        //Click On FaceBook Icon
        clickOnElement(_faceBookIcon);
    }

    public void verifyWelcomeMsg() {

        Assert.assertEquals(getTextFromElement(_welcomeMsg), loadProp.getProperty("ExpWelcomeMsg"), "Welcome Back to Store");
    }

    public void clickOnDetailsButton() {
        clickOnElement(_detailsButton);
    }

    public void searchProductByBrandName() {
        typeText(_searchBox, loadProp.getProperty("BrandName"));
    }

    public void selectEuroCurrency() {
        selectTextByVisibleText(_currency, "Euro");
        //Store product
        List<WebElement> productContainEuroCurrencySymbol = driver.findElements(_currencySymbol);

        for (WebElement webelement : productContainEuroCurrencySymbol) {
            Assert.assertNotNull(webelement.getText(), "One Of Product Does Not Contain Currency Symbol");

        }

    }
    public void selectUSDollarCurrency(){
        selectTextByVisibleText(_currency, "US Dollar");
        //Store product
        List<WebElement> productContainUSDollarCurrencySymbol = driver.findElements(_currencySymbol);

        for (WebElement webelement : productContainUSDollarCurrencySymbol) {
            Assert.assertNotNull(webelement.getText(), "One Of Product Does Not Contain Currency Symbol");

        }
    }
    public void clickOnElectronics(){
        //Click on Electronics option from top bar
        clickOnElement(_electronicsbutton);

    }
}

