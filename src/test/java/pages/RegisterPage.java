package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class RegisterPage extends BaseClass {


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By genderMale = By.xpath("//input[@id='gender-male']");
    By genderFemale= By.xpath("//input[@id='gender-female']");
    By firstName = By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//input[@id='LastName']");
    By email = By.xpath("//input[@id='Email']");
    By password = By.xpath("//input[@id='Password']");
    By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    By btnRegister = By.xpath("//input[@id='register-button']");

    By registerOK = By.xpath("//div[contains(text(),'Your registration completed')]");



    public void Registrar(String genero ,String nombre, String apellido, String correo, String pass, String resultadoesperado){
        if(genero == "male"){
            click(esperaExplicita(genderMale));
        }else{
            click(esperaExplicita(genderFemale));
        }
        agregarTexto(esperaExplicita(firstName),nombre);
        agregarTexto(esperaExplicita(lastName),apellido);
        agregarTexto(esperaExplicita(email),correo);
        agregarTexto(esperaExplicita(password),pass);
        agregarTexto(esperaExplicita(confirmPassword),pass);

        click(esperaExplicita(btnRegister));
    }


}
