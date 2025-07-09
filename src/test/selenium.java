package com.example;
 
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class SeleniumTest {
    @Test
    public void testGoogleHomepageTitle() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
 
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
 
        String title = driver.getTitle();
        Assert.assertEquals("Google", title);
 
        driver.quit();
    }
}
