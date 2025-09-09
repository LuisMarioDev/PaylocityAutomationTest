package RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CreateEmployee extends Base {

    public static final String PathENV = "src/main/resources/.env";

    // Employee data
    public static final String EMPLOYEE_FIRSTNAME = "Kevin";
    public static final String EMPLOYEE_LASTNAME = "Navarro";
    public static final Integer EMPLOYEE_DEPENDENTS = 3;


    // Method to create employee in Paylocity
    public Response createEmployee() {
        // Build JSON using a Map
        Map<String, Object> employeeData = new HashMap<>();
        employeeData.put("firstName", EMPLOYEE_FIRSTNAME);
        employeeData.put("lastName", EMPLOYEE_LASTNAME);
        employeeData.put("dependants", EMPLOYEE_DEPENDENTS);

        Response response = RestAssured.given()
                .baseUri(getBaseURL()) // Paylocity base URL
                .header("Content-Type", "application/json")
                .header(getHeader(), getToken()) // Authorization header
                .body(employeeData) // Map converted to JSON automatically
                .when()
                .post("/api/Employees")
                .then()
                .log().all()
                .extract().response();

        return response;
    }

    // Update .env file
    public void updateEnvFile() {
        Map<String, String> envValues = new HashMap<>();
        envValues.put("EMPLOYEE_FIRSTNAME", EMPLOYEE_FIRSTNAME);
        envValues.put("EMPLOYEE_LASTNAME", EMPLOYEE_LASTNAME);
        envValues.put("EMPLOYEE_DEPENDENTS", EMPLOYEE_DEPENDENTS.toString());
        envValues.put("EMPLOYEE_ID", String.valueOf(createEmployee().jsonPath().getString("id")));

        try (BufferedReader reader = new BufferedReader(new FileReader(PathENV));
             BufferedWriter writer = new BufferedWriter(new FileWriter(PathENV + ".tmp"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String key = line.split("=")[0];
                if (envValues.containsKey(key)) {
                    writer.write(key + "=" + envValues.get(key) + "\n");
                    envValues.remove(key);
                } else {
                    writer.write(line + "\n");
                }
            }

            for (Map.Entry<String, String> entry : envValues.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error updating .env file: " + e.getMessage());
        }

        new File(PathENV + ".tmp").renameTo(new File(PathENV));
    }

    // Print response info
    private void printResponseInfo(Response response) {
        System.out.println("JSON Response:");
        response.prettyPrint();
        System.out.println("Employee ID: " + response.jsonPath().getString("id"));
        System.out.println("First Name: " + response.jsonPath().getString("firstName"));
        System.out.println("Last Name: " + response.jsonPath().getString("lastName"));
        System.out.println("Dependents: " + response.jsonPath().getInt("dependants"));
        System.out.println("Salary: " + response.jsonPath().getDouble("salary"));
        System.out.println("Gross Pay: " + response.jsonPath().getDouble("gross"));
        System.out.println("Net Pay: " + response.jsonPath().getDouble("net"));
        System.out.println("Status Code: " + response.getStatusCode());
    }

    public static void main(String[] args) {
        CreateEmployee createEmployee = new CreateEmployee();
        createEmployee.setup();

        Response response = createEmployee.createEmployee();

        if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
            createEmployee.printResponseInfo(response);
            createEmployee.updateEnvFile();
        } else {
            System.err.println("Error creating employee. Status code: " + response.getStatusCode());
        }
    }
}
