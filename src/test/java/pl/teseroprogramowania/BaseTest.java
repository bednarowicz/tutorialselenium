import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am running before test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am running before method.");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am running after test");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am running after method.");
    }
}
