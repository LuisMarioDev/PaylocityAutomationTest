package AssertJ;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteEmployee extends RestAssured.DeleteEmployee{

    private RestAssured.DeleteEmployee deleteEmployee;

    @BeforeEach
    public void setUp() {
        deleteEmployee = new RestAssured.DeleteEmployee();
        deleteEmployee.setup();
    }

    @Test
    public void testdeleteEmployee() {
        Response response = deleteEmployee.response();

        assertThat(response.getStatusCode()).as("The status code should be 200").isEqualTo(200);
        assertThat(response.jsonPath().getString("id")).as("ID should be: " + deleteEmployee.employeeID).isEqualTo(deleteEmployee.employeeID);
        assertThat(response.jsonPath().getString("name")).as("The name should be: " + EMPLOYEE_FIRSTNAME).isEqualTo(EMPLOYEE_FIRSTNAME);

        String valueField = response.jsonPath().getString("_value");

        assertThat(valueField).as("Body should be null " + valueField).isNull();
    }
}
