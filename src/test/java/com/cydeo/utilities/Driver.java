package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Creating a private constructor,so we are closing the access to the object of this class
    from outside the class
     */
    private Driver(){

    }
    /*
    making WebDriver private,we don't want to be accessed from outside the class
    making WebDriver static ,we will use it in static method
     */
   // private static WebDriver driver;
    /*
    create a re-usable utility method will return same driver instance when it is called.
     */
    private static InheritableThreadLocal<WebDriver>driverPool= new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if( driverPool.get()== null){
            /*
            We read our browser type from configuration.properties.
            This way,we can control which browser is opened from outside our code,
            from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set( new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;

                case "firefox":

                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set( new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;

            }
        }

        return driverPool.get();
    }

    /*
    this method will make sure the driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); //terminate current driver
            driverPool.remove();  //and start with new driver with another test
        }

    }
}
