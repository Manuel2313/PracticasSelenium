package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

import java.util.Random;

public class RegisterPage extends BaseClass {


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By genderMale = By.xpath("//input[@id='gender-male']");
    By genderFemale = By.xpath("//input[@id='gender-female']");
    By firstName = By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//input[@id='LastName']");
    By email = By.xpath("//input[@id='Email']");
    By password = By.xpath("//input[@id='Password']");
    By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    By btnRegister = By.xpath("//input[@id='register-button']");

    By registerOK = By.xpath("//div[contains(text(),'Your registration completed')]");

    By resgisterNOOK = By.xpath("//body/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[1]/span[2]");


    public String getNameMail() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * caracteres.length());
            salt.append(caracteres.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    String Email = getNameMail() + "@gmail.com";

    public void Registrar(String genero, String nombre, String apellido, String pass) {
        if (genero == "male") {
            click(esperaExplicita(genderMale));
        } else {
            click(esperaExplicita(genderFemale));
        }
        agregarTexto(esperaExplicita(firstName), nombre);
        agregarTexto(esperaExplicita(lastName), apellido);
        agregarTexto(esperaExplicita(email),Email);
        agregarTexto(esperaExplicita(password), pass);
        agregarTexto(esperaExplicita(confirmPassword), pass);
        click(esperaExplicita(btnRegister));
    }

    public String obtenerOkRegister() {
        return obtenerTexto(esperaExplicita(registerOK));
    }

    public String obtenerRegisterFail(){
        return  obtenerTexto(esperaExplicita(resgisterNOOK));
    }


}






