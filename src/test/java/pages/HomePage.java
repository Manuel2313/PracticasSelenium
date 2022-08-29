package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

import java.util.ArrayList;

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
    By inputMail = By.xpath("//input[@id='newsletter-email']");
    By btnSubcribe = By.xpath("//input[@id='newsletter-subscribe-button']");
    By msjSub = By.xpath("//div[@id='newsletter-result-block']");



    public void IraRegistro(){
        click(esperaExplicita(btnRegistro));
    } /**Click en registro**/

    public void iraLogin(){                                            /**Click en Login**/
        click(esperaExplicita(btnLogin));
    }
    public void irAComputer(){                                         /**Click en Computer**/
        click(esperaExplicita(btnProducto));
    }

    public void votarComunnityPoll(){
        click(esperaExplicita(itemVotar));
        click(esperaExplicita(btnVote));
    }


    public void subNewsletter(String mail){                             /**Completar Newsletter y Click **/
        agregarTexto(esperaExplicita(inputMail),mail);
        click(esperaExplicita(btnSubcribe));
    }

    public String obtenerMsjSub(){                              /**Obtener msj Sub Newsletter**/
        return obtenerTexto(esperaExplicita(msjSub));
    }

    public String obtenerResultadoVotacion(){                   /**Obtener Text Votación**/
        return obtenerTexto(esperaExplicita(resultadoVotacion));
    }






}
