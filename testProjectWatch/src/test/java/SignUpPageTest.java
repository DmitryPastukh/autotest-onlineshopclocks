import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class SignUpPageTest {

    private MainPage mainPage;
    private ItemPage itemPage;
    private CheckOutPage checkOutPage;
    private CheckOutSuccessPage checkOutSuccessPage;
    private WebDriver driver;

    private SignUpPage signUpPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://t-time.ru/simpleregister/");
        signUpPage = new SignUpPage(driver);


    }

    @Test
    public void typeInvalidEmail() {
        signUpPage.typeEmileFields("edewf");
        signUpPage.clickConfirmButton();
        Assert.assertTrue(signUpPage.isErrorVisible("Некорректный адрес электронной почты!"));

    }

    @Test
    public void typeInvalidValues() {

        signUpPage.typeEmileFields("тест");
        signUpPage.typePassswordField("тест");

        signUpPage.typeConfirmPasswordField("тtcnn");

        signUpPage.typeFirstnameField("тест");
        signUpPage.typeLastnameField("тест");
        signUpPage.typeTelephoneField("тест");
        signUpPage.selectRegions("Россия", "АР Крым");
        signUpPage.typeCityField("тест");
        signUpPage.typeAddressField("тест");

        signUpPage.clickConfirmButton();

        Assert.assertEquals(12, signUpPage.getErrors().size());

        Assert.assertEquals("Некорректный адрес электронной почты!", signUpPage.getErrorByNumber(2));
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}