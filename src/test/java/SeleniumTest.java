import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SeleniumTest {

    @Test
    public void openGooglePage(){
        /*WebDriver driver = getDriver("MS Edge");
        driver.manage().window().maximize();
        //Dimension windowSize = new Dimension(200, 200);
        //driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.com");
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("window.open('https://www.google.com','blank','height=200,width=200')");
        //driver.quit();
        //driver.close();*/
        WebDriver driver = getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        // klikniecie przycisku
        agreeButton.click();
        // znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // wprowadz wartosc Selenium do pola
        searchField.sendKeys("Selenium");
        // zasymuluj nacisniecie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        // znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());
    }
    public WebDriver getDriver(String name) throws IllegalArgumentException {
        switch(name){
            case "MS Edge":
               // System.setProperty("webdriver.edge.driver", "C:\\Users\\Rafi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "FireFox":
               // System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rafi\\Downloads\\geckodriver-v0.33.0-win64 (1)\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "Chrome":
               // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
        throw new IllegalArgumentException("Podano nie poprawna przegladarke.");
    }
}
