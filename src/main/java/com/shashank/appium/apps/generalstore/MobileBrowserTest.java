package com.shashank.appium.apps.generalstore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseTest{

    @Test
    public void test() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler-icon")).click();
        driver.findElement(By.xpath("//a[contains(href, 'products']")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 100);", "");
        Thread.sleep(5000);
    }
}
