package com.tricentis.demowebshop.steps;

import com.tricentis.demowebshop.pages.BuildYourOwnComputerPage;
import com.tricentis.demowebshop.pages.ComputerPage;
import com.tricentis.demowebshop.pages.DesktopsPage;
import com.tricentis.demowebshop.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ComputerSteps {
    @When("I click on the COMPUTER tab")
    public void iClickOnTheCOMPUTERTab() {
        new HomePage().clickOnComputerTab();
    }

    @Then("I should see the text Computers")
    public void iShouldSeeTheTextComputers() {
        Assert.assertEquals(new ComputerPage().getPageTitleText(), "Computers");
    }

    @And("I click on the Desktops link")
    public void iClickOnTheDesktopsLink() {
        new ComputerPage().clickonDesktopFromComputerTab();

    }

    @Then("I should see the text Desktops")
    public void iShouldSeeTheText() {
        Assert.assertEquals(new DesktopsPage().getPageTitleText(), "Desktops");
    }

    @And("I click on the product name {string}")
    public void iClickOnTheProductName(String productName) {
        new DesktopsPage().buildYourOwnComputerLink("Build your own computer");
    }

    @And("I select processor {string}")
    public void iSelectProcessor(String processor) {
        new BuildYourOwnComputerPage().selectProcessor(processor);
    }

    @And("I select RAM {string}")
    public void iSelectRAM(String ram) {
        new BuildYourOwnComputerPage().selectRam(ram);
    }

    @And("I select HDD {string}")
    public void iSelectHDD(String hdd) {
        new BuildYourOwnComputerPage().selectHDD(hdd);
    }

    @And("I select OS {string}")
    public void iSelectOS(String osName) {
        new BuildYourOwnComputerPage().selectOS(osName);
    }

    @And("I select software {string}")
    public void iSelectSoftware(String software) {
        new BuildYourOwnComputerPage().selectSoftware(software);
    }

    @And("I click on the Add to Cart button")
    public void iClickOnTheAddToCartButton() {
        new BuildYourOwnComputerPage().clickOnAddToCartButton();
    }

    @Then("I should see the message The product has been added to your shopping cart")
    public void iShouldSeeTheMessageTheProductHasBeenAddedToYourShoppingCart() {
        Assert.assertEquals(new BuildYourOwnComputerPage().getProductAddedMessage(),"The product has been added to your shopping cart");
    }
}
