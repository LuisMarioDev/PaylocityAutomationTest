package Login;

import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseConfigElements.BaseSteps;
public class LoginSteps {

    public LoginLocators loginLocators = new LoginLocators();
    public BaseSteps baseSteps = new BaseSteps();

    @And("User enters and logs credentials with email: {string} and password: {string}")
    public void LogCredentials(String Username, String Password) {
        // Fill in the login form and submit
        WebElement emailInput = baseSteps.wait
                .until(ExpectedConditions.visibilityOfElementLocated(loginLocators.Usernameinput));
        WebElement passwordInput = baseSteps.wait
                .until(ExpectedConditions.visibilityOfElementLocated(loginLocators.Passwordinput));
        WebElement loginButton = baseSteps.wait
                .until(ExpectedConditions.elementToBeClickable(loginLocators.LoginButton));

        emailInput.clear();
        emailInput.sendKeys(Username);
        passwordInput.clear();
        passwordInput.sendKeys(Password);
        loginButton.click();

        try {
            // Verify if an error message appears after attempting to log in
            WebElement errorSign = baseSteps.wait
                    .until(ExpectedConditions.visibilityOfElementLocated(loginLocators.errorSign));
            if (errorSign.isDisplayed()) {
                Assertions.fail("An error happened while trying to log in: " + errorSign.getText());
            }
        } catch (TimeoutException e) {
            System.out.println("Logged in successfully, no error message displayed.");
        } catch (Exception e) {
            // Manage any other unexpected exceptions
            throw new RuntimeException("An unexpected error: " + e.getMessage());
        }
    }
    
    public void LogOut() {
        WebElement logoutButton = baseSteps.wait
                .until(ExpectedConditions.elementToBeClickable(loginLocators.logoutbutton));
        logoutButton.click();
    }
}