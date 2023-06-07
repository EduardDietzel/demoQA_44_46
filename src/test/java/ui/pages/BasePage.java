package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void fillField(WebElement field, String value) {
        field.click();
        field.clear();
        field.sendKeys(value);
    }

    public void pressKey(WebElement field, Keys value) {
        field.sendKeys(value);
    }

    public void checkItemText(WebElement element, String expectedText, String err) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, err);
    } // void - означает, что метод ничего не возвращает, просто делает некоторые действия
}
