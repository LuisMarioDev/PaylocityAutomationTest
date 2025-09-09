package AssertJ;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import PojoClasses.EmployeePojo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetEmployees extends RestAssured.GetAllEmployees {

    private static GetEmployees buildRequest;
    private static Response response;
    private static List<EmployeePojo> employees;

    @BeforeAll
    public static void setUp() {
        buildRequest = new GetEmployees();
        buildRequest.setup(); // Initialize base URL, headers, etc.
        response = buildRequest.buildRequest(); // GET /api/Employees

        // Deserialize response body into a list of EmployeePojo
        employees = response.jsonPath().getList("", EmployeePojo.class);
    }

    @Test
    public void testResponseCode() {
        assertThat(response.getStatusCode())
                .as("The status code should be 200")
                .isEqualTo(200);

        assertThat(response.getContentType())
                .as("The content must be JSON Type")
                .contains("application/json");

        assertThat(response.getBody().asString())
                .as("The JSON Body must not be empty")
                .isNotEmpty();
    }

    @Test
    public void testResponseTime() {
        assertThat(response.getTime())
                .as("Response time should be less than 2 seconds")
                .isLessThan(2000);
        System.out.println("Response time: " + response.getTime() + " ms");
    }

    @Test
    public void testEmployeeListNotEmpty() {
        assertThat(employees)
                .as("The employee list should not be empty")
                .isNotEmpty();
    }
}
