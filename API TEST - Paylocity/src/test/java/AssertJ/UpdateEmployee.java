package AssertJ;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UpdateEmployee extends RestAssured.UpdateEmployee {

    private RestAssured.UpdateEmployee updateEmployee;

    @BeforeEach
    public void setup() {
        updateEmployee = new RestAssured.UpdateEmployee();
        updateEmployee.setup();
    }

    @Test
    public void testupdateEmployee() {
        Response response = updateEmployee.actualizarTablero();

        assertThat(response.getStatusCode()).as("La respuesta debe de ser 200").isEqualTo(200);
        assertThat(response.jsonPath().getString("name")).as("El nombre deberia ser" + EMPLOYEE_FIRSTNAME).isEqualTo(EMPLOYEE_FIRSTNAME);
        assertThat(response.jsonPath().getString("id")).as("El idOrganization deberia ser" + updateEmployee.employeeID).isEqualTo(updateEmployee.employeeID);
    }
}
