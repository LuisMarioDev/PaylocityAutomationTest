package Login;

import org.openqa.selenium.By;

public class LoginLocators {
    //Username input field
    By Usernameinput = By.xpath("//input[@id='Username']");
    //Password input field
    By Passwordinput = By.xpath("//input[@id='Password']");
    //Login button
    By LoginButton = By.xpath("//button[@class='btn btn-primary']");
    //Error sign
    By errorSign = By.xpath("//div[@class='text-danger']");
    //Log out button
    By logoutbutton = By.xpath("/html/body/header/nav/div/ul/li/a");
}
