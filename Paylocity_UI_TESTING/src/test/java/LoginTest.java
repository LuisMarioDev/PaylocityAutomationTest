import Scenario.BaseTest;
import Login.LoginSteps;
import BaseConfigElements.BaseSteps;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Login Tests")
@Feature("Login")
public class LoginTest extends BaseTest {

    Dotenv dotenv = Dotenv.load();

    String validUsername = dotenv.get("USERNAME");
    String validPassword = dotenv.get("PASSWORD");

    @Test
    @Story("Valid login test")
    @Description("Validate that a user can log in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Smoke")
    public void testValidCredentials() {
        LoginSteps loginSteps = new LoginSteps();


        loginSteps.LogCredentials(validUsername, validPassword);
    }

    @Test
    @Story("Second invalid login test")
    @Description("Validate that a user cannot log in with an invalid email but correct password")
    @Severity(SeverityLevel.CRITICAL)
    public void testInvalidEmail() {
        LoginSteps loginSteps = new LoginSteps();

        loginSteps.LogCredentials("invalidemail@example.com", "test121@");
    }

    @Test
    @Story("Third invalid login test")
    @Description("Validate that a user cannot log in with a valid email but incorrect password")
    @Severity(SeverityLevel.CRITICAL)
    public void testInvalidPassword() {
        LoginSteps loginSteps = new LoginSteps();
        BaseSteps baseSteps = new BaseSteps();
        loginSteps.LogCredentials("xluismariox@gmail.com", "wrongpassword");
    }

    @Test
    @Story("Fourth invalid login test")
    @Description("Validate that a user cannot log in with an empty email")
    @Severity(SeverityLevel.CRITICAL)
    public void testEmptyEmail() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.LogCredentials("", "test121@");
    }

    @Test
    @Story("Fifth invalid login test")
    @Description("Validate that a user cannot log in with an empty password")
    @Severity(SeverityLevel.CRITICAL)
    public void testEmptyPassword() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.LogCredentials("xluismariox@gmail.com", "");
    }

    @Test
    @Story("Sixth invalid login test")
    @Description("Validate that a user cannot log in with empty credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testEmptyCredentials() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.LogCredentials("", "");
    }
}