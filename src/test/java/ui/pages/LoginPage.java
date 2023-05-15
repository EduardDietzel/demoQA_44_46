package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.wait.Wait;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(id = "")
    public WebElement usernameField;

    @FindBy(id = "")
    public WebElement passwordField;

    @FindBy(id = "")
    public WebElement loginButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(usernameField);
        wait.forVisibility(passwordField);
        wait.forVisibility(loginButton);
    }

    public void fillLoginForm(String username, String password) {
        fillField(usernameField, username);
        fillField(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }
}
