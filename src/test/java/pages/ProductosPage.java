package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class ProductosPage extends BaseClass {
    public ProductosPage(WebDriver driver) {
        super(driver);
    }

    By producto = By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/h2[1]");
    By btnAddtoProd = By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]");
    By btnShoppingCart = By.xpath("//span[contains(text(),'Shopping cart')]");
    By btnAddsingle = By.xpath("//input[@id='add-to-cart-button-72']");

    By nameProd = By.xpath("//tbody/tr[1]/td[3]/a[1]");
    public void verProducto(){
        click(esperaExplicita(producto));
    }

    public void addToShoppingCart(){
        click(esperaExplicita(btnAddtoProd));
        click(esperaExplicita(btnAddsingle));
        click(esperaExplicita(btnShoppingCart));
    }

    public String obtenerNameProd(){
        return obtenerTexto(esperaExplicita(nameProd));
    }

}
