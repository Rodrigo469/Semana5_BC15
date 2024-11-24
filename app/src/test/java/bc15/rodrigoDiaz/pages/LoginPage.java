package bc15.rodrigoDiaz.pages;

import bc15.rodrigoDiaz.utils.MetodosGenericos;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MetodosGenericos {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By btnlogin = By.id("login-button");

    By textError =By.xpath("//h3[@data-test=\"error\"]");


    By addProd1=By.id("add-to-cart-sauce-labs-backpack");
    By addProd2=By.id("add-to-cart-sauce-labs-bike-light");
    By removeProd1=By.id("remove-sauce-labs-backpack");

    By shopCart = By.className("shopping_cart_link");
    By shopCartContinuePage = By.id("continue-shopping");
    By shopCartEndPage= By.xpath("//button[@class=\"btn btn_action btn_medium checkout_button \"]");

    By inputName=By.id("first-name");
    By inputName2=By.id("last-name");
    By inputCod=By.id("postal-code");
    By btnContinue =By.id("continue");
    By btnFinish = By.id("finish");


    public void rellenarLogin(String user_name, String pass_word) {
        agregarTexto(esperaExplicita(username, 10), user_name);
        agregarTexto(esperaExplicita(password, 10), pass_word);
        click(esperaExplicita(btnlogin,10));
    }

    public void rellenarLoginFail(String user_name2, String pass_word2) {
        agregarTexto(esperaExplicita(username, 10), user_name2);
        agregarTexto(esperaExplicita(password, 10), pass_word2);
        click(esperaExplicita(btnlogin,10));
    }


    public void validarTexto(String text) throws InterruptedException {
        esperaExplicita(textError,10);
        Assertions.assertEquals(text,getText(textError));
    }



    public void añadirItem(){
      click(esperaExplicita(addProd1,10));
    }

    public void añadirItem2(){
        click(esperaExplicita(addProd2,19));
    }

    public void removeItem(){
        click(esperaExplicita(removeProd1,10));
    }

    public void goShopCart(){
        click(esperaExplicita(shopCart,10));
    }

    public void continueShopItem(){
        click(esperaExplicita(shopCartContinuePage,10));
    }
    public void endShopCart(){
        click(esperaExplicita(shopCartEndPage,10));
    }
    public void registerShop(String name,String name2,int Cod){
        agregarTexto(esperaExplicita(inputName,300),name);
        agregarTexto(esperaExplicita(inputName2,300),name2);
        agregarTexto(esperaExplicita(inputCod,300), String.valueOf(Cod));
        click(esperaExplicita(btnContinue,300));
        click(esperaExplicita(btnFinish,500));

    }


}

