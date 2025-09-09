import DeleteEmployee.DeleteEmployeeSteps;
import Scenario.BaseTest;


import BaseConfigElements.BaseSteps;
import io.qameta.allure.junit4.Tag;

public class DeleteEmployeeTest extends BaseTest {
    @org.junit.jupiter.api.Test
    @Tag("Smoke")
    public void testDeleteEmployee() {
        BaseSteps baseSteps = new BaseSteps();
        DeleteEmployeeSteps deleteEmployeeSteps = new DeleteEmployeeSteps();
        baseSteps.login();
        deleteEmployeeSteps.deleteEmployee();
    }
}
