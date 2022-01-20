import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StepDefinitions {

    private WebDriver driver = null;
    private WebDriverWait wait;

    @Given("I am on the new user registration page")
    public void iAmOnTheNewUserRegistrationPage() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
    }

    @When("I enter invalid data on the page")
    public void iEnterInvalidDataOnThePage(DataTable table) {
        wait = new WebDriverWait(driver, 5);
        List<List<String>> data = table.asLists();
        System.out.println(data.get(1).get(0) + ": " + data.get(1).get(1));
        driver.findElement(By.cssSelector("button[data-testid = 'cookie-policy-dialog-accept-button']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[data-testid = 'open-registration-form-button']")));
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();

        //Enter data
        driver.findElement(By.name("firstname")).sendKeys(data.get(1).get(1));
        driver.findElement(By.name("lastname")).sendKeys(data.get(2).get(1));
        driver.findElement(By.name("reg_email__")).sendKeys(data.get(3).get(1));
        driver.findElement(By.name("password")).sendKeys(data.get(4).get(1));
        Select month = new Select(driver.findElement(By.name("month")));
        month.selectByValue(data.get(6).get(1));
        Select day = new Select(driver.findElement(By.name("day")));
        day.selectByValue(data.get(5).get(1));
        Select year = new Select(driver.findElement(By.name("year")));
        year.selectByValue(data.get(7).get(1));
        driver.findElement(By.xpath("//label[text()='" + data.get(8).get(1)+"']"));
        driver.findElement(By.name("name='websubmit'")).click();

    }

    @Then("The user registration should be unsuccessful")
    public void theUserRegistrationShouldBeUnsuccessful() {
    }
}
