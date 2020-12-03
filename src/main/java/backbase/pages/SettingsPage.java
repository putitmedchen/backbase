package backbase.pages;

import backbase.pages.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage {

    private WebDriver driver;

    public SettingsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@routerlink='/settings']")
    private WebElement settingButton;

    @FindBy(xpath = "//button[@class='btn btn-outline-danger']")
    private WebElement logOutButton;

    private void openSettings() {
        settingButton.click();
    }

    public void signOut() {
        openSettings();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logOutButton.click();
    }
}
