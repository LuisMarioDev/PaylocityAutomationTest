package BaseConfigElements;

import org.openqa.selenium.By;

public interface BaseLocators{
    
    //Username input field
    By Usernameinput = By.xpath("//input[@id='Username']");
    //Password input field
    By Passwordinput = By.xpath("//input[@id='Password']");
    //Login button
    By LoginButton = By.xpath("//button[@class='btn btn-primary']");
    //Edit button
    By EditButton = By.xpath("//*[@id=\"employeesTable\"]/tbody/tr[1]/td[9]/i[1]");
    //Delete button
    By DeleteButton = By.xpath("//*[@id=\"employeesTable\"]/tbody/tr[1]/td[9]/i[2]");
    //Add Employee button
    By AddEmployeeButton = By.xpath("//button[@id='add']");
    //Log out button
    By LogoutButton = By.xpath("/html/body/header/nav/div/ul/li/a");
    //Edit first name field
    By EditFirstName = By.xpath("//input[@id='firstName']");
    //Edit last name field
    By EditLastName = By.xpath("//input[@id='lastName']");
    //Edit dependants field
    By EditDependants = By.xpath("//input[@id='dependants']");
    //Update button
    By UpdateButton = By.xpath("//button[@id='updateEmployee']");
    //Cancel button
    By CancelButton = By.xpath("//*[@id=\"employeeModal\"]/div/div/div[3]/button[3]");
    //Close button
    By CloseButton = By.xpath("//*[@id=\"employeeModal\"]/div/div/div[1]/button");
    //Confirm Delete button
    By ConfirmDeleteButton = By.xpath("//button[@id='deleteEmployee']");
    //Cancel Delete button
    By CancelDeleteButton = By.xpath("//*[@id=\"deleteModal\"]/div/div/div[3]/button[2]");
    //Close delete sign
    By CloseDeleteSign = By.xpath("//*[@id=\"deleteModal\"]/div/div/div[1]/button");
    //Error sign
    By errorSign = By.xpath("//div[@class='text-danger']");
}
