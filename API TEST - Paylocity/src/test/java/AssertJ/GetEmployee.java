package AssertJ;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import PojoClasses.EmployeePojo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetEmployee extends RestAssured.GetAllEmployees {

    private static GetEmployee buildRequest;
    private static Response response;
    private static List<EmployeePojo> employees;

    @BeforeAll
    public static void setUp() {
        buildRequest = new GetEmployee();
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
    public void testResponseBody() {
        // Expected POJO
        EmployeePojo expectedEmployee = new EmployeePojo();
        expectedEmployee.setId(buildRequest.IdRequest());
        expectedEmployee.setUsername("xluismariox");
        expectedEmployee.setFirstName("Luis");
        expectedEmployee.setLastName("Navarro");
        expectedEmployee.setDependants(2);
        expectedEmployee.setSalary(2000.0);
        expectedEmployee.setGross(52000.0);
        expectedEmployee.setBenefitsCost(2000.0);
        expectedEmployee.setNet(50000.0);

        // Find actual employee from API response
        EmployeePojo actualEmployee = employees.stream()
                .filter(emp -> emp.getId().equals(expectedEmployee.getId()))
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("Employee with ID " + expectedEmployee.getId() + " not found"));

        // Compare fields
        assertThat(actualEmployee.getUsername()).isEqualTo(expectedEmployee.getUsername());
        assertThat(actualEmployee.getFirstName()).isEqualTo(expectedEmployee.getFirstName());
        assertThat(actualEmployee.getLastName()).isEqualTo(expectedEmployee.getLastName());
        assertThat(actualEmployee.getDependants()).isEqualTo(expectedEmployee.getDependants());
        assertThat(actualEmployee.getSalary()).isEqualTo(expectedEmployee.getSalary());
        assertThat(actualEmployee.getGross()).isEqualTo(expectedEmployee.getGross());
        assertThat(actualEmployee.getBenefitsCost()).isEqualTo(expectedEmployee.getBenefitsCost());
        assertThat(actualEmployee.getNet()).isEqualTo(expectedEmployee.getNet());
    }
}
