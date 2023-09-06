import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage(){
        WebDriver driver = WebDriverFinal("MS Edge");
        driver.get("https://www.google.com");
    }
    public WebDriver WebDriverFinal(String name) throws IllegalArgumentException {
        switch(name){
            case "MS Edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\Rafi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                return new EdgeDriver();
            case "FireFox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rafi\\Downloads\\geckodriver-v0.33.0-win64 (1)\\geckodriver.exe");
                return new FirefoxDriver();
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                return new ChromeDriver();
        }
        throw new IllegalArgumentException("Podano nie poprawna przegladarke.");
    }
}
