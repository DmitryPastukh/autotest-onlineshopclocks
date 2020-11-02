import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {
    private WebDriver driver;

    public ItemPage(WebDriver driver) {

        this.driver = driver;
    }

    private By dobavlenieV = By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/div/div[2]/div[3]/button[1]/span\n");
    private By korzina = By.xpath("//div [@class=\"num\"]");
    private By oformitZakaz = By.xpath("//i[@ class=\"fa fa-share\"]");
    private By ozgidanie = By.xpath("//div[@ class=\"product-thumb\"]//*[contains(.,'CASIO LTP-1183A-7A')]/descendant::button/span");
    private By headien=By.xpath("//div[@ class=\"caption\"]//*[contains(text(), 'ВОСТОК 2414 (431950)')]");

        public String headienItempage() {
            return driver.findElement(headien).getText();
    }

    public ItemPage clickDobavlenieV() {
        driver.findElement(dobavlenieV).click();
        return this;
    }


    public ItemPage clickKorzina() {
        driver.findElement(korzina).click();
        return this;
    }

    public CheckOutPage clickOformitZakaz() {
        driver.findElement(oformitZakaz).click();
        return new CheckOutPage(driver);
    }

    public CheckOutPage registers() {
            this.headienItempage();
        this.clickDobavlenieV();
        this.clickKorzina();
        this.clickOformitZakaz();
        return new CheckOutPage(driver);


    }


}