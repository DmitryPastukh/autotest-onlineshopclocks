import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChosePage {
    WebDriver driver;

    public ChosePage(WebDriver driver) {
        this.driver = driver;
    }

    private By pokazatVse = By.xpath("//div[@id=\"option-m\"] //button[@class=\"btn btn-block\"]");
    private By item = By.xpath("//input[@value=\"m:19\"]");
    private By pokazatTovar = By.xpath("//div[@class=\"popover-content\"]//button[@class=\"btn btn-primary\"]");


    public ChosePage clickPokazatVse() {
        driver.findElement(pokazatVse).click();
        return this;

    }

    public ChosePage clickItem() {
        driver.findElement(item).click();
        return this;

    }

    public ItemPage clickPokazatTovar() {
        driver.findElement(pokazatTovar).click();
        return new ItemPage(driver);

    }

    public ItemPage register() {
        this.clickPokazatVse();
        this.clickItem();
        this.clickPokazatTovar();
        return new ItemPage(driver);

    }

}