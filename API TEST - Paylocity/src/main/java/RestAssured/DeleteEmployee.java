package RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteEmployee extends UpdateEmployee{
    public Response response (){
        return RestAssured.given()
                .baseUri(getBaseURL())
                .header(getHeader(), getToken())
                .when()
                .delete("/api/Employees/" + employeeID)
                .then()
                .extract().
                response().
                prettyPeek();
    }

    public static void main (String [] args){
        DeleteEmployee deleteEmployee = new DeleteEmployee();
        deleteEmployee.setup();

        Response response = deleteEmployee.response();

        System.out.println("Respuesta JSON: ");
        response.prettyPrint();
        System.out.println("\n El nombre del tablero borrado es: " + deleteEmployee.employeeName);
        System.out.println("\n Se ha borrado el tablero con el siguiente ID: " + deleteEmployee.employeeID);
        System.out.println("\n El código de estado es: " + response.getStatusCode());
    }
}
