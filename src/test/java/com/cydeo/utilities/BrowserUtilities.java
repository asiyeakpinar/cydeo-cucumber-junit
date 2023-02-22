package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtilities {

    //This method will accept int(in seconds) and execute Thread.sleep for given duration
    public static void sleep(int second)  {
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver,String expectedInUrl, String expectedPartInTitle){
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println(driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        //5. Assert: Title contains “expectedPartInTitle”
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedPartInTitle));

    }
    //This method accepts a string "expectedTitle" and Asserts if it is true
    public static void verifyTitle(WebDriver driver,String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    //creating a utility method for explicitWait,no  need to repeat the code all again
    public static void waitForInvisibilityOf(WebElement webElement){
        //we add this cancellation driver's implicitly wait just for avoid mix waiting time on compiler
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }

}
