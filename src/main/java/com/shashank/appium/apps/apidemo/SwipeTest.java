package com.shashank.appium.apps.apidemo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test
    public void scrollTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();

        WebElement firstPic = driver.findElements(By.xpath("//android.widget.ImageView")).get(0);
        Assert.assertEquals(firstPic.getAttribute("focusable"), "true");

        swipe(firstPic, "left");

        Assert.assertEquals(firstPic.getAttribute("focusable"), "false");
    }
}
