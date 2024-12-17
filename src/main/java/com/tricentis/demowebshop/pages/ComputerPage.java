package com.tricentis.demowebshop.pages;

import com.tricentis.demowebshop.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());


    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='sublist']/li/a")
    List<WebElement> subMenuLinks;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Computers'])[1]")
    WebElement computerTab;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Desktops']")
    WebElement desktopLink;


    public String getPageTitleText() {
        String message = getTextFromElement(pageTitle);
        Reporter.log("Get pageTitle text : " + pageTitle.getText() + "<br>");
        log.info("Get pageTitle text : " + pageTitle.getText());
        return message;
    }

    public void clickOnSubMenu(String subTab) {
        for (WebElement menu : subMenuLinks) {
            System.out.println(menu.getText());
            if (menu.getText().trim().contains(subTab)) {
                Reporter.log("Click on '" + subTab + "' link <br>");
                log.info("Click on '" + subTab + "' link");
                clickOnElement(menu);
                break;
            }
        }
    }

    public void clickonDesktopFromComputerTab() {
       mouseHoverToElement(computerTab);
       clickOnElement(desktopLink);
    }
}







