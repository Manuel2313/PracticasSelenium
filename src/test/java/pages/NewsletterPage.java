package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class NewsletterPage extends BaseClass {
    public NewsletterPage(WebDriver driver) {super(driver);}

        By inputMail = By.xpath("//input[@id='newsletter-email']");
        By btnSubcribe = By.xpath("//input[@id='newsletter-subscribe-button']");
        By msjSub = By.xpath("//div[@id='newsletter-result-block']");

        public void subNewsletter(String mail){
            agregarTexto(esperaExplicita(inputMail),mail);
            click(esperaExplicita(btnSubcribe));
        }

        public String obtenerMsjSub(){
            return obtenerTexto(esperaExplicita(msjSub));
        }

}

