import backbase.models.User;
import backbase.pages.*;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FollowUserTest extends BaseTest {

    private String followedUserId;

    @Test(description = "Follow User")
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
    }

    @Test(description = "Follow the same user with different accounts", dependsOnMethods = "followUser")
    public void followUserWithDifferentAccount() {
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.signOut();

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

        settingsPage.signOut();
    }

    @Test(description = "Follow XUser with one account and logout, login again with the same user and check that XUser is followed.", dependsOnMethods = "followUserWithDifferentAccount")
    public void checkUserIsFollowedAfterLogout() {
        User user = User.generateRandomUser();
        BackBaseLandingPage backBaseLandingPage = new BackBaseLandingPage(driver);
        backBaseLandingPage.signUp();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpWithUser(user);

        BackBaseHomePage backBaseHomePage = new BackBaseHomePage(driver);
        backBaseHomePage.openGlobalFeed();
        backBaseHomePage.goToFirstUser();

        UserPage userPage = new UserPage(driver);
        followedUserId = userPage.clickFollowUser();
        userPage.checkUserIsFollowed();

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.signOut();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(user);

        backBaseHomePage.openGlobalFeed();
        backBaseHomePage.goToFirstUser();
        userPage.checkUserIsFollowed();
    }

}
