package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager extends Utils {
    //anything relate to browser to go here
    LoadProp loadProp = new LoadProp();
    String browser = "Chrome";

    public void openBrowser(){
        //open browser
        if(browser.equalsIgnoreCase("Chrome")){
            System.out.println("Your browser is Chrome");
            driver= new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.out.println("Your browser is Firefox");
            driver=new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.out.println("Your browser is Edge");
            driver= new EdgeDriver();
        }else {
            System.out.println("Your browser Name is Wrond"+browser);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open URL
        driver.get(loadProp.getProperty("Url"));
    }
    public void closeBrowser(){
        driver.quit();
    }





}
