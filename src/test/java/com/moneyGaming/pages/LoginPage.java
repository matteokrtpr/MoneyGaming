package com.moneyGaming.pages;

import com.moneyGaming.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    @FindBy (id="title")
    public WebElement title;

    @FindBy (xpath = "//a[@class='newUser green']")
    public WebElement joinNowForSignUp;

    @FindBy(id="forename")
    public WebElement firstName;

    @FindBy(xpath ="//input[@name='map(lastName)']")
    public WebElement lastName;

    @FindBy(id="checkbox")
    public WebElement checkBox;

    @FindBy(id="form")
    public WebElement joinNow;

    @FindBy(xpath="//label[@for='dob']")
    public WebElement message;




    public LoginPage(){
        PageFactory.initElements(driver,this);
    }






}
