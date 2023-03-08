package com.cydeo.step_definitions;

import com.cydeo.pages.VyDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class VyTrackLoginTest {

      VyTrackLoginPage vyTrackLoginPage= new VyTrackLoginPage();
      VyDashboardPage vyDashboardPage=new VyDashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
    }
    @When("user enters {string} and {string} as credentials")
    public void user_enters_and_as_credentials(String string, String string2) {
        vyTrackLoginPage.usernameInput.sendKeys(string);
        vyTrackLoginPage.passwordInput.sendKeys(string2);
        vyTrackLoginPage.clickButton.click();
    }
    @Then("user is on the dashboard page")
    public void user_is_on_the_dashboard_page() {
     String actualHeader=vyDashboardPage.dashboardHeader.getText();
     String expectedHeader="Fleet Management";
        Assert.assertEquals(expectedHeader,actualHeader);



    }

    @Then("user gets warning message")
    public void userGetsWarningMessage() {
        System.out.println("vyTrackLoginPage.warningMessage.getText() = "
                + vyTrackLoginPage.warningMessage.getText());
        vyTrackLoginPage.warningMessage.isDisplayed();

    }
}
