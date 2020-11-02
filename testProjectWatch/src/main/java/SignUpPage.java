
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver=driver;


    }

    private By emaileFields = xpath("//input[@id=\"register_email\"]");
    private By passswordField = xpath("//input[@id=\"register_password\"]");
    private By confirmPasswordField = xpath("//input[@name=\"register[confirm_password]\"]");
    private By firstnameField = xpath("//input[@name=\"register[firstname]\"]");
    private By lastnameField = xpath("//input[@id=\"register_lastname\"]");
    private By telephoneField = xpath("//input[@id=\"register_telephone\"]");
    private By regionDropDown = xpath("//select[@id=\"register_zone_id\"]");
    private String regionDropDownOption = "//select[@id=\"register_zone_id\"]/option[text()='%s']";
    private By cityField = xpath("//input[@id=\"register_city\"]");
    private By addressField = xpath("//input[@id=\"register_address_1\"]");
    private By confirmButton = xpath("//a[@id=\"simpleregister_button_confirm\"]");
    private String errorByText = "//div[@class=\"simplecheckout-error-text simplecheckout-rule\"and text()=\"%s\"]";
    private By errorByLabel = xpath("//div[@class=\"simplecheckout-error-text simplecheckout-rule\" and string-length(text())>0 ]");


    public SignUpPage typeEmileFields(String email) {
        driver.findElement(emaileFields).sendKeys(email);
        return this;

    }

    public SignUpPage typePassswordField(String password) {
        driver.findElement(passswordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeConfirmPasswordField(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        return this;
    }

    public SignUpPage typeFirstnameField(String firstname) {
        driver.findElement(firstnameField).sendKeys(firstname);
        return this;

    }

    public SignUpPage typeLastnameField(String lastname) {
        driver.findElement(lastnameField).sendKeys(lastname);
        return this;
    }

    public SignUpPage typeTelephoneField(String tel) {
        driver.findElement(telephoneField).sendKeys(tel);
        return this;
    }


    public SignUpPage selectRegions(String listName, String option) {

        String listXpath = String.format("//label[text()='Регион']/following-sibling::div//select", listName);
        String optionXpath = String.format("//option[text()='%s']", option);
        driver.findElement(xpath(listXpath)).click();

        driver.findElement(xpath(optionXpath)).click();

        return this;
    }

    public SignUpPage typeCityField(String city) {
        driver.findElement(cityField).sendKeys(city);
        return this;


    }

    public SignUpPage typeAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;


    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();


    }
    public SignUpPage selectRegion(String listName, String option) {

        String listXpath = String.format("//label[text()='Регион']/following-sibling::div//select", listName);
        String optionXpath = String.format("//option[text()='%s']", option);
        driver.findElement(xpath(listXpath)).click();

        driver.findElement(xpath(optionXpath)).click();

        return this;
    }

    public List<WebElement> getErrors() {
        return driver.findElements(errorByLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String message) {
        return driver.findElements(xpath(format(errorByText, message))).size()>0&&driver.findElements(xpath(format(errorByText, message))).get(0).isDisplayed();
    }


    }






