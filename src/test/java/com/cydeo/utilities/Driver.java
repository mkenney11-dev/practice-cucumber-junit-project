package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object
    private Driver(){
    }
    /*
    We made the webdriver private because we want to close
    access to it from outside of the class
    We are making it static because we will use it in a static method

     */
    //private static WebDriver driver; // default value = null

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    /*
    Create a re-usable method which will return the same driver instance
     once we call it
     - If an instance doesn't exist, it will create first and then it will always return the same instance

     */
    public static WebDriver getDriver(){

        if(driverPool.get() == null){
// we will read our browser type from configuration properties file, this way we can control which browser is opened from outside of our code
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser
             */
            switch(browserType){
                case "chrome":
                   // WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                   // WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().quit();
            // this line will terminate currently existing driver
            //rather than leaving the driver non-existent, we reassign it back to null to be able to reassign and reuse it
            driverPool.remove();
        }

    }

}
