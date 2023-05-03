import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class AT03 {
    // 3. Home page - Images in Arrivals should navigate
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Arrivals only
    //6) The Home page must contains only three Arrivals
    //7) Now click the image in the Arrivals
    //8) Test whether it is navigating to next page where the user can add that book into his basket.
    //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket

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
        //driver.quit();
    }

    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(3000);//Extension load

        //Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //Click on Shop Menu
        WebElement shopMenu = driver.findElement(By.xpath("//a[.='Shop']"));
        shopMenu.click();

        //Now click on Home menu button
        WebElement homeMenu = driver.findElement(By.xpath("//a[.='Home']"));
        homeMenu.click();

        //Test whether the Home page has Three Arrivals only
        int numberOfArrivals = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
        Assertions.assertEquals(3, numberOfArrivals);

        //Now click the image in the Arrivals
        //Test whether it is navigating to next page where the user can add that book into his basket.
        //Image should be clickable and shoul navigate to next page where user can add that book to his basket
        List<WebElement> arrivalsList = driver.findElements(By.xpath("//ul[@class='products']"));

        for (WebElement w : arrivalsList) {
            w.click();
            try {
                List<WebElement> outOfStockElements = driver.findElements(By.xpath("//p[@class='stock out-of-stock']"));
                if (!outOfStockElements.isEmpty() && outOfStockElements.get(0).isDisplayed()) {
                    driver.navigate().back();
                } else {
                    driver.findElement(By.xpath("//button[@type='submit']")).click();
                }
            } catch (NoSuchElementException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
