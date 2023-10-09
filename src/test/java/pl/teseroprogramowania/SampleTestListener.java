package pl.teseroprogramowania;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleTestListener implements ITestListener{

    private TakesScreenshot driver;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestFailure(result);
                // TODO Auto-generated method stub
        //ITestListener.super.onTestFailure(result);
        WebDriver driver = DriverFactory.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        int randomNumber = (int) (Math.random()*100);
        //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String timeNow = java.time.LocalDateTime.now();
        try{ 
        FileUtils.copyFile(srcFile, new File("src/test/resources/screenshot failed assert" + randomNumber + ".png"));}
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSuccess(result);
    }
    
}
