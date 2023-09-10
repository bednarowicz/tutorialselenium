import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class XpathOnMyOwn {
    @Test
    public void CdAction(){
        WebDriverManager.firefoxdriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cdaction.pl/");
        driver.manage().window().maximize();
        By AkceptujWszystkieCookies = By.xpath("//div[@id='cookiescript_accept']");
        driver.findElement(AkceptujWszystkieCookies).click();
        By News = By.xpath("/html/body/div[1]/header/div/nav/div/a[1]");
        driver.findElement(News).click();
        By recenzje = By.xpath("//a[text()='Recenzje']");
        driver.findElement(recenzje).click();
        By teksty = By.xpath("//svg[@href='/teksty']");
        driver.findElement(teksty).click();
        /html/body/div[1]/header/div/nav/div/a[3]

    }
}
