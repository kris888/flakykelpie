package com.example.flakykelpie;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class LoginPage {
//    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
//    public SelenideElement toolsMenu = $x("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']");
    public SelenideElement loginButton = $x("//input[contains(@id,'login-button')]");
}
