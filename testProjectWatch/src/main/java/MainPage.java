import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By poiskStroka = By.xpath("//div[@ id=\"search-console\"]//input [@name=\"search\"]");
    private By knopkaPoisk = By.xpath("//button [@ class=\"btn btn-primary btn-lg\"]");
    private By failPoisk=By.xpath("//*[contains(text(), 'Ничего не найдено!')]");
public MainPage clickPoiskStroka(){
    driver.findElement(poiskStroka).click();
    return this;
}

    public MainPage typePoiskStroka(String brand) {
        driver.findElement(poiskStroka).sendKeys(brand);
        return this;
    }
    public String  typeFailPoisk(){

        return driver.findElement(failPoisk).getText();    }
        public ItemPage clickPoisk() {
            driver.findElement(knopkaPoisk).click();
            return new ItemPage(driver);
        }


    public ItemPage register (String brand){
    this.clickPoiskStroka();
        this.typePoiskStroka(brand);
        this.typeFailPoisk();
        this.clickPoisk();
return new ItemPage(driver);

    }



}



