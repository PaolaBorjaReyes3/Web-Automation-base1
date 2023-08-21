package com.bdd.web.obj;

import com.bdd.base.WebDriverDom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoObj extends WebDriverDom {
    @FindBy(id = "user-name")
    protected WebElement txtUser;
    @FindBy(id = "password")
    protected WebElement txtPassword;
    @FindBy(id = "login-button")
    protected WebElement btnLogin;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    protected WebElement btnAddCard;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    protected WebElement btnAddCard2;
    @FindBy(className = "shopping_cart_link")
    protected WebElement btnShoppingCard;
    @FindBy(id = "checkout")
    protected WebElement btnCheckout;
    @FindBy(id = "first-name")
    protected WebElement txtFirstName;
    @FindBy(id = "last-name")
    protected WebElement txtLastName;
    @FindBy(id = "postal-code")
    protected WebElement txtPostalCode;
    @FindBy(id = "continue")
    protected WebElement btnContinue;
    @FindBy(id = "finish")
    protected WebElement btnFinish;
    //coomparar el texto
    @FindBy(className = "complete-header")
    protected WebElement getMensaje;

}
