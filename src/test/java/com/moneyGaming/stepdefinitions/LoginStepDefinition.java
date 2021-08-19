package com.moneyGaming.stepdefinitions;

import com.moneyGaming.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {

    @Given("navigate to MoneyGaming login page")
    public void navigate_to_MoneyGaming_login_page() {
       setUp();

    }

    @When("click the first join now on login page")
    public void click_the_first_join_now_on_login_page() {
        click(loginPage.joinNowForSignUp);
    }

    @When("select a title")
    public void select_a_title() {
        selectDropdownValue(loginPage.title, "Mr");
    }

    @When("enter your first name and last name")
    public void enter_your_first_name_and_last_name() {
        sendText(loginPage.firstName, "Matteo");
        sendText(loginPage.lastName, "Karteper");
    }

    @When("check the the tickbox")
    public void check_the_the_tickbox() {
        click(loginPage.checkBox);
    }

    @When("submit the form by clicking JOINNOW button")
    public void submit_the_form_by_clicking_JOINNOW_button() {
        jsClick(loginPage.joinNow);
    }

    @Then("validate the message with text")
    public void validate_the_message_with_text() {
        Assert.assertTrue(loginPage.message.isDisplayed());
    }









}
