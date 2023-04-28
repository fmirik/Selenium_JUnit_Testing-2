package example.selenium_junit_testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class AT02 {
    // 2. Home page with three Arrivals only
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Arrivals only
    //6) The Home page must contains only three Arrivals


    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*").addExtensions(new File("./extension.crx"));//uBlock Origin Extension
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void test02() throws InterruptedException {
        Thread.sleep(3000);//Extension load
        driver.get("http://practice.automationtesting.in/");

        //Click on Shop Menu
        WebElement shopMenu = driver.findElement(By.xpath("//a[.='Shop']"));
        shopMenu.click();

        //Now click on Home menu button
        WebElement homeMenu = driver.findElement(By.xpath("//a[.='Home']"));
        homeMenu.click();

        //Test whether the Home page has Three Arrivals only

    }
}
