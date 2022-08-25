package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass {


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By Email = By.xpath("//input[@id='Email']");
   By Password = By.xpath("//input[@id='Password']");
     By btnLog = By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]");
    By LoginOK = By.xpath("//a[contains(text(),'prueba_1@gmail.com')]");
    By errorLogin = By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");


    public void login(String mail, String pass){
        agregarTexto(esperaExplicita(Email),mail);
        agregarTexto(esperaExplicita(Password),pass);
        click(esperaExplicita(btnLog));
    }

    public String obtenerLoginOK(){
        return obtenerTexto(esperaExplicita(LoginOK));
    }

    public String obtenerLoginError(){return obtenerTexto(esperaExplicita(errorLogin));}
}
