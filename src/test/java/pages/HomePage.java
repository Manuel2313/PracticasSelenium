package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {


    public HomePage(WebDriver driver) {
        super(driver);
    }

  By btnRegistro = By.xpath("//a[contains(text(),'Register')]");


    public void IraRegistro(){
        click(esperaExplicita(btnRegistro));
    }

}
