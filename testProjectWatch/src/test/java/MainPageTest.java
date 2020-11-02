import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://t-time.ru/");
        mainPage = new MainPage(driver);


    }

    @Test

    public void FailpoiskBrand() {
        mainPage.clickPoiskStroka();
        MainPage newMainPage = mainPage.typePoiskStroka("vdsfdsff");
        String failPoisk = newMainPage.typeFailPoisk();
        Assert.assertEquals("Ничего не найдено!", failPoisk);

    }

    @Test
    public void poiskBrand() {
        mainPage.clickPoiskStroka();
        mainPage.typePoiskStroka("ВОСТОК 2414 (431950)");
        ItemPage newItemPage = mainPage.clickPoisk();
        String headien = newItemPage.headienItempage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertEquals("ВОСТОК 2414 (431950)", headien);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}




