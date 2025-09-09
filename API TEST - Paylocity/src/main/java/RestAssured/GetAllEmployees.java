package RestAssured;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetAllEmployees extends Base {
    Dotenv dotenv = Dotenv.load();

    public Response buildRequest(){

        return RestAssured.given()
                .baseUri(getBaseURL())
                .header(getHeader(), getToken())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Employees")
                .then()
                .extract().
                response().
                prettyPeek();
    }

    public String IdRequest(){
        Response response = buildRequest();
        return response.jsonPath().getString("id");
    }


    public static void main(String[]args){
        GetAllEmployees buildRequest = new GetAllEmployees();

        buildRequest.setup();

        Response response = buildRequest.buildRequest();

        
        response.prettyPrint();
        
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Complete JSON response");
        System.out.println("ID of the first employee: " + buildRequest.IdRequest());
        System.out.println("Response Time: " + response.getTimeIn(TimeUnit.MILLISECONDS) + " ms");
        System.out.println("Content Type: " + response.getContentType());
        System.out.println("Status Line: " + response.getStatusLine());        

    }
}