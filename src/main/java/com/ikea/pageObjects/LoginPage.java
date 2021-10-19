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

    @FindBy(css = ".AccountTab_column__1iRoY > button")
    private WebElement updateProfileWish;

    @FindBy(css = ".TransactionsList_transactionsList__1BbIi:nth-child(2) > h4:nth-child(2)")
    private WebElement transactionTab;

    @FindBy(className = "MembersPage_introInvite__1VRVX")
    private WebElement memberTab;

    @FindBy(id = "middleName")
    private WebElement optionName;

    @FindBy(css = ".sheets__content-wrapper > div > div > form > button")
    private WebElement updateProfileValidation;

    @FindBy(className = "toast__text")
    private WebElement updateStatut;

    @FindBy(css = ".loyalty-modal-content__link-page__header-top > a")
    private WebElement disconnectField;

    @FindBy(linkText = "Se connecter")
    private WebElement login;

    @FindBy(css = ".loyalty-modal-content__link-page__header-bottom > a > div > div:nth-child(1)")
    private WebElement isLogged;

    private static int logged = 0;

    private final String URI = config.getEnvironment()+
            "p/ragrund-porte-serviettes-avec-2-barres-bambou-50417614/";

    private String notice = "";

    private int correctIteration = 0;

    private String specialCharactere = "l@l@";

    public LoginPage(){}

    private void setField(WebElement element, String value){
        clickOn(element);
        element.sendKeys(value);
    }

    private void addFavoris(){
        clickOn(favourite);
        shortUntil(visibilityOf(notification));
    }

    public void getLogged() {
        if (logged==0) {
            shortUntil(visibilityOf(login));
            clickOn(login);
            waitForLoadingPage();
            connexion();
            logged++;
        } else {
            clickOn(isLogged);
            waitForLoadingPage();
        }
    }

    public void connexion(){
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
        clickOnProfile();
        shortUntil(visibilityOf(profilTab));
        notice = profilTab.getText();
        getLangage();
    }

    public void clickOnProfile(){
        shortUntil(visibilityOf(navBar));
        clickOnNavBarItem("Mon profil");
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

    public void clickOnModifyProfile(){
        shortUntil(visibilityOf(updateProfileWish));
        clickOn(updateProfileWish);
    }

    public void setMiddleName(){
        shortUntil(visibilityOf(optionName));
        resetField();
        optionName.sendKeys(specialCharactere);
        clickOn(updateProfileValidation);
        shortUntil(visibilityOf(updateStatut));
        notice = updateStatut.getText();
    }

    public void resetField(){
        optionName.sendKeys(Keys.CONTROL + "a");
        optionName.sendKeys(Keys.DELETE);
    }

    public boolean verifyFavorisNotification(){
        return (correctIteration==1);
    }

    public boolean verifyTabsLangages(){
        return (correctIteration==3);
    }

    public boolean verifyProfileFakeUpdates(){
        return !notice.contains("a été mise à jour");
    }



}
