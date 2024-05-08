import org.example.*;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest{
    HomePage homePage = new HomePage();
    FaceBookPage faceBookPage = new FaceBookPage();
    NewsReleasePage newsReleasePage = new NewsReleasePage();
    NikePage nikePage = new NikePage();
    Electronics electronics = new Electronics();
    CameraAndPhoto cameraAndPhoto = new CameraAndPhoto();
@Test
    public void verifyWhenClickOnSearchButtonAlertMsgShouldPopupAndAbleToAcceptAlertSuccessfully(){
    //Open Browser
    //Type Url
    //click On Search Button
    homePage.clickOnSearchButton();
    // Verify Alert Msg And Accept Alert
    homePage.verifyAlertMsg();
    }

@Test
    public void verifyWhenClickOnVoteButtonWithoutSelectAnswerAlertShouldPopupAndAbleToAcceptAlertSuccessfully(){
    //Open Browser
    //Type Url
    //Click On Vote Button
    homePage.clickOnVoteButton();
    //Verify Alert Msg And Accept Alert
    homePage.verifyingVoteAlertMsg();
}
@Test
    public void verifyWhenClickOnFacebookButtonItShouldBeNavigateToFacebookPage(){
    //Open Browser
    //Type Url
    //Click On FaceBook Button
    homePage.clickOnFaceBookIcon();
    //Verify FaceBook Page Open Verify with URL,|Accepting ang Closing Cookies And Comparing page Title
    faceBookPage.verifyFaceBookPageOpen();
    //Comeback And Verify Welcome Msg
    homePage.verifyWelcomeMsg();
}
@Test
    public void verifyUserShouldBeAbleToAddNewCommentAndItShouldBeDisplayAtLast(){
    //Open Browser
    //Type Url
    //Click On Details Button under News Release
    homePage.clickOnDetailsButton();
    //Enter Title and comment
    newsReleasePage.addingNewComment();
    //click On New Comment
    //Verify New Comment is Added At Last
}
@Test
    public void verifyUserShouldBeAbleToSearchProductByBrandName(){
    //Open browser
    //Type Url
    //Type BrandName
    homePage.searchProductByBrandName();
    //Click On Search Button
    homePage.clickOnSearchButton();
    //verify Url Contain Nike and Each Product Contain Nike Word
    nikePage.eachProductContainNikeName();


}

@Test
    public void verifyEachProductContainSelectedCurrencySymbol(){
    //Open browser
    //Type Url
    //Select Euro currency and verify each product contain euro symbol
    homePage.selectEuroCurrency();
    //Select US Dollar currency and Verify each Product contain US Dollar Symbol
    homePage.selectUSDollarCurrency();
}

    @Test
    public void eachProductShouldHaveAddToCartButtonOnCameraAndPhotoPage(){
        //open Browser
        //Open URL
        //Click On Electronics
        homePage.clickOnElectronics();
        //click On Camera & Photo
        electronics.clickOnCameraAndPhoto();
        //verify Each Product Have Add To Cart Button
        cameraAndPhoto.EachProductHaveAddToCartButton();


    }











}
