package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {


    @FindBy(css = "button[data-testid='cookie-policy-dialog-accept-button']")
    private WebElement allowAllCookiesButton;

    @FindBy(css = "a[data-testid='open-registration-form-button']")
    private WebElement createNewAccount;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllowAllCookiesButton() {
        allowAllCookiesButton.click();
    }

    public RegistrationPage clickCreateNewAccount() {
        wait.until(ExpectedConditions.visibilityOf(createNewAccount));
        createNewAccount.click();
        return new RegistrationPage(driver);
    }

}
