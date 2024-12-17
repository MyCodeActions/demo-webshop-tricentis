package com.tricentis.demowebshop.pages;


import com.tricentis.demowebshop.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-name']//h1")
    WebElement productNameText;

    @CacheLookup
    @FindBy(id = "product_attribute_16_5_4")
    WebElement processor;

    @CacheLookup
    @FindBy(id = "product_attribute_16_6_5")
    WebElement ram;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='option-list']//li/input[@type='radio']/parent::li/label")
    List<WebElement> hDDRadios;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='option-list']//li/input[@type='radio']/parent::li/label")
    List<WebElement> oSRadios;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='option-list']//li/input[@type='checkbox']/parent::li/label")
    List<WebElement> softwareCheckBoxes;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='add-to-cart-button-16'])[1]")
    WebElement addToCartBtn;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement productAddeMessage;


    public String getProductNameText() {
        String message = getTextFromElement(productNameText);
        Reporter.log("Get productName text : " + productNameText.getText() + "<br>");
        log.info("Get productName text : " + productNameText.getText());
        return message;
    }

    public void selectProcessor(String processorName) {
        selectByVisibleTextFromDropDown(processor, processorName);
        Reporter.log("Select processor '" + processorName + "'" + "<br>");
        log.info("Select processor '" + processorName + "'");
    }

    public void selectRam(String ramGB) {
        selectByVisibleTextFromDropDown(ram, ramGB);
        selectByVisibleTextFromDropDown(ram, ramGB);
        Reporter.log("Select RAM '" + ramGB + "'" + "<br>");
        log.info("Select RAM '" + ramGB + "'");
    }

    public void selectHDD(String hDdGB) {
        for (WebElement hdd : hDDRadios) {
            if (hdd.getText().equals(hDdGB)) {
                clickOnElement(hdd);
                Reporter.log("Select HDD '" + hDdGB + "'" + "<br>");
                log.info("Select HDD '" + hDdGB + "'");
                break;
            }
        }
    }

    public void selectOS(String oSName) {
        for (WebElement os : oSRadios) {
            if (os.getText().equals(oSName)) {
                clickOnElement(os);
                Reporter.log("Select HDD '" + oSName + "'" + "<br>");
                log.info("Select HDD '" + oSName + "'");
                break;
            }
        }
    }

    public void selectSoftware(String softwareName) {
        for (WebElement software : softwareCheckBoxes) {
            if (software.getText().equals(softwareName)) {
                clickOnElement(software);
                Reporter.log("Select Software '" + software + "'" + "<br>");
                log.info("Select Software '" + softwareName + "'");
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartBtn);
        Reporter.log("Click on 'ADD TO CART' Button" + "<br>");
        log.info("Click on 'ADD TO CART' Button");
    }

    public String getProductAddedMessage() {
        String message = getTextFromElement(productAddeMessage);
        Reporter.log("Get productAdded Message : " + productAddeMessage.getText() + "<br>");
        log.info("Get productAdded Message : " + productAddeMessage.getText());
        return message;
    }
}