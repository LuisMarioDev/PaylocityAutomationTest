package AssertJ;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateEmployee extends RestAssured.CreateEmployee {
    private static CreateEmployee createEmployee;

    private String readEnvFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private void writeEnvFile(String path, String content) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setupGB() {
        createEmployee = new CreateEmployee();
        createEmployee.setup();
    }

    @Test
    public void testCreateEmployee() {
        Response response = createEmployee.createEmployee();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.body().jsonPath().getString("firstName"))
                .as("The first name doesn't match")
                .isEqualTo(EMPLOYEE_FIRSTNAME);

        assertThat(response.body().jsonPath().getString("lastName"))
                .as("The last name doesn't match")
                .isEqualTo(EMPLOYEE_LASTNAME);

        assertThat(response.body().jsonPath().getString("dependants"))
                .as("The dependants don't match")
                .isEqualTo(EMPLOYEE_DEPENDENTS);

    }

    @Test
    public void testUpdateEnvFile() {
        createEmployee.updateEnvFile();

        String envContent = readEnvFile(PathENV);

        assertThat(envContent).contains("EMPLOYEE_FIRSTNAME=" + EMPLOYEE_FIRSTNAME);
        assertThat(envContent).contains("EMPLOYEE_LASTNAME=" + EMPLOYEE_LASTNAME);
        assertThat(envContent).contains("EMPLOYEE_DEPENDENTS=" + EMPLOYEE_DEPENDENTS);
    }
}
