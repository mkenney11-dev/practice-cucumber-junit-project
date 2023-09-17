package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to create pre and post conditions for all teh scenarios and even STEPS
 */


public class Hooks {

    //import the @Before coming from io.cucumber.java
    @Before
    public void setupMethod(){
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @After
    public void tearDownMethod(Scenario scenario) {
        // the parameter above is an object coming from cucumber library
        // It keeps track of the scenario that is currently being executed

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
            System.out.println("---> @After: RUNNING AFTER EACH SCENARIO");
            Driver.closeDriver();

    }

  //  @BeforeStep
    public void setupStep(){
        System.out.println("-----> @BeforeSTEP: RUNNING BEFORE EACH STEP");
    }

  //  @AfterStep
    public void tearDownStep(){
        System.out.println("-----> @BeforeSTEP: RUNNING AFTER EACH STEP");
    }

}
