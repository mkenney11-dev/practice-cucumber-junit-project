package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WT_LoginPage {

    public WT_LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;


    /**
     * This method will login with below credentials
     * @username: Test
     * @password: Tester
     */
    public void login(){
        this.usernameInputBox.sendKeys("Test");
        this.passwordInputBox.sendKeys("Tester");
        this.loginButton.click();
    }

    /**
     * This method will log in with credentials that are provided in
     * the method at the time of calling it
     * @param user
     * @param pass
     */
    public void login(String user, String pass){
        this.usernameInputBox.sendKeys(user);
        this.passwordInputBox.sendKeys(pass);
        this.loginButton.click();
    }
}
