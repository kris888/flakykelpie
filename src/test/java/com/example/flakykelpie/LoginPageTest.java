package com.example.flakykelpie;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
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
    public void loginPageDesign() {
        loginPage.logoLogin.shouldBe(visible);
        loginPage.botLogin.shouldBe(visible);
        loginPage.loginButton.shouldBe(visible);
    }
    @Test
    public void errorMessageEmptyCredentials() {
        loginPage.errorMessage.getClass();
        loginPage.loginButton.click();
        $x("//input[contains(@id,'login-button')]").click();
        assertTimeout(Duration.ofMillis(30000), ()->{} );
        $x("//h3[contains(.,'Epic sadface: Username is required')]").shouldBe(visible);
    }

  @Test
   public void loginAccepted() {
        loginPage.userName.click();
        loginPage.password.click();
      $x("//input[contains(@id,'user-name')]").shouldBe(visible);
      $x("//input[@id='password']").shouldBe(visible);

      $x("//input[contains(@id,'user-name')]").sendKeys("standard_user");
      $x("//input[@id='password']").sendKeys("secret_sauce");
      loginPage.loginButton.click();
      assertTimeout(Duration.ofMillis(30000), ()->{} );
      loginPage.currentPageStyle.shouldBe(visible);
 }
 @Test
         public void loginLockedOutUser()
 {
     loginPage.userName.click();
     loginPage.password.click();
     $x("//input[contains(@id,'user-name')]").shouldBe(visible);
     $x("//input[@id='password']").shouldBe(visible);
     $x("//input[contains(@id,'user-name')]").sendKeys("locked_out_user");
     $x("//input[@id='password']").sendKeys("secret_sauce");
     loginPage.loginButton.click();
     assertTimeout(Duration.ofMillis(30000), ()->{} );
     $x("//h3[@data-test='error'][contains(.,'Epic sadface: Sorry, this user has been locked out.')]").shouldBe(visible);
 }
    @Test
    public void problemUser()
    {
        loginPage.userName.click();
        loginPage.password.click();
        $x("//input[contains(@id,'user-name')]").shouldBe(visible);
        $x("//input[@id='password']").shouldBe(visible);
        $x("//input[contains(@id,'user-name')]").sendKeys("problem_user");
        $x("//input[@id='password']").sendKeys("secret_sauce");
        loginPage.loginButton.click();
        assertTimeout(Duration.ofMillis(30000), ()->{} );
        $("#item_0_img_link > img:nth-child(1)").shouldBe(visible);
        $x("(//img[@src='/static/media/sl-404.168b1cce.jpg'])[1]").shouldBe(visible);
    }
    @Test
    public void performanceGlitchUser() {
        loginPage.userName.click();
        loginPage.password.click();
        $x("//input[contains(@id,'user-name')]").shouldBe(visible);
        $x("//input[@id='password']").shouldBe(visible);
        $x("//input[contains(@id,'user-name')]").sendKeys("performance_glitch_user");
        $x("//input[@id='password']").sendKeys("secret_sauce");
        loginPage.loginButton.click();
        assertTimeout(Duration.ofMillis(1000000), () -> {
        });
        loginPage.currentPageStyle.shouldBe(visible);
    }
    @Test
    public void performanceGlitchUserLogout()
    {
        loginPage.userName.click();
        loginPage.password.click();
        $x("//input[contains(@id,'user-name')]").shouldBe(visible);
        $x("//input[@id='password']").shouldBe(visible);
        $x("//input[contains(@id,'user-name')]").sendKeys("performance_glitch_user");
        $x("//input[@id='password']").sendKeys("secret_sauce");
        loginPage.loginButton.click();
        assertTimeout(Duration.ofMillis(1000000), () -> {});
        $x("//button[contains(.,'Open Menu')]").shouldBe(visible).click();
       // $x("//button[contains(.,'Open Menu')]").click();
       loginPage.logoutButton.click();
        assertTimeout(Duration.ofMillis(1000000), ()->{} );
        loginPage.logoLogin.shouldBe(visible);
        loginPage.botLogin.shouldBe(visible);
        loginPage.loginButton.shouldBe(visible);
    }
}
