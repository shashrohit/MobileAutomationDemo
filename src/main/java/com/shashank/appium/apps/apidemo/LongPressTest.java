package com.shashank.appium.apps.apidemo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressTest extends BaseTest {

    @Test
    public void longPressTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        logPress(ele);

        String expectedText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(expectedText, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
    }
}
