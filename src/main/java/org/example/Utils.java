package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage {
    // reusable methods go here
    LoadProp loadProp = new LoadProp();
    // Store Email
    static String email = "seema" + randomDate() + "@gmail.com";

    //Store password
    static String password = "Abc@123";

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static String randomDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void selectTextByVisibleText(By by, String text) {
        //select date of birth
        Select dateofbirth = new Select(driver.findElement(by));
        dateofbirth.selectByVisibleText(text);
        //Select month of birth
        Select dateofbirthMonth = new Select(driver.findElement(by));
        dateofbirthMonth.selectByVisibleText(text);
        //Select Year of birth
        Select dateofbirthYear = new Select(driver.findElement(by));
        dateofbirthYear.selectByVisibleText(text);
    }

    public static void selectTextByValue(By by, String text) {
        //select date of birth
        Select dateofbirth = new Select(driver.findElement(by));
        dateofbirth.selectByValue(text);
        //Select month of birth
        Select dateofbirthMonth = new Select(driver.findElement(by));
        dateofbirthMonth.selectByValue(text);
        //Select Year of birth
        Select dateofbirthYear = new Select(driver.findElement(by));
        dateofbirthYear.selectByValue(text);
    }

    public static void selectTextByIndex(By by, int i) {
        //select date of birth
        Select dateofbirth = new Select(driver.findElement(by));
        dateofbirth.selectByIndex(i);
        //Select month of birth
        Select dateofbirthMonth = new Select(driver.findElement(by));
        dateofbirthMonth.selectByIndex(i);
        //Select Year of birth
        Select dateofbirthYear = new Select(driver.findElement(by));
        dateofbirthYear.selectByIndex(i);
    }

    public static void takeScreenShot(String text) {
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        //Copy File at destination
        try {
            FileUtils.copyFile(SrcFile, new File("src\\ScreenShots\\" + text + randomDate() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void waitForElementToBeVisible(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    static String capturingTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public static void acceptingAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static void searchByBrandName(){;
    }
}
