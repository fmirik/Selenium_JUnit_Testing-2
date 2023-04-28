package example.selenium_junit_testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.time.Duration;

public class AT01 {
    // https://practice.automationtesting.in/test-cases/
    // 1. Home Page with three Sliders only
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Sliders only
    //6) The Home page must contains only three sliders

    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
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
    public void test01() throws InterruptedException {
        Thread.sleep(3000);//Extension load
        driver.get("http://practice.automationtesting.in/");
        driver.findElement(By.xpath("//a[.='Shop']")).click();
        driver.findElement(By.xpath("//a[.='Home']")).click();

    }
}
