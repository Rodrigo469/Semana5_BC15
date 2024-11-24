package bc15.rodrigoDiaz.tests;

import bc15.rodrigoDiaz.pages.HomePage;
import bc15.rodrigoDiaz.pages.LoginPage;
import bc15.rodrigoDiaz.utils.DataDriven;
import bc15.rodrigoDiaz.utils.Propertiesdriven;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class SwagLabsTest {
    //Atributos
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    //private static String urlDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
    //private static String property = "webdriver.chrome.driver";
    //private static String browser = "chrome";
    private static String browser = Propertiesdriven.obtenerProperty("browser");
    private ArrayList<String> data;

    @Test
    public void CP001_LoginExitoso() throws InterruptedException {
          data= DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP001"));
          loginPage.rellenarLogin(data.get(1),data.get(2));
    }
    @Test
    public void CP002_LoginFallido() throws InterruptedException {
        data= DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP002"));
        loginPage.rellenarLogin(data.get(1),data.get(2));
        loginPage.validarTexto(data.get(3));
    }
    @Test
    public void CP003_GoShopPageItem_BeforeAddItems() throws InterruptedException {
        data= DataDriven.getTestData(Propertiesdriven.obtenerProperty("LoginExitoso"));
        loginPage.rellenarLogin(data.get(1),data.get(2));
        loginPage.esperarXSegundos(10);
        loginPage.añadirItem();
        loginPage.añadirItem2();
        loginPage.esperarXSegundos(500);
        loginPage.goShopCart();
        loginPage.esperarXSegundos(500);
        loginPage.continueShopItem();
    }

    @Test
    public void CP004_GoShopPageItem_BeforeRemoveItemsAdded() throws InterruptedException {
        data= DataDriven.getTestData(Propertiesdriven.obtenerProperty("LoginExitoso"));
        loginPage.rellenarLogin(data.get(1),data.get(2));
        loginPage.esperarXSegundos(10);
        loginPage.añadirItem();
        loginPage.añadirItem2();
        loginPage.esperarXSegundos(5000);
        loginPage.removeItem();
        loginPage.esperarXSegundos(500);
        loginPage.goShopCart();
        loginPage.esperarXSegundos(500);
        loginPage.continueShopItem();
    }

    @Test
    public void CP005_EndShopCart() throws InterruptedException {
        data= DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP005"));
        loginPage.rellenarLogin(data.get(1),data.get(2));
        loginPage.esperarXSegundos(10);
        loginPage.añadirItem();
        loginPage.añadirItem2();
        loginPage.esperarXSegundos(5000);
        loginPage.removeItem();
        loginPage.esperarXSegundos(500);
        loginPage.goShopCart();
        loginPage.esperarXSegundos(500);
        loginPage.endShopCart();
        loginPage.registerShop(data.get(3),data.get(4), Integer.parseInt(data.get(5)));
    }


    @BeforeEach
    public void preCondiciones(){
        data = new ArrayList<String>();
        loginPage = new LoginPage(driver);
        loginPage.conexionDriver(browser);
        homePage = new HomePage(loginPage.getDriver());
        homePage.cargarSitio(Propertiesdriven.obtenerProperty("url"));
        loginPage.maximizarBrowser(); }

    @AfterEach
    public void posCondiciones(){
        loginPage.cerrarBrowser();

    }
}
