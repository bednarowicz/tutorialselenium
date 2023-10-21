import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class AnnotationsTest {

    @FindBys({
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th")
    })
    List<WebElement> elements;

    @FindAll({
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th"),
            @FindBy(tagName =  "a")
    })
    List<WebElement> elements1;

    @Test
    public void performAction() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        System.out.println(elements.size());
        System.out.println(elements1.size());
    }
}
