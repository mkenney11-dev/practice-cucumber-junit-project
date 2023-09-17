package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTable_StepDefinition {

    DropdownsPage dropdownsPage = new DropdownsPage();

    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruitsAndVegetables) {

        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);

        System.out.println(fruitsAndVegetables.get(1));

    }

    @Then("I will share my favorites")
    public void i_will_share_my_favorites(List<String> petsILove) {
        System.out.println("petsILove = " + petsILove);

        System.out.println(petsILove.get(1));

    }

    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String, String> driverInfo) {

        System.out.println("driverInfo = " + driverInfo);
        System.out.println("driverInfo.get(\"name\") = " + driverInfo.get("name"));
        System.out.println("driverInfo.get(\"address\") = " + driverInfo.get("address"));
        System.out.println("driverInfo.size() = " + driverInfo.size());


    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        Select month = new Select(dropdownsPage.monthDropdown); // the month object will contain all of the options (AS WEBELEMENTS)from the drop down web element in the html
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions(); // this action takes those options and stores them in a List
                                                                        // now actualMonth_as_WEBELEMENT contains the months listed in the html
                                                                    // The 'expectedMonths' variable still contains the list of STRING months declared in our feature file
        List<String> actualMonth_as_STRING = new ArrayList<>();//So to do our final assertion we have to extract all strings from the list of WEBELEMENTS and compare it with the list of expectedMonths from feature files

        for (WebElement each : actualMonth_as_WEBELEMENT) { //iterates through the list of WEBELEMENTS
            actualMonth_as_STRING.add(each.getText()); //this takes our empty List of Strings, and adds teh text of each WEBELEMENT to it to compare with our feature file variable 'expectedMonths''

        }

        Assert.assertEquals(expectedMonths, actualMonth_as_STRING);

        /*
        CLEANER VERSION OF THE ABOVE METHOD USING BROWSER UTILS
        List<String> actualMonths = BrowserUtils.dropdown_options_as_STRING(dropdownsPage.monthDropdown);
        Assert.assertEquals(expectedMonths, actualMonths);
         */
    }



}
