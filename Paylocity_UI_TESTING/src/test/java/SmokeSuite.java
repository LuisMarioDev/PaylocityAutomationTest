import Scenario.BaseTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        LoginTest.class,
        BaseTest.class,
        DeleteEmployeeTest.class,
        AddEmployeeTest.class,
        EditEmployeeTest.class
        }
                        )

public class SmokeSuite {
}
