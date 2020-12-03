package backbase.pages;

import backbase.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UserPage extends BasePage {

    private WebDriver driver;
    private String followText = " Follow ";
    private String unfollowText = " Unfollow ";

    public UserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='user-info']//button")
    private WebElement followButton;

    @FindBy(xpath = "//div[@class='user-info']//h4")
    private WebElement userId;

    public String clickFollowUser() {
        getWebdriverWait().until(ExpectedConditions.textToBePresentInElement(followButton, followText + userId.getText()));
        Assert.assertTrue(followButton.getText().contains(followText + userId.getText()));
        followButton.click();
        return userId.getText();
    }

    public void checkUserIsFollowed() {
        getWebdriverWait().until(ExpectedConditions.textToBePresentInElement(followButton, unfollowText + userId.getText()));
        Assert.assertTrue(followButton.getText().contains(unfollowText + userId.getText()));
    }

}
