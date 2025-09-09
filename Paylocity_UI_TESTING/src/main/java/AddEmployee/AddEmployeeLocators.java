package AddEmployee;

import org.openqa.selenium.By;

public class AddEmployeeLocators {

    //Add Employee button   
    By AddEmployeeButton = By.xpath("//button[@id='add']");
    //First name field
    By FirstNameField = By.xpath("//input[@id='firstName']");
    //Last name field
    By LastNameField = By.xpath("//input[@id='lastName']");
    //Dependants field
    By DependantsField = By.xpath("//input[@id='dependants']");
    //Save button
    By SaveButton = By.xpath("//button[@id='saveEmployee']");
    //Cancel button
    By CancelButton = By.xpath("//*[@id=\"employeeModal\"]/div/div/div[3]/button[3]");
    //Add Employee Confirm button
    By AddEmployeeConfirmButton = By.xpath("//button[@id='addEmployee']");
    
}
