import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CheckOutSuccessPage {
    private WebDriver driver;

    public CheckOutSuccessPage(WebDriver driver) {

        this.driver = driver;
    }

    private By heading = By.xpath("//div[@ id=\"content\" ]//*[text()='Заказ успешно сформирован!']");
    private By prodolzhit=By.xpath("//a[@class=\"btn btn-primary\"]");


   public CheckOutSuccessPage getHeadingText() {
       driver.findElement(heading).getText();

       return this;
   }public MainPage clickprodolzhit() {

        driver.findElement(prodolzhit).click();
        return new MainPage(driver);
    }

    public MainPage checkOutSuccess () {

       this.getHeadingText();
   this.clickprodolzhit();
        return new MainPage(driver);

    }



}


