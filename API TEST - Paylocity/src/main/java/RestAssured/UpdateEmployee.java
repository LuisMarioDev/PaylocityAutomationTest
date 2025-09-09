package RestAssured;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateEmployee extends GetEmployee {
    Dotenv dotenv = Dotenv.load();
    public static final String PATH_ENV = "src/main/resources/.env";
    public String firstname = "Updated User";
    public String lastname = "Updated Lastname";
    public String username = "UpdatedUsername";
    public Integer newSalary = 80000;
    public Integer dependencies = 4;


    // Method to update employee
    public Response actualizarTablero() {
        return RestAssured.given()
                .baseUri(getBaseURL())
                .header(getHeader(), getToken())
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": \"" + employeeID + "\",\n" +
                        "  \"firstName\": \"" + firstname + "\",\n" +
                        "  \"lastName\": \"" + lastname + "\",\n" +
                        "  \"username\": \"" + username + "\",\n" +
                        "  \"salary\": " + newSalary + ",\n" +
                        "  \"dependants\": " + dependencies + "\n" +
                        "}")
                .when()
                .put("/api/Employees/")
                .then()
                .extract().
                response().
                prettyPeek();
    }

    public static void main(String[] args) {
        UpdateEmployee updateEmployee = new UpdateEmployee();
        updateEmployee.setup();

        // Make the update request
        Response response = updateEmployee.actualizarTablero();

        System.out.println("JSON Response: ");
        response.prettyPrint();
        System.out.println("\nThe status code is: " + response.getStatusCode());
        System.out.println("\nThe name of the employee is " + response.jsonPath().getString("firstName"));
        System.out.println("\nThe last name of the employee is " + response.jsonPath().getString("lastName"));
        System.out.println("\nThe updated salary is: " + response.jsonPath().getString("salary"));
        System.out.println("\nThe updated gross pay is: " + response.jsonPath().getString("gross"));
        System.out.println("\nThe updated net pay is: " + response.jsonPath().getString("net"));
        System.out.println("\nThe updated number of dependents is: " + response.jsonPath().getString("dependants"));
        System.out.println("\nThe updated benefits cost is: " + response.jsonPath().getString("benefitsCost"));

    }
}
