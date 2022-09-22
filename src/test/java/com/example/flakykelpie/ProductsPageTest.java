package com.example.flakykelpie;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class ProductsPageTest {
    static ProductsPage productsPage = new ProductsPage();
    static LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1600x1200";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.saucedemo.com/");
    }
    @Test
    public void validatePageStylesStandardUser(){
        loginPage.userName.click();
        loginPage.password.click();
        $x("//input[contains(@id,'user-name')]").shouldBe(visible);
        $x("//input[@id='password']").shouldBe(visible);

        $x("//input[contains(@id,'user-name')]").sendKeys("standard_user");
        $x("//input[@id='password']").sendKeys("secret_sauce");
        loginPage.loginButton.click();
        assertTimeout(Duration.ofMillis(30000), ()->{} );
        loginPage.currentPageStyle.shouldBe(visible);
        productsPage.errorMessage.shouldNotBe(Condition.visible);
        productsPage.productsText.shouldBe(Condition.visible);
        productsPage.inventoryContainer.shouldBe(Condition.visible);
        productsPage.inventoryItem.shouldBe(Condition.visible);
        productsPage.inventoryItemImg.shouldBe(Condition.visible);
        productsPage.inventoryItemPriceFlexItem.shouldBe(Condition.visible);
        productsPage.inventoryItemName.shouldBe(Condition.visible);
        productsPage.inventoryItemDesc.shouldBe(Condition.visible);
        productsPage.addToCartButton.shouldBe(Condition.visible);
        productsPage.productSortContainer.shouldBe(visible);
    }
    @Test

    public  void sortProductsStandardUser(){
        loginPage.userName.click();
        loginPage.password.click();
        $x("//input[contains(@id,'user-name')]").shouldBe(visible);
        $x("//input[@id='password']").shouldBe(visible);

        $x("//input[contains(@id,'user-name')]").sendKeys("standard_user");
        $x("//input[@id='password']").sendKeys("secret_sauce");
        loginPage.loginButton.click();
        assertTimeout(Duration.ofMillis(30000), ()->{} );
        loginPage.currentPageStyle.shouldBe(visible);
        productsPage.errorMessage.shouldNotBe(Condition.visible);
        productsPage.productsText.shouldBe(Condition.visible);
        productsPage.productSortContainer.shouldBe(visible).click();
        productsPage.selectSortContainerOption2.click();
        productsPage.testAllTheThings.shouldBe(visible).click();
        productsPage.testAllTheThingsImage.shouldBe(visible);
        productsPage.buttonBackToProducts.shouldBe(visible).click();
    }
    @Test
    public  void orderProductsStandardUser(){
        loginPage.userName.click();
        loginPage.password.click();
        $x("//input[contains(@id,'user-name')]").shouldBe(visible);
        $x("//input[@id='password']").shouldBe(visible);

        $x("//input[contains(@id,'user-name')]").sendKeys("standard_user");
        $x("//input[@id='password']").sendKeys("secret_sauce");
        loginPage.loginButton.click();
        assertTimeout(Duration.ofMillis(30000), ()->{} );
        loginPage.currentPageStyle.shouldBe(visible);
        productsPage.errorMessage.shouldNotBe(Condition.visible);
        productsPage.productsText.shouldBe(Condition.visible);
        productsPage.productSortContainer.shouldBe(visible).click();
        productsPage.selectSortContainerOption2.click();
        productsPage.testAllTheThings.shouldBe(visible).click();
        productsPage.testAllTheThingsImage.shouldBe(visible);
        productsPage.addToCardProduct.shouldBe(visible).click();
        productsPage.basketProducts.shouldBe(visible).click();
    }
    @Test
    public  void checkoutProductsStandardUser(){
        loginPage.userName.click();
        loginPage.password.click();
        $x("//input[contains(@id,'user-name')]").shouldBe(visible);
        $x("//input[@id='password']").shouldBe(visible);

        $x("//input[contains(@id,'user-name')]").sendKeys("standard_user");
        $x("//input[@id='password']").sendKeys("secret_sauce");
        loginPage.loginButton.click();
        assertTimeout(Duration.ofMillis(30000), ()->{} );
        productsPage.errorMessage.shouldNotBe(Condition.visible);
        productsPage.productsText.shouldBe(Condition.visible);
        productsPage.productSortContainer.shouldBe(visible).click();
        productsPage.selectSortContainerOption2.click();
        productsPage.testAllTheThings.shouldBe(visible).click();
        productsPage.testAllTheThingsImage.shouldBe(visible);
        productsPage.addToCardProduct.shouldBe(visible);
        productsPage.addToCardProduct.shouldBe(visible).click();
        productsPage.basketProducts.shouldBe(visible).click();
        productsPage.removeProduct.shouldBe(visible);
        productsPage.checkoutButtonProduct.shouldBe(visible).click();
        productsPage.checkoutButtonProduct1.click();
        productsPage.checkoutButtonProductError.shouldBe(visible);
       // open("https://www.saucedemo.com/cart.html");
        $x("//input[contains(@placeholder,'First Name')]\n").shouldBe(visible).sendKeys("test");
        $x("//input[contains(@placeholder,'Last Name')]\n").shouldBe(visible).sendKeys("test");

        $x("//input[contains(@placeholder,'Zip/Postal Code')]").shouldBe(visible).sendKeys("test");
        productsPage.checkoutButtonProduct1.shouldBe(visible).click();
        $x("//div[@class='summary_total_label'][contains(.,'Total: $17.27')]").shouldBe(visible);
        $x("//button[contains(.,'Finish')]").shouldBe(visible).click();
        $x("//img[contains(@alt,'Pony Express')]").shouldBe(visible);
    }
    @AfterAll
    public static void loggedOutUser(){
        $x("//button[contains(.,'Open Menu')]").shouldBe(visible).click();
        loginPage.logoutButton.click();
        assertTimeout(Duration.ofMillis(1000000), () -> {
        });
        loginPage.logoLogin.shouldBe(visible);
        loginPage.botLogin.shouldBe(visible);
        loginPage.loginButton.shouldBe(visible);
        open("https://www.saucedemo.com/inventory.html");
        productsPage.errorMessage.shouldBe(Condition.visible);

    }
}
