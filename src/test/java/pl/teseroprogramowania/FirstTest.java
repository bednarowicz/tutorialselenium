package pl.teseroprogramowania;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstTest extends BaseTest {
    WebDriver driver;

    @Test
    public void FirstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        ;
        driver.findElement(By.id("clickOnMe")).click();
        //Thread.sleep(5000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        //WebElement para = driver.findElement(By.cssSelector("pa"));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        // driver.findElement(By.cssSelector("p"));

        waitForElementToExist(By.cssSelector("p"));

        String paraText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
        driver.quit();
    }
    @Test
    public void SecondTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        ;
        driver.findElement(By.id("clickOnMe")).click();
        //Thread.sleep(5000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        //WebElement para = driver.findElement(By.cssSelector("pa"));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        // driver.findElement(By.cssSelector("p"));

        waitForElementToExist(By.cssSelector("p"));

        String paraText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
        driver.quit();
    }

    /*public void waitForElementToExist(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until(new Function<WebDriver, Boolean>() {
            @Override
                    public Boolean apply(WebDriver driver){
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size()>0){
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Elementu nie ma na stronie");
                    return false;
                }
            }
        });
    }*/
    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver) -> {
                    List<WebElement> elements = driver.findElements(locator);
                    if (elements.size() > 0) {
                        System.out.println("Element jest na stronie");
                        return true;
                    } else {
                        System.out.println("Elementu nie ma na stronie");
                        return false;
                    }
                }
        );
    }
}

