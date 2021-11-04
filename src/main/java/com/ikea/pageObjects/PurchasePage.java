package com.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PurchasePage extends Page{

    @FindBy(css = "div.sc-hBEYos.dWjUC > div.input-field:nth-child(1)")
    private WebElement purchaseNumber;

    @FindBy(css = "div.sc-hBEYos.dWjUC > div.input-field:nth-child(2)")
    private WebElement email;

    @FindBy(className = "btn__label")
    private WebElement submitButton;

    @FindBy(id = "orderNumberValidationMessage")
    private WebElement purchaseNumberVerification;

    @FindBy(id = "liteIdHelper")
    private WebElement emailVerification;

    public PurchasePage(){}

    private void setField(WebElement element){
        clickOn(element);
        element.findElement(By.tagName("input"))
                .sendKeys(config.getEmail().substring(0,2));
    }

    public void fillForm(){
        setField(purchaseNumber);
        setField(email);
        clickOn(submitButton);
        shortUntil(visibilityOf(purchaseNumberVerification));
    }

    public boolean verifyPurchaseNumberField(){
        return purchaseNumberVerification.isDisplayed();
    }

    public boolean verifyEmailField(){
        return !emailVerification.isDisplayed();
    }

}
