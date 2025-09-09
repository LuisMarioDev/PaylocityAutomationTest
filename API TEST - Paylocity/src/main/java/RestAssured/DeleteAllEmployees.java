package RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class DeleteAllEmployees extends GetAllEmployees {

    // Method to get all employees
    public Response getEmployeesResponse() {
        return RestAssured.given()
                .baseUri(getBaseURL())
                .header(getHeader(), getToken()) // Authorization header
                .when()
                .get("/api/Employees")
                .then()
                .extract()
                .response();
    }

    // Method to get list of employee IDs
    public List<String> getEmployeeIds() {
        Response response = getEmployeesResponse();
        return response.jsonPath().getList("id");
    }

    public static void main(String[] args) {
        DeleteAllEmployees deleteAllEmployees = new DeleteAllEmployees();
        deleteAllEmployees.setup();  // Setup base URL and headers

        // Get all employee IDs
        List<String> employeeIds = deleteAllEmployees.getEmployeeIds();

        if(employeeIds.isEmpty()){
            System.out.println("There are no Employees to delete.");
            return;
        }

        // Iterate and delete each employee
        for (String id : employeeIds) {
            RestAssured.given()
                    .baseUri(deleteAllEmployees.getBaseURL())
                    .header(deleteAllEmployees.getHeader(), deleteAllEmployees.getToken())
                    .delete("/api/Employees/" + id)
                    .then()
                    .statusCode(200); // opcional: validar que fue eliminado correctamente

            System.out.println("Employee with ID: " + id + " deleted.");
        }

        System.out.println("All the Employees have been deleted correctly.");
    }
}
