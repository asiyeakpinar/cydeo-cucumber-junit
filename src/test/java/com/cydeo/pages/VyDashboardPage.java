package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyDashboardPage {

    public VyDashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Fleet Management")
    public WebElement dashboardHeader;


}
