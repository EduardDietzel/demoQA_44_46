package e2e;

import api.RegistrationApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.LoginPage;
import ui.pages.ProfilePage;

public class RegistrationNewUserTest extends TestBase {

    // создаем переменную и типизируем её как RegistrationApi
    RegistrationApi registrationApi;
    Response response;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Test
    public void registrationNewUserViaApiAndLoginViaUITest() {
        // делаем метод регистрации нового пользователя
        String password = "yA*UeeuA2pU3";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(201, password);
        // заводим переменную userName, значение которой вытаскиваем по ключу "username"
        String userName = response.jsonPath().getString("username");
        // String password = registrationApi.randomDataBodyForRegistration().getPassword();

        loginPage = new LoginPage(app.driver);
        // нам всегда надо заводить waitForLoading, чтобы дать возможность подгрузиться и дождаться основных элементов
        loginPage.waitForLoading();
        // применяем полученные данные чтобы залогиниться
        loginPage.fillLoginForm(userName, password);
        // ввели все данные и нажимаем кнопку "Логин"
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
        profilePage.checkUsername(userName);
    }

    @Test
    public void newUserNotRegisterViaApiAndLoginViaUITest() {
        String invalidPassword = "5665765342";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(400, invalidPassword);
        String errMessage = response.jsonPath().getString("message");
        String userName = registrationApi.randomDataBodyForRegistration(invalidPassword).getPassword();
        String expectedErrorMessage = "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";
        Assert.assertEquals(errMessage, expectedErrorMessage, "Error Message is not correct");

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, invalidPassword);
        loginPage.clickLoginButton();
        loginPage.waitForLoading();
    }

}
