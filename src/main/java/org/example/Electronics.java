package org.example;

import org.openqa.selenium.By;

public class Electronics extends Utils {
    private By _CameraAndPhoto=By.linkText("Camera & photo");
    public void clickOnCameraAndPhoto ()
    {
        //Click on Camera & photo option
        clickOnElement(_CameraAndPhoto);
    }
}
