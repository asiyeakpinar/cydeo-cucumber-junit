package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTable_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on the login page of the web table app")
    public void user_is_on_the_library_login_page_of_the_web_table_app() {

        String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);

    }

    @When("user enters username {string}")
    public void userEntersUsername(String string) {
        webTableLoginPage.inputUsername.sendKeys(string);

    }

    @And("user enters password {string}")
    public void userEntersPassword(String string) {
        webTableLoginPage.inputPassword.sendKeys(string);
    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();

    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtilities.verifyUrlContains("orders");

    }

    @When("user enters username {string}  password {string} and login")
    public void user_enters_username_password_and_login(String username, String pasword) {
     webTableLoginPage.inputUsername.sendKeys(username);
     webTableLoginPage.inputPassword.sendKeys(pasword);
     webTableLoginPage.loginButton.click();

    }


    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String>credentials) {

      // webTableLoginPage.inputUsername.sendKeys(credentials.get("username"));
      // webTableLoginPage.inputPassword.sendKeys(credentials.get("password"));
       //webTableLoginPage.loginButton.click();

        //we can call login util method and pass value from map
       webTableLoginPage.login(credentials.get("username"),credentials.get("password"));

    }

}