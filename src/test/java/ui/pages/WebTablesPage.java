package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.wait.Wait;

public class WebTablesPage extends BasePage {

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(xpath = "//input[@id='searchBox']")
    WebElement typeToSearch;

    public WebElement makeRowLocator(String name) {
        return driver.findElement(By.xpath("//*[@role='row']//*[contains(text(), '" + name + "')]/ancestor::*[@role='row']"));
    }

    public void clickOnAddButton() {
        click(addButton);
    }

    public void filterBy(String text) {
        fillField(typeToSearch, text);
    }

    public void clickOnEditButton(String name) {
        makeRowLocator(name).findElement(By.xpath("//*[@title='Edit']")).click();
    }

    public void clickOnDeleteButton(String name) {
        makeRowLocator(name).findElement(By.xpath("//*[@title='Delete']")).click();
    }

}
