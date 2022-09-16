package com.example.flakykelpie;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public SelenideElement loginButton = $x("//input[contains(@id,'login-button')]");
    public SelenideElement errorMessage = $x("//h3[contains(.,'Epic sadface: Username is required')]");

    public SelenideElement userName = $x("//input[contains(@id,'user-name')]");
    public SelenideElement password = $x("//input[@id='password']");
    public SelenideElement logoLogin = $(".login_logo");
    public SelenideElement botLogin = $x("//div[@class='bot_column']");
    public SelenideElement currentPageStyle = $("#page_wrapper");

}
