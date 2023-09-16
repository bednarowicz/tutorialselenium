import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;

public class ActionsTest {
    @Test
    public void actions(){
        int randomNumber = (int)(Math.random()*1000);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        //actions.contextClick(driver.findElement(By.id("myFile"))).perform();
        WebElement doubleClickButton = driver.findElement(By.id("bottom"));
        actions.doubleClick(doubleClickButton).perform();
    }
}
