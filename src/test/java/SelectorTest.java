import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By buttonid = By.id("clickOnMe");
        //WebElement clickOnButton = driver.findElement(buttonid);
        //clickOnButton.click();
        //driver.findElement(buttonid).click();

        //fname
        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);

        //klasy
        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement showLink = driver.findElement(linkText);

        By partialLink = By.partialLinkText("Visit");
        WebElement showLinkPartial = driver.findElement(partialLink);

    }
}
