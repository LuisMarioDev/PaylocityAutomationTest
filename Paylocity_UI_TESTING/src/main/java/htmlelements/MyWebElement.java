package htmlelements;

/*
 *  Here WebElement methods can be overridden or extended using htmlelements annotations.
 *
 */

import org.openqa.selenium.WebElement;

public class MyWebElement {

    private WebElement element;

    public MyWebElement(WebElement element) {
        this.element = element;
    }

    public void clickWithMessage() {
        System.out.println("You have clicked on this element");
        element.click();
    }

    public void clearAndType() {
        element.clear();
        element.sendKeys("This is a test text to type in this field");
    }

    public boolean isDisplayedWithMessage() {
        System.out.println("The element is visible");
        element.isDisplayed();
        return true;
    }

    public void submitWithMessage() {
        System.out.println("You have submitted the form");
        element.submit();
    }

    public void typeWithMessage(String text) {
        System.out.println("You have typed the text: " + text);
        element.sendKeys(text);
    }
}
;