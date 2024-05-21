package com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class OrangeHrmLiveMultiBrowser {
    static String browser = "Firefox";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else{
            System.out.println("Wrong browser name");
        }
        //Open URL.
        driver.get(baseUrl);
        // Maximise the browser window
        driver.manage().window().maximize();
        // We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Print the title of the page.
        String getTitle = driver.getTitle();
        System.out.println("Page Title: " +getTitle);
        //Print the current url.
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Page Current URL: " +currentUrl);
        //Print the page source.
        String pageSource = driver.getPageSource();
        System.out.println("Page Page Source: " +pageSource);
        //Click on ‘Forgot your password?’ link.
        WebElement forgotPassword = driver.findElement(By.className("orangehrm-login-forgot-header"));
        forgotPassword.click();
        //Print the current url.
        String prtCurrentUrl = driver.getCurrentUrl();
        System.out.println("Page Current URL: " +prtCurrentUrl);
        //Navigate back to the login page.
        driver.navigate().back();
        //Refresh the page.
        driver.navigate().refresh();
        //Enter the email to email field.
        WebElement emailID = driver.findElement(By.name("username"));
        emailID.sendKeys("Admin");
        //Enter the password to password field.
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        //Click on Login Button.
        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();
        //Close the browser.
        driver.quit();

    }
}
