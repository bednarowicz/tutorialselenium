import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By buttonid = By.xpath("//button[@id='clickOnMe']");
        //WebElement clickOnButton = driver.findElement(buttonid);
        //clickOnButton.click();
        //driver.findElement(buttonid).click();

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        WebElement firstNameInput = driver.findElement(firstName);

        //klasy
        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement showLink = driver.findElement(linkText);

        By partialLink = By.xpath("//a[contains(text(),'W3Schools')]");
        WebElement showLinkPartial = driver.findElement(partialLink);

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        By sttrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//*[@id!='clickOnMe']");
        By attrCon = By.xpath("//*[contains(@name,'ame')]");
        By startWith = By.xpath("//*[starts-with(@name,'user')]");
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']");

        driver.findElement(sttrEq);
        driver.findElement(attrNotEq);
        driver.findElement(attrCon);
        driver.findElement(startWith);
        driver.findElement(endsWith);

        By child = By.xpath("//div/child::ul");
        By parent = By.xpath("//div/../..");
        By desc = By.xpath("//div/descendant::*");
        By asc = By.xpath(("//div/ancestor::*"));
        By foll = By.xpath("//img/following::*");
        By follSib = By.xpath("//img/following-sibling::*");
        By prec = By.xpath("//img/preceding::*");
        By precSib = By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(parent);
        driver.findElement(desc);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follSib);
        driver.findElement(prec);
        driver.findElement(precSib);

        By divAndLinks = By.xpath("//a | //input");
        By AndXpath = By.xpath("//input[@name='fname' and @id='fname']");
        By OrXpath = By.xpath(("//input[@name='fname' or @id='fanme']"));

        driver.findElement(divAndLinks);
        driver.findElement(AndXpath);
        driver.findElement(OrXpath);



    }
}
