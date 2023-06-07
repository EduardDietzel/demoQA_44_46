package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.SelectPage;

public class SelectsAllTest extends TestBase {

    SelectPage selectPage;

    @Test
    public void checkSelectValue() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectValueDropdown("Group 1, option 2");
        Thread.sleep(5000);
    }

    @Test
    public void checkOldSelectValue() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectOldDropdown("8");
        Thread.sleep(5000);
    }

    @Test
    public void checkStandardMultiValue() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
//        selectPage.selectStandardMulti();
    }
}
