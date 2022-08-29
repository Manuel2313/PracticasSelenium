package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    By btnRegistro = By.xpath("//a[contains(text(),'Register')]");
    By btnLogin = By.xpath("//a[contains(text(),'Log in')]");
    By btnProducto = By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]");
    By btnVote = By.xpath("//input[@id='vote-poll-1']");
    By itemVotar = By.xpath("//input[@id='pollanswers-1']");
    By resultadoVotacion = By.xpath("//div[@id='block-poll-vote-error-1']");
    public void IraRegistro(){
        click(esperaExplicita(btnRegistro));
    }

    public void iraLogin(){
        click(esperaExplicita(btnLogin));
    }
    public void irAComputer(){
        click(esperaExplicita(btnProducto));
    }

    public void votarComunnityPoll(){
        click(esperaExplicita(itemVotar));
        click(esperaExplicita(btnVote));
    }

    public String obtenerResultadoVotacion(){
        return obtenerTexto(esperaExplicita(resultadoVotacion));
    }






}
