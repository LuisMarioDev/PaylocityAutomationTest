package Scenario;

import BaseConfigElements.AccountPOJO;
import BaseConfigElements.DataProvider;
import Factory.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class BaseTest {
    private static Dotenv dotenv; // Make the variable static to use it in static methods
    public static WebDriver driver; // Public so child classes can access it
    private static String URL;
    protected static List<AccountPOJO> testAccounts;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        testAccounts = DataProvider.getTestAccounts();
        System.out.println("Test data loaded: " + testAccounts.size() + " accounts");
    }

    @Given("User access the main page")
    @Step("Accessing the main page")
    @BeforeEach
    public void setUp() throws IOException {
        // Load environment variables
        dotenv = Dotenv.load();
        URL = dotenv.get("URL");

        // Initialize WebDriver
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();

        // Configure the browser
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Then("User closes browser")
    @Step("Closing the browser")
    @AfterEach
    public void tearDown() throws IOException {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    @AfterAll
    public static void tearDownAll() throws IOException {
        if (driver != null) {
            driver.quit();
        }
        ScenarioContext.getInstance().removeAll();
    }
}