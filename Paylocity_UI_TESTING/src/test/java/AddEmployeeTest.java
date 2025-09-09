import org.junit.jupiter.api.Tag;

import AddEmployee.AddEmployeeSteps;
import BaseConfigElements.BaseSteps;
import Scenario.BaseTest;

public class AddEmployeeTest extends BaseTest {
    @org.junit.jupiter.api.Test
    @Tag("Regression")
    public void testAddEmployee() {
        BaseSteps baseSteps = new BaseSteps();
        AddEmployeeSteps addEmployeeSteps = new AddEmployeeSteps();
        baseSteps.login();
        addEmployeeSteps.addEmployee(
                "Kevin",
                "Durant",
                3
        );
        addEmployeeSteps.cancelAdd();
    }
    
}
