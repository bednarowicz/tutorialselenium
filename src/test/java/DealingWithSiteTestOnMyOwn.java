import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.Selector;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.Executor;

public class DealingWithSiteTestOnMyOwn {
    @Test
    public void playingWithSite() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        WebElement kliknijMnie = driver.findElement(By.id("clickOnMe"));
        kliknijMnie.click();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        WebElement firstName = driver.findElement(By.cssSelector("#fname"));
        firstName.sendKeys(alertText);
        WebElement googleLink = driver.findElement(By.xpath("//a[contains(text(),'IamWeird')]"));
        googleLink.click();
        WebElement zakceptujZgodyGoogle = driver.findElement(By.xpath("//*[text()='Zaakceptuj wszystko']"));
        zakceptujZgodyGoogle.click();

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/resources/screenshotGoogle.png"));

        WebElement poleWyszukiwaniaGoogle = driver.findElement(By.cssSelector("#APjFqb"));
        poleWyszukiwaniaGoogle.sendKeys("bednarowicz github");
        poleWyszukiwaniaGoogle.sendKeys(Keys.ENTER);
        //driver.close();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.history.go(-2)");
        WebElement oszczednosci = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(2) > td:nth-child(2)"));
        //        /html/body/table/tbody/tr[2]/td[2]
        //body > table > tbody > tr:nth-child(2) > td:nth-child(2)
        System.out.println("Zaoszczedzono: " + oszczednosci.getText());
        WebElement listaSamochodow = driver.findElement(By.tagName("select"));
        Select samochody = new Select(listaSamochodow);
        samochody.selectByVisibleText("Audi");
        WebElement zgodaNieczytanieRegulaminu = driver.findElement(By.cssSelector("[type='checkbox']"));
        zgodaNieczytanieRegulaminu.click();
        WebElement genderMale = driver.findElement(By.cssSelector("form > input[value='male']"));
        genderMale.click();
        WebElement nazwaUzytkownika = driver.findElement(By.cssSelector("form > input[type='text']"));
        WebElement haslo = driver.findElement(By.cssSelector("form > input[type='password']"));
        nazwaUzytkownika.clear();
        nazwaUzytkownika.sendKeys("rafal123");
        haslo.clear();
        haslo.sendKeys("przykladoweHaslo");
        WebElement submit = driver.findElement(By.cssSelector("form > input[type='submit']"));
        submit.click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        String akutalnaStrona = driver.getWindowHandle();
        WebElement clickMe = driver.findElement(By.id("newPage"));
        clickMe.click();
        //String google = driver.getWindowHandle(); zle dzialalo
        String google = null;
        Set<String> otwarteStrony = driver.getWindowHandles();
        for (String strona : otwarteStrony){
            System.out.println("Strona " + strona);
            if(strona != akutalnaStrona ){
                google = strona;
            }
        }
        driver.switchTo().window(akutalnaStrona);
        driver.switchTo().window(google);
        driver.close();
        driver.quit();
    }
}
