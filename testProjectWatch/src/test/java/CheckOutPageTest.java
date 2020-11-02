import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckOutPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private ItemPage itemPage;
    private CheckOutPage checkOutPage;
    private CheckOutSuccessPage checkOutSuccessPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://t-time.ru/");
        mainPage = new MainPage(driver);
        itemPage = new ItemPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkOutSuccessPage = new CheckOutSuccessPage(driver);

    }

    @Test
    public void tel() throws InterruptedException {
        mainPage.clickPoiskStroka();
        mainPage.typePoiskStroka("Casio");
        mainPage.clickPoisk();
        itemPage.clickDobavlenieV();
        itemPage.clickKorzina();
        itemPage.clickOformitZakaz();
        checkOutPage.typeEmail("afasdfsd@mail.ru");
        checkOutPage.typeTelephone("8985678759654444455454");
        checkOutPage.typeFirstnameField("Fggghh");
        checkOutPage.typeLastnameField("sdfsfd");
        checkOutPage.selectOption("Россия", "АР Крым");
        TimeUnit.SECONDS.sleep(10);

        checkOutPage.typeCityField("Ялта");
        TimeUnit.SECONDS.sleep(10);

        checkOutPage.clickVyborOplati();
        TimeUnit.SECONDS.sleep(10);

        checkOutPage.clickOformlenieZakaza();

        checkOutPage.getTelFail();


    }


    @After
    public void tearDown() {
        driver.quit();
    }

}




