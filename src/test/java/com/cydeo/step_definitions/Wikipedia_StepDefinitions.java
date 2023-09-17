package com.cydeo.step_definitions;

import com.cydeo.pages.WikiResultPage;
import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Wikipedia_StepDefinitions {

    WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();

    @Given("user is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");

    }
    @When("user enters Elvis Presley in the wiki search box")
    public void user_enters_steve_jobs_in_the_wiki_search_box() {
        wikipediaSearchPage.searchBox.sendKeys("Elvis Presley");
    }
    @Then("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaSearchPage.searchButton.click();

    }

    @When("user enters {string} in the wiki search box")
    public void userEntersInTheWikiSearchBox(String arg0) {

        wikipediaSearchPage.searchBox.sendKeys("Elvis Presley");
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedTitle) {

        BrowserUtils.verifyTitleContains(expectedTitle);
    }

    WikiResultPage wikiResultPage = new WikiResultPage();
    @Then("user should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String expectedHeaderText) {
        String actualHeaderText = wikiResultPage.mainHeader.getText();
        Assert.assertEquals(actualHeaderText, expectedHeaderText);

    }

    @Then("user should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String expectedText) {

        Assert.assertEquals(wikiResultPage.imageHeader.getText(), expectedText);

    }
}
