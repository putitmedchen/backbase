import backbase.models.User;
import backbase.pages.*;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FollowUserTest extends BaseTest {

    private String followedUserId;

    @Test
    public void followUser() {
        User user1 = User.generateRandomUser();

        BackBaseLandingPage backBaseLandingPage = new BackBaseLandingPage(driver);
        backBaseLandingPage.signUp();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpWithUser(user1);

        BackBaseHomePage backBaseHomePage = new BackBaseHomePage(driver);
        backBaseHomePage.openGlobalFeed();
        backBaseHomePage.goToFirstUser();

        UserPage userPage = new UserPage(driver);
        followedUserId = userPage.clickFollowUser();
        userPage.checkUserIsFollowed();

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.signOut();
    }

    @Test(dependsOnMethods = "followUser")
    public void followUserWithDifferentAccount() {
        User user2 = User.generateRandomUser();
        BackBaseLandingPage backBaseLandingPage = new BackBaseLandingPage(driver);
        backBaseLandingPage.signUp();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpWithUser(user2);

        BackBaseHomePage backBaseHomePage = new BackBaseHomePage(driver);
        backBaseHomePage.openGlobalFeed();
        backBaseHomePage.goToFirstUser();

        UserPage userPage = new UserPage(driver);
        Assert.assertTrue(followedUserId.contains(userPage.clickFollowUser()));
        userPage.checkUserIsFollowed();

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.signOut();
    }

}
