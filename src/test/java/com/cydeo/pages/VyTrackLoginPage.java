package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

    public VyTrackLoginPage() {
      PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "prependedInput")
  public   WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public   WebElement passwordInput;

    @FindBy(id = "_submit")
    public   WebElement clickButton;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public   WebElement warningMessage;
}
