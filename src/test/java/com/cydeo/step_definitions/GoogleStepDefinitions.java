package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import javax.swing.*;

public class GoogleStepDefinitions {
    GoogleSearchPage googleSearchPage=new GoogleSearchPage();

    @When("user writes apple and click enter")
    public void user_writes_and_click_enter2() {
        googleSearchPage.searchBox.sendKeys("apple"+Keys.ENTER);

    }

    @When("user writes {string} and click enter")
    public void user_writes_and_click_enter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword+Keys.ENTER);

    }
    @Then("user sees {string} in Google title")
    public void user_sees_in_google_title(String string) {
        String expectedTitle = string+" - Google Search";
        String actualTitle=Driver.getDriver().getTitle();

        //junit assertion accepts first as expected opposite of testNg
        Assert.assertEquals("Title is not as expected!",expectedTitle,actualTitle);


    }


    @Then("user sees apple in Google title")
    public void user_sees_apple_in_google_title() {

        String expectedTitle="apple"+ " - Google Search";
        String actualTitle=Driver.getDriver().getTitle();

        //junit assertion accepts first as expected opposite of testNg
        Assert.assertEquals("Title is not as expected!",expectedTitle,actualTitle);

    }


    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
        googleSearchPage.acceptButton.click();
    }
    @Then("user should see title Google")
    public void user_should_see_title_google() {
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();

    }



}
