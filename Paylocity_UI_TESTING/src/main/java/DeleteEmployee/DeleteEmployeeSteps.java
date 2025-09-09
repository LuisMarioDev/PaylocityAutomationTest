package DeleteEmployee;
import org.openqa.selenium.WebElement;

import BaseConfigElements.BaseSteps;
import io.cucumber.java.en.And;

public class DeleteEmployeeSteps {

    private DeleteEmployeeLocators deleteLocators = new DeleteEmployeeLocators();
    private BaseSteps baseSteps;

    public DeleteEmployeeSteps() {
        baseSteps = new BaseSteps();
    }

    @And("User deletes the employee")
    public void deleteEmployee() {

        WebElement deleteButton = baseSteps.wait
                .until(driver -> driver.findElement(deleteLocators.DeleteButton));
        deleteButton.click();

        WebElement confirmDeleteButton = baseSteps.wait
                .until(driver -> driver.findElement(deleteLocators.ConfirmDeleteButton));
        confirmDeleteButton.click();
    }
}
