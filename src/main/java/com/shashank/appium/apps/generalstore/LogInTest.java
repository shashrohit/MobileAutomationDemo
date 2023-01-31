package com.shashank.appium.apps.generalstore;

import com.shashank.appium.apps.generalstore.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test(dependsOnMethods = {"logInError"})
    public void logIn() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shashank");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
    }

    @Test
    public void logInError() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String errorMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(errorMessage, "Please enter your name");
        Thread.sleep(2000);
    }
}
