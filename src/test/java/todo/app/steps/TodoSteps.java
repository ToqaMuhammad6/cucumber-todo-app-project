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
import todo.app.pages.NewTodoPage;
import todo.app.pages.TodoPage;
import todo.app.utils.EnvUtils;

import java.io.IOException;
import java.time.Duration;


public class TodoSteps {

    WebDriver driver;

    @Given("User is at the todos page")
    public void userISAtTheTodosPage() throws IOException {

        driver= DriverFactory.getDriver();
        LoginPage loginPage= new LoginPage(driver);

        loginPage.load(EnvUtils.getInstance().getURL() + "/login");


        loginPage.login(EnvUtils.getInstance().getEmail(),EnvUtils.getInstance().getPassword());

    }

    @When("User add a new todo")
    public void userAddANewTodo(){
        new TodoPage(driver).plusButtonClick();
        new NewTodoPage(driver).addTodo("Learn Cucumber");



    }

    @Then("Todo should be added correctly")
    public void todoShouldBeAddedCorrectly(){
        String text= new TodoPage(driver).getLastTodoText();
        Assert.assertEquals(text, "Learn Cucumber");

        driver.quit();

    }
}
