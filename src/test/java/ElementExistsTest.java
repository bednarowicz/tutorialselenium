import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistsTest {
    WebDriver driver;
    @Test
    public void elementExistsTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));

        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        WebElement checbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checbox.isSelected());
        checbox.click();
        System.out.println(checbox.isSelected());

    }
    public boolean elementExist(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }
    public boolean elementExistSecond(By locator){

            return driver.findElements(locator).size()>0;

    }
}
