import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

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
        driver.quit();
    }

    @Test
    public void test03(){
        Thread.sleep(3000);//Extension load

        //Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //Click on Shop Menu
        WebElement shop = driver.findElement(By.xpath("//a[.='Shop']"));
        shop.click();

        //Now click on Home menu button
        WebElement home = driver.findElement(By.xpath("//a[.='Home']"));
        home.click();

        //Test whether the Home page has Three Arrivals only
        int numberOfArrivals  = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
        Assertions.assertEquals(3, numberOfArrivals);





    }

}
