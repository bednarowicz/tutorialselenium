import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.DriverManager;

public class CssSelectorsGoogle {
    @Test
    public void selektoryGoogle(){
        WebDriverManager.firefoxdriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.pl/");
        driver.manage().window().maximize();

        //By zakceptujWszystko = By.cssSelector("div[class='QS5gu sy4vM'");
        By zakceptujWszystko = By.cssSelector("#L2AGLb > div:nth-child(1)");
        driver.findElement(zakceptujWszystko).click();
        By adresGmail = By.cssSelector("[href*='mail.google.com/mail']");
        driver.findElement(adresGmail);
        By adresGoogleGrafika = By.cssSelector("[href*='www.google.pl/img']");
        driver.findElement(adresGmail);
        By googleNadPolemUzupelnialnym = By.cssSelector(".lnXdpd");
        driver.findElement(googleNadPolemUzupelnialnym);
        By lupa = By.cssSelector(".QCzoEc > svg:nth-child(1)");
        driver.findElement(lupa);
        By opcjeGoogle = By.cssSelector("body a[aria-label^=Aplikacje]");
        driver.findElement(opcjeGoogle).click();
        driver.findElement(opcjeGoogle).click();
        By poleUzupelnialne = By.cssSelector("textarea[id=APjFqb]");
        driver.findElement(poleUzupelnialne).sendKeys("bednarowicz git hub");
       // driver.findElement(By.cssSelector("div.o3j99:nth-child(4)")).click();
        By szukahWGoogleButton = By.cssSelector(".gNO89b[data-ved$='A0'");
        driver.findElement(szukahWGoogleButton).click();



    }
}
