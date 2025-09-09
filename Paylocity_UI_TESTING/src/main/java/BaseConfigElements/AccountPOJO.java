package BaseConfigElements;

public class AccountPOJO {
    private String Username;
    private String Password;
    private String FirstName;
    private String LastName;
    private Integer Dependants;
        

    public void setPassword(String password) {
        Password = password;
    }
        
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getDependants() {
        return Dependants;
    }

    public void setDependants(Integer dependants) {
        Dependants = dependants;
    }
}