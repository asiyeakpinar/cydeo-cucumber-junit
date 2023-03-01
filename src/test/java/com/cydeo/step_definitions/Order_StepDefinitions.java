package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage= new WebTableLoginPage();
    BasePage basePage= new BasePage();

    OrderPage orderPage=new OrderPage();

    ViewAllOrdersPage viewAllOrdersPage= new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {

        //to go login page using configuration properties url value
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));

        //calling our login method in "webTableLoginPage"
       webTableLoginPage.login();
//       clicking on order link to go to order page
        basePage.order.click();


    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select= new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);

    }
   // @When("user enters quantity {string}")
   // public void user_enters_quantity(String string){}

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {
        //accepts integer argument and send key with sendKeys() method
// since sendKeys() accepts only string therefore concat+""
//        or send String.valueOf(int)
     //  orderPage.inputQuantity.sendKeys(arg0+"");
        //clear() method will delete whatever is in the input box
       // orderPage.inputQuantity.click(); //if this doesn't work

        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        //BACK_SPACE to clear you can use as much as want with ,
        orderPage.inputQuantity.sendKeys(String.valueOf(arg0));

    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
    orderPage.inputName.sendKeys(string);

    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
    orderPage.inputStreet.sendKeys(string);

    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
    orderPage.inputCity.sendKeys(string);

    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
    orderPage.inputState.sendKeys(string);

    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
   orderPage.inputZip.sendKeys(string);

    }
    /*
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {

    List<WebElement> cardTypes= orderPage.cardType;
        for (WebElement each : cardTypes) {
            if(each.getAttribute("value").equalsIgnoreCase(expectedCardType));
            each.click();

        }
    }
    */
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
//        to use ready utility method

        BrowserUtilities.clickRadioButton(orderPage.cardType,expectedCardType);

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
     orderPage.inputCard.sendKeys(string);

    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.inputCardExp.sendKeys(string);


    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {

    orderPage.buttonProcessOrder.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        System.out.println("viewAllOrdersPage.newCustomerCell.getText() = " + viewAllOrdersPage.newCustomerCell.getText());

        String actualName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedName,actualName);
    }


}
