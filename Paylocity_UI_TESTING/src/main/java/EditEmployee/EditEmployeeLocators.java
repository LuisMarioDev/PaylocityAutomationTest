package EditEmployee;

import org.openqa.selenium.By;

public class EditEmployeeLocators {

    //Edit button
    By EditButton = By.xpath("//*[@id=\"employeesTable\"]/tbody/tr[1]/td[9]/i[1]");
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
}
