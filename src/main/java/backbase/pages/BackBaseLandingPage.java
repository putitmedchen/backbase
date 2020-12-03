package backbase.pages;

import backbase.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackBaseLandingPage extends BasePage {

    private static final String backBaseUrl = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/";
    private WebDriver driver;

    public BackBaseLandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@href='#/register'])[1]")
    private WebElement signUpButton;

    public void signUp() {
        driver.get(backBaseUrl);
        signUpButton.click();
    }

}
