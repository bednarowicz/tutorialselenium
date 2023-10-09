package pl.teseroprogramowania;

import org.testng.annotations.Test;

public class ThirdTest extends BaseTest {
    
    @Test(priority = 2)
    public void FirstTest() {
        System.out.println("I am first test.");

    }
    
    @Test(priority = 0)
    public void SecondTest() {
        System.out.println("I am second test.");
        
    }

    @Test(priority = 1)
    public void ThirdTest() {
        System.out.println("I am third test.");
        
    }
}
