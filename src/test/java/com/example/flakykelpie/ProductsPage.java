package com.example.flakykelpie;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    public SelenideElement errorMessage = $x("//h3[contains(@data-test,'error')]");

    public SelenideElement productsText = $x("//span[@class='title'][contains(.,'Products')]");
    public SelenideElement inventoryContainer = $x("//*[@id=\"inventory_container\"]");
    public SelenideElement inventoryItem = $x("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[1]");
    public SelenideElement inventoryItemImg = $("div.inventory_item:nth-child(1) > div:nth-child(1)");
    public SelenideElement inventoryItemPriceFlexItem = $("div.inventory_item:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)");
    public SelenideElement inventoryItemName = $("#item_4_title_link > div:nth-child(1)");
    public SelenideElement inventoryItemDesc = $("div.inventory_item:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)");
    public SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-backpack");
    public SelenideElement productSortContainer = $x("//select[contains(@class,'product_sort_container')]");
    public SelenideElement selectSortContainerOption2 = $x("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select/option[2]");

    public SelenideElement testAllTheThings = $x("//div[@class='inventory_item_name'][contains(.,'Test.allTheThings() T-Shirt (Red)')]\n");
    public SelenideElement testAllTheThingsImage = $x("//img[@src='/static/media/red-tatt-1200x1500.e32b4ef9.jpg']");
    public SelenideElement buttonBackToProducts = $x("//button[contains(@data-test,'back-to-products')]");
    public SelenideElement addToCardProduct = $x("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]");
    public SelenideElement basketProducts = $x("/html/body/div/div/div/div[1]/div[1]/div[3]/a\n");
    public SelenideElement removeProduct = $x("//button[@class='btn btn_secondary btn_small cart_button'][contains(.,'Remove')]\n");
    public SelenideElement checkoutButtonProduct = $x("//*[@id=\"checkout\"]");
    public SelenideElement checkoutButtonProduct1 = $x("//*[@id=\"continue\"]");
    public SelenideElement checkoutButtonProductError = $x("//h3[@data-test='error'][contains(.,'Error: First Name is required')]");
}
