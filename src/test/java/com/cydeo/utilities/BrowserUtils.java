package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    /*
 This method will accept integer int (seconds) and execute Thread.sleep method for given duration
 Arg: int seconds
  */
    public static void sleep(int second){
        second +=1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){

        }
    }

    /*
    This method will accept driver, string - expected in URL, and string - expected in title and will execute the switch
    and verification of the title name in the specified window
     */
    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));


    }

    /*
    This method will accept string expected title and will verify the title equals expected title
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }
    /*
    This method will accept a string - expectedInTitle and will verify that the title contains the given string
     */
    public static void verifyTitleContains(String expectedInTitle){

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));

    }

    /*
    This method accepts a web element - target, and waits for that element to not be displayed on the page
     */
    public static void waitForInvisibilityOfGiveElement(WebElement target){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title, and waits for the Title to contain given string value
     */
    public static void waitForTitleContains(String title){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method accepts a dropdown element and returns a List<String> that contains all option values as String.
     * @param dropdownElement
     * @return actualMonth_as_STRING
     */

    public static List<String> dropdown_options_as_STRING(WebElement dropdownElement) {

        Select month = new Select(dropdownElement);
        //Storing all the options into a List<WebElements>
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        //Creating an empty List<String> to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //Looping through the List<WebElement> getting all options' text and storing them into List<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {
            actualMonth_as_STRING.add(each.getText());
        }

        return actualMonth_as_STRING;
    }

    public static void verifyURLContains(String expectedInURL){
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedInURL));

    }


    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {                  // this for each loop is iterating through each of the radio button elements we found earlier and stored in a list
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){ // this is checking the attribute value of each iteration, find the one that matches the example we provide from the feature file and click it
                each.click();
            }
        }
    }








}

