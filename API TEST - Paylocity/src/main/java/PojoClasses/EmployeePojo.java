package PojoClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos extra
public class EmployeePojo {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private int dependants;
    private double salary;
    private double gross;
    private double benefitsCost;
    private double net;

    @JsonProperty("id")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @JsonProperty("username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonProperty("firstName")
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @JsonProperty("lastName")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @JsonProperty("dependants")
    public int getDependants() { return dependants; }
    public void setDependants(int dependants) { this.dependants = dependants; }

    @JsonProperty("salary")
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @JsonProperty("gross")
    public double getGross() { return gross; }
    public void setGross(double gross) { this.gross = gross; }

    @JsonProperty("benefitsCost")
    public double getBenefitsCost() { return benefitsCost; }
    public void setBenefitsCost(double benefitsCost) { this.benefitsCost = benefitsCost; }

    @JsonProperty("net")
    public double getNet() { return net; }
    public void setNet(double net) { this.net = net; }

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"id\": \"12345\",\n" +
                "    \"username\": \"xluismariox\",\n" +
                "    \"firstName\": \"Luis\",\n" +
                "    \"lastName\": \"Navarro\",\n" +
                "    \"dependants\": 2,\n" +
                "    \"salary\": 2000,\n" +
                "    \"gross\": 52000,\n" +
                "    \"benefitsCost\": 2000,\n" +
                "    \"net\": 50000\n" +
                "}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EmployeePojo employee = objectMapper.readValue(json, EmployeePojo.class);

            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Username: " + employee.getUsername());
            System.out.println("Dependants: " + employee.getDependants());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Gross: " + employee.getGross());
            System.out.println("Benefits Cost: " + employee.getBenefitsCost());
            System.out.println("Net: " + employee.getNet());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
