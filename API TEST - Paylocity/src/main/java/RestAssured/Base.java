package RestAssured;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;

public class Base {
    private String header;
    private String token;
    private String baseURL;


    public void setup(){
        Dotenv dotenv = Dotenv.load();

        //Set apikey and token
        this.header = dotenv.get("HEADER");
        this.token = dotenv.get("AUTH_TOKEN");

        //Configure RestAssure
        this.baseURL = dotenv.get("URL");
        RestAssured.baseURI = baseURL;
    }

    public String getApikey() {
        return header;
    }

    public String getToken() {
        return token;
    }

    public String getBaseURL() {
        return baseURL;
    }
    
    public String getHeader() {
        return header;
    }

    public static void main(String[]args){
        Base baseTest = new Base();
        baseTest.setup();
        System.out.println("API KEY: " + baseTest.getApikey());
        System.out.println("TOKEN: " + baseTest.getToken());
        System.out.println("BASE URL: " + baseTest.getBaseURL());
    }
}