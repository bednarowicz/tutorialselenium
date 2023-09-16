import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class iframeTest {
    @Test
    public void NewWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        //driver.switchTo().frame(0);
        driver.switchTo().frame(iframe);
        //driver.switchTo().frame("wartosc id lub wartosc name"); gdyby byl atrybut id lub name dla tagu frame
        driver.findElement(By.id("fname")).sendKeys("Rafal");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());


    }
}
