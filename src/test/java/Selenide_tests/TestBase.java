package Selenide_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public AreasPage areaPage;
    public NavigationHelper goTo;
    public HomePage homePage;
    public GooglePage googlePage;
    public PlacesPage placesPage;
    public SpacesPage spacesPage;


    @BeforeSuite
    public void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 4000;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;
        //Configuration.baseUrl = "";
        Configuration.fastSetValue = true; //fill in with JavaScript

        googlePage = new GooglePage();
        homePage = new HomePage();
        goTo = new NavigationHelper();
        areaPage = new AreasPage();
        placesPage = new PlacesPage();
        spacesPage = new SpacesPage();

    }

    @AfterSuite
    public void testShutDown() {
        SelenideLogger.removeListener("allure");
        WebDriverRunner.clearBrowserCache();
        close();
    }
}
