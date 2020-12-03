package backbase.pages;

import backbase.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackBaseHomePage extends BasePage {

    private WebDriver driver;

    public BackBaseHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()=\"Global Feed\"]")
    private WebElement globalFeedLink;

    @FindBy(xpath = "//app-article-list-item[1]//div[@class='info']/a")
    private WebElement firstUserLink;

    public void openGlobalFeed(){
        globalFeedLink.click();
    }

    public void goToFirstUser() {
        firstUserLink.click();
    }
}
