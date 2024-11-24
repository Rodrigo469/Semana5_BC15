package bc15.rodrigoDiaz.pages;

import bc15.rodrigoDiaz.utils.MetodosGenericos;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MetodosGenericos {
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
