package todo.app.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import todo.app.factory.DriverFactory;
import todo.app.pages.LoginPage;
import todo.app.pages.TodoPage;
import todo.app.utils.EnvUtils;

import java.io.IOException;
import java.time.Duration;

public class UserSteps {

    WebDriver driver;

    @Given("User is at the login page")
    public void userIsATTheLoginPage() throws IOException {
        driver= DriverFactory.getDriver();
        new LoginPage(driver).load(EnvUtils.getInstance().getURL() + "/login");

    }

    @When("User fill the email and password and login")
    public void userFillTheEmailAndPassword() throws IOException {
       new LoginPage(driver).login(EnvUtils.getInstance().getEmail(), EnvUtils.getInstance().getPassword());



    }

    @Then("welcome message should be displayed")
    public void welcomeMessageShouldBeDisplayed() throws InterruptedException {
        boolean isWelcomeDisplayed =  new TodoPage(driver).isWelcomeDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
        Thread.sleep(5000);
        driver.quit();


    }

}
