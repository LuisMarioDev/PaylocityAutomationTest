package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class MyPageFactory {

    private static WebDriverFactory webDriverFactory;
    private final Properties properties;

    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();

    public MyPageFactory() {
        webDriverFactory = new WebDriverFactory();
        this.properties = new Properties();
        loadProperties();
    }

    public static MyPageFactory getPageFactory() {
        return pageFactory;
    }

    public <T> T on (Class <T> webpage){
        WebDriver driver = getDriver();
        return PageFactory.initElements(driver, webpage);
    }

    public WebDriver getDriver() {
        return webDriverFactory.get();
    }

    private void loadProperties() {
        try(FileInputStream fis = new FileInputStream("src/main/resources/runConfiguration.properties")) {
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file", e);
        }
    }
}