package com.ikea.pageObjects;

import org.apache.tika.language.LanguageIdentifier;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends Page{

    @FindBy(css = ".page-container__main > nav:nth-child(1) li a")
    private List<WebElement> navMenu;

    @FindBy(css = ".page-container__main > nav:nth-child(1)")
    private WebElement navBar;

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "BusinessPage_intro__kH7HD")
    private WebElement welcomeMessage;

    @FindBy(css = "div.js-buy-module.range-revamp-buy-module > div > button")
    private WebElement favourite;

    @FindBy(className = "hnf-toast__text")
    private WebElement notification;

    @FindBy(className = "ProfilePage_paragraph__3QfT9")
    private WebElement profilTab;

    @FindBy(css = ".TransactionsList_transactionsList__1BbIi:nth-child(2) > h4:nth-child(2)")
    private WebElement transactionTab;

    @FindBy(className = "MembersPage_introInvite__1VRVX")
    private WebElement memberTab;

    private final String URI = config.getEnvironment()+
            "p/ragrund-porte-serviettes-avec-2-barres-bambou-50417614/";

    private String notice = "";

    private int correctIteration = 0;

    public LoginPage(){}

    private void setField(WebElement element, String value){
        clickOn(element);
        element.sendKeys(value);
    }

    private void addFavoris(){
        clickOn(favourite);
        shortUntil(visibilityOf(notification));
    }

    public void getLogged(){
        setField(emailField, config.getEmail());
        setField(passwordField, config.getPwd());
        passwordField.sendKeys(Keys.ENTER);
        middleUntil(visibilityOf(welcomeMessage));
    }

    public void selectArticle(){
        get(URI);
    }

    private void clickOnNavBarItem( String elementNavigation){
        WebElement menu = navMenu
                .stream()
                .filter( elt -> elt.getText().equals(elementNavigation))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Not element Found !"));

        clickOn(menu);
        waitForLoadingPage();
    }

    public boolean isCorrectLangage(){
        LanguageIdentifier noticeLangage = new LanguageIdentifier(notice);
        return noticeLangage.getLanguage().equals("fr");
    }

    public void getLangage(){
        if(isCorrectLangage()){
            correctIteration++;
        }
    }

    public void getOnProfile(){
        shortUntil(visibilityOf(navBar));
        clickOnNavBarItem("Mon profil");
        shortUntil(visibilityOf(profilTab));
        notice = profilTab.getText();
        getLangage();
    }

    public void getOnTransaction(){
        clickOnNavBarItem("Transactions");
        shortUntil(visibilityOf(transactionTab));
        notice = transactionTab.getText();
        getLangage();
    }

    public void getOnMembres(){
        clickOnNavBarItem("Membres");
        shortUntil(visibilityOf(memberTab));
        notice = memberTab.getText();
        getLangage();
    }

    public void setOnFavourite(){
        shortUntil(visibilityOf(favourite));
        addFavoris();
        notice = notification.getText();
        getLangage();
    }

    public boolean verifyFavorisNotification(){
        return (correctIteration==1);
    }

    public boolean verifyTabsLangages(){
        return (correctIteration==3);
    }

}
