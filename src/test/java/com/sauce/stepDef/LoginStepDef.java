package com.sauce.stepDef;

import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductPage;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    LoginPage loginPage=new LoginPage();
    ProductPage productPage=new ProductPage();

    CheckoutPage checkoutPage=new CheckoutPage();


    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("The user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("The user should be able to login and see {string} header")
    public void the_user_should_be_able_to_login_and_be_see_header(String expectedHeader) {
        Assert.assertEquals(expectedHeader,productPage.productsHeader.getText());
    }

    @And("The user able to sort the by {string}")
    public void theUserAbleToSortTheBy(String sortType) {
        productPage.sortProducts(sortType);
    }

    @And("The user clicks first as {string} and second as {string} products")
    public void theUserClicksCheapestAsAndSecondAsProducts(String first, String second) {
        productPage.addProduct(first);
        productPage.addProduct(second);
    }

    @And("The user opens the basket")
    public void theUserOpensTheBasket() {
        productPage.basket.click();
    }

    @And("The user clicks checkout")
    public void theUserClicksCheckout() {
        checkoutPage.checkout.click();
    }

    @And("The user enters details {string} {string} {string} and finish the purchase")
    public void theUserEntersDetailsAndFinishThePurchase(String firstName, String lastName, String postCode) {
    checkoutPage.firstNameInput.sendKeys(firstName);
    checkoutPage.lastNameInput.sendKeys(lastName);
    checkoutPage.postCodeInput.sendKeys(postCode);
    checkoutPage.continueBtn.click();
    }

    @Then("The user verify that {string}")
    public void theUserVerifyThat(String expectedPrice) {
        System.out.println("totalPrice = " + checkoutPage.totalPrice.getText());
        Assert.assertEquals(expectedPrice,checkoutPage.totalPrice.getText());
    }

    @And("The user clicks finish button")
    public void theUserClicksFinishButton() {
        checkoutPage.finishBtn.click();
    }

    @Then("The user able to see confirmation message as {string}")
    public void theUserAbleToSeeConfirmationMessageAs(String expectedMessage) {

        Assert.assertEquals(expectedMessage,checkoutPage.confirmationMessage.getText());

    }
}
