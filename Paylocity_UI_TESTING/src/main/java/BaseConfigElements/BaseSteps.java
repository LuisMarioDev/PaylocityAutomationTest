package BaseConfigElements;

import Factory.WebDriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class BaseSteps implements BaseLocators {
    public Dotenv dotenv = Dotenv.load();

    public WebDriver driver;
    public WebDriverWait wait;

    public BaseSteps() {
        this.driver = WebDriverFactory.get();
        int TIMEOUT = Integer.parseInt(dotenv.get("TIMEOUT"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private String usernameString = dotenv.get("USERNAME");
    private String passwordString = dotenv.get("PASSWORD");

    public void login() {
        // Fill in the login form and submit
        WebElement emailInput = wait
                .until(ExpectedConditions.visibilityOfElementLocated(BaseLocators.Usernameinput));
        WebElement passwordInput = wait
                .until(ExpectedConditions.visibilityOfElementLocated(BaseLocators.Passwordinput));
        WebElement loginButton = wait
                .until(ExpectedConditions.elementToBeClickable(BaseLocators.LoginButton));

        emailInput.clear();
        emailInput.sendKeys(usernameString);
        passwordInput.clear();
        passwordInput.sendKeys(passwordString);
        loginButton.click();

        try {
            // Verify if an error message appears after attempting to log in
            WebElement errorSign = wait.until(ExpectedConditions.visibilityOfElementLocated(BaseLocators.errorSign));
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

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }
}
