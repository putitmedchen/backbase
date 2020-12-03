package backbase.pages;

import backbase.models.User;
import backbase.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement userName;


    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    public void signIn(User user) {
        userName.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        getWebdriverWait().until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}
