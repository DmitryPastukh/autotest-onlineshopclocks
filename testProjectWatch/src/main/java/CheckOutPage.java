import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CheckOutPage {
    private WebDriver driver;

    public CheckOutPage(WebDriver driver) {

        this.driver = driver;
    }

    private By emailField = By.xpath("//input [@ id=\"customer_email\"]");
    private By telephoneField = By.xpath("//input [@ id=\"customer_telephone\" ]");
    private By lastnameField = By.xpath("//input [@ id=\"payment_address_lastname\"]");
    private By firstnameField = By.xpath("//input [@ id=\"payment_address_firstname\"]");

    private By regionField = By.xpath("//label[text()='Регион']/following-sibling::div//select");
    private By region = By.xpath("//option[@ value=\"4236\"]");
    private By city = By.xpath("//input[@id=\"payment_address_city\"]");
    private By oformlenieZakaza = By.xpath("//div [@class=\"simplecheckout-button-right\"]/input");
    private By vyborOplati = By.xpath("//input[@id=\"filterit.6\"]");
    private By telFail=By.xpath("//*[contains(text(), 'Номер телефона должен содержать от 11 до 25 символов, например +7(999)999-99-99')]");


    public CheckOutPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;


    }

    public CheckOutPage typeTelephone(String tel) {

        driver.findElement(telephoneField).sendKeys(tel);
        return this;
    }

    public CheckOutPage typeLastnameField(String Lastname) {
        driver.findElement(lastnameField).sendKeys(Lastname);
        return this;


    }

    public CheckOutPage typeFirstnameField(String Firstname) {
        driver.findElement(firstnameField).sendKeys(Firstname);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        return this;

    }

    public CheckOutPage selectOption(String listName, String option) {

        String listXpath = String.format("//label[text()='Регион']/following-sibling::div//select", listName);
        String optionXpath = String.format("//option[text()='%s']", option);
        driver.findElement(By.xpath(listXpath)).click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        driver.findElement(By.xpath(optionXpath)).click();
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);

        return this;
    }



            public CheckOutPage typeCityField (String citys) {
                driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

                driver.findElement(city).sendKeys(citys);
                driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

                return this;



}

    public CheckOutPage clickVyborOplati() {
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


       driver.findElement(vyborOplati).click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        return this;

    }

    public  CheckOutSuccessPage clickOformlenieZakaza() {

            driver.findElement(oformlenieZakaza).click();
        return new CheckOutSuccessPage(driver);
    }
    public String getTelFail() {
        return driver.findElement(telFail).getText();
    }

public CheckOutSuccessPage pay(String email, String tel, String Lastname, String Firstname, String listName, String option, String citys) throws InterruptedException {
    this.typeTelephone(tel);
    TimeUnit.SECONDS.sleep(10);
    this.typeEmail(email);
    TimeUnit.SECONDS.sleep(5);
    this.typeCityField(citys);
    TimeUnit.SECONDS.sleep(10);




    this.typeLastnameField(Lastname);
    TimeUnit.SECONDS.sleep(20);

    this.typeFirstnameField(Firstname);

    TimeUnit.SECONDS.sleep(10);


    this.selectOption(listName,option);

    TimeUnit.SECONDS.sleep(10);
    this.getTelFail();


    this.clickVyborOplati();
    TimeUnit.SECONDS.sleep(10);

    this.clickOformlenieZakaza();
    return new CheckOutSuccessPage(driver);




}}