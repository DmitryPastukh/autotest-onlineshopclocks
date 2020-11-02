import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://t-time.ru/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        MainPage mainPage=new MainPage(driver);
        mainPage.register("ВОСТОК 2414 (431950)");
       ItemPage itemPage=new ItemPage(driver);
       itemPage.registers();
       CheckOutPage checkOutPage=new CheckOutPage(driver);
       checkOutPage.pay("dfsdfgs@mail.ru","+7(999)999-99","dsfgdfgdf","dfsger","Регион","АР Крым","Ялта");

CheckOutSuccessPage checkOutSuccessPage=new CheckOutSuccessPage(driver);
checkOutSuccessPage.checkOutSuccess();

       SignUpPage signUpPage =new SignUpPage(driver);

    }}
