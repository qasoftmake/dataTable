package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "firstname")
    protected WebElement firstName;

    @FindBy(name = "lastname")
    protected WebElement lastName;

    @FindBy(name = "reg_email__")
    protected WebElement email;

    @FindBy(name = "reg_email_confirmation__")
    protected WebElement confirmEmail;

    @FindBy(name = "reg_passwd__")
    protected WebElement password;

    @FindBy(name = "birthday_day")
    protected WebElement day;

    @FindBy(name = "birthday_month")
    protected WebElement month;

    @FindBy(name = "birthday_year")
    protected WebElement year;

    @FindBy(name = "websubmit")
    protected WebElement submitButton;

    public void fillFirstName(String usernameValue) {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(usernameValue);
    }

    public void fillLastName(String usernameValue) {
        lastName.sendKeys(usernameValue);
    }

    public void fillEmail(String emailValue) {
        email.sendKeys(emailValue);
    }

    public void fillPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public void fillConfirmEmail(String emailValue) {
        confirmEmail.sendKeys(emailValue);
    }

    public void fillMonth(String monthValue) {
        Select monthSelector = new Select(month);
        monthSelector.selectByValue(monthValue);
    }

    public void fillDay(String dayValue) {
        Select monthSelector = new Select(day);
        monthSelector.selectByValue(dayValue);
    }

    public void fillYear(String yearValue) {
        Select monthSelector = new Select(year);
        monthSelector.selectByValue(yearValue);
    }

    public void fillSex(String sexValue) {
        WebElement sex = driver.findElement(By.xpath("//label[text()='" + sexValue + "']/..//input[@name=\"sex\"]"));
        sex.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
