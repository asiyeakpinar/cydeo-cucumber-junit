package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTableStepDefinitions {


    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(3));


    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    DropdownsPage dropdownsPage= new DropdownsPage();
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        //   we create method in BrowserUtils
       /* Select select= new Select(dropdownsPage.monthDropdown);
            List<WebElement> actualOptionsAsWebElement= select.getOptions();

            List<String> actualOptionsAsString =new ArrayList<>();

            for (WebElement webElement : actualOptionsAsWebElement) {
                actualOptionsAsString.add(webElement.getText());

            }
      */

//        This method returns as a list of String
        List<String>actualOptionsAsString = BrowserUtilities.dropdownOptionsAsString(dropdownsPage.monthDropdown);

        Assert.assertEquals(expectedMonths,actualOptionsAsString);
  //Assert checks size of lists first and check all contents if they are matching





    }



}
