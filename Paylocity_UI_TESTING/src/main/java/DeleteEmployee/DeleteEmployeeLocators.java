package DeleteEmployee;

import org.openqa.selenium.By;

public class DeleteEmployeeLocators {

    //Delete button
    By DeleteButton = By.xpath("//*[@id=\"employeesTable\"]/tbody/tr[1]/td[9]/i[2]");
    //Confirm Delete button
    By ConfirmDeleteButton = By.xpath("//button[@id='deleteEmployee']");
    //Cancel Delete button
    By CancelDeleteButton = By.xpath("//*[@id=\"deleteModal\"]/div/div/div[3]/button[2]");
    //Close delete sign
    By CloseDeleteSign = By.xpath("//*[@id=\"deleteModal\"]/div/div/div[1]/button");
}
