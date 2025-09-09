package EditEmployee;

import org.openqa.selenium.WebElement;

public class EditEmployeeSteps {

    private EditEmployeeLocators editLocators = new EditEmployeeLocators();
    private BaseConfigElements.BaseSteps baseSteps;

    public EditEmployeeSteps() {
        baseSteps = new BaseConfigElements.BaseSteps();
    }


    public void editEmployee(String newFirstName, String newLastName, Integer newDependants) {

        WebElement editButton = baseSteps.wait
                .until(driver -> driver.findElement(editLocators.EditButton));
        editButton.click();

        WebElement firstNameField = baseSteps.wait
                .until(driver -> driver.findElement(editLocators.EditFirstName));
        firstNameField.clear();
        firstNameField.sendKeys(newFirstName);

        WebElement lastNameField = baseSteps.wait
                .until(driver -> driver.findElement(editLocators.EditLastName));
        lastNameField.clear();
        lastNameField.sendKeys(newLastName);

        WebElement dependantsField = baseSteps.wait
                .until(driver -> driver.findElement(editLocators.EditDependants));
        dependantsField.clear();
        dependantsField.sendKeys(newDependants.toString());

        WebElement updateButton = baseSteps.wait
                .until(driver -> driver.findElement(editLocators.UpdateButton));
        updateButton.click();
    }

    public void cancelEdit() {

        WebElement editButton = baseSteps.wait
                .until(driver -> driver.findElement(editLocators.EditButton));
        editButton.click();

        WebElement cancelButton = baseSteps.wait
                .until(driver -> driver.findElement(editLocators.CancelButton));
        cancelButton.click();
    }
    
}
