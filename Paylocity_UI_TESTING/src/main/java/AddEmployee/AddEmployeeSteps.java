package AddEmployee;

import org.openqa.selenium.WebElement;

import com.basis.bbj.processor.instruction.de;

public class AddEmployeeSteps {

    private AddEmployeeLocators addLocators = new AddEmployeeLocators();
    private BaseConfigElements.BaseSteps baseSteps;

    public AddEmployeeSteps() {
        baseSteps = new BaseConfigElements.BaseSteps();
    }

    @io.cucumber.java.en.And("User adds a new employee")
    public void addEmployee(String firstName, String lastName, Integer dependants) {

        WebElement addEmployeeButton = baseSteps.wait
                .until(driver -> driver.findElement(addLocators.AddEmployeeButton));
        addEmployeeButton.click();

        WebElement firstNameField = baseSteps.wait
                .until(driver -> driver.findElement(addLocators.FirstNameField));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = baseSteps.wait
                .until(driver -> driver.findElement(addLocators.LastNameField));
        lastNameField.sendKeys(lastName);

        WebElement dependantsField = baseSteps.wait
                .until(driver -> driver.findElement(addLocators.DependantsField));
        dependantsField.sendKeys(dependants.toString());

        WebElement addEmployeeConfirmButton = baseSteps.wait
                .until(driver -> driver.findElement(addLocators.AddEmployeeConfirmButton));
        addEmployeeConfirmButton.click();
    }

    public void cancelAdd() {

        WebElement addEmployeeButton = baseSteps.wait
                .until(driver -> driver.findElement(addLocators.AddEmployeeButton));
        addEmployeeButton.click();

        WebElement cancelButton = baseSteps.wait
                .until(driver -> driver.findElement(addLocators.CancelButton));
        cancelButton.click();
    }
    
}
