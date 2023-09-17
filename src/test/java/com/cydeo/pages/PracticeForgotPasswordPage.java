package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeForgotPasswordPage {

    public PracticeForgotPasswordPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement inputBox;

    @FindBy(id = "form_submit")
    public WebElement retrieveButton;

    @FindBy(xpath = "//h4[@name='confirmation_message']")
    public WebElement confirmationMessage;
}
