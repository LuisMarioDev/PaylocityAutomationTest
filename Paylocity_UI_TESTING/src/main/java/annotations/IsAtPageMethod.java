package annotations;

import io.qameta.htmlelements.context.Context;
import io.qameta.htmlelements.exception.WebPageException;
import io.qameta.htmlelements.extension.MethodHandler;
import io.qameta.htmlelements.util.WebDriverUtils;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import static io.qameta.htmlelements.context.Store.DRIVER_KEY;

public @interface IsAtPageMethod {

    class Extension implements MethodHandler {

        @Override
        public Object handle(Context context, Object proxy, Method method, Object[] args) {
            WebDriver driver = context.getStore().get(DRIVER_KEY, WebDriver.class)
                    .orElseThrow(() -> new WebPageException("HtmlElements handler: WebDriver is missing!"));

            // Get timeout message and URL matcher
            String pageNotLoadedMessage = getLoadTimeoutDetails(args);
            Matcher<String> urlMatcher = getUrlMatcher(args);

            // Set the timeout as a configurable property
            int timeoutSeconds = getTimeoutFromProperties();

            // Use WebDriverWait with updated Selenium
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            wait.withMessage(pageNotLoadedMessage)
                    .ignoring(Exception.class)
                    .until(pageIsLoadedCondition(driver, urlMatcher));

            return proxy;
        }

        private static String getLoadTimeoutDetails(final Object[] args) {
            String url = args != null && args.length > 0 ? String.valueOf(args[0]) : "Unknown";
            return String.format("PageSteps \"%s\" was not loaded within the timeout period!", url);
        }

        @SuppressWarnings("unchecked")
        private static Matcher<String> getUrlMatcher(final Object... args) {
            return args != null && args.length > 0 ? (Matcher<String>) args[0] : null;
        }

        private static int getTimeoutFromProperties() {
            // Load a configuration file to get the timeout
            Properties properties = new Properties();
            return 30; // TODO: Replace this with a configurable property
        }

        private static ExpectedCondition<Boolean> pageIsLoadedCondition(WebDriver driver, Matcher<String> urlMatcher) {
            return webDriver -> {
                if (webDriver == null) return false;
                boolean isUrlMatched = urlMatcher != null && urlMatcher.matches(webDriver.getCurrentUrl());
                boolean isPageLoaded = WebDriverUtils.pageIsLoaded(webDriver);
                return isUrlMatched && isPageLoaded;
            };
        }
    }
}