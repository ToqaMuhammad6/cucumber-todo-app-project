package todo.app.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import todo.app.factory.DriverFactory;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup(){
        driver= DriverFactory.initDriver();
    }


    @After
    public void teardown(){
        driver.quit();
    }
}
