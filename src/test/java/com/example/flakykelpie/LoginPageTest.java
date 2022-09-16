package com.example.flakykelpie;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest {
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.saucedemo.com/");
    }

    @Test
    public void login() {
        loginPage.loginButton.click();

//        $("[data-test='search-input']").sendKeys("Selenium");
//        $("button[data-test='full-search-button']").click();
        $x("//input[contains(@id,'login-button')]");
        ;
    }

//    @Test
//    public void toolsMenu() {
//        loginPage.toolsMenu.click();
//
//        $("div[data-test='main-submenu']").shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        loginPage.seeAllToolsButton.click();
//
//        $("#products-page").shouldBe(visible);
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
//    }
}
