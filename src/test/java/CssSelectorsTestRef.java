import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTestRef {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("element input");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName).sendKeys("2element input");

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        driver.findElement(all);

        By ulInsideDiv = By.cssSelector("div ul");
        By trnTable = By.cssSelector("table tr");
        By trInBody = By.cssSelector("tbody tr");

        driver.findElement(ulInsideDiv);
        driver.findElement(trnTable);
        driver.findElement(trInBody);

        By firsCHildUlinDiv = By.cssSelector("div > ul");
        By firsCHildTrInTbody = By.cssSelector("tbody > tr");

        driver.findElement(firsCHildUlinDiv);
        driver.findElement(firsCHildTrInTbody);

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormAfterLabel = By.cssSelector("label ~ form");

        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormAfterLabel);

        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='name']");
        By attrStart = By.cssSelector("[name^='f']");
        By attrEnds = By.cssSelector("[name$='name']");

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStart);
        driver.findElement(attrEnds);

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By thirdChild = By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);


    }
}
