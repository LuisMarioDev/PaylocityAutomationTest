import org.junit.jupiter.api.Tag;

import BaseConfigElements.BaseSteps;
import EditEmployee.EditEmployeeSteps;
import Scenario.BaseTest;

public class EditEmployeeTest extends BaseTest {
    @org.junit.jupiter.api.Test
    @Tag("Regression")
    public void testEditEmployee() {
        BaseSteps baseSteps = new BaseSteps();
        EditEmployeeSteps editEmployeeSteps = new EditEmployeeSteps();
        baseSteps.login();
        editEmployeeSteps.editEmployee(
                "Kevin",
                "Durant",
                3
        );
        editEmployeeSteps.cancelEdit();
    }
    
}
