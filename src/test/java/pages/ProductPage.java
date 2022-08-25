package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class ProductPage extends BaseClass {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By producto = By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/h2[1]");

    public void AgregarProducto(){
        click(esperaExplicita(producto));
    }

}
