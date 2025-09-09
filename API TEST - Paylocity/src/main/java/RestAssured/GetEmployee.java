package RestAssured;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetEmployee extends CreateEmployee {
    Dotenv dotenv = Dotenv.load();
    public String employeeID = dotenv.get("EMPLOYEE_ID");
    public String employeeName = dotenv.get("EMPLOYEE_FIRSTNAME");

    public Response response() {
        return RestAssured.given()
                .baseUri(getBaseURL())
                .header(getHeader(), getToken())
                .when()
                .get("/api/Employees/" + employeeID)
                .then()
                .extract().
                response().
                prettyPeek();
    }

    public static void main(String[] args) {
        GetEmployee getBoard = new GetEmployee();
        getBoard.setup();

        Response response = getBoard.response();

        if (response != null) {
            System.out.println("Respuesta JSON: ");
            response.prettyPrint();
            System.out.println("\nEl id es: " + response.jsonPath().getString("id"));
            System.out.println("El nombre del tablero es: " + response.jsonPath().getString("name"));
            System.out.println("La descripción del tablero es: " + response.jsonPath().getString("desc"));
            System.out.println("El código de estado es: " + response.getStatusCode());
        } else {
            System.out.println("No se pudo obtener la información del tablero.");
        }
    }
}
