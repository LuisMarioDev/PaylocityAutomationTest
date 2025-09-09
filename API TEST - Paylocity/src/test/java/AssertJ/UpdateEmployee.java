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

        assertThat(response.getStatusCode()).as("The answer should be 200 ").isEqualTo(200);
        assertThat(response.getBody().jsonPath().getString("firstName"))
                .as("The first name doesn't match")
                .isEqualTo(updateEmployee.firstname);
        assertThat(response.getBody().jsonPath().getString("lastName"))
                .as("The last name doesn't match")
                .isEqualTo(updateEmployee.lastname);
        assertThat(response.getBody().jsonPath().getString("salary"))
                .as("The salary doesn't match")
                .isEqualTo(updateEmployee.newSalary.toString());
        assertThat(response.getBody().jsonPath().getString("dependants"))
                .as("The dependants don't match")
                .isEqualTo(updateEmployee.dependencies.toString());
    }
}
