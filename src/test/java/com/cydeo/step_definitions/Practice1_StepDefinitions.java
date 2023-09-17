package com.cydeo.step_definitions;

import com.cydeo.pages.PracticeForgotPasswordPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Practice1_StepDefinitions {

    PracticeForgotPasswordPage practiceForgotPasswordPage = new PracticeForgotPasswordPage();



    @When("user is on the forgot password page")
    public void user_is_on_the_forgot_password_page() {
        Driver.getDriver().get("https://practice.cydeo.com/forgot_password");
   }
    @Then("user should see the title is Forgot Password")
    public void user_should_see_the_title_is_forgot_password() {
         String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("user has entered their email into the blank field")
    public void user_has_entered_their_email_into_the_blank_field() {
        practiceForgotPasswordPage.inputBox.sendKeys("abc123@gmail.com");
    }
    @Then("user clicks the Retrieve Password button")
    public void user_clicks_the_retrieve_password_button() {
        practiceForgotPasswordPage.retrieveButton.click();

    }
    @Then("user should see new title Your e-mail's been sent!")
    public void user_should_see_new_title_your_e_mail_s_been_sent() {
       Assert.assertTrue(practiceForgotPasswordPage.confirmationMessage.isDisplayed());

    }


}
