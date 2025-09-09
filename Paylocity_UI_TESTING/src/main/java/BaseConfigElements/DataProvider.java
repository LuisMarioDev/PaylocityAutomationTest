package BaseConfigElements;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class DataProvider {
    public static List<AccountPOJO> getTestAccounts(){
        try{
            Gson gson = new Gson();
            Reader reader = new FileReader("src/test/resources/accounts.json");
            return gson.fromJson(reader, new TypeToken<List<AccountPOJO>>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Error reading the JSON File", e);
        }
    }
}