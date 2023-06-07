package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.wait.Wait;

import java.util.List;


public class SelectPage extends BasePage {
    Wait wait;

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "withOptGroup")
    WebElement selectValueDropdown;

    @FindBy(id = "react-select-2-input")
    WebElement selectOptionInput;

    @FindBy(id = "selectOne")
    WebElement selectOneDropdown;

    @FindBy(id = "oldSelectMenu")
    WebElement selectOldDropdown;

    @FindBy(id = "oldSelectMenu")
    WebElement standardMultiSelect;

    @FindBy(id = "react-select-4-input")
    WebElement multiSelectDropDown;

    @FindBy(css = "[class=' css-yk16xz-control']")
    WebElement thirdInput;

    public void goToSelectPage() {
        driver.get("https://demoqa.com/select-menu");
        wait = new Wait(driver);
        wait.forVisibility(selectValueDropdown);
    }

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(selectValueDropdown);
        wait.forVisibility(selectOptionInput);
    }

    public void selectValueDropdown(String inputValue) {
        click(selectValueDropdown);
        fillField(selectOptionInput, inputValue);
        pressKey(selectOptionInput, Keys.ENTER);
        // driver.findElement(By.id("withOptGroup")).click();
        // wait.forVisibility(firstInput);
//        driver.findElement(By.id("react-select-2-input")).sendKeys(inputValue);
//        driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
    }

    public void selectOneDropdown(String inputValue) {
        click(selectValueDropdown);
        fillField(standardMultiSelect, inputValue);
        pressKey(standardMultiSelect, Keys.ENTER);
//        driver.findElement(By.id("selectOne")).click();
//        wait.forVisibility(secondInput);
//        driver.findElement(By.id("react-select-3-input")).sendKeys(inputValue);
//        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }

    public void selectOldDropdown(String text) {
        Select select = new Select(selectOldDropdown);
        select.selectByVisibleText(text);
//        WebElement selectElement = driver.findElement(By.id("oldSelectMenu"));
//        select.selectByValue(value);
//        select.selectByIndex(0);
    }

    public void standardMultiSelect(List<String> values) {
        // WebElement selectElement = driver.findElement(By.id("cars"));
        Select select = new Select(standardMultiSelect);
        for (String value : values) {
            select.selectByValue(value);
        }

    }
}