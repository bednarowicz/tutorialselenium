import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();



    }
    @Test
    public void sampleTest(){
        System.out.println("Hello!");
    }
}
