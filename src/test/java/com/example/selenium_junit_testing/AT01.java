package com.example.selenium_junit_testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jetbrains.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("http://practice.automationtesting.in/");
        driver.findElement(By.xpath("//a[.='Shop']")).click();
        driver.findElement(By.xpath("//a[.='Home']")).click();


    }
}
