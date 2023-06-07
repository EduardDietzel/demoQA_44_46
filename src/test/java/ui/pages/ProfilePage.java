package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.wait.Wait;

public class ProfilePage extends BasePage {

    Wait wait;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement username;

    // копируем метод waitForLoading из класса к примеру LoginPage
    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(username);
    }

    public void checkUsername(String expectedUsername) {
        super.checkItemText(username, expectedUsername, "Username is not equal to expected");
    }
}
