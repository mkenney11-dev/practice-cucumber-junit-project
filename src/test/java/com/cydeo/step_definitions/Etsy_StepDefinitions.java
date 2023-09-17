package com.cydeo.step_definitions;

import com.cydeo.pages.EtsySearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_StepDefinitions {


    EtsySearchPage etsySearchPage = new EtsySearchPage();


    @Given("user is on the Etsy home page")
    public void user_is_on_the_etsy_home_page() {

        Driver.getDriver().get("https://www.etsy.com");

    }
    @Then("user should see title is as expected")
    public void user_should_see_title_is_as_expected() {

        BrowserUtils.verifyTitle("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
    }

    @When("user types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        etsySearchPage.searchBox.sendKeys("Wooden Spoon");

    }
    @When("user clicks Etsy search button")
    public void user_clicks_etsy_search_button() {
    etsySearchPage.searchButton.click();

    }
    @Then("user sees Wooden Spoon in the title")
    public void user_sees_wooden_spoon_in_the_title() {
    BrowserUtils.verifyTitleContains("Wooden spoon");
    }

    @When("user types {string} in the search box")
    public void userTypesInTheSearchBox(String keyword) {
        etsySearchPage.searchBox.sendKeys(keyword);
    }

    @Then("user sees {string} in the title")
    public void userSeesInTheTitle(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }
}
