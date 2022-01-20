package cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.List;

public class StepDefinitions {

    ThreadLocal<Driver> driver = new ThreadLocal<>();
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @Before
    public void setup() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver.set(new Driver(BrowserType.CHROME));
    }

    @Given("I am on the new user registration page")
    public void iAmOnTheNewUserRegistrationPage() {
        driver.get().get("https://www.facebook.com");
    }

    @When("I enter invalid data on the page")
    public void iEnterInvalidDataOnThePage(DataTable table) {
        loginPage = new LoginPage(driver.get());
        loginPage.clickAllowAllCookiesButton();
        registrationPage = loginPage.clickCreateNewAccount();
        List<List<String>> data = table.asLists();
        registrationPage.fillFirstName(data.get(1).get(1));
        registrationPage.fillLastName(data.get(2).get(1));
        registrationPage.fillEmail(data.get(3).get(1));
        registrationPage.fillConfirmEmail(data.get(4).get(1));
        registrationPage.fillPassword(data.get(4).get(1));
        registrationPage.fillMonth(data.get(5).get(1));
        registrationPage.fillDay(data.get(6).get(1));
        registrationPage.fillYear(data.get(7).get(1));
        registrationPage.fillSex(data.get(8).get(1));
        registrationPage.clickSubmit();


//        wait = new WebDriverWait(driver, 5);
//        List<List<String>> data = table.asLists();
//        System.out.println(data.get(1).get(0) + ": " + data.get(1).get(1));
//        driver.findElement(By.cssSelector("button[data-testid = 'cookie-policy-dialog-accept-button']")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[data-testid = 'open-registration-form-button']")));
//        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
//
//        //Enter data
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
//        driver.findElement(By.name("firstname")).sendKeys(data.get(1).get(1));
//        driver.findElement(By.name("lastname")).sendKeys(data.get(2).get(1));
//        driver.findElement(By.name("reg_email__")).sendKeys(data.get(3).get(1));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
//        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(data.get(3).get(1));
//        driver.findElement(By.name("reg_passwd__")).sendKeys(data.get(4).get(1));
//        Select month = new Select(driver.findElement(By.name("birthday_month")));
//        month.selectByValue(data.get(6).get(1));
//        Select day = new Select(driver.findElement(By.name("birthday_day")));
//        day.selectByValue(data.get(5).get(1));
//        Select year = new Select(driver.findElement(By.name("birthday_year")));
//        year.selectByValue(data.get(7).get(1));
//        driver.findElement(By.xpath("//label[text()='" + data.get(8).get(1)+"']")).click();
//        driver.findElement(By.name("websubmit")).click();

    }

    @Then("The user registration should be unsuccessful")
    public void theUserRegistrationShouldBeUnsuccessful() {
        if (driver.get().getCurrentUrl().contains("confirmemail")) {
            System.out.println("Failed");
        } else System.out.println("Passed");

        //Assertions.assertTrue(!driver.getCurrentUrl().contains("confirmemail"));
    }

    @After
    public void cleanUp() {
        driver.get().close();
        driver.get().quit();
    }
}
