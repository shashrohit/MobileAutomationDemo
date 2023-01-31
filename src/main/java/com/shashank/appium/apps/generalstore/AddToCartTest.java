package com.shashank.appium.apps.generalstore;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCart() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shashank");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);

        String addToCartXPath;
        scrollIntoView("Converse All Star");
        Thread.sleep(2000);
        addToCartXPath = "//android.widget.TextView[@text='Converse All Star']/../android.widget.LinearLayout/android.widget.TextView[@text='ADD TO CART']";
        driver.findElement(By.xpath(addToCartXPath)).click();

        scrollIntoView("Air Jordan 9 Retro");
        Thread.sleep(2000);
        addToCartXPath = "//android.widget.TextView[@text='Air Jordan 9 Retro']/../android.widget.LinearLayout/android.widget.TextView[@text='ADD TO CART']";
        driver.findElement(By.xpath(addToCartXPath)).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        WebElement cart = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        wait.until(ExpectedConditions.attributeContains(cart, "text", "Cart"));

        List<WebElement> prices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        double totalPrice = 0;
        for(WebElement price: prices){
            String cost = price.getText();
            totalPrice += Double.parseDouble(cost.substring(1));
        }
        System.out.println("Expected Total Price = "+ totalPrice);

        String actualCost = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double actualTotal = Double.parseDouble(actualCost.substring(1));
        System.out.println("Actual Total Cost = "+ actualTotal);
        Assert.assertEquals(totalPrice, actualTotal);

        longPress(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(5000);

        Set<String> contexts = driver.getContextHandles();
        for(String context: contexts){
            System.out.println(context);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Shashank is awesome");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }
}
