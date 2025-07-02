package todo.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v135.dom.model.BackendNode;
import org.openqa.selenium.devtools.v135.dom.model.BackendNodeId;
import todo.app.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private final By emailInput= By.cssSelector("[data-testid=email]");
    private final By passwordInput= By.cssSelector("[data-testid=password]");
    private final By submit= By.cssSelector("[data-testid=submit]");


    public void login(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submit).click();
    }

}
