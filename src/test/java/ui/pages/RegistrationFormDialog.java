package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormDialog extends WebTablesPage {
    public RegistrationFormDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='modal-content']")
    WebElement dialog;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userEmailField;

    @FindBy(xpath = "//input[@id='age']")
    WebElement ageField;

    @FindBy(xpath = "//input[@id='salary']")
    WebElement salaryField;

    @FindBy(xpath = "//input[@id='department']")
    WebElement departmentField;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

    public void checkOpenedDialog() {
        dialog.isDisplayed();
    }

    public void fillRegistrationForm(String name, String lastName, String email, String age, String salary, String department) {
        fillField(firstNameField, name);
        fillField(lastNameField, lastName);
        fillField(userEmailField, email);
        fillField(ageField, age);
        fillField(salaryField, salary);
        fillField(departmentField, department);
    }

    public void clickOnSubmitButton() {
        click(submitButton);
    }
}
