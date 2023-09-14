import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class BasicActionsTest {
    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        driver.findElement(By.id("fname")).sendKeys("Rafał");
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("Moj login");
        System.out.println(userNameInput.getText());
        System.out.println(userNameInput.getAttribute("value"));
        userNameInput.sendKeys(Keys.ENTER);
        //userNameInput.sendKeys(Keys.TAB);
        Alert firstAlert = driver.switchTo().alert();;
        firstAlert.accept();
        driver.switchTo().alert().accept();


        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        // cars.selectByIndex(2);
        cars.selectByVisibleText("Saab");
        cars.selectByValue("volvo");

        List<WebElement> options = cars.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        optionsChecker(selectCar, "auto");
        optionsChecker(selectCar, "Volvo");

        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text: " + para.getText());
        System.out.println("By text: " + para.getAttribute("value"));
        System.out.println("By text: " + para.getAttribute("textContent"));


    }

    public boolean optionsChecker(WebElement elementZOpcjami, String szukanyTekst){

        Select opcjeSelect = new Select(elementZOpcjami);
        List<WebElement> opcje = opcjeSelect.getOptions();
        for (WebElement opcja: opcje){
            if (opcja.getText().equals(szukanyTekst)){
                System.out.println("Szukany tekst byl w liscie.");
                return true;
            }
        }
        System.out.println("Szukanego tekstu nie bylo w liscie.");
        return false;

    }
}
