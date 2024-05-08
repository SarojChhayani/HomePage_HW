import org.example.BrowserManager;
import org.example.Utils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils {
    BrowserManager browserManager = new BrowserManager();

    @BeforeMethod
    public void setup(){
        browserManager.openBrowser();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (!result.isSuccess()) {
            takeScreenShot(result.getName());
        }
       browserManager.closeBrowser();
    }














}

